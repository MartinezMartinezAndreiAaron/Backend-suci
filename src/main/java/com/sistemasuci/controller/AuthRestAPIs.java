package com.sistemasuci.controller;

import com.sistemasuci.entity.TipoUsuarioNombre;
import com.sistemasuci.entity.Tipousuario;
import com.sistemasuci.entity.Usuarios;
import com.sistemasuci.reponse.JwtResponse;
import com.sistemasuci.reponse.ResponseMessage;
import com.sistemasuci.repository.TipoUsuarioRepository;
import com.sistemasuci.repository.UsuariosRepository;
import com.sistemasuci.request.LoginForm;
import com.sistemasuci.request.SingUpForm;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import security.JwtProvider;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPIs {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsuariosRepository usuariosRepository;

    @Autowired
    TipoUsuarioRepository tipoUsuarioRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Validated @RequestBody LoginForm loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateJwtToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
    }

    @PostMapping("/singup")
    public ResponseEntity<?> registerUser(@Validated @RequestBody SingUpForm singUpRequest) {
        if (usuariosRepository.existsByUserName(singUpRequest.getUsername())) {
            return new ResponseEntity<>(new ResponseMessage("Error -> Usuario ya Registrado"),
                    HttpStatus.BAD_REQUEST);
        }

        //Creando la cuenta de usuario
        Usuarios user = new Usuarios(singUpRequest.getUsername(),
                encoder.encode(singUpRequest.getPassword()));

        Set<Tipousuario> tipousuarios = new HashSet<>();
        if (singUpRequest.getTipousuario() != null) {
            Set<String> strTipousuarios = singUpRequest.getTipousuario();

            strTipousuarios.forEach(tipousuario -> {
                switch (tipousuario) {
                    case "admin":
                        Tipousuario adminTipousuario = tipoUsuarioRepository.findByName(TipoUsuarioNombre.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error -> Causa: Tipo de Usuario no encontrado."));
                        tipousuarios.add(adminTipousuario);
                        break;
                    case "revisor":
                        Tipousuario revisorTipousuario = tipoUsuarioRepository.findByName(TipoUsuarioNombre.ROLE_REVISOR)
                                .orElseThrow(() -> new RuntimeException("Error -> Causa: Tipo de Usuario no encontrado."));
                        tipousuarios.add(revisorTipousuario);
                        break;
                    default:
                        Tipousuario userTipousuario = tipoUsuarioRepository.findByName(TipoUsuarioNombre.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error -> Causa: Tipo de Usuario no encontrado."));
                        tipousuarios.add(userTipousuario);
                }
            });
        } else {
            // por default registro de usuario
            Tipousuario userTipousuario = tipoUsuarioRepository.findByName(TipoUsuarioNombre.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error -> Causa: Tipo de Usuario no encontrado."));
            tipousuarios.add(userTipousuario);
        }
        user.setTipousuarios( tipousuarios);
        usuariosRepository.save(user);

        return new ResponseEntity<>(new ResponseMessage("Usuario " + singUpRequest.getUsername() + " registrado correctamente"), HttpStatus.OK);
        //return ResponseEntity.ok(new ResponseMessage("Usuario registrado exitosamente"));
    }
}

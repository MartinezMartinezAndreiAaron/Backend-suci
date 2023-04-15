package com.sistemasuci.controller;

import com.sistemasuci.entity.TipoUsuarioNombre;
import com.sistemasuci.entity.Tipousuario;
import com.sistemasuci.entity.Usuarios;
import payload.response.JwtResponse;
import com.sistemasuci.reponse.ResponseMessage;
import com.sistemasuci.repository.TipoUsuarioRepository;
import com.sistemasuci.repository.UsuariosRepository;
import com.sistemasuci.request.LoginForm;
import com.sistemasuci.request.SingUpForm;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
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
import security.service.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

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

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> tipousuarios = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), tipousuarios));
    }

    @PostMapping("/singup")
    public ResponseEntity<?> registerUser(@Validated @RequestBody SingUpForm singUpRequest) {
        if (usuariosRepository.existsByUserName(singUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new ResponseMessage("Error -> Usuario ya Registrado"));
        }

        //Creando la cuenta de usuario
        Usuarios user = new Usuarios(singUpRequest.getUsername(),
                encoder.encode(singUpRequest.getPassword()));

        Set<String> strTipousuarios = singUpRequest.getTipousuario();
        Set<Tipousuario> tipousuarios = new HashSet<>();

        if (strTipousuarios == null) {
            Tipousuario usuarioTipousuario = tipoUsuarioRepository.findByName(TipoUsuarioNombre.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Tipo de usuario no encontrado"));
            tipousuarios.add(usuarioTipousuario);
        } else {
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
        }
        user.setTipousuarios(tipousuarios);
        usuariosRepository.save(user);

        return ResponseEntity.ok(new ResponseMessage("Usuario registrado exitosamente"));
    }
}

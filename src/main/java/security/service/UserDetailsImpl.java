package security.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sistemasuci.entity.Usuarios;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsImpl implements UserDetails {

    private static final long serialVersionUID = 1L;

    private String username;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    private GrantedAuthority authority;

    public UserDetailsImpl(String usarname, String password, Collection<? extends GrantedAuthority> authorities) {
        this.username = usarname;
        this.password = password;
        this.authorities = authorities;
    }

    public static UserDetailsImpl build(Usuarios user) {
        List<GrantedAuthority> authorities = user.getTipousuarios().stream().map(
                tipousuario -> new SimpleGrantedAuthority(tipousuario.getTipousuario())) //tipousuario.getTipousuario().name())
                .collect(Collectors.toList());
        return new UserDetailsImpl(user.getUsuario(), user.getContraseña(), authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(username, user.username);
    }

}
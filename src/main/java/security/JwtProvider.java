package security;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import security.service.UserDetailsImpl;
import security.service.UserPrinciple;

@Component
public class JwtProvider {

    private static final Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    @Value("${suci.app.jwtSecret}")
    private String jwtSecret;

    @Value("${suci.app.jwtExpirationMs}")
    private int jwtExpiration;

    public String generateJwtToken(Authentication authenticacion) {
        //UserPrinciple userPrincipal = (UserPrinciple) authenticacion.getPrincipal();
        UserDetailsImpl userPrincipal = (UserDetailsImpl) authenticacion.getPrincipal();

        return Jwts.builder().setSubject((userPrincipal.getUsername()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpiration)) //.setExpiration(new Date((new Date()).getTime() + jwtExpiration * 1000))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public Boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            logger.error("firma invalida JWT -> Message: {} ", e);
        } catch (MalformedJwtException e) {
            logger.error("token invalido JWT -> Message: {} ", e);
        } catch (ExpiredJwtException e) {
            logger.error("token expirado JWT -> Message: {} ", e);
        } catch (UnsupportedJwtException e) {
            logger.error("token no admitido JWT -> Message: {} ", e);
        } catch (IllegalArgumentException e) {
            logger.error("el reclamo es una cadena vacia JWT -> Message: {} ", e);
        }
        return false;
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody().getSubject();
    }
}

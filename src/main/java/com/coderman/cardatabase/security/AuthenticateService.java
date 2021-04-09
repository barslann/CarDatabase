package com.coderman.cardatabase.security;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.Date;

public class AuthenticateService {
        // EXPIRATIONTIME -> defines the expiration time of the token in milliseconds
        static final long EXPIRATIONTIME = 864_000_00; // 1 day in milliseconds
        // SIGNINKEY -> algorithmic specific signing key that is used to digitally sign the JWT. should use a base64-encoded string to do this.
        static final String SIGNINKEY = "SecretKey";
        // PREFIX -> defines the prefix of the token and adds it to the request's Authorization header.
        static final String PREFIX = "Bearer";

        // create token and adds it to the response's Authorization header
        static public void addToken(HttpServletResponse res, String username){
            String jwtToken = Jwts.builder()
                    .setSubject(username)
                    .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
                    .signWith(SignatureAlgorithm.HS512,SIGNINKEY)
                    .compact();
            res.addHeader("Authorization", PREFIX + " " + jwtToken);
            // This is needed because we are unable to access the Authorization header through Javascript frontend by default
            res.addHeader("Access-Control-Expose-Headers","Authorization");
        }

        // Get token from Authorization header
        static public Authentication getAuthentication(HttpServletRequest request){
            String token = request.getHeader("Authorization");
            if(token != null){
                String user = Jwts.parser()
                        .setSigningKey(SIGNINKEY)
                        .parseClaimsJws(token.replace(PREFIX,""))
                        .getBody()
                        .getSubject();

                if(user != null){
                    return new UsernamePasswordAuthenticationToken(user,null, Collections.emptyList());
                }
            }
            return null;
        }



}

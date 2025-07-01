package org.scoula.security.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JwtProcessor {
    static private final long TOKEN_VALID_MILISECOND = 1000L * 60 * 20; // 20분으로 유효기간 변경

    private String secretKey = "충분히 긴 임의의(랜덤한) 비밀키 문자열 배정 ";
    private Key key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));

    // private Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256); -- 운영시 사용

    // jwt생성
    public String generateToken(String subject) {  // 유저 이름을 subject로 설정
        return Jwts.builder()
                .setSubject(subject) // 사용자 정보 
                .setIssuedAt(new Date())  // 발급 시간
                .setExpiration(new Date(new Date().getTime() + TOKEN_VALID_MILISECOND))  // 만료 시간
                .signWith(key)  // 서명용 키로 서명
                .compact();  // 최종 토큰 문자열 생성
    }

    // JWT Subject(username) 추출 - 해석 불가인 경우 예외 발생
    // 예외 ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException,
    // IllegalArgumentException
    public String getUsername(String token) { // 토큰을 통해 유저 아이디를 얻어내는 과정이다
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject(); // claims에서 추출한다
    }
    // 예외 처리를 하고 있지 않지만, 예외가 발생할 수 있다. Runtime예외이기에 강제로 try catch 안해도 됨

    // JWT 검증(유효 기간 검증 - 즉, refresh토큰을 검증할 때) - 해석 불가인 경우 예외 발생
    public boolean validateToken(String token) {
        Jws<Claims> claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);
        return true;
    }
}

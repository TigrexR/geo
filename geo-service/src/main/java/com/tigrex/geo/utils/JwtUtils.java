package com.tigrex.geo.utils;

import io.jsonwebtoken.*;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

/**
 * @author linus
 */
public class JwtUtils {

    /**
     * 密钥
     */
    private static final String KEY = "geo@#123456";

    /**
     * 创建token
     *
     * @param subject 主题
     * @param issue 发行者
     * @param claim 主题，包含用户信息
     * @param ttlMillis 有效时长
     * @return token
     */
    public static String createToken(String subject, String issue, Object claim, long ttlMillis) {
        /*
          setSubject 设置主题
          setIssuer 发行者
          setId jwtID jwtID
          setExpiration 设置过期日期
          claim 主题，可以包含用户信息
          signWith 加密算法
          compressWith 对载荷进行压缩
         */
        return Jwts.builder().setSubject(subject).setIssuer(issue).setId(issue)
                .setExpiration(new Date(System.currentTimeMillis() + ttlMillis)).claim("user", claim)
                .signWith(getSignatureAlgorithm(), getSignedKey()).compressWith(CompressionCodecs.DEFLATE).compact();
    }

    /**
     * 解析token
     *
     * @param token token
     * @return Jws<Claims>
     */
    public static Jws<Claims> parseToken(String token) {
        Jws<Claims> claims;
        try {
            claims = Jwts.parser().setSigningKey(getSignedKey()).parseClaimsJws(token);
        } catch (Exception ex) {
            claims = null;
        }
        return claims;
    }

    /**
     * 获取主题信息
     *
     * @param token token
     * @return claims
     */
    public static Claims getClaims(String token) {
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(getSignedKey()).parseClaimsJws(token).getBody();
        } catch (Exception ex) {
            claims = null;
        }
        return claims;
    }

    /**
     * 获取密钥
     *
     * @return Key
     */
    private static Key getSignedKey() {
        return new SecretKeySpec(DatatypeConverter.parseBase64Binary(KEY), getSignatureAlgorithm().getJcaName());
    }

    private static SignatureAlgorithm getSignatureAlgorithm() {
        return SignatureAlgorithm.HS256;
    }
}


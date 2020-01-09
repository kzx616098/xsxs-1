package cn.xinzhi.xsxs.uilt;

import cn.xinzhi.xsxs.pojo.UserInfo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @author youName
 * @create 2019-12-05 15:27
 */
public class JwtUtils  {
    public static final String SUBJECT = "xdclass";
    //过期时间 毫秒 一周
    public static long EXPIRE = 1000 * 60;
    //密钥
    public static final String APPSECRET = "cmzzg";

    /**
     * 生成jwt
     *
     * @param user
     * @return java.lang.String
     */
    public static String geneJsonWebToken(UserInfo user) {
        if (user == null || user.getUid() == null || user.getUpwd() == null || user.getP_phone() == null) {
            return null;
        } else {
            String token = Jwts.builder().setSubject(SUBJECT)
                    .claim("id", user.getId())
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                    .signWith(SignatureAlgorithm.HS256, APPSECRET).compact();
            return token;
        }
    }

    /**
     * 校验token
     * @param token
     * @return io.jsonwebtoken.Claims
     */
    public static String checkToken(String token) {
        try {
            final String claims = Jwts.parser().setSigningKey(APPSECRET)
                    .parseClaimsJws(token).getBody().getId();
            return claims;
        }catch (Exception e){
            return null;
        }
    }
}

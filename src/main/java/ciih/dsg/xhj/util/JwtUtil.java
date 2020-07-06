package ciih.dsg.xhj.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {
    public static String SECRET = "ngmzd";
    private static final long EXPIRATION = 7200L;//单位为秒

    public static String createToken(Map<String, String> claims) {
        //过期时间
        Date expireDate = new Date(System.currentTimeMillis() + EXPIRATION * 1000);
        Date now = new Date();
        Map<String, Object> map = new HashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        JWTCreator.Builder token = JWT.create()
                .withHeader(map)// 添加头部
                .withExpiresAt(expireDate) //超时设置,设置过期的日期
                .withIssuedAt(now) //签发时间
                .withNotBefore(now);
        for (Map.Entry<String, String> entry : claims.entrySet()) {
            token.withClaim(entry.getKey(), entry.getValue());
        }
               // token.sign(Algorithm.HMAC256(SECRET)); //SECRET加密
        return token.sign(Algorithm.HMAC256(SECRET));
    }

    /**
     * 校验token并解析token
     */
    public static Map<String, Claim> verifyToken(String token) {
        DecodedJWT jwt = null;
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
            jwt = verifier.verify(token);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("token解码异常");
            //解码异常则抛出异常
            return null;
        }
        Map<String, Claim> claims = jwt.getClaims();
        for (Map.Entry<String, Claim> entry : claims.entrySet()) {
            String key = entry.getKey();
            Long claim = entry.getValue().asLong();
            System.out.println("key:"+key+" value:"+claim);
        }
        return claims;
    }

    public static void main(String[] args) throws Exception {
//        Map<String,String> claim = new HashMap<>();
//        claim.put("user_id","04364031191281697");
//        claim.put("phone","15158230518");
//        claim.put("name","黄哥");
//        claim.put("scope","1");
//        claim.put("depts","100562279");
////        claim.put("iat","1585791201");
////        claim.put("nbf","1585791201");
////        claim.put("exp","1585798401");
//        String token = JwtUtil.createToken(claim);
//        System.out.println(token);

        System.out.println(JwtUtil.verifyToken("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMDQzNjQwMzExOTEyODE2OTciLCJwaG9uZSI6IjE1MTU4MjMwNTE4IiwibmFtZSI6Ilx1OWVjNFx1NTRlNSIsInNjb3BlIjoiMSIsImRlcHRzIjoiMTAwNTYyMjc5IiwiaWF0IjoxNTg1Nzk3NjI2LCJuYmYiOjE1ODU3OTc2MjYsImV4cCI6MTU4NTgwNDgyNn0.dfg8M9U5SfjitIGElOuTrNd3aRehbeoa8PoSL5vlQUA"));
    }
}

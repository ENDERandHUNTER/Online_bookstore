//package com.hust.online_bookstore_backend.utils;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.interfaces.DecodedJWT;
//import com.auth0.jwt.interfaces.JWTVerifier;
//import org.springframework.beans.factory.annotation.Value;
//
//import java.util.Calendar;
//
////自己封装当前项目生成token令牌和验证token令牌的通用方法
////工具类 静态方法
//public class JwtUtils {
//
//    //外部签名带的密钥
//    public static final String SECRET = "ACC";
//
//    //获取application.proprerties中配置的常量
//    @Value("${secretkey}")
//    private static final String SECRETKEY = null;
//
//
//    //生成登录令牌的方法
//    public static String sign(User user){
//        //定义一个日历对象,配置令牌的有效期
//        Calendar instance = Calendar.getInstance();
//        // 120秒后令牌token失效
//        //instance.add(Calendar.HOUR,2);
//        instance.add(Calendar.HOUR,12);
//        return JWT.create()
//                //将什么内容放入到令牌中，自己决定 start
//                .withClaim("id", user.getUserId())
//                .withClaim("userName", user.getUserName())
//                //.withClaim("userImg", user.getUserImg())
//                .withClaim("secretkey",SECRETKEY)
//                //将什么内容放入到令牌中，自己决定 end
//                //设置令牌的有效期
//                .withExpiresAt(instance.getTime())
//                //设置加密模式
//                .sign(Algorithm.HMAC256(SECRET));
//    }
//
//    //校验token
//    public static boolean verify(String token){
//        try {
//            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
//            DecodedJWT decodedJWT  = verifier.verify(token);
//            return true;
//        }catch (Exception e){
//            return false;
//        }
//    }
//
//    //获取token内的携带的用户名信息
//    public static String getUserIdByToken(String token){
//        DecodedJWT decodedJWT = JWT.decode(token);
//        return decodedJWT.getClaim("id").asString();
//    }
//
//}

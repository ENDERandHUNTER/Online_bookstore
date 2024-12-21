//package com.hust.online_bookstore_backend.interceptor;
//
//import com.hust.online_bookstore_backend.entity.JsonResult;
//import com.hust.online_bookstore_backend.utils.JwtUtils;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.web.servlet.HandlerInterceptor;
//
///**
// *
// */
//public class LoginInterceptor implements HandlerInterceptor {
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String token=request.getHeader("token");
//        System.out.println(token);
//
//        if(token!=null&&!token.equals("")){
//            if(JwtUtils.verify(token)){
//                return true;
//            }else {
//                response.setCharacterEncoding("utf-8");
//                response.getWriter().println(new JsonResult(false,"1001","token无效"));
//            }
//        }else{
//            response.setCharacterEncoding("utf-8");
//            response.getWriter().println(new JsonResult(false,"1001","未登录"));
//        }
//        return false;
//    }
//}

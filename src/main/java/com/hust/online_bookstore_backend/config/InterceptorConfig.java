//package com.hust.online_bookstore_backend.config;//package com.hust.tamako_blog.config;
//
//import com.hust.online_bookstore_backend.interceptor.LoginInterceptor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class InterceptorConfig  implements WebMvcConfigurer {
//
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        //注册LoginInterceptor拦截器
//        registry.addInterceptor(createLoginInterceptor())
//                //排除在此拦截器外
//                .excludePathPatterns("/login","/reg")
//                //被拦截的规则
//                .addPathPatterns("/**");
//    }
//
//    @Bean
//    public LoginInterceptor createLoginInterceptor(){
//        return new LoginInterceptor();
//    }
//
//}

package kea.alog.issue.config;

import kea.alog.issue.Intercepter.JwtIntecepter;
import kea.alog.issue.config.util.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@RequiredArgsConstructor
@Configuration
public class CorsConfig implements WebMvcConfigurer{
    final private JwtProvider jwtProvider;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("*").allowedMethods("*");
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new JwtIntecepter(jwtProvider))
                .addPathPatterns("/api/issue/**")
                .excludePathPatterns("/api/issue/swagger-ui/**");
    }
}

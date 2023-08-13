package kea.alog.issue.Intercepter;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
@RequiredArgsConstructor
public class JwtRequestIntercepter implements RequestInterceptor {
    final private static String AUTHORIZATION_HEADER = "Autuorization";
    final private static String BEARER_TOKEN_TYPE = "Bearer";

    @Override
    public void apply(RequestTemplate template) {
        HttpServletRequest request = getCurrentHttpRequest();
        if(request != null){
            String token = request.getHeader(AUTHORIZATION_HEADER);
            if(token != null && token.startsWith(BEARER_TOKEN_TYPE)){
                template.header(AUTHORIZATION_HEADER, String.format("%s %s", BEARER_TOKEN_TYPE, token));
            }
        }
    }

    private HttpServletRequest getCurrentHttpRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes instanceof ServletRequestAttributes) {
            return ((ServletRequestAttributes) requestAttributes).getRequest();
        }
        return null;
    }
}

package ro.ubb.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class SpringCloudConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/clients/**")
                        .uri("http://clients-docker:8081"))
                .route(r -> r.path("/gun-types/**")
                        .uri("gun-types-docker:8082"))
//                .build();
//                .route(r -> r.path("/clients/**")
//                        .uri("http://localhost:8081/"))
//                .route(r -> r.path("/gun-types/**")
//                        .uri("http://localhost:8082/"))
                .route(r -> r.path("/bullets/**")
                        .uri("http://localhost:3000/"))
                .route(r -> r.path("/articles/**")
                        .uri("http://localhost:3001/"))
                .build();
    }

//    @Bean
//    public CorsFilter corsFilter() {
//        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        final CorsConfiguration config = new CorsConfiguration();
//        config.setAllowCredentials(true);
//        config.addAllowedOrigin("");
//        config.addAllowedHeader("");
//        config.addAllowedMethod("OPTIONS");
//        config.addAllowedMethod("HEAD");
//        config.addAllowedMethod("GET");
//        config.addAllowedMethod("PUT");
//        config.addAllowedMethod("POST");
//        config.addAllowedMethod("DELETE");
//        config.addAllowedMethod("PATCH");
//        source.registerCorsConfiguration("/**", config);
//        return new CorsFilter(source);
//    }

}

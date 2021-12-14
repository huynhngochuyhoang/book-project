package com.hoanghuynh.apigateway.config;

import lombok.AllArgsConstructor;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class GatewayConfig {

    private GatewayAuthorizationFilter filter;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("user-service", r -> r.path("/api/users/**")
                        .filters(f -> f.filter(filter))
                        .uri("http://localhost:8081"))
                .route("book-service", r -> r.path("/api/book/**")
                        .filters(f -> f.filter(filter))
                        .uri("http://localhost:8082"))
                .route("order-service", r -> r.path("/api/order/**")
                        .filters(f -> f.filter(filter))
                        .uri("http://localhost:8083"))
                // another route
                .build();
    }

}
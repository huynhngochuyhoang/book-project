package com.hoanghuynh.apigateway.config;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class GatewayConfig {

    private GatewayAuthorizationFilter filter;

    @Value("${user.service.url}")
    private String userServiceURL;

    @Value("${book.service.url}")
    private String bookServiceURL;

    @Value("${order.service.url}")
    private String orderServiceURL;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("user-service", r -> r.path("/api/user/**")
                        .filters(f -> f.filter(filter))
                        .uri(userServiceURL))
                .route("book-service", r -> r.path("/api/book/**")
                        .filters(f -> f.filter(filter))
                        .uri(bookServiceURL))
                .route("order-service", r -> r.path("/api/order/**")
                        .filters(f -> f.filter(filter))
                        .uri(orderServiceURL))
                // another route
                .build();
    }

}
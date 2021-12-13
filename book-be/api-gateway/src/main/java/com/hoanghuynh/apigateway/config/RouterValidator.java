package com.hoanghuynh.apigateway.config;

import org.springframework.http.server.reactive.ServerHttpRequest;

import java.util.List;
import java.util.function.Predicate;

public class RouterValidator {

    private RouterValidator() {}

    public static final List<String> openApiEndpoints = List.of(
            "/api/user/register",
            "/api/user/login"
    );

    public static final Predicate<ServerHttpRequest> isSecured = request -> openApiEndpoints.stream()
            .noneMatch(uri -> request.getURI().getPath().contains(uri));

}
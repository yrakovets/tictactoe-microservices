package com.yrakovets.tictactoe.tictactoegateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {
    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p.path("").uri("lb://tic-tac-toe-ui"))
                .route(p -> p.path("/getDesk").uri("lb://tic-tac-toe-game-manager/getDesk"))
                .route(p -> p.path("/newGame").uri("lb://tic-tac-toe-game-manager/newGame"))
                .route(p -> p.path("/newGame/**").uri("lb://tic-tac-toe-game-manager/newGame"))
                .route(p -> p.path("/makeStep/**").uri("lb://tic-tac-toe-game-manager/makeStep"))
                .build();
    }
}

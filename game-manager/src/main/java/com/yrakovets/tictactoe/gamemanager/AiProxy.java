package com.yrakovets.tictactoe.gamemanager;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="tic-tac-toe-ai")
public interface AiProxy {
    @GetMapping(path = "/getAnswer")
    int getAnswer(@RequestParam String crosses, @RequestParam String zeros, @RequestParam Boolean isCross);
}

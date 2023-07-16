package com.yrakovets.tictactoe.tictactoeAI.controller;

import com.yrakovets.tictactoe.tictactoeAI.ai.AI;
import com.yrakovets.tictactoe.tictactoeAI.ai.FieldBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AIController {

    @GetMapping(path = "/getAnswer")
    @ResponseBody
    public int getAnswer(@RequestParam String crosses, @RequestParam String zeros, @RequestParam Boolean isCross) {
        List<Character> field = new FieldBuilder().setCrosses(crosses).setZeros(zeros).build();

        return new AI().getStep(field, isCross);
    }
}

package com.yrakovets.tictactoe.tictactoeUI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UIController {

    @GetMapping(path = "")
    public ModelAndView welcome() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("tic-tac-toe.html");
        return modelAndView;
    }
}

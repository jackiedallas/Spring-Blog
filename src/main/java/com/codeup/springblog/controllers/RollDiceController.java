package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RollDiceController {




    @GetMapping("/roll-dice")
    public String rollDice() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{number}")
    @ResponseBody
    public String guessNumber(@PathVariable int number, Model model) {
        int randomNumber = (int) (Math.floor(Math.random() * 6) + 1);

        model.addAttribute("number", number);
        model.addAttribute("randomNumber", randomNumber);

        if (number == randomNumber) {
            return "<h1>Congrats! The correct number was " + randomNumber + "!</h1>";
        }
        return "<h1>You didn't guess the correct number. Number guessed was " + number + ". The correct number was " + randomNumber + ".</h1>";


    }




}

package com.example.caculator_ss2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/calculate")
public class CalculatorController {
    @GetMapping("")
    public String showList() {
        return "form";
    }

    @PostMapping("/list")
    public String calculator(@RequestParam(name = "firstNumber", defaultValue = "0") double firstNumber,
                             @RequestParam(name = "secondNumber", defaultValue = "0") double secondNumber,
                             @RequestParam(name = "operator") String operator, Model model
    ) {
        model.addAttribute("firstNumber", firstNumber);
        model.addAttribute("secondNumber", secondNumber);
        switch ( operator) {
            case "add":
                model.addAttribute("operator", "addition");
                model.addAttribute("result", firstNumber + secondNumber);
                break;
            case "sub":
                model.addAttribute("operator", "subtraction");
                model.addAttribute("result", firstNumber - secondNumber);
                break;
            case "mul":
                model.addAttribute("operator", "Multiplication");
                model.addAttribute("result", firstNumber * secondNumber);
                break;
            case "div":
                if (secondNumber == 0) {
                    model.addAttribute("result", "cannot divide by 0");
                } else {
                    model.addAttribute("operator", "Division");
                    model.addAttribute("result", firstNumber / secondNumber);
                }
                break;

        }
        return "form";
    }
}

package id.ac.ui.cs.advprog.eshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("")
public class HomePage {
    @GetMapping("")
    public String getHomePage(Model model) {
        return "HomePage";
    }
}
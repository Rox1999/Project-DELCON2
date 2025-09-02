package com.delcon.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "DEL-CON - Fast Parcel Delivery");
        return "index";
    }

    @GetMapping("/services")
    public String services(Model model) {
        model.addAttribute("title", "Our Services & Pricing - DEL-CON");
        return "services";
    }

    @GetMapping("/booking")
    public String booking(Model model) {
        model.addAttribute("title", "Book a Delivery - DEL-CON");
        return "booking";
    }
}

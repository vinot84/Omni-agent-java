package com.omniagent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BillingController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/billing")
    public String showBillingForm() {
        return "billing";
    }

    @PostMapping("/billing")
    public String submitBilling(@RequestParam String name,
                                @RequestParam String cardNumber,
                                @RequestParam String expiry,
                                @RequestParam String cvv,
                                @RequestParam String address,
                                @RequestParam String city,
                                @RequestParam String state,
                                @RequestParam String zip,
                                RedirectAttributes redirectAttributes) {
        String sql = "INSERT INTO billing_info (name, card_number, expiry, cvv, address, city, state, zip) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, name, cardNumber, expiry, cvv, address, city, state, zip);
        redirectAttributes.addFlashAttribute("message", "Payment information received. Thank you!");
        return "redirect:/";
    }
}

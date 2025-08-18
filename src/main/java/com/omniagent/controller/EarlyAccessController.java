package com.omniagent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EarlyAccessController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/early-access")
    public String showForm() {
        return "early-access";
    }

    @PostMapping("/early-access")
    public String submitForm(@RequestParam String name,
                             @RequestParam String email,
                             @RequestParam String phone,
                             RedirectAttributes redirectAttributes) {
        String sql = "INSERT INTO early_access (name, email, phone) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, name, email, phone);
        redirectAttributes.addFlashAttribute("message", "Thank you for signing up! We'll be in touch soon.");
        return "redirect:/";
    }
}

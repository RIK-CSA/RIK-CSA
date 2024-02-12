package com.nighthawk.spring_portfolio.mvc.profile;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

    @GetMapping("/profile")
    public String showProfilePage(Model model) {
        // Assuming you have a user object with username and additional details
        // You can replace it with your actual user object
        String username = "John Mort";
        String pastExperiences = "Worked at ABC Company, Software Engineer";
        String honorsAndAwards = "Employee of the Month, 2020";

        model.addAttribute("username", username);
        model.addAttribute("pastExperiences", pastExperiences);
        model.addAttribute("honorsAndAwards", honorsAndAwards);

        return "profile";
    }
}
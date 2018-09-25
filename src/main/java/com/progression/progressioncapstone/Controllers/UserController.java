package com.progression.progressioncapstone.Controllers;

import com.progression.progressioncapstone.Models.User;
import com.progression.progressioncapstone.Repositories.ProjectsRepo;
import com.progression.progressioncapstone.Repositories.Users;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private Users users;
    private PasswordEncoder passwordEncoder;
    private ProjectsRepo projectsRepo;

    public UserController(Users users, PasswordEncoder passwordEncoder, ProjectsRepo projectsRepo) {
        this.users = users;
        this.passwordEncoder = passwordEncoder;
        this.projectsRepo = projectsRepo;
    }

    @GetMapping("/register")
    public String showSignupForm(Model model){
        model.addAttribute("user", new User());
        return "users/register";
    }

    @PostMapping("/register")
    public String saveUser(@ModelAttribute User user){
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        users.save(user);
        return "redirect:/login";
    }

    @GetMapping("/profile")
    public String showProfile(Model model){
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = users.findOne(loggedInUser.getId());
        model.addAttribute("projects", projectsRepo.findAllByOwner(user.getId()));
        model.addAttribute("user", user);
        return "users/profile";
    }

}

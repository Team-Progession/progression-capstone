package com.progression.progressioncapstone.Controllers;

import com.progression.progressioncapstone.Models.*;
import com.progression.progressioncapstone.Repositories.ProjectsRepo;
import com.progression.progressioncapstone.Repositories.Users;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import sun.plugin.liveconnect.SecurityContextHelper;

@Controller
public class ProjectController {
    ProjectsRepo projectsRepo;
    Users users;

    public ProjectController(ProjectsRepo projectsRepo, Users users) {
        this.projectsRepo = projectsRepo;
        this.users = users;
    }

    @GetMapping("/project")
    public String index(Model model){
        model.addAttribute("project", projectsRepo.findAll());
        return "home";
    }

    @GetMapping("/project/{id}")
    public String show(@PathVariable long id, Model model){
        model.addAttribute("project", projectsRepo.findOne(id));
        return "project-index";
    }


    @GetMapping("/create")
    public String createForm(Model model){
        model.addAttribute("project", new Project());
        return "/project-create";
    }

    @PostMapping("/create")
    public String insertProject(@ModelAttribute Project project){
        project.setOwner((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        projectsRepo.save(project);
        return "redirect:/profile";
    }

    @GetMapping("/project/{id}/edit")
    public String projectEditForm(@PathVariable long id, Model model ){
        model.addAttribute("project", projectsRepo.findOne(id));
        return "project-edit";

    }

    @PostMapping("/project/{id}/edit")
    public String updateProject(@ModelAttribute Project project){
        projectsRepo.save(project);
        return "redirect:/project";
    }


}


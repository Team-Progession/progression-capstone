package com.progression.progressioncapstone.Controllers;

import com.progression.progressioncapstone.Models.*;
import com.progression.progressioncapstone.Repositories.ProjectsRepo;
import com.progression.progressioncapstone.Repositories.TasksRepo;
import com.progression.progressioncapstone.Repositories.Users;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProjectController {
    ProjectsRepo projectsRepo;
    Users users;
    TasksRepo tasksRepo;

    public ProjectController(ProjectsRepo projectsRepo, Users users, TasksRepo tasksRepo) {
        this.projectsRepo = projectsRepo;
        this.users = users;
        this.tasksRepo = tasksRepo;
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
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        boolean isLoggedIn = loggedInUser != null;
        User user = users.findOne(loggedInUser.getId());
        model.addAttribute("projects", projectsRepo.findAllByOwner(user.getId()));
        model.addAttribute("user", user);
        model.addAttribute("task", new Task());
        model.addAttribute("isLoggedIn", isLoggedIn);
        model.addAttribute("loggedInUser", loggedInUser);
        return "project-create";
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


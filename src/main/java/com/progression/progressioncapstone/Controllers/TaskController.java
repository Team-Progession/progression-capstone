package com.progression.progressioncapstone.Controllers;

import com.progression.progressioncapstone.Models.Project;
import com.progression.progressioncapstone.Models.Task;
import com.progression.progressioncapstone.Models.User;
import com.progression.progressioncapstone.Repositories.ProjectsRepo;
import com.progression.progressioncapstone.Repositories.TasksRepo;
import com.progression.progressioncapstone.Repositories.Users;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TaskController {
    Users users;
    ProjectsRepo projectsRepo;
    TasksRepo tasksRepo;

    public TaskController(Users users, ProjectsRepo projectsRepo, TasksRepo tasksRepo) {
        this.users = users;
        this.projectsRepo = projectsRepo;
        this.tasksRepo = tasksRepo;
    }

    @GetMapping("/task")
    public String createForm(Model model){
        model.addAttribute("task", new Task());
        return "task-show";
    }

    @PostMapping("/task")
    public String insertProject(@ModelAttribute Task task){
        tasksRepo.save(task);
        return "redirect:/profile";
    }
}

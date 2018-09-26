package com.progression.progressioncapstone.Controllers;

import com.progression.progressioncapstone.Models.Project;
import com.progression.progressioncapstone.Models.Task;
import com.progression.progressioncapstone.Models.User;
import com.progression.progressioncapstone.Repositories.ProjectsRepo;
import com.progression.progressioncapstone.Repositories.TasksRepo;
import com.progression.progressioncapstone.Repositories.Users;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/task/{projectId}")
    public String createForm(@PathVariable long projectId, Model model){
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        boolean isLoggedIn = loggedInUser != null;
        Project project = projectsRepo.findOne(projectId);
        User user = users.findOne(loggedInUser.getId());
        model.addAttribute("projects", projectsRepo.findAllByOwner(user.getId()));
        model.addAttribute("user", user);
        model.addAttribute("project", project);
        model.addAttribute("task", new Task());
        model.addAttribute("tasks", project.getTasks());
        model.addAttribute("isLoggedIn", isLoggedIn);
        model.addAttribute("loggedInUser", loggedInUser);
        return "task-show";
    }

    @PostMapping("/task/{projectId}")
    public String insertProject(@PathVariable long projectId, @ModelAttribute Task task){
        Project project = projectsRepo.findOne(projectId);
        task.setProject(project);
        tasksRepo.save(task);
        return "redirect:/task/" + projectId;
    }

    @PostMapping("/task/setComplete/{taskId}/{projectId}")
    public String setComplete(@PathVariable long taskId, @PathVariable long projectId) {
        Task task = tasksRepo.findOne(taskId);
        task.setComplete(true);
        tasksRepo.save(task);
        return "redirect:/task/" + projectId;
    }
}

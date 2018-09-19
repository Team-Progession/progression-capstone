package com.progression.progressioncapstone.Controllers;

import com.progression.progressioncapstone.Models.Project;
import com.progression.progressioncapstone.Repositories.ProjectsRepo;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProjectController {
     private final ProjectsRepo project;

    public ProjectController(ProjectsRepo project) {
        this.project = project;
    }

    @GetMapping("/project")
    public String index(Model model){
        model.addAttribute("project", project.findAll());
        return "project/index";
    }

    @GetMapping("/project/{id}")
    public String show(@PathVariable long id, Model model){
        model.addAttribute("project", project.findOne(id));
        return "project/show";
    }


    @GetMapping("/project/create")
    public String createForm(Model model){
        model.addAttribute("project", new Project());
        return "project/create";
    }

    @GetMapping("/project/{id}/edit")
    public String projectEditForm(@PathVariable long id, Model model ){
        model.addAttribute("project", project.findAll());
        return "project/edit";

    }


}


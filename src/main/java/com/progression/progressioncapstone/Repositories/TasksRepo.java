package com.progression.progressioncapstone.Repositories;

import com.progression.progressioncapstone.Models.Project;
import com.progression.progressioncapstone.Models.Task;
import org.springframework.data.repository.CrudRepository;

public interface TasksRepo extends CrudRepository <Task, Long> {
    Task findAllByTitle(String title);



}

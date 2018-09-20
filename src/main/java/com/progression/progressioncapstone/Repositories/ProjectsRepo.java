package com.progression.progressioncapstone.Repositories;

import com.progression.progressioncapstone.Models.Project;
 import org.springframework.stereotype.Repository;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface ProjectsRepo extends CrudRepository<Project, Long> {

}
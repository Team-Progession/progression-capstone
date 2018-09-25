package com.progression.progressioncapstone.Repositories;

import com.progression.progressioncapstone.Models.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

@Repository
public interface ProjectsRepo extends CrudRepository<Project, Long> {
    Project findAllByOwner(String title);

    @Query(nativeQuery= true, value="SELECT * FROM projects where owner like ?1")
    List<Project> findAllByOwner(long id);
}
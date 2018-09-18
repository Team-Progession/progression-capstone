package com.progression.progressioncapstone.Repositories;


import com.progression.progressioncapstone.Models.User;
import org.springframework.data.repository.CrudRepository;

public interface Users extends CrudRepository<User, Long> {
    User findByUsername(String username);
}

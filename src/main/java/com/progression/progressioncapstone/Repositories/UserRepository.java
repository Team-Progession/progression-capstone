package com.progression.progressioncapstone.Repositories;

import com.progression.progressioncapstone.Models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM users LIMIT 1")
    User first();
}

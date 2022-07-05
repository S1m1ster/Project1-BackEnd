package com.revature.repo;

import com.revature.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    User findUserByEmailAndPassword(String email, String Password);

    User findUserByEmail(String email);

    List<User> findAllUsersByUserId(int userId);
}

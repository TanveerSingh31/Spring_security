package com.example.spring_security.Repository;


import com.example.spring_security.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User getUserByUserName(String userName);
}

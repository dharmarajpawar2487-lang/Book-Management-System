package com.example.Book_Management.repository; 
import org.springframework.data.jpa.repository.JpaRepository; 
import com.example.Book_Management.model.User;
public interface UserRepository 
extends JpaRepository<User, Long> 
{ User findByEmail(String email);

User findByUsername(String username); }
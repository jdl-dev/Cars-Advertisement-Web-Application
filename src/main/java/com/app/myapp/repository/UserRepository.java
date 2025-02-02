package com.app.myapp.repository;

import com.app.myapp.model.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByPesel(String pesel);

    @Query(value = "SELECT email FROM cars_database.user", nativeQuery = true)
    List<String> findTableWithEmails();

    @Query(value = "SELECT pesel FROM cars_database.user", nativeQuery = true)
    List<String> findTableWithPesels();
}
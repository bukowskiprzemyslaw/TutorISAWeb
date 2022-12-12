package com.bukowskiprzemyslaw.tutorisaweb.repository;

import com.bukowskiprzemyslaw.tutorisaweb.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

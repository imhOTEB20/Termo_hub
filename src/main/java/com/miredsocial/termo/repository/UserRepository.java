package com.miredsocial.termo.repository;

import com.miredsocial.termo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

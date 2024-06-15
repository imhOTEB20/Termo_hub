package com.miredsocial.termo.repository;

import com.miredsocial.termo.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}

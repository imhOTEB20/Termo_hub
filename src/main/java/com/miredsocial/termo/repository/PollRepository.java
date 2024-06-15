package com.miredsocial.termo.repository;

import com.miredsocial.termo.models.Poll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PollRepository extends JpaRepository<Poll, Long> {
}

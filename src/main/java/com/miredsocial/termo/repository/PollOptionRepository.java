package com.miredsocial.termo.repository;

import com.miredsocial.termo.models.PollOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface PollOptionRepository extends JpaRepository<PollOption, Long> {
}

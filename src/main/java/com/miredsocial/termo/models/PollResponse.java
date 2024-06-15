package com.miredsocial.termo.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "poll_responses")
public class PollResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "response_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "poll_id")
    private Poll poll;

    @ManyToOne
    @JoinColumn(name = "option_id")
    private PollOption option;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public PollResponse (User user, Poll poll, PollOption option) {
        this.poll = poll;
        this.user = user;
        this.option = option;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public PollOption getOption() {
        return option;
    }

    public void setOption(PollOption option) {
        this.option = option;
    }

    public Poll getPoll() {
        return poll;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
    }
}

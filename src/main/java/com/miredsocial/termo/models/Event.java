package com.miredsocial.termo.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "server_id")
    private Server server;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private LocalDateTime event_date;

    @OneToMany(mappedBy = "event")
    private Set<EventInvitation> eventInvitations;

    public Event (Server server, String title, String description, LocalDateTime event_date) {
        this.server = server;
        this.title = title;
        this.description = description;
        this.event_date = event_date;
    }

    public Long getId() {
        return id;
    }

    public Server getServer() {
        return server;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getEvent_date() {
        return event_date;
    }

    public void setEvent_date(LocalDateTime event_date) {
        this.event_date = event_date;
    }
}

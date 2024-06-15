package com.miredsocial.termo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "channels")
public class Channel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "channel_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "server_id")
    private Server server;

    private String description;

    public Channel(String description, Server server) {
        this.description = description;
        this.server = server;
    }

    public Long getId() {
        return this.id;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

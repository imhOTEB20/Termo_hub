package com.miredsocial.termo.models;

import com.miredsocial.termo.miselaneo.MessageStatus;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    private String email;

    @Lob
    @Column(columnDefinition = "BYTEA")
    private byte[] profile_image = null;

    @ManyToMany
    @JoinTable(
            name = "server_onboarding",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "server_id")
    )
    private Set<Server> servers = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<EventInvitation> eventInvitations = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Message> messages = new HashSet<>();

    public User(String username, String password, String email, byte[] profile_image) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.profile_image = profile_image;
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(byte[] profile_image) {
        this.profile_image = profile_image;
    }

    public void removeMessage(Message message) {
        this.messages.remove(message);
        message.setStatus(MessageStatus.valueOf("ELIMINATED"));
    }
}

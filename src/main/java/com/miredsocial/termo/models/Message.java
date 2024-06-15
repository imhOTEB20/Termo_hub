package com.miredsocial.termo.models;

import com.miredsocial.termo.miselaneo.MessageStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "messagges")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "channel_id")
    private Channel channel;

    private String content;

    private LocalDateTime creationDate;

    private LocalDateTime update_date;

    @Enumerated(EnumType.STRING)
    private MessageStatus status = MessageStatus.UNMODIFIED;

    public Message (User user, Channel channel, String content) {
        this.user = user;
        this.channel = channel;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public Channel getChannel() {
        return channel;
    }

    public User getUser() {
        return user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public MessageStatus getStatus() {
        return status;
    }

    public void setStatus(MessageStatus status) {
        this.status = MessageStatus.fromString(String.valueOf(status));
    }

    @PrePersist
    protected void onCreate() {
        creationDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        update_date = LocalDateTime.now();
    }
}

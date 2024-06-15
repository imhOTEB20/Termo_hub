package com.miredsocial.termo.miselaneo;

public enum MessageStatus {
    UNMODIFIED("Unmodified"),
    ELIMINATED("Eliminated"),
    MODIFIED("Modified");

    private String status;
    MessageStatus (String status) {
        this.status = status;
    }

    public static MessageStatus fromString(String status) {
        for (MessageStatus messageStatus : MessageStatus.values()) {
            if (messageStatus.status.equalsIgnoreCase(status))
                return messageStatus;
        }
        throw new IllegalArgumentException("Invalid message status" + status);
    }
}

package com.findme.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.findme.models.User;

import java.util.Date;

public class PostDTO {
    private Long id;
    private String message;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date datePosted;
    private User userPosted;

    public PostDTO() {
    }

    public PostDTO(Long id, String message, Date datePosted, User userPosted) {
        this.id = id;
        this.message = message;
        this.datePosted = datePosted;
        this.userPosted = userPosted;
    }

    public PostDTO(Long id, String message, Date datePosted) {
        this.id = id;
        this.message = message;
        this.datePosted = datePosted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(Date datePosted) {
        this.datePosted = datePosted;
    }

    public User getUserPosted() {
        return userPosted;
    }

    public void setUserPosted(User userPosted) {
        this.userPosted = userPosted;
    }
}

package com.findme.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "POST")
public class Post {
    private Long id;
    private String message;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date datePosted;
    private User userPosted;
    //TODO: levels permission
    //TODO: comments


    @Id
    @SequenceGenerator(name = "POST_SEQ", sequenceName = "POST_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "POST_SEQ")
    @Column(name = "POST_ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "MESSAGE")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Column(name = "DATE_POSTED")
    public Date getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(Date datePosted) {
        this.datePosted = datePosted;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public User getUserPosted() {
        return userPosted;
    }

    public void setUserPosted(User userPosted) {
        this.userPosted = userPosted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id) &&
                Objects.equals(message, post.message) &&
                Objects.equals(datePosted, post.datePosted) &&
                Objects.equals(userPosted, post.userPosted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, message, datePosted, userPosted);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", datePosted=" + datePosted +
                ", userPosted=" + userPosted +
                '}';
    }
}

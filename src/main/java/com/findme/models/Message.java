package com.findme.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "MESSAGE")
public class Message {
    private Long id;
    private String text;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateSent;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateRead;
    private User userFrom;
    private User userTo;

    @Id
    @SequenceGenerator(name = "MESSAGE_SEQ", sequenceName = "MESSAGE_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MESSAGE_SEQ")
    @Column(name = "MESSAGE_ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "TEXT")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Column(name = "DATE_SENT")
    public Date getDateSent() {
        return dateSent;
    }

    public void setDateSent(Date dateSent) {
        this.dateSent = dateSent;
    }

    @Column(name = "DATE_READ")
    public Date getDateRead() {
        return dateRead;
    }

    public void setDateRead(Date dateRead) {
        this.dateRead = dateRead;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public User getUserFrom() {
        return userFrom;
    }

    public void setUserFrom(User userFrom) {
        this.userFrom = userFrom;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public User getUserTo() {
        return userTo;
    }

    public void setUserTo(User userTo) {
        this.userTo = userTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;
        Message message = (Message) o;
        return Objects.equals(id, message.id) &&
                Objects.equals(text, message.text) &&
                Objects.equals(dateSent, message.dateSent) &&
                Objects.equals(dateRead, message.dateRead) &&
                Objects.equals(userFrom, message.userFrom) &&
                Objects.equals(userTo, message.userTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, dateSent, dateRead, userFrom, userTo);
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", dateSent=" + dateSent +
                ", dateRead=" + dateRead +
                ", userFrom=" + userFrom +
                ", userTo=" + userTo +
                '}';
    }
}

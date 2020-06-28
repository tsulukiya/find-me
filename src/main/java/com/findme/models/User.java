package com.findme.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "USER_SOCIAL")
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    //TODO: from existed data
    private String country;
    private String city;
    private Integer age;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateRegistered;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateLastActive;
    //TODO: enum
    private String relationshipStatus;
    private String religion;
    //TODO: from existed data
    private String school;
    private String university;
    //private String [] interests;
    private List<Message>messagesSent;
    private List<Message>messagesReceived;


    @Id
    @SequenceGenerator(name = "USER_SOCIAL_SEQ", sequenceName = "USER_SOCIAL_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SOCIAL_SEQ")
    @Column(name = "USER_ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "PHONE")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "COUNTRY")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name = "CITY")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "AGE")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Column(name = "DATE_REGISTERED")
    public Date getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    @Column(name = "DATE_LAST_ACTIVE")
    public Date getDateLastActive() {
        return dateLastActive;
    }

    public void setDateLastActive(Date dateLastActive) {
        this.dateLastActive = dateLastActive;
    }

    @Column(name = "RELATIONSHIP_STATUS")
    public String getRelationshipStatus() {
        return relationshipStatus;
    }

    public void setRelationshipStatus(String relationshipStatus) {
        this.relationshipStatus = relationshipStatus;
    }

    @Column(name = "RELIGION")
    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    @Column(name = "SCHOOL")
    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Column(name = "UNIVERSITY")
    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userFrom")
    public List<Message> getMessagesSent() {
        return messagesSent;
    }

    public void setMessagesSent(List<Message> messagesSent) {
        this.messagesSent = messagesSent;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userTo")
    public List<Message> getMessagesReceived() {
        return messagesReceived;
    }

    public void setMessagesReceived(List<Message> messagesReceived) {
        this.messagesReceived = messagesReceived;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(phone, user.phone) &&
                Objects.equals(country, user.country) &&
                Objects.equals(city, user.city) &&
                Objects.equals(age, user.age) &&
                Objects.equals(dateRegistered, user.dateRegistered) &&
                Objects.equals(dateLastActive, user.dateLastActive) &&
                Objects.equals(relationshipStatus, user.relationshipStatus) &&
                Objects.equals(religion, user.religion) &&
                Objects.equals(school, user.school) &&
                Objects.equals(university, user.university) &&
                Objects.equals(messagesSent, user.messagesSent) &&
                Objects.equals(messagesReceived, user.messagesReceived);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, phone, country, city, age, dateRegistered, dateLastActive,
                relationshipStatus, religion, school, university, messagesSent, messagesReceived);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", age=" + age +
                ", dateRegistered=" + dateRegistered +
                ", dateLastActive=" + dateLastActive +
                ", relationshipStatus='" + relationshipStatus + '\'' +
                ", religion='" + religion + '\'' +
                ", school='" + school + '\'' +
                ", university='" + university + '\'' +
                ", messagesSent=" + messagesSent +
                ", messagesReceived=" + messagesReceived +
                '}';
    }
}

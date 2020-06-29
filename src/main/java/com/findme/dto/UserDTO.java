package com.findme.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class UserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    //TODO: from existed data
    private String country;
    private String city;
    private Integer age;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateRegistered;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateLastActive;
    //TODO: enum
    private String relationshipStatus;
    private String religion;
    //TODO: from existed data
    private String school;
    private String university;

    public UserDTO() {
    }

    public UserDTO(Long id, String firstName, String lastName, String phone, String country, String city, Integer age,
                   Date dateRegistered, Date dateLastActive, String relationshipStatus, String religion, String school,
                   String university) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.country = country;
        this.city = city;
        this.age = age;
        this.dateRegistered = dateRegistered;
        this.dateLastActive = dateLastActive;
        this.relationshipStatus = relationshipStatus;
        this.religion = religion;
        this.school = school;
        this.university = university;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public Date getDateLastActive() {
        return dateLastActive;
    }

    public void setDateLastActive(Date dateLastActive) {
        this.dateLastActive = dateLastActive;
    }

    public String getRelationshipStatus() {
        return relationshipStatus;
    }

    public void setRelationshipStatus(String relationshipStatus) {
        this.relationshipStatus = relationshipStatus;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }
}

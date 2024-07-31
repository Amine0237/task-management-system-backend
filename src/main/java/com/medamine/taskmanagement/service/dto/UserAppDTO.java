package com.medamine.taskmanagement.service.dto;

import java.io.Serializable;
import java.util.Objects;

public class UserAppDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String password;

    private String username;

    private String firstName;
    private String lastName;
    private String email;

    public UserAppDTO() {}

    public UserAppDTO(String password, String username, String firstName, String lastName, String email, Long id) {
        this.id = id;
        this.password = password;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAppDTO that = (UserAppDTO) o;
        return (
            Objects.equals(password, that.password) &&
            Objects.equals(username, that.username) &&
            Objects.equals(firstName, that.firstName) &&
            Objects.equals(lastName, that.lastName) &&
            Objects.equals(email, that.email)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(password, username, firstName, lastName, email);
    }

    @Override
    public String toString() {
        return (
            "UserAppDTO{" +
            "username='" +
            username +
            '\'' +
            ", firstName='" +
            firstName +
            '\'' +
            ", lastName='" +
            lastName +
            '\'' +
            ", email='" +
            email +
            '\'' +
            '}'
        );
    }
}

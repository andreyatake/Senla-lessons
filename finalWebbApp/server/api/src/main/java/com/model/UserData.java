package com.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_data")
public class UserData extends WebEntity {


    private String name;
    private String surname;
    private String patronymic;
    private Date dateOfBirth;
    private String email;
    private Role role;



    public UserData() {
    }

    public UserData(User user,
                    String name,
                    String surname,
                    String patronymic,
                    Date dateOfBirth,
                    String email,
                    Role role,
                    UserAddress address,
                    UserContact userContact) {

        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.role = role;

    }

    public UserData(Long id,
                    User user,
                    String name,
                    String surname,
                    String patronymic,
                    Date dateOfBirth,
                    String email,
                    Role role,
                    UserAddress address,
                    UserContact userContact) {
        super(id);

        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.role = role;

    }


    @Column(name = "date_of_birth")
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Column(name = "surname")
    public String getPatronymic() {
        return patronymic;
    }

    @Column(name = "patronymic")
    public String getSurname() {
        return surname;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    @Enumerated
    @Column(name = "role",columnDefinition = "smallint")
    public Role getRole() {
        return role;
    }





    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserData userData = (UserData) o;

        if (name != null ? !name.equals(userData.name) : userData.name != null) return false;
        if (surname != null ? !surname.equals(userData.surname) : userData.surname != null) return false;
        if (patronymic != null ? !patronymic.equals(userData.patronymic) : userData.patronymic != null) return false;
        if (dateOfBirth != null ? !dateOfBirth.equals(userData.dateOfBirth) : userData.dateOfBirth != null)
            return false;
        if (email != null ? !email.equals(userData.email) : userData.email != null) return false;
        return role == userData.role;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (patronymic != null ? patronymic.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }
}

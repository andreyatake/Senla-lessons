package com.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;


@Entity
@Table(name = "guest")
public class Guest extends HotelEntity {
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "surname")
    private String surname;

    public Guest( String name, String surName) {
        this.name = name;
        this.surname = surName;
    }
    @JsonCreator
    public Guest(@JsonProperty("id") Integer id, @JsonProperty("name") String name, @JsonProperty("surName") String surName) {
      super(id);
        this.name = name;
        this.surname = surName;
    }
public Guest(){}

@Getter
    public String getName() {
        return name;
    }
@Setter
    public void setName(String name) {
        this.name = name;
    }

    @Getter
    public String getSurname() {
        return surname;
    }
    @Setter
    public void setSurname(String surname) {
        this.surname = surname;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Guest that = (Guest) o;

        if (getId() != that.getId()) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result =(int) getId();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        return result;
    }
}
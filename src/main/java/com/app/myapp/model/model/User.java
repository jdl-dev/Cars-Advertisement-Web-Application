package com.app.myapp.model.model;

import com.app.myapp.model.model.user_members.Gender;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String username;
    private LocalDate birthday;

    @Column(unique = true)
    private String email;

    private String password;

    @Column(unique = true)
    private String phone;
    private String address;
    private String city;

    @Column(unique = true)
    private String pesel;

    private Gender gender;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference //prevents child from serializing parent (car is child in this case)
    private List<Car> advertisements;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<Car> getAdvertisements() {
        return advertisements;
    }

    public void setAdvertisements(List<Car> advertisements) {
        this.advertisements = advertisements;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof User user)) return false;
        return Objects.equals(getName(), user.getName()) && Objects.equals(getSurname(), user.getSurname()) && Objects.equals(getUsername(), user.getUsername()) && Objects.equals(getBirthday(), user.getBirthday()) && Objects.equals(getEmail(), user.getEmail()) && Objects.equals(getPassword(), user.getPassword()) && Objects.equals(getPhone(), user.getPhone()) && Objects.equals(getAddress(), user.getAddress()) && Objects.equals(getCity(), user.getCity()) && Objects.equals(getPesel(), user.getPesel()) && getGender() == user.getGender() && Objects.equals(getAdvertisements(), user.getAdvertisements());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getUsername(), getBirthday(), getEmail(), getPassword(), getPhone(), getAddress(), getCity(), getPesel(), getGender(), getAdvertisements());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", username='" + username + '\'' +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", pesel='" + pesel + '\'' +
                ", gender=" + gender +
                ", advertisements=" + advertisements +
                '}';
    }
}
package com.example.demo.Model;

import javax.persistence.*;

@Entity
@Table(name = "`user`")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "user_id_seq")
    @SequenceGenerator(name = "user_id_seq",
            allocationSize = 1,
            sequenceName = "user_id_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "family_name")
    private String familyName;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "position")
    private String position;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "fb")
    private String fb;

    @Column(name = "linkedin")
    private String linkedin;

    @Column(name = "role")
    private String role;

    public User(Long id,String name, String familyName, String username, String email, String password, String position,
                String phoneNumber, String fb, String linkedin, String role){
        this.id = id;
        this.name = name;
        this.familyName = familyName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.position = position;
        this.phoneNumber = phoneNumber;
        this.fb = fb;
        this.linkedin = linkedin;
        this.role = role;
    }
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public User(String id,String name, String familyName, String username, String email, String password, String position,
                String phoneNumber, String fb, String linkedin, String role) {
        this.id = Long.parseLong(id);
        this.name = name;
        this.familyName = familyName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.position = position;
        this.phoneNumber = phoneNumber;
        this.fb = fb;
        this.linkedin = linkedin;
    }


    public User(String name, String familyName, String username, String email, String password, String position,
                String phoneNumber, String fb, String linkedin, String role){
        this.name = name;
        this.familyName = familyName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.position = position;
        this.phoneNumber = phoneNumber;
        this.fb = fb;
        this.linkedin = linkedin;
        this.role = role;
    }
    public User(){

    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFb() {
        return fb;
    }

    public void setFb(String fb) {
        this.fb = fb;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

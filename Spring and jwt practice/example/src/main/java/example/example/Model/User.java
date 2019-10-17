package example.example.Model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "users", catalog = "learnrest")
public class User {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    @Column(unique = true, name = "uuid", nullable = false)
    private String uuid = UUID.randomUUID().toString().toLowerCase();


    public User() {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public String encode(String password) {

//            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

//            String encodedPassword = passwordEncoder.encode(password);

//        return encodedPassword;
        String sha256hex = org.apache.commons.codec.digest.DigestUtils.sha256Hex(password);
        return  sha256hex;
    }


}

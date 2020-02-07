package web.model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @Column (name = "city")
    private String city;

    @Column(name = "age")
    private Integer age;

    public User(){
    }

    public User(Long id, String name, String surname, String email, String city, Integer age){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.city = city;
        this.age = age;
    }

    public User( String name, String surname, String email, String city, Integer age){
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.city = city;
        this.age = age;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}

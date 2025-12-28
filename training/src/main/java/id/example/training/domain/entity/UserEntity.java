package id.example.training.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

//spring jpa annotation to set this class as entity
@Entity
//spring jpa annotation to set table name as mst_user
@Table(name = "mst_user")
public class UserEntity {

    //spring jpa annotation to set this id field as primary key
    @Id
    private UUID id;


    //spring jpa annotation to set this field as column in table
    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String password;

    //getter and setter

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}


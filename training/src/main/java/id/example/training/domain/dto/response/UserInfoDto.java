package id.example.training.domain.dto.response;


import java.util.UUID;

//class for handle response body for user info
public class UserInfoDto {

    private UUID id;
    private String name;
    private String email;

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
}


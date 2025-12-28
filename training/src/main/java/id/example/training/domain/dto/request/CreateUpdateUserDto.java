package id.example.training.domain.dto.request;


//class for handle request body for create and update user
public class CreateUpdateUserDto {

    private String name;
    private String email;
    private String password;

    //getter and setter

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


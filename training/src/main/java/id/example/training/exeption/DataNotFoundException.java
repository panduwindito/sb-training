package id.example.training.exeption;

//this class is a custom exception so we can handle a specific case
public class DataNotFoundException extends RuntimeException{
    public DataNotFoundException(String message) {
        super(message);
    }
}

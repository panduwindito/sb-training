package id.example.training.exeption;

import id.example.training.domain.dto.response.BaseResponseDto;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


//this class will handle all exception that threw in the application
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {

    //this function will handle all DataNotFoundException exception in the application
    //we will use BaseResponseDto class so the client will receive the same response format
    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<BaseResponseDto> handleDataNotFoundException(DataNotFoundException ex){
        // can add any logic like save logs or send email
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new BaseResponseDto(ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BaseResponseDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new BaseResponseDto(
                        ex.getBindingResult().getFieldError().getDefaultMessage()
                ));
    }
}

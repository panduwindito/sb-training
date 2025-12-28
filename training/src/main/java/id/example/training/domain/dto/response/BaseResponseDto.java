package id.example.training.domain.dto.response;

import java.util.UUID;


//this response will be used for base response, so all responses will have the same format
public class BaseResponseDto<T> {

    private UUID reqId;
    private String message;
    //generic used so this field can be any data type
    private T data;

    public BaseResponseDto(T data) {
        this.reqId = UUID.randomUUID();
        this.message = "Success";
        this.data = data;
    }

    public BaseResponseDto(String message) {
        this.reqId = UUID.randomUUID();
        this.message = message;
    }

    public UUID getReqId() {
        return reqId;
    }

    public void setReqId(UUID reqId) {
        this.reqId = reqId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}


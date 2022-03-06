package in.samsquare.springboot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EmptyTransaction extends RuntimeException {
    public EmptyTransaction(String s, String message){
        super(message);
    }
}

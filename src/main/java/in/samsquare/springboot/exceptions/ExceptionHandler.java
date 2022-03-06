package in.samsquare.springboot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {MissingParameters.class})
    public ResponseEntity<Object> handleException(MissingParameters m){
        ApiException exception =new ApiException(m.getMessage(), HttpStatus.BAD_REQUEST);
    return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }
}

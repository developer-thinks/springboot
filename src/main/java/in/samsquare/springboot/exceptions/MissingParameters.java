package in.samsquare.springboot.exceptions;

public class MissingParameters extends RuntimeException {

    public MissingParameters(String message){
        super(message);
    }
//    public MissingParameters(String message, Throwable cause){
//        super(message,cause);
//    }
}

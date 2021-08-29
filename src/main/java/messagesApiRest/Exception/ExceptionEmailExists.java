package messagesApiRest.Exception;

public class ExceptionEmailExists extends RuntimeException{

    public ExceptionEmailExists (String message) { super(message); }
    public ExceptionEmailExists (String message, Throwable cause) { super(message, cause);}
}

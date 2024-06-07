package in.codetech.angulareducloud.portal.exception;


public class UserFoundException extends Exception {
    public UserFoundException() {
        super("User already exists!");
    }
}

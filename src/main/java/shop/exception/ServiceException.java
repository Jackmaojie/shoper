package shop.exception;

public class ServiceException extends RuntimeException{
	public ServiceException(String message){
		super(message);
	}
    public ServiceException(String message, Exception cause) {
        super(message, cause);
    }
}

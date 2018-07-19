package shop.exception;

public class NameExistsException extends ServiceException{

	public NameExistsException() {
		super("用户名已存在！");
	}

}

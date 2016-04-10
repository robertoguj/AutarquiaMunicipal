package amc.scda.util.exception;

public class DAOException extends Exception {

	private static final long serialVersionUID = 5790608574435017170L;

	public DAOException() {
	}

	public DAOException(String message) {
		super(message);
	}

	public DAOException(Throwable cause) {
		super(cause);
	}

	public DAOException(String message, Throwable cause) {
		super(message, cause);
	}

}

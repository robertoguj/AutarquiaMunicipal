package scda.util.exception;

public class UtilException extends Exception {

	private static final long serialVersionUID = -1477709230376060887L;

	public UtilException() {
		super();
	}

	public UtilException(String message, Throwable cause) {
		super(message, cause);
	}

	public UtilException(String message) {
		super(message);
	}

	public UtilException(Throwable cause) {
		super(cause);
	}

}

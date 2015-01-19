package uas.exception;

public class UasException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String description;

	public UasException() {
		super();
	}

	public UasException(String message) {
		super(message);
	}

	public UasException(String message, String description) {
		super(message);
		this.description = description;
	}

	public UasException(String message, String description, Throwable cause) {
		super(message, cause);
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

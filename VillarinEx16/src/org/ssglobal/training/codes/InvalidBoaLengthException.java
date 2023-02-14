package org.ssglobal.training.codes;

public class InvalidBoaLengthException extends Exception {

	private static final long serialVersionUID = 566513107685211074L;
	private String message = "Invalid boa length.";
	
	public InvalidBoaLengthException() {}
	
	public InvalidBoaLengthException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
	
	@Override
	public void printStackTrace() {
		System.err.println(message);
	}

}

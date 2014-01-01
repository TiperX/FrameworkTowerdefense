package data.exceptions;

@SuppressWarnings("serial")
public class NoSuchStateException extends Exception {

	public NoSuchStateException(String s) {
		super("NoSuchStateException: Given State was: " + s);
	}
	
}

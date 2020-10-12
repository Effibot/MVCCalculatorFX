package logic;

public class DivisionByZeroException extends Exception {

	private static final long serialVersionUID = 8871399288281932081L;
	private static final String MESSAGE = "DIVISION_BY_ZERO";
	private final Throwable cause = new Throwable(MESSAGE);
	
	public DivisionByZeroException() {
		super(MESSAGE);
        this.initCause(cause);
	}

}

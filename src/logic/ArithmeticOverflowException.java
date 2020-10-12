package logic;

public class ArithmeticOverflowException extends Exception{

	private static final long serialVersionUID = -5645534816541998542L;
	private static final String MESSAGE = "ARITHMETIC_OVERFLOW";
	private final Throwable cause;	
	public ArithmeticOverflowException(String context) {
		super(MESSAGE);
		cause = new Throwable(MESSAGE+"\n"+context);
        this.initCause(cause);
        
	}
		
}

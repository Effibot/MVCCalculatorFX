package logic;

public class Model {

	public double calculate(double num1, double num2, String opCode) throws ArithmeticOverflowException, DivisionByZeroException{
		double result = 0;
		switch(opCode) {
		case "+":
			result = num1+num2;
			if(num1 > 0 && num2 > 0 && result < 0) 
				throw new ArithmeticOverflowException("Sum of positive numbers leads to negative result.");
			break;
		case "-":
			result = num1-num2;
			if(num1 < 0 && num2 < 0 && result > 0) 
				throw new ArithmeticOverflowException("Sum of negative numbers leads to positive result.");
			break;
		case "*":
			result = num1*num2;
			if(result != 0 && num1 != result/num2) {
				throw new ArithmeticOverflowException("Products of two numbers had product overflow");
			}
			break;
		case "/": 
			if(num2 == 0) throw new DivisionByZeroException();
			result = num1/num2;
			break;
			default: break;
		}
		return result;
	}
}

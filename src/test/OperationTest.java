package test;

import static org.junit.Assert.*;

import java.util.logging.Logger;

import org.junit.Test;

import logic.ArithmeticOverflowException;
import logic.DivisionByZeroException;
import logic.Model;

public class OperationTest {

	private Model model = new Model();
	private static final String[] opCode = {"+", "-", "*", "/"};
	private static final double NUM1 = 10;
	private static final double NUM2 = 4;
	private Double result;
	private Double expectedResult;
	private static final String ARITHEX = "Arithmetic Overflow Occurred";
	private static final Logger logger = Logger.getLogger(OperationTest.class.getName());
	@Test
	public void sum() {
		expectedResult = (double) 14;
		try {
			result = model.calculate(NUM1, NUM2, opCode[0]);
			assertEquals(expectedResult, result);
		} catch (ArithmeticOverflowException | DivisionByZeroException e) {
			logger.info(e.getMessage());
			fail(ARITHEX);
		}
	}
	
	@Test
	public void sub() {
		expectedResult = (double) 6;
		try {
			result = model.calculate(NUM1, NUM2, opCode[1]);
			assertEquals(expectedResult, result);
		} catch (ArithmeticOverflowException | DivisionByZeroException e) {
			logger.info(e.getMessage());
			fail(ARITHEX);
		}
	}
	@Test
	public void multiply() {
		expectedResult = (double)40;
		try {
			result = model.calculate(NUM1, NUM2, opCode[2]);
			assertEquals(expectedResult, result);
		} catch (ArithmeticOverflowException | DivisionByZeroException e) {
			logger.info(e.getMessage());
			fail(ARITHEX);
		}
		
	}
	@Test
	public void divide() {
		expectedResult = 2.5;
		try {
			result = model.calculate(NUM1, NUM2, opCode[3]);
			assertEquals(expectedResult, result);
		} catch (ArithmeticOverflowException | DivisionByZeroException e) {
			logger.info(e.getMessage());
			fail("Division by zero occurred");
		}
	}

}

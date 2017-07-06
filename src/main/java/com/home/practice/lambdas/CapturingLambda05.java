package com.home.practice.lambdas;

/**
 * @author nahusha
 *
 * A Lambda which used the parameter from the enclosing type
 * is called a CAPTURING LAMBDA
 *
 */
public class CapturingLambda05 {

	interface ITrade {
		boolean check(Trade t);
	}
	
	public static void main(String[] args) {
		Trade t = new Trade();

		// Check open trade
		ITrade iTrade = (trade) -> trade.isOpen();
		iTrade.check(t);
		
		// Check status & observe Capturing Lambda feature
		String status = "trading";
		// status variable is a local variable but is used in the body of the lambda 
		// but status should be treated as a final variable in the body of the lambda
		ITrade statusTrade = (trade) -> {
			return trade.getStatus().equals(status);
			};
		statusTrade.check(t);
	}
}

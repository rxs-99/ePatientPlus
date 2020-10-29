package com.revature.exception;

import com.revature.model.MonsterCard;

/*
 * In order to create a custom exception, we just need to extend
 * the Exception class. Note that this is a checked exception
 * because it extends and Exception but not RuntimeException.
 */
public class CardNotFaceUpException extends Exception{

	public static void main(String[] args) {
		
		/*
		 * It is good practice to be specific about the Exception you're
		 * trying to handle.
		 * 
		 * Note that you can only have one try block and that you cannot
		 * use a try block without a catch block or a catch block without
		 * a try block. Of course, you can have as many catch blocks
		 * as you want. Just make sure that your most specific exceptions
		 * are first.
		 * 
		 * You can also optionally have a finally block. A finally block always
		 * executes. As a result, it is often used to close resources such as
		 * connections to databases and streams.
		 */
		try {
			new MonsterCard().play();
		}catch(CardNotFaceUpException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("I always execute.");
		}
		
		/*
		 * This is a RuntimeException that we've created. We do not have to
		 * handle it, but we can.
		 */
		throw new MyRuntimeException();
	}
}

class MyRuntimeException extends RuntimeException{
	
}



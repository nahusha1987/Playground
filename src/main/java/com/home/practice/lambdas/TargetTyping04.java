/**
 * 
 */
package com.home.practice.lambdas;

/**
 * @author nahusha
 *
 */
public class TargetTyping04 {

	interface Email {
		String constructEmail(String name);
	}
	
	Email email = (name) -> {
		return name + "@nahusha.com";
	};
	
	private String getEmail(String name, Email email) {
		return email.constructEmail(name);
	}
	
	public static void main(String[] args) {
		String emailAddress = new TargetTyping04().getEmail("nahusha", (name) -> name + "@nahusha.com");
		System.out.println(emailAddress);
	}

}

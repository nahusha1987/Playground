/**
 * 
 */
package com.home.practice.lambdas;

/**
 * @author nahusha
 *
 */
public class LambdaScoping06 extends SuperScope {

	private String member = "FATHER";
	interface Family {
		String who(String member);
	}
	
	public void testMember(String member) {
		System.out.println("Local member : " + member);
		System.out.println("Family member : " + this.member);
		System.out.println("Super member : " + super.member);
		
		Family familyLambda = (familyMember) -> {
			System.out.println("Local member : " + familyMember);
			System.out.println("Local member : " + member);
			System.out.println("Family member : " + this.member);
			System.out.println("Super member : " + super.member);
			return familyMember;
		};
		familyLambda.who(member);
	}
	
	public static void main(String[] args) {
		new LambdaScoping06().testMember("SON");
	}

}

class SuperScope {
	public String member = "GRANDPA"; 
}

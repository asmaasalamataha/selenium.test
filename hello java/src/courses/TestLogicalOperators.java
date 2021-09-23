package courses;

public class TestLogicalOperators {

	public static void main(String[] args) {
		boolean x = 100 > 99 , y = 99 > 100 ; 

		// Logical operator "&&" AND
		// el etnen mat7a2osh m3 ba3d fy wa7da false w wa7da true yab2a false 
		System.out.println("What is the result of 100 > 99 && 99 > 100 ? " + (x && y));

		// Logical OR || operator
		System.out.println("What is the result of 100 > 99 || 99 > 100 ? " + (x || y));

		//Logical operator XOR ^ 
		System.out.println("What is the result of 100 > 99 ^ 99 > 100 ? " + (x ^ y));


		// Logical operator Not !
		// btrg3 el natega el 3aksya bata3t ya3ny lw el natega true btrg3 false 
		System.out.println("What is the result of not 100 > 99 ? " + (!x));

		// Logical operator Not !
		System.out.println("What is the result of not 100 > 99 ? " + (!y));

	}

	}



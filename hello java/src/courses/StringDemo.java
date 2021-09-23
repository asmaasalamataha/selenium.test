package courses;

public class StringDemo {

	public static void main(String[] args) {
		
		String greeting = "Hello World" ;
		String firstname = "Asmaa ";
		String Lastname = "Salama";
		String Fullname = firstname.concat(Lastname);
		int len = greeting.length();
		
		System.out.println(greeting);
		System.out.println(len);
		System.out.println(firstname + Lastname);
		System.out.println(Fullname);

	}

}

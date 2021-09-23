package courses;
//Class name 

public class EnglishCourse {
	
	//defiend variabls

	int students;
	int weeks;
	int days ;
	
	
	public static void main(String[] args) {
		// object 
		EnglishCourse Eng101 = new EnglishCourse();
		int totalDays ;
		
		Eng101.students = 10;
		Eng101.days= 4;
		Eng101.weeks= 3 ;
		
		totalDays = Eng101.weeks * Eng101.days ;
		System.out.println("the total days of the course will be " + totalDays + " Days");
				
		
		
		
	}

}

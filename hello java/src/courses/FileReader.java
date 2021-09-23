package courses;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// io >> is packag name( input,output >> File this the class name found in io package

public class FileReader {

	public static void main(String[] args) {
		
		// take object from class(File) ely mawgod fy el package io 
		File file = new File("Hello.txt");
		//lw 3aeza a7oto 3la c 
		//File file = new File("c:\\Hello.txt");
		try {
			
			// using method >> createNewfile found in the class File to(create the file in pervious path)
			file.createNewFile();
			FileWriter Writer = new FileWriter(file);
			Writer.write("Hello from created file");
			// method bast5dmha 3ashan yabd2 yaktb
			Writer.flush();
			Writer.close();
			
			// method bast5dmha 3ashan ya2ra ely mawgod fy ely file
			BufferedReader Reader = new BufferedReader(new java.io.FileReader(file));
			// 3aeza ad5ol goa el file w a2ra str str 
			String line ;
			
			while ((line= Reader.readLine()) != null) {
				
				System.out.println(line);
			}
			
			Reader.close();
					
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		
		

	}

}

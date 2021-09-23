package data;

import java.io.File;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class JsonDataReader {
	
	public String firstname , lastname, email , password ;
	
	public void jsonreader()  throws IOException, ParseException {
		
		
		String filepath = ("D:\\seleniumcourse\\eclipse\\selenium.test\\src\\test\\java\\data\\UserData.Json");
		File scrfile = new File(filepath);
		
		JSONParser parser = new JSONParser();
		JSONArray jarray = (JSONArray)parser.parse(new FileReader(scrfile));
				

		for(Object jsonObj : jarray) 
		{
			
			//custing from object
			JSONObject person = (JSONObject) jsonObj ; 
			firstname  = (String) person.get("firstname"); 
			System.out.println(firstname);

			lastname = (String) person.get("lastname"); 
			System.out.println(lastname);

			email = (String) person.get("email"); 
			System.out.println(email);

			password = (String) person.get("password"); 
			System.out.println(password);

		}

	}
		
		
		
		
		
		
		
	}
	
	
	



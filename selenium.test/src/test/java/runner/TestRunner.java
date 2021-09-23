package runner;

import io.cucumber.testng.CucumberOptions;
import tests.TestBase;


// extend from testbase 3ashan hea ely feha el driver w hatft7ly el chrome 

// bst5dm anotation cucumber options 3ashan a3rf a run el features w el steps bata3ty 
// glue ba2lo el steps bata3ty mawgoda fan mawgoda fan

//@CucumberOptions(features={"src/test/java/features/AutomatedE2ETests.feature","src/test/java/features/UserRegisteration.feature"}, 
//glue={"steps"}
//,plugin={"pretty","html:target/cucumber-html-report.html"})
//@CucumberOptions(features="src\\test\\java\\features",		
//glue= {"steps"}
//,plugin= {"pretty","html:target/cucumber-html-report.html"})

@CucumberOptions(features="src/test/java/features",
glue= {"steps"}
//,tags={"@login","@checkout"}
,plugin= {"pretty","html:target/cucumber-html-report.html"})



public class TestRunner extends TestBase
{
	

} 



	
	
	
	
	
	


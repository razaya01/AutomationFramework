package testRunner;		

//import org.junit.runner.RunWith;		
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;		
//import cucumber.api.junit.Cucumber;		

//@RunWith(Cucumber.class)				
@CucumberOptions
(features="D:\\Jebesh\\Microservices\\Maven_cucumber_TestNg\\src\\test\\resources\\featureFiles\\login_testing.feature",
glue={"com.yasin.test.scripts"})						
public class Runner extends AbstractTestNGCucumberTests			
{		

}
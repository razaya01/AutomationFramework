package ReusableFunctions;
import java.io.FileReader;
import java.util.Properties;

public class ReadPropertyFile {

	//*************************** get environment url to login into homepage********************************************	
		public static String getUrl() throws Exception{
			FileReader reader = new FileReader("D:\\Jebesh\\Microservices\\Maven_cucumber_TestNg\\src\\test\\resources\\PropertiesFile\\env-aubdfrci.properties");
	        Properties prop = new Properties();
	        prop.load(reader);
	        String Bdfrci_url = prop.getProperty("url");
	        return Bdfrci_url;
		}
		
//*****************************************get jenkins afa url************************************************************
		public static String getJenkinsUrl_afa() throws Exception{
			FileReader reader = new FileReader("D:\\Jebesh\\Microservices\\Maven_cucumber_TestNg\\src\\test\\resources\\PropertiesFile\\env-aubdfrci.properties");
	        Properties prop = new Properties();
	        prop.load(reader);
	        String jenkins_afa = prop.getProperty("jenkins_afa_suit_url");
	        return jenkins_afa;
		} 
		public static String getJenkinsUrl_newframework() throws Exception{
			FileReader reader = new FileReader("D:\\Jebesh\\Microservices\\Maven_cucumber_TestNg\\src\\test\\resources\\PropertiesFile\\env-aubdfrci.properties");
	        Properties prop = new Properties();
	        prop.load(reader);
	        String jenkins_NF = prop.getProperty("jenkins_nf_suit_url");
	        return jenkins_NF;
		}
		public static String getJenkinsUrl_radiator() throws Exception{
			FileReader reader = new FileReader("D:\\Jebesh\\Microservices\\Maven_cucumber_TestNg\\src\\test\\resources\\PropertiesFile\\env-aubdfrci.properties");
	        Properties prop = new Properties();
	        prop.load(reader);
	        String jenkins_NF = prop.getProperty("jenkins_radiator");
	        return jenkins_NF;
		}
//***************************************get jenkins credentials**************************
		public static String getJenkins_userid() throws Exception{
			FileReader reader = new FileReader("D:\\Jebesh\\Microservices\\Maven_cucumber_TestNg\\src\\test\\resources\\PropertiesFile\\env-aubdfrci.properties");
	        Properties prop = new Properties();
	        prop.load(reader);
	        String jenkins_id = prop.getProperty("jenkins_userid");
	        return jenkins_id;
		}
		public static String getJenkins_password() throws Exception{
			FileReader reader = new FileReader("D:\\Jebesh\\Microservices\\Maven_cucumber_TestNg\\src\\test\\resources\\PropertiesFile\\env-aubdfrci.properties");
	        Properties prop = new Properties();
	        prop.load(reader);
	        String jenkins_pswd = prop.getProperty("jenkins_pswd");
	        return jenkins_pswd;
		}
//*****************************get opco name******************************************************************************		

		
		public static String getOpco() throws Exception{
			FileReader reader = new FileReader("D:\\Jebesh\\Microservices\\Maven_cucumber_TestNg\\src\\test\\resources\\PropertiesFile\\env-aubdfrci.properties");
	        Properties prop = new Properties();
	        prop.load(reader);
	        String opco_afa = prop.getProperty("opco");
	        return opco_afa;
		}	
//*************************get queries**************************************************************************************
		public static String getXmlQuery() throws Exception{
			FileReader reader = new FileReader("D:\\Jebesh\\Microservices\\Maven_cucumber_TestNg\\src\\test\\resources\\PropertiesFile\\env-aubdfrci.properties");
	        Properties prop = new Properties();
	        prop.load(reader);
	        String opco_afa = prop.getProperty("xmlQuery");
	        return opco_afa;
		}	
//***************************get store location which need to enter during login*********************************************
	public static String getStore() throws Exception{
		FileReader read = new FileReader("D:\\Jebesh\\Microservices\\Maven_cucumber_TestNg\\src\\test\\resources\\PropertiesFile\\env-aubdfrci.properties");
      Properties prop = new Properties();
      prop.load(read);
      String Bdfrci_storeLoc = prop.getProperty("store_location");
      return Bdfrci_storeLoc;
	}
	

	
	


	
	
}

package seleniumWebDriverLearning;

public class UrlAmmend {
	
	public static void main(String[] args) {
		String url = "https://www.guru99.com/parameterization-using-xml-and-dataproviders-selenium.html";
		int len = url.length();
		String finalUrl = url.substring(0, len-4);
		System.out.println(finalUrl);
	}

}

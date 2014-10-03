import java.util.*;

public class CitiesCountries {
	public static void main(String args[]){
		Hashtable<String, String> h = new Hashtable<String, String>();
		
		h.put("Tokyo", "Japan");
		h.put("Beijing", "China");
		h.put("Bangkok", "Thailand");
		h.put("Taipei", "Taiwan");
		h.put("Shanhai", "China");
		h.put("Seoul", "South Korea");
		h.put("Bombay", "India");
		
		if(args.length == 0){
			System.out.println("Supply the name of a city as" + "a command line argument!!");
			//return;
		}
		
		for(int i = 0; i < args.length; i++){
			String city = args[i];
			String country = h.get(city);
			if(country == null){
				System.out.println(city + "is not located in the hashtable");
			}else{
				System.out.println(city + "is located in " + country);
			}
		}
	}
}

class getCitiesCountries{
	String cityName, countryName;
	
	getCitiesCountries(String cityName, String countryName){
		this.cityName = cityName;
		this.countryName = countryName;
	}
}
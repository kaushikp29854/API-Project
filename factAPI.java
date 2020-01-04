import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class factAPI {


	private String horoscope;

	public void HoroscopeAPI(String input) throws Exception{
	
	String fact;
	

	
	String endpoint =	"http://ohmanda.com/api/horoscope/";

	// Make a GET request to the API.
    URL url = new URL("http://ohmanda.com/api/horoscope/" + input );
    HttpURLConnection http = (HttpURLConnection) url.openConnection();
 
    http.setRequestMethod("GET");

    // Data returned from API is read. 
    BufferedReader reader = new BufferedReader(new InputStreamReader(http.getInputStream()));
    StringBuilder data = new StringBuilder();

    String line;
    while ((line = reader.readLine()) != null) {
        data.append(line);
    }
    String newResult;
    newResult= data.toString();
    

    reader.close();
    
    //returning the formatted data
    pparsingJSON(newResult);
	}
    
	 public void pparsingJSON(String newResult1) {
		 
		 // Parse entire JSON string and convert to object
	        JsonObject obj = new JsonParser().parse(newResult1).getAsJsonObject();

	        String horoscope =obj.get("horoscope").getAsString();
	    
	        MainParsing1(horoscope);
	 }
	 
	 //getter and setter functions
	public void MainParsing1( String horoscope) {
			this.horoscope = horoscope;
	}
		
	 
	 public String toString() { 
	        return String.format("%s", horoscope);
	}
    
			
	public String getHoroscope() {
			return horoscope;
	}
	
	public void setHoroscope(String horoscope) {
		this.horoscope = horoscope;
	}
	
	}

	


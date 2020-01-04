
import org.jibble.pircbot.*;



public class bot extends PircBot

{ 
		//calling MainParser function for weather API
		MainParser parsing = new MainParser();

		factAPI parsing2 = new factAPI();
//constructor 

public bot(){

       this.setName("KP29"); //this is the name the bot will use to join the IRC server

   }



public void onMessage(String channel, String sender, String login, String hostname, String message)
 {
	message.toLowerCase(); 
	String weather;
	String location;
	String birthSign;
	
	if(message.contains("weather")) 
	{
		//split the message
		String input [] =message.split(" "); 
		
		//if the first element is weather call weather API
		if(input[0].equals("weather"))
		{
			location = input[1];
			try {
				
				parsing.weatherAPI(location);
				String output = parsing.toString();
				sendMessage(channel, output);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//if first element is horocope split and call API for horoscope
	}else if(message.contains("horoscope")) {
		 String input []  =message.split(" ");
		
		 if(input[0].equals("horoscope")) {
		   
			 birthSign =input[1];
			try {
				parsing2.HoroscopeAPI(birthSign);
				String output = parsing2.toString();
				sendMessage(channel, output);
			}catch(Exception e) {
				
				e.printStackTrace();
			}
			
		}
	}
	
	
	if (message.equalsIgnoreCase("hello")) 
	{
	sendMessage(channel,"Hello My friend");
	} 


    } 

}




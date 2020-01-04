
import java.util.*;
import org.jibble.pircbot.*;



public class ChatBot

{
        
   public static void main(String[] args) throws Exception
   {
	   
	   
	   
	   Scanner input = new Scanner(System.in);

	   //creates a new bot
       bot ChatBot = new bot();

       ChatBot.setVerbose(true);

     //tells it where to connect to
       ChatBot.connect("irc.freenode.net"); 

       //name of channel
       ChatBot.joinChannel("#KPChannel"); 
       
       //this is the default message it will send when your pircbot first goes live 
       ChatBot.sendMessage("#KPChannel", "Hey! Enter weather followed by your location and I will give you  weather details!!");
       ChatBot.sendMessage("#KPChannel", "Or enter horoscope followed by your birthsign");
        
       String message = input.nextLine();

   }

}


import java.util.Arrays;

public class UpperCases {

	public static void main(String[] args) {
		
		
		String input = "iQRaJaV";

		String upper = input.toUpperCase();
		String lower = input.toLowerCase();
		System.out.println("Print the string " + upper);
		System.out.println("print in lower cases " + lower);
		
		int letter = input.length();
		  System.out.println(letter);
		 /* 
		  String[] r = input.split("(?<=.)(?=\\p{Lu})");
		  System.out.println(Arrays.toString(r));*/

			    String new_string = "";
			    String uppercase ="";
			    String lowerCase ="";
			    for (int i=0; i < input.length(); i++){
			        char c = input.charAt(i);
			        if(Character.isUpperCase(c)){               
			        	uppercase += c;
			        }
			        else {
			        	lowerCase += c;
			        }
			    }
			    
			    System.out.println( uppercase);
			   
			}
		 
	}
	
		
	


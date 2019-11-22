
public class InterviewReverseString {

	public static void main(String[] args) {
		String s="javeria";
		String t = "";
		
		
		
		for(int i= s.length()-1; i>=0; i--) {
			t = t + s.charAt(i);
		}
		System.out.println(t);
		
		 if (t.equals(s))

         {

System.out.println("String is Palindrome ");

         }

else {

System.out.println("string is not Palindrome ");

    }

}

	}



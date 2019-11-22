
public class StringHandling {

	public static void main(String[] args) {
		//payment $100 paid
		String str = "Payment $100 Paid";
		String str1 = "Payments $100 Paid";

		int s = str.length();
		System.out.println(s);
		
		
		System.out.println(str.charAt(8));
		
		System.out.println(str.indexOf("$"));
		
		System.out.println(str1.indexOf("$"));
		
		
		System.out.println(str.toUpperCase());
		
		System.out.println(str.toLowerCase());
		
		System.out.println(str.contains("$"));
		
		System.out.println(str.substring(8, 14));
	
	
	}

}

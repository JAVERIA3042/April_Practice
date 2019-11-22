
public class ArrayDemo {

	public static void main(String[] args) {
		int a[] = new int [5]; // Declare the array and allocate memory of the variable
		a[0] =5;
		a[1]=1;
		a[2]=2;
		a[3]=5;
		a[4]=6;
		for(int i=0; i<a.length; i++) {
			System.out.println(a[i]);
		}
		System.out.println(a.length);

	}

}

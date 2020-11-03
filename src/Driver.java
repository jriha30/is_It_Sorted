import java.util.Random;

public class Driver
{
	public static void main(String[] args)
	{
		int[] ar = Driver.createArray();
		int counter = 0;
		
		do 
		{
			ar = Driver.createArray();
			Driver.displayArray(ar);
			System.out.println("\n");
			counter++;
		}
		while(!Driver.checkIfSorted(ar));
		
		System.out.println(counter);
	}
	
	public static boolean checkIfSorted(int[] ar)
	{
		for(int i = 0; i < ar.length - 1; i++)
		{
			if(ar[i] > ar[i + 1])
			{
				return false;
			}
		}
		return true;
	}
	
	public static int[] createArray()
	{
		Random r = new Random();
		
		int[] ar = new int[10];
		for(int i = 0; i < ar.length; i++)
		{
			int num = r.nextInt(10);
			ar[i] = num;
		}
		return ar;
	}
	
	public static void displayArray(int[] ar)
	{
		for(int s : ar)
		{
			System.out.println(s);
		}
	}
}
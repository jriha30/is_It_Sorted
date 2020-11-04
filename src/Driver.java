import java.util.Random;
import java.util.Scanner;
import java.time.*;

public class Driver
{
	public static void main(String[] args)
	{
		Scanner myObj = new Scanner(System.in);
		System.out.println("What size array would you like to create? ");
		String input = myObj.nextLine();
		myObj.close();
		int size = Integer.parseInt(input);
		System.out.println("Processing . . .\n");
		long counter = 0;
		int[] ar;
		Clock clockBegin = Clock.systemDefaultZone();
		int totalMillisecondsStart = Driver.getStringFromClock(clockBegin);

		do 
		{
			ar = Driver.createArray(size);
//			Driver.displayArray(ar);
//			System.out.println("\n");
			counter++;
		}
		while(!Driver.checkIfSorted(ar));
		
		String counterString = counter + "";
		Clock clockEnd = Clock.systemDefaultZone();
		int totalMillisecondsEnd = Driver.getStringFromClock(clockEnd);
		int totalMilliseconds = Driver.subtractTimes(totalMillisecondsStart, totalMillisecondsEnd);
		System.out.println("Total Runtime (in milliseconds): " + totalMilliseconds + "\nTotal Runtime: " + Driver.millisecondsToHMS(totalMilliseconds) + "\n\nTotal Array Count: " + Driver.addCommas(counterString) + "\n");
		Driver.displayArray(ar);
	}
	
	public static String addCommas(String aString)
	{
		String newString = "";
		int counter = 0;
		for(int i = aString.length() - 1; i >= 0; i--)
		{
			counter++;
			if(counter % 3 == 0 && i != 0)
			{
				newString = "," + aString.charAt(i) + newString;
			}
			else
			{
				newString = aString.charAt(i) + newString;
			}
		}
		return newString;
	}
	
	public static int getStringFromClock(Clock clock)
	{
		clock = Clock.systemDefaultZone();
		Instant clockBegin = clock.instant();
		
		String clockBeginString = clockBegin + "";
		String timeString = "";
		for(int i = 11; i <= 22; i++)
		{
			if(i == 19)
			{
				timeString = timeString + ":";
			}
			else
			{
				timeString = timeString + clockBeginString.charAt(i);
			}
		}
		return Driver.getTimeListFromClockString(timeString);
	}
	
	public static int getTimeListFromClockString(String timeString)
	{
		String[] stringArray = timeString.split(":");
		return Driver.stringArrayToIntArray(stringArray);
	}
	
	public static int stringArrayToIntArray(String[] stringArray)
	{
		int[] intTimeArray = new int[stringArray.length];
		for(int i = 0; i < intTimeArray.length; i++)
		{
			intTimeArray[i] = Integer.parseInt(stringArray[i]);
		}
		return Driver.getMilliseconds(intTimeArray);
	}
	
	public static int getMilliseconds(int[] intTimeArray)
	{
		int timeInMilliseconds = 0;
		intTimeArray[0] *= 3600000;
		intTimeArray[1] *= 60000;
		intTimeArray[2] *= 1000;
		
		for(int i = 0; i < intTimeArray.length; i++)
		{
			timeInMilliseconds += intTimeArray[i];
		}
		return timeInMilliseconds;
	}
	
	public static int subtractTimes(int clockStart, int clockEnd)
	{
		return clockEnd - clockStart;
	}
	
	public static String millisecondsToHMS(int ms)
	{
		int hours;
		int minutes;
		int seconds;
		hours = ms / 3600000;
		ms %= 3600000;
		minutes = ms / 60000;
		ms %= 60000;
		seconds = ms / 1000;
		ms %= 1000;
		return (hours + " Hours " + minutes + " Minutes " + seconds + " Seconds " + ms + " Milliseconds.");
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
	
	public static int[] createArray(int arraySize)
	{
		Random r = new Random();
		
		int[] ar = new int[arraySize];
		for(int i = 0; i < ar.length; i++)
		{
			int num = r.nextInt(1000);
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
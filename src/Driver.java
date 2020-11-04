import java.util.Random;
import java.time.*;

public class Driver
{
	public static void main(String[] args)
	{
		int counter = 0;
		int[] ar = Driver.createArray();
		Clock clockBegin = Clock.systemDefaultZone();
		int totalMillisecondsStart = Driver.getStringFromClock(clockBegin);
		do 
		{
			ar = Driver.createArray();
//			Driver.displayArray(ar);
//			System.out.println("\n");
			counter++;
		}
		while(!Driver.checkIfSorted(ar));
		
		Clock clockEnd = Clock.systemDefaultZone();
		int totalMillisecondsEnd = Driver.getStringFromClock(clockEnd);
		int totalMilliseconds = Driver.subtractTimes(totalMillisecondsStart, totalMillisecondsEnd);
		System.out.println("Total Runtime (in milliseconds): " + totalMilliseconds);
		System.out.println("Total Runtime: " + Driver.millisecondsToHMS(totalMilliseconds) + "\n");
		System.out.println("Total Array Count: " + counter + "\n");
		Driver.displayArray(ar);
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
		int hours = 0;
		int minutes = 0;
		int seconds = 0;
		
		
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
	
	public static int[] createArray()
	{
		Random r = new Random();
		
		int[] ar = new int[10];
		for(int i = 0; i < ar.length; i++)
		{
			int num = r.nextInt(100);
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
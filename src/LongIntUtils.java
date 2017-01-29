// Called using LongIntUtils.method(...)

public class LongIntUtils {

	//returns the overflow (digits 9+ of an integer)
	//by dividing the number by 100000000, the remaining is the overflow
	public static int overflow(int t) {
		int over = t/100000000;
		if ( over < 1)
		{
			return 0;
		}
		else
		{
			return over;
		}
	}

	//returns digits 1 to 8 of a integer
	//by modulo of 100000000
	//because the remainder is the digits 1-8
	public static int underflow(int t) {
		int under = t%100000000;
		return under;
	}

	//returns digits 5 to 8
	//first by removing ending 4 digits through division
	//then getting each ending digits multiplying it by 1,10,100,1000 respectively
	//and adding all those digits(to get digits 5 to 8)
	public static int upperHalf(int t) {
		int upper = 0;
		int i = 0;
		int u = t/10000;
		
		if ( t <= 9999)
		{
			return 0;
		}
		
		while ( (u > 0) && (i < 4))
		{
			upper = upper + ((u%10)*(int)(Math.pow(10, i)));
			i++;
			u = u/10;
		}
		return upper;
	}

	//returns digits 1 to 4
	//similar to upperHalf
	//gets each ending digit and multiplies it by 1,10,100,1000 
	//and adds all those digits
	public static int lowerHalf(int t) {
		int lower = 0;
		int i = 0;
		
		while ( (t > 0) && (i < 4))
		{
			lower = (lower + ((t%10)*(int)(Math.pow(10, i))));
			i++;
			t = t/10;
		}
		return lower;
	}

	//returns number of digits in t through division
	public static int digits(int t) {
		int numOfDigits = 0;
		if (t == 0)
		{
			return 1;
		}
		while ( t > 0)
		{
			numOfDigits++;
			t = (t/10);
		}
		return numOfDigits;
	}
}
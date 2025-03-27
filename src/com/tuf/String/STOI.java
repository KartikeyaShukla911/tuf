package com.tuf.String;

public class STOI {
	
	public static int stoi(String s)
	{
		if(s==null || s.length()==0)
		{
			return 0;
		}
		int n  = s.length();
		int i=0;
		//avoid spacing
		while(i<n && s.charAt(i)==' ')
			i++;
		
		int sign=1;
		if(i<n)
		{
			sign = s.charAt(i)=='-' ? -1 : 1;
		}
		
		if(sign==-1)
			i++;
		
		int result=0;
		
		while(i<n && Character.isDigit(s.charAt(i)))
		{
			result = result*10 + (s.charAt(i)-'0');
			
			if(result>=Integer.MAX_VALUE || result<=Integer.MIN_VALUE)
				return (sign==-1 ? Integer.MIN_VALUE : Integer.MAX_VALUE);
			i++;
		}
		
		return (result * sign);
		
	}
	
	public static String ATOI(int n)
	{
		if(n==0)
			return "0";
		int i;
		int sign=1;
		StringBuilder ans= new StringBuilder();
		if(n<0) {
			sign=-1;
			n=-n;
		}
		
		while(n!=0)
		{
			int digit = n%10;
			ans.append(digit);
			n=n/10;
		}
		String s="";
		if(sign==-1)
		{
			s+="-";
		}
		s+=ans.reverse().toString();
		return s;
	}
	
	/*
	 * Minimum: Integer.MIN_VALUE = -2,147,483,648

Maximum: Integer.MAX_VALUE = 2,147,483,647
O N
S 1
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = stoi("2147483643");
		System.out.println(x);
		System.out.println(ATOI(-554));
	}

}
 
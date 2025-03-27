package com.tuf.Stack2;

public class ReverseWords {
	
	public static void reverseWords(String arr,int n)
	{
		String[] temp = arr.split(" ");
		int i;
		String ans="";
		for(i=n-1;i>=0;i--)
		{
			ans = ans + temp[i]+" ";
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}

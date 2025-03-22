package com.tuf.Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CountBracketPower {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//String s = "((5)*((9)))+(2)+1";
		String s = "((5)*((9)))+(2)+1";
		
		System.out.println("Number with highest Brackets: "+ countBracket(s));
	}

	public static int countBracket(String s)
	{
		int n = s.length();
		if(n<=1)
			return -1;
		
		Stack<Character> st = new Stack();
		int i;
		int max=0;
		HashMap<Character,Integer> hm = new HashMap();
		char[] crr= s.toCharArray();
		for(i=0;i<n;i++)
		{
			if(crr[i]=='(')
			{
				st.push(crr[i]); // stack size is the power
			}
			else if(crr[i]>='0' && crr[i]<='9')
			{
				//st.push(crr[i]);
				hm.put(crr[i], st.size());
			}
			else if(crr[i]==')')
			{
				char temp = st.peek();
				if(temp=='(')
				{
					st.pop();
				}
			}
		}
		int ans = 0;
		for(Map.Entry<Character,Integer> entry : hm.entrySet())
		{
			char number = entry.getKey();
			if(max<hm.get(number))
			{
				max = hm.get(number);
				ans = number - '0';
			}
			
		}
		 
		return ans;
	}
}

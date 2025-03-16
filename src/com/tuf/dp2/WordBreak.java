package com.tuf.dp2;

import java.util.HashMap;
import java.util.List;

public class WordBreak {
	
	HashMap<String,Boolean> hm = new HashMap();
	public boolean WordBreak(String s, List<String> words)
	{
		
		if(s.isEmpty())
			return true;
		
		int n = s.length();
		
		if(hm.containsKey(s))
			return hm.get(s);
		
		int k;
		for(k=0;k<n;k++)
		{
			String prefix = s.substring(0,k);
			
			if(words.contains(prefix) && WordBreak(s.substring(k),words))
			{
				hm.put(prefix,true);
				break;
			}
		hm.put(prefix,false);
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

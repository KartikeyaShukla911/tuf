package com.tuf.arrays.misc2;

import java.util.HashMap;

public class LongestSubstringNoRepeat {
	
	static int solve(String s) {
        HashMap < Character, Integer > mpp = new HashMap < Character, Integer > ();

        int left = 0, right = 0;
        int n = s.length();
        int len = 0;
        while (right < n) {
            if (mpp.containsKey(s.charAt(right))) left = Math.max(mpp.get(s.charAt(right)) + 1, left);

            mpp.put(s.charAt(right), right);

            len = Math.max(len, right - left + 1);
            right++;
        }
        return len;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

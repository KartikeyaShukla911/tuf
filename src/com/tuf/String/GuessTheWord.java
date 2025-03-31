package com.tuf.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GuessTheWord {
	
	/*
	 * https://leetcode.com/problems/guess-the-word/description/
	 * LC - HARD
	 * eliminate the guess, with master, as soon as we get the matches from master to guess word
	 * update the list and reiterate
	 * make sure to find ans withing 10 and match should not be 6,
	 * if 6 that means we found one
	 */
	
	public static void Guess(String[] arr, Master master)
	{
		List<String> wordList = new ArrayList(Arrays.asList(arr));
		
		Random random = new Random();
		// using random, to eliminates searches, kind of optimizing the brute and probability approach
		
		int i;

		int n = wordList.size();
		for(i=0;i<10;i++)
		{
			String word = wordList.get(random.nextInt(n-1));
			int masterWord = master.findWord(word);
			if(masterWord==6)
			{
				// word found, return
				return;
			}
			wordList = findNewWordList(masterWord,wordList);
		}
	}
	
	public static List<String> findNewWordList(int masterWord,List<String> wordList)
	{
		List<String> ans = new ArrayList();
		int i,j;
		for(j=0;j<wordList.size();j++) {
			String word = wordList.get(j);
			int cnt=0;
			for(i=0;i<word.length() && i<masterWord.length();i++)
			{
				if(word.charAt(i)==masterWord.charAt(i))
				cnt++;
			}
			if(cnt==masterWord)
				ans.add(word);
		}
		return ans;
	}
	
	/*
	 * O 10 x N words
	 * S = N
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

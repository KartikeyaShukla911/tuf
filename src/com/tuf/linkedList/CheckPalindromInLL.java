package com.tuf.linkedList;

public class CheckPalindromInLL {
	
	public static boolean checkPalindrom(Node root)
	{
		if(root==null)
			return true;
		
		if(root.next==null)
			return true;
		
		/*
		 * either use a String array and check for the first and second half
		 */
		
		Node slow = root, fast = root;
		while(slow!=null && fast!=null && fast.next!=null)
		{
			slow=slow.next;
			fast=fast.next.next;
		}
		
		Node first = root, second = slow.next;
		Node temp = slow.next;
		slow.next=null;
		// halfed elements
		
		
		second = reverseList(second);
		
		while(first!=null && second!=null)
		{
			if(first.val!=second.val)
				return false;
			
			first=first.next;second=second.next;
		}
		
		// else it's palindrome
		
		second = temp;
		second = reverseList(second);
		
		temp.next = second;
		return true;
	}
	
	public static Node reverseList(Node second)
	{
		Node curr=second;
		Node prev = null;
		while(curr!=null)
		{
			Node temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		return prev;
	}
	
	/*
	 * O N = 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

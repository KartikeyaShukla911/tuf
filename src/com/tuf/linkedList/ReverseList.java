package com.tuf.linkedList;

class Node
{
	int val;
	Node next = null;
}

public class ReverseList {
	
	public static void reverseList(Node root)
	{
		if(root==null)
			return;
		
		Node curr = root;
		Node prev=null;
		while(curr!=null)
		{
			Node temp=curr.next;
			temp.next = prev;
			prev=temp;
			curr=temp;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

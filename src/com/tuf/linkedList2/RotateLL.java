package com.tuf.linkedList2;

class Node
{
	Node next;
	int val;
	
	public Node(int val)
	{
		this.val=val;
		this.next=null;
	}
}

public class RotateLL {
	
	public static Node rotateRight(Node node, int k)
	{
		if(k==0 || node==null || node.next==null)
			return node;
		
		
		Node temp = node;
		int n=1;
		while(temp.next!=null)
		{
			temp=temp.next;
			n++;
		}
		if(k>n)
			k=n%k;
		
		temp.next=node;
		
		int rem = n - k-1;
		temp=node;
		while(rem!=0)
		{
			temp=temp.next;
			rem--;
		}
		Node head = temp.next;
		temp.next=null;
		return head;
		
	}
	/*
	 * O N
	 */
	
	public static int countNode(Node node)
	{
		int n=0;
		while(node!=null)
		{
			node=node.next;
			n++;
		}
		return n;
	}
	
	static Node insertNode(Node head,int val) {
	    Node newNode = new Node(val);
	    if(head == null) {
	        head = newNode;
	        return head;
	    }
	    Node temp = head;
	    while(temp.next != null) temp = temp.next;
	    
	    temp.next = newNode;
	    return head;
	}
	
	static void printList(Node head) {
	    while(head.next != null) {
	        System.out.print(head.val+"->");
	        head = head.next;
	    } 
	    System.out.println(head.val);
	    
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = null;
	    //inserting Node
	    head=insertNode(head,1);
	    head=insertNode(head,2);
	    head=insertNode(head,3);
	    head=insertNode(head,4);
	    head=insertNode(head,5);
	    
	    System.out.println("Original list: ");
	    printList(head);
	    
	    int k = 2;
	    Node newHead = rotateRight(head,k);//calling function for rotating right 
	    
	    System.out.println("After "+k+" iterations: ");
	    printList(newHead);//list after rotating nodes
	}

}

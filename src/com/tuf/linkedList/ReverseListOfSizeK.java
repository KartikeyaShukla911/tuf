package com.tuf.linkedList;

public class ReverseListOfSizeK {
	
	/*
	 * given a list, reverse in groups of k size and return head;
	 * a fn, takes a node and k size,
	 * another function getKnode returns the kth node.
	 * if the kth node is null, check if the prevNode is null, if yes, then break(no group) else point the head to this last group
	 * if not, and kth.next node is null, it's the last,
	 * 
	 */
	
	// O - 2N - O n for finding + O n for reversing
	public static Node kReverse(Node head, int k) {
        // Initialize a temporary
        // node to traverse the list
        Node temp = head;
        
        // Initialize a pointer to track the
        // last node of the previous group
        Node prevLast = null;
        
        // Traverse through the linked list
        while (temp != null) {
            
            // Get the Kth node of the current group
            Node kThNode = getKthNode(temp, k);
            
            // If the Kth node is NULL
            // (not a complete group)
            if (kThNode == null) {
               
                // If there was a previous group,
                // link the last node to the current node
                if (prevLast != null) {
                    prevLast.next = temp;
                }
                
                // Exit the loop
                break;
            }
            
            // Store the next node
            // after the Kth node
            Node nextNode = kThNode.next;
            
            // Disconnect the Kth node
            // to prepare for reversal
            kThNode.next = null;
            
            // Reverse the nodes from
            // temp to the Kth node
            reverseLinkedList(temp);
            
             // Adjust the head if the reversal
            // starts from the head
            if (temp == head) {
                head = kThNode;
            } else {
                // Link the last node of the previous
                // group to the reversed group
                prevLast.next = kThNode;
            }
            
            // Update the pointer to the
            // last node of the previous group
            prevLast = temp;
            
            // Move to the next group
            temp = nextNode;
        }
        
        // Return the head of the
        // modified linked list
        return head;
    }
	
	public static Node getKnode(Node node,int k)
	{
		while(node!=null && k--!=0)
			node=node.next;
		return node;
	}
	
	public static int  countNodes(Node node)
	{
		int cnt=0;
		while(node!=null)
		{
			cnt++;
			node=node.next;
		}
		return cnt;
	}
	
	public static Node reverseNode(Node node)
	{
		Node curr =node;
		Node prev=null;
		while(curr!=null)
		{
			Node temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr=temp;
		}
		return prev;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

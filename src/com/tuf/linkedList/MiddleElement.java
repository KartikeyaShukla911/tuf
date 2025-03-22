package com.tuf.linkedList;

public class MiddleElement {
	
	static Node findMiddle(Node head) {
        
        Node slow = head; 
        
        // Initialize the fast pointer to the head.
        Node fast = head;   

        // Traverse the linked list using
        // the Tortoise and Hare algorithm.
        while (fast != null && fast.next != null && slow != null) {
            // Move fast two steps.
            fast = fast.next.next;  
            // Move slow one step.
            slow = slow.next;        
        }
        // Return the slow pointer,
        // which is now at the middle node.
        return slow;  
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

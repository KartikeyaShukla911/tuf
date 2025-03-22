package com.tuf.linkedList2;

class NodeRandom
{
	int val;
	NodeRandom next;
	NodeRandom random;
	
	public NodeRandom(int val)
	{
		this.val =val;
		this.next=null;
		this.random=null;
	}
}

public class CopyRandomAndNext {
	
	static void printClonedLinkedList(NodeRandom head) {
	    while (head != null) {
	        System.out.print("Data: " + head.val);
	        if (head.random != null) {
	            System.out.print(", Random: " + head.random.val);
	        } else {
	            System.out.print(", Random: null");
	        }
	        System.out.println();
	        // Move to the next node
	        head = head.next;
	    }
	}
	
	public static NodeRandom copyNext(NodeRandom head)
	{
		if(head==null)
			return head;
		
		NodeRandom temp = head;
		while(temp!=null)
		{
			NodeRandom move = temp.next;
			NodeRandom nextTemp = new NodeRandom(temp.val);
			NodeRandom currNext = temp.next;
			temp.next = nextTemp;
			nextTemp.next= currNext;
			temp=move;
			
		}
		
		temp=head;
		NodeRandom head2=null;
		while(temp.next!=null)
		{
			NodeRandom nextTemp = temp.next;
			if(head2==null)
			{
				head2=nextTemp;
			}
			temp.next=nextTemp.next;
			nextTemp.next = nextTemp.next.next;
			temp=temp.next;
		}
		return head2;
	}
	
	/*
	 * clone LL in brute -  o N + S n
	 */
	 public static Node cloneLL(Node head) {
	        Node temp = head;
	        // Create a HashMap to map original nodes
	        // to their corresponding copied nodes
	        HashMap<Node, Node> map = new HashMap<>();

	        // Step 1: Create copies of each
	        // node and store them in the map
	        while (temp != null) {
	            // Create a new node with the
	            // same data as the original node
	            Node newNode = new Node(temp.data);
	            // Map the original node to its
	            // corresponding copied node in the map
	            map.put(temp, newNode);
	            // Move to the next node in the original list
	            temp = temp.next;
	        }

	        temp = head;
	        // Step 2: Connect the next and random
	        // pointers of the copied nodes using the map
	        while (temp != null) {
	            // Access the copied node corresponding
	            // to the current original node
	            Node copyNode = map.get(temp);
	            // Set the next pointer of the copied node
	            // to the copied node mapped to the
	            // next node in the original list
	            copyNode.next = map.get(temp.next);
	            // Set the random pointer of the copied node
	            // to the copied node mapped to the
	            // random node in the original list
	            copyNode.random = map.get(temp.random);
	            // Move to the next node in the original list
	            temp = temp.next;
	        }

	        // Return the head of the
	        // deep copied list from the map
	        return map.get(head);
	    }
	 

	 
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		NodeRandom head = new NodeRandom(7);
	    head.next = new NodeRandom(14);
	    head.next.next = new NodeRandom(21);
	    head.next.next.next = new NodeRandom(28);

	    // Assigning random pointers
	    head.random = head.next.next;
	    head.next.random = head;
	    head.next.next.random = head.next.next.next;
	    head.next.next.next.random = head.next;

	    System.out.println("Original Linked List with Random Pointers:");
	    printClonedLinkedList(head);
	    
	    System.out.println("cloned list");
	    NodeRandom head2=copyNext(head);
	    printClonedLinkedList(head2);
	    
	}
	
	void insertCopyInBetween(Node head) {
	    Node temp = head;
	    while (temp != null) {
	        Node nextElement = temp.next;
	        // Create a new node with the same data
	        Node copy = new Node(temp.data);

	        // Point the copy's next to
	        // the original node's next
	        copy.next = nextElement;

	        // Point the original
	        // node's next to the copy
	        temp.next = copy;

	        // Move to the next original node
	        temp = nextElement;
	    }
	}

	// Function to connect random
	// pointers of the copied nodes
	void connectRandomPointers(Node head) {
	    Node temp = head;
	    while (temp != null) {
	        // Access the copied node
	        Node copyNode = temp.next;

	        // If the original node
	        // has a random pointer
	        if (temp.random != null) {
	            // Point the copied node's random to the
	            // corresponding copied random node
	            copyNode.random = temp.random.next;
	        } else {
	            // Set the copied node's random to
	            // null if the original random is null
	            copyNode.random = null;
	        }

	        // Move to the next original node
	        temp = temp.next.next;
	    }
	}

	// Function to retrieve the
	// deep copy of the linked list
	Node getDeepCopyList(Node head) {
	    Node temp = head;
	    // Create a dummy node
	    Node dummyNode = new Node(-1);
	    // Initialize a result pointer
	    Node res = dummyNode;

	    while (temp != null) {
	        // Creating a new List by
	        // pointing to copied nodes
	        res.next = temp.next;
	        res = res.next;

	        // Disconnect and revert back to the
	        // initial state of the original linked list
	        temp.next = temp.next.next;
	        temp = temp.next;
	    }

	    // Return the deep copy of the
	    // list starting from the dummy node
	    return dummyNode.next;
	}
	/*
	 * O - 3 N
	 */

}

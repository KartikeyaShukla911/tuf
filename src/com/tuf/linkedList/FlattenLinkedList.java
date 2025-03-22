package com.tuf.linkedList;

public class NodeFlat
{
	int val;
	NodeFlat next,down;
	
	public NodeFlat(int val)
	{
		this.val=val;
		this.next=null;
		this.down=null;
	}
}



public class FlattenLinkedList {

	public static NodeFlat flatten(NodeFlat root)
	{
		if(root==null || root.down==null)
			return root;
		
		NodeFlat flat = flatten(root.down);
		
		flat = merge(root,flat);
		return flat;
	}
	
	public static merge(NodeFlat root1,NodeFlat root2)
	{
		NodeFlat dummy = new NodeFlat(-1);
		NodeFlat ans = dummy;
		
		NodeFlat temp = dummy.next;
		
		while(root1!=null && root2!=null)
		{
			if(root1.val <=root2.val)
			{
				temp.next = root1.next;
				
				root1.down=null;
				root1=root1.next;
			}
			else
			{
				temp.next = root2.next;
				
				root2.down=null;
				root2=root2.next;
			}
			temp=temp.next;
		}
		
		while(root1!=null)
		{
			temp.next = root1;
			root1=root1.next;
			temp=temp.next;
		}
		
		while(root2!=null)
		{
			temp.next = root2;
			root2=root2.next;
			temp=temp.next;
		}
		
		return dummy.next;
		/*
		 * O n x m = where m is child
		 */
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

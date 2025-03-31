package com.tuf.binarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode
{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode next;
	
	public TreeNode(int val)
	{
		this.val=val;
		this.left=left;
		this.right=right;
	}
}

public class PopulateNextPointer {
	
	public static void popNextPointer(TreeNode root)
	{
		if(root==null)
			return;
		
		Queue<TreeNode> q=new LinkedList();
		q.add(root);
		while(!q.isEmpty())
		{
			TreeNode temp = q.poll();
			int n =q.size();
			int i;
			for(i=1;i<n;i++)
			{
				TreeNode nextTemp = q.poll();
				if(temp!=null)
				{
					temp.next=nextTemp;
				}
				if(nextTemp!=null && nextTemp.left!=null)
				{
					q.add(nextTemp.left);
				}
				if(nextTemp!=null && nextTemp.right!=null)
				{
					q.add(nextTemp.right);
				}
			}
			if(temp.left!=null)
				q.add(temp.left);
			if(temp.right!=null)
				q.add(temp.right);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            Node rightNode = null;
            for(int i = q.size(); i > 0; i--) {
                Node cur = q.poll();
                cur.next = rightNode;
                rightNode = cur;
                if(cur.right != null) {
                    q.offer(cur.right);
                    q.offer(cur.left);
                }
            }
        }
        return root;        
    }
		//O n and S n
}

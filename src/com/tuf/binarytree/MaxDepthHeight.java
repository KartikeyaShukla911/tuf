package com.tuf.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepthHeight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(10);
        root.left.left.right = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(10);
        root.right.left = new TreeNode(9);
        
        System.out.println("MaxDepth "+height(root));
        System.out.println("using queue "+bfs(root));
	}

	public static int height(TreeNode root)
	{
		if(root==null)
			return 0;
		
		return 1+Math.max(height(root.left),height(root.right));
	}
	
	public static int bfs(TreeNode root)
	{
		if(root==null)
			return 0;
		
		Queue<TreeNode> q = new LinkedList();
		q.add(root);
		int lvl=0;
		while(!q.isEmpty())
		{
			int n = q.size();
			for(int i=0;i<n;i++)
			{
				TreeNode temp = q.poll();
				if(temp.left!=null)
					q.add(temp.left);
				if(temp.right!=null)
					q.add(temp.right);
			}
			lvl++;
		}
		return lvl;
	}
}

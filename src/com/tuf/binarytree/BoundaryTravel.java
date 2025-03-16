package com.tuf.binarytree;

import java.util.ArrayList;
import java.util.List;

public class BoundaryTravel {

	public static List<TreeNode> ans = new ArrayList();
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
        
        printLeft(root);
        Leaves(root);
        printRight(root);
        
        for(TreeNode i : ans)
        {
        	System.out.println(i.val);
        }
        
	}
	
	public static void Leaves(TreeNode node)
	{
		if(node==null)
		{
			return;
		}
		
		if(node.left==null && node.right==null)
			ans.add(node);
		Leaves(node.left);
		Leaves(node.right);
	}
	
	public static void printLeft(TreeNode root)
	{
		if(root==null)
			return;
		
		while(root!=null)
		{
			if(root.left!=null && root.right!=null)
			{
				ans.add(root.left);
			}
			if(root.left!=null)
			{
				printLeft(root.left);
				
			}
			else
				printLeft(root.right);
		}
	}
	public static void printRight(TreeNode root)
	{
		if(root==null)
			return;
		
		while(root!=null)
		{
			if(root.left!=null && root.right!=null)
			{
				ans.add(root.left);
			}
			if(root.right!=null)
			{
				printLeft(root.right);
				
			}
			else
				printLeft(root.left);
		}
	}
	

}

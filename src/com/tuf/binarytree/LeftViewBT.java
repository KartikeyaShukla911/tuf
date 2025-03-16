package com.tuf.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeftViewBT {
	
	public static List<Integer> leftView(TreeNode node)
	{
		List<Integer> ans = new ArrayList();
		if(node==null)
			return ans;
		
		Queue<TreeNode> q = new LinkedList();
		q.add(node);
		
		List<Integer> rightView = new ArrayList();
		
		while(!q.isEmpty())
		{
			int n = q.size();
			for(int i=0;i<n;i++) {
				TreeNode temp = q.poll();
				if(i==0)
				{
					ans.add(temp.val);
				}
				if(i==n-1)
				{
					rightView.add(temp.val);
				}
				if(temp.left!=null)
				{
					q.add(temp.left);
				}
				if(temp.right!=null)
				{
					q.add(temp.right);
				}
			}
		}
		System.out.println("Right view");
		for(int x : rightView)
        {
        	System.out.println(x);
        }
		
		return ans;
	}
	

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
        List<Integer> ans = leftView(root);
        for(int x : ans)
        {
        	System.out.println(x);
        }
	}

}

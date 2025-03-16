package com.tuf.binarytree;

import java.util.ArrayList;
import java.util.List;

public class RootToNodePath {

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
        
        List<Integer> ans = new ArrayList();
        rootToNodePath(root,ans,9);
        
        for(int x : ans)
        	System.out.println(x);
	}
	
	public static boolean rootToNodePath(TreeNode root,List<Integer> ans,int tar)
	{
		if(root==null)
			return false;
		
		ans.add(root.val);
		if(root.val==tar)
			return true;
		
		if(rootToNodePath(root.left,ans,tar) || rootToNodePath(root.right,ans,tar))
		{
			return true;
		}
		
		ans.remove(ans.size()-1);
		return false;
	}
}

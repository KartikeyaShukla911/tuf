package com.tuf.binarytree;

import java.util.ArrayList;
import java.util.List;

import com.tuf.binarytree.InorderTree.TreeNode;

public class inOrderMorris {
	
	public List<TreeNode> morrisInorder(TreeNode node)
	{
		if(node==null)
			return null;
		List<TreeNode> ans = new ArrayList();
		
		while(node!=null)
		{
			if(node.left==null)
			{
				ans.add(node);
				node= node.right;
			}
			else
			{
				TreeNode prev = node.left;
				while(prev.right!=null && prev.right!=node)
				{
					prev=prev.right;
				}
				if(prev.right==null)
				{
					prev.right=node;
					node=node.left;
				}
				else
				{
					prev.right=null;
					ans.add(node);
					node=node.right;
				}
				
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

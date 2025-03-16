package com.tuf.binarytree;

public class LowestCommonAnc {

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
        
        System.out.println("lca: "+lca(root,root.left.left.right.right,root.left.right ));
	}
	
	public static TreeNode lca(TreeNode root,TreeNode p, TreeNode q)
	{
		if(root== null || p==null || q==null)
		{
			return root;
		}
		
		TreeNode l = lca(root.left,p,q);
		TreeNode r = lca(root.right,p,q);
		
		if(l==null)
			return r;
		else if(r==null)
			return l;
		else
			return root;
	}

}

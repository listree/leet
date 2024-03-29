package com.leet;

/**
 * Definition for a binary tree node for leetcode problems
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int val, int leftVal, int rightVal) {
        this.val = val;
        this.left = new TreeNode(leftVal);
        this.right = new TreeNode(rightVal);
    }

    public String toString() {
        return "" + val;
    }
}

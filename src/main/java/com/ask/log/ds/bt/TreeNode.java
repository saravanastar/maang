package com.ask.log.ds.bt;

public class TreeNode<T> {
    private TreeNode<T> left;
    private TreeNode<T> right;
    private T data;

    public TreeNode(final T data) {
        this.data = data;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(final TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(final TreeNode<T> right) {
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public void setData(final T data) {
        this.data = data;
    }
}

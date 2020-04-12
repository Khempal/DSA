package com.khempal.dsa.tree;

import java.util.Random;

public class BinarySearchTree implements BinaryTree {

    @Override
    public Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }

        return root;
    }

    @Override
    public Node delete(Node root, int data) {
        if (root == null) {
            return null;
        }
        // move to desired node to be deleted
        if (data < root.data) {
            root.left = delete(root.left, data);
        } else if (data > root.data) {
            root.right = delete(root.right, data);
        } else {
            // now we are at desired node to be deleted
            // let's delete this node
            if (root.left == null && root.right == null) {
                // if node does not have any child
                root = null;
            } else if (root.left != null && root.right != null) {
                // if both nodes are present
                Random random = new Random();
                // using random for switching between Left or Right subtree. just for fun.
                if (random.nextInt(2) == 0) {
                    // delete current node and replace it with inorder predecessor
                    // Means Max element from left subtree
                    Node leftMax = findMax(root.left);
                    // Delete bottom max node in left subtree and remove pointer from it's parent.
                    root.left = delete(root.left, leftMax.data);
                    // now replace left max with current node to be deleted;
                    leftMax.left = root.left;
                    leftMax.right = root.right;
                    root.left = null;
                    root.right = null;
                    root = leftMax;
                } else {
                    // delete current node and replace it with inorder successor
                    // Means Min element from right subtree
                    Node rightMin = findMin(root.right);
                    // Delete min node from right subtree and remove pointer from it's parent.
                    root.right = delete(root.left, rightMin.data);
                    // now replace left max with current node to be deleted;
                    rightMin.left = root.left;
                    rightMin.right = root.right;
                    root.left = null;
                    root.right = null;
                    root = rightMin;
                }

            } else if (root.left != null) {
                root = root.left;
            } else if (root.right != null) {
                root = root.right;
            }
        }
        return root;
    }

    public Node findMin(Node root) {
        if (root == null) {
            return null;
        }

        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public Node findMax(Node root) {
        if (root == null) {
            return null;
        }

        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

}

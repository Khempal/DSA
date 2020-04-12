package com.khempal.dsa.tree;

import java.util.LinkedList;
import java.util.Queue;

public interface Tree {
    Node insert(Node root, int data);

    Node delete(Node root, int data);

    default void levelOrder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node == null) continue;
                System.out.print(node.data+" ("+node.toString().split("@")[1]+") ");
                queue.offer(node.left);
                queue.offer(node.right);
            }
            System.out.println();
        }
    }
}

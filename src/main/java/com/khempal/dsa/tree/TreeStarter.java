package com.khempal.dsa.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TreeStarter {
    public static void main(String[] args) throws IOException {
        BinarySearchTree bst = new BinarySearchTree();
        Node root = null;
//        30 20 40 15 25 35 45 10 18 22 28 32 38 42 48
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            while (tokenizer.hasMoreTokens()) {
                root = bst.insert(root, Integer.parseInt(tokenizer.nextToken()));
            }
        }

//        bst.inOrder(root);
//        System.out.println();
//        bst.preOrder(root);
//        System.out.println();
//        bst.postOrder(root);
//        System.out.println();
        bst.levelOrder(root);
        System.out.println("Let's delete 40 ");
        root = bst.delete(root, 30);
        System.out.println("After delete == 40");
        bst.levelOrder(root);
        System.out.println("Let's delete 45 ");
        bst.delete(root,45);
        System.out.println("After delete == 45");
        bst.levelOrder(root);
    }
}

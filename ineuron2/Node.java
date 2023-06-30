package in.ineuron2;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BST {
    Node root;

    public void constructBST(int[] arr) {
        if (arr == null || arr.length == 0) {
            root = null;
            return;
        }

        root = new Node(arr[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            Node current = queue.poll();

            int leftChildValue = arr[i];
            if (leftChildValue != -1) {
                current.left = new Node(leftChildValue);
                queue.add(current.left);
            }
            i++;

            if (i < arr.length) {
                int rightChildValue = arr[i];
                if (rightChildValue != -1) {
                    current.right = new Node(rightChildValue);
                    queue.add(current.right);
                }
                i++;
            }
        }
    }

    public void inorderTraversal(Node node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.data + " ");
            inorderTraversal(node.right);
        }
    }

    public static void main(String[] args) {
        BST bst = new BST();
        int[] arr = {7, 4, 12, 3, 6, 8, 1, 5, 10};
        bst.constructBST(arr);

        System.out.println("BST:");
        bst.inorderTraversal(bst.root);
    }
}
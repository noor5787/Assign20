package in.ineuron3;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class LevelOrderBSTCheck {

    static boolean isLevelOrderBST(int[] arr, int n) {
        if (n == 0)
            return true;

        Queue<Node> queue = new LinkedList<>();
        int i = 0;

        Node root = new Node(arr[i++]);
        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            if (i < n && arr[i] < temp.data) {
                temp.left = new Node(arr[i++]);
                queue.add(temp.left);
            }

            if (i < n && arr[i] > temp.data) {
                temp.right = new Node(arr[i++]);
                queue.add(temp.right);
            }
        }

        if (i == n)
            return true;
        else
            return false;
    }

    public static void main(String args[]) {
        int[] arr1 = {7, 4, 12, 3, 6, 8, 1, 5, 10};
        int n1 = arr1.length;
        if (isLevelOrderBST(arr1, n1))
            System.out.println("Output1: Yes");
        else
            System.out.println("Output1: No");

        int[] arr2 = {11, 6, 13, 5, 12, 10};
        int n2 = arr2.length;
        if (isLevelOrderBST(arr2, n2))
            System.out.println("Output2: Yes");
        else
            System.out.println("Output2: No");
    }
}
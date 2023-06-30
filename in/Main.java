package in.ineuron.in;
//Node class representing a node in the binary tree
class Node {
 int data;
 Node left, right;

 public Node(int item) {
     data = item;
     left = right = null;
 }
}

//Utility class to store the maximum subtree sum
class MaxSum {
 int sum;
}

//Binary tree class
class BinaryTree {
 Node root;

 // Function to find the subtree with maximum sum
 int findMaxSubtreeSum(Node node) {
     MaxSum maxSum = new MaxSum();
     maxSum.sum = Integer.MIN_VALUE;
     findMaxSubtreeSumUtil(node, maxSum);
     return maxSum.sum;
 }

 // Utility function to recursively find the subtree with maximum sum
 int findMaxSubtreeSumUtil(Node node, MaxSum maxSum) {
     if (node == null)
         return 0;

     int leftSum = findMaxSubtreeSumUtil(node.left, maxSum);
     int rightSum = findMaxSubtreeSumUtil(node.right, maxSum);

     // Calculate the sum of the subtree rooted at the current node
     int currentSum = leftSum + rightSum + node.data;

     // Update the maximum subtree sum if necessary
     if (currentSum > maxSum.sum)
         maxSum.sum = currentSum;

     // Return the sum of the subtree rooted at the current node
     return currentSum;
 }
}

//Main class to test the program

 

public class Main {
	public static void main(String[] args) {
	     BinaryTree tree = new BinaryTree();
	     tree.root = new Node(1);
	     tree.root.left = new Node(2);
	     tree.root.right = new Node(3);
	     tree.root.left.left = new Node(4);
	     tree.root.left.right = new Node(5);
	     tree.root.right.left = new Node(6);
	     tree.root.right.right = new Node(7);

	     int maxSubtreeSum = tree.findMaxSubtreeSum(tree.root);
	     System.out.println("Maximum Subtree Sum: " + maxSubtreeSum);
	 }
	}


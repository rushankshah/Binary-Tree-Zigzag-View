import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeZigZagTraversal {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Node root = createTree();
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> answer = new ArrayList<>();
        queue.offer(root);
        int rowNumber = 0;
        while (queue.size() != 0) {
            List<Integer> rowSolution = new ArrayList<>();
            int q = queue.size();
            for (int i = 0; i < q; i++) {
                Node tempNode = queue.poll();
                rowSolution.add(tempNode.data);
                if (rowNumber % 2 == 0) {
                    if (tempNode.right != null)
                        queue.offer(tempNode.right);
                    if (tempNode.left != null)
                        queue.offer(tempNode.left);
                } else {
                    if (tempNode.left != null)
                        queue.offer(tempNode.left);
                    if (tempNode.right != null)
                        queue.offer(tempNode.right);
                }
            }
            answer.add(rowSolution);
            rowNumber++;
        }

        System.out.println(answer);
    }

    static Node createTree() {
        Node root = null;

        System.out.println("Enter data: ");
        int data = sc.nextInt();

        if (data == -1)
            return root;

        root = new Node(data);
        System.out.println("Left subtree data for " + data + ": ");
        root.left = createTree();

        System.out.println("Right subtree data for " + data + ": ");
        root.right = createTree();

        return root;
    }
}

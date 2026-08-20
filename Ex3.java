import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class Main {

    static Scanner sc = new Scanner(System.in);

    // Insert/Create Node
    static Node insertNode() {
        System.out.print("Enter data (-1 for NULL): ");
        int data = sc.nextInt();

        if (data == -1)
            return null;

        Node node = new Node(data);

        node.left = insertNode();
        node.right = insertNode();

        return node;
    }

    // Preorder: Root -> Left -> Right
    static void preorder(Node node) {
        if (node == null)
            return;

        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    // Inorder: Left -> Root -> Right
    static void inorder(Node node) {
        if (node == null)
            return;

        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    // Postorder: Left -> Right -> Root
    static void postorder(Node node) {
        if (node == null)
            return;

        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {

        System.out.println("Create Binary Tree");
        Node root = insertNode();

        System.out.print("\nPreorder Traversal: ");
        preorder(root);

        System.out.print("\nInorder Traversal: ");
        inorder(root);

        System.out.print("\nPostorder Traversal: ");
        postorder(root);
    }
}

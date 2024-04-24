class Node {
    int data;
    Node left, right;

    public Node(int value) {
        this.data = value;
        this.left = null;
        this.right = null;
    }
}

public class Heap {

    private static boolean isHeap(Node root, int index, int nodeNo) {
        int leftInd = 2 * index + 1;
        int rightInd = 2 * index + 2;
        
        if (root == null) {
            return true;
        }

        if (root.left != null && root.left.data > root.data) {
            return false;
        }

        if (root.right != null && root.right.data > root.data) {
            return false;
        }

        if (index >= nodeNo) {
            return false;
        }

        return isHeap(root.left, leftInd, nodeNo) && isHeap(root.right, rightInd, nodeNo);
    }

    private static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private static void checkHeap(Node root, int index, int nodeNo){
        if (isHeap(root, index, nodeNo)) {
            System.out.println("Binary Tree satisfies heap propertu.");
        } 
        else {
            System.out.println("Binary Tree does not satisfy heap property.");
        }
    }

    public static void main(String[] args) {
        //first tree
        Node root1 = new Node(97);
        root1.left = new Node(46);
        root1.left.left = new Node(12);
        root1.left.left.left = new Node(6);
        root1.left.left.right = new Node(9);
        root1.left.right = new Node(3);

        root1.right = new Node(37);
        root1.right.left = new Node(7);
        root1.right.right = new Node(31);

        System.out.print("First ");
        checkHeap(root1, 0, countNodes(root1));

        //second tree
        Node root2 = new Node(97);
        root2.left = new Node(46);
        root2.left.left = new Node(12);
        root2.left.right = new Node(3);
        root2.left.right.left = new Node(2);
        root2.left.right.right = new Node(4);

        root2.right = new Node(37);
        root2.right.left = new Node(7);
        root2.right.right = new Node(31);

        System.out.print("Second ");
        checkHeap(root2, 0, countNodes(root2));
    }
}

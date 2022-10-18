import java.util.Scanner;

public class bstTester {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        long start1, start2;
        start1 = System.currentTimeMillis();
        BinarySearchTree bst = new BinarySearchTree(0);

        for (int i = 1; i < N; i++) {
            bst.insert(i, bst.root);
        }   

        System.out.println("It takes " + (System.currentTimeMillis()-start1) + " milliseconds to finish first part");
        start2 = System.currentTimeMillis();

        for (int i = 0; i < N; i++) {
            bst.insert((int) (N*Math.random()), bst.root);
        }

        System.out.println("It takes " + (System.currentTimeMillis()-start2) + " milliseconds to finish second part");
        bst.printPreOrder(bst.root);
    }
}

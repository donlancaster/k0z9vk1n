import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Tree tree = new Tree();
        tree.insert(25);
        tree.insert(20);
        tree.insert(15);
        tree.insert(17);
        tree.insert(16);
        tree.insert(30);
        tree.insert(35);
        tree.insert(27);
        while (true) {
            System.out.println("1. Show tree\n2. Add elements\n3. Remove\n4. Search\n5. Exit");
            switch (sc.next()) {
                case "1":
                    System.out.println("In-order:");//симметричный
                    tree.inorder();
                    System.out.println("Pre-order:");//прямой
                    tree.preorder();
                    System.out.println("Post-order:");//обратный
                    tree.postorder();
                    System.out.println();
                    break;
                case "2":
                    System.out.print("Adding:");
                    tree.insert(sc.nextInt());
                    System.out.println();
                    break;
                case "3":
                    System.out.print("Removing:");
                    tree.deleteKey(sc.nextInt());
                    System.out.println();
                    break;
                case "4":
                    System.out.print("Finding:");
                    System.out.println(tree.contains(sc.nextInt()));
                    break;
                case "5":
                    System.exit(0);
            }
        }
    }
}

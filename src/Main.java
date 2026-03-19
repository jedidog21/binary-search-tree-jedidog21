import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;


public class Main {
    public static BST<Integer> bst = new BST<>();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String in = "";

        label:
        while (!in.equals("EXIT")){
            System.out.println("What do you want to do? ");
            in = scan.nextLine().toLowerCase();
            switch (in) {
                case "load from file":
                    System.out.println("What file would you like to add?");
                    in = scan.nextLine();
                    try (Scanner reader = new Scanner(new File(in))){
                        while (reader.hasNextLine()){
                            String next = reader.nextLine();
                            try {
                                bst.add(Integer.parseInt(next));
                            }
                            catch (NumberFormatException e){
                                System.out.print("");
                            }

                        }
                    }
                    catch (FileNotFoundException e){
                        System.out.println("File not found");
                    }
                    break;
                case "save to file":
                    String addToFile = "";
                    try (FileWriter writer = new FileWriter("binaryTreeSave.txt")){
                        String values = bst.printInorder();
                        values = values.substring(1, values.length()-1);
                        for (String s : values.split(", ")) {
                            addToFile += s + "\n";
                        }
                        writer.write(addToFile);
                        System.out.println("Saved to file");
                    }

                    catch (IOException e){
                        System.out.println("An error occurred while writing" + " to the file: " + e.getMessage());
                    }
                    break;
                case "add value":
                    System.out.println("Add an int to the tree: ");
                    try {
                        in = scan.nextInt() + "";
                    } catch (InputMismatchException e) {
                        System.out.println("Not a Number");
                    }
                    bst.add(Integer.parseInt(in));
                    System.out.println("Added " + in + " to tree");
                    break;
                case "delete value":
                    try {
                        in = scan.nextInt() + "";
                    } catch (InputMismatchException e) {
                        System.out.println("Not a Number");
                    }
                    System.out.println("Deleted " + bst.delete(Integer.parseInt(in)) + " from tree");
                    break;
                case "contains value":
                    try {
                        in = scan.nextInt() + "";
                    } catch (InputMismatchException e) {
                        System.out.println("Not a Number");
                    }
                    System.out.println("Contains " + in + "?" + bst.contains(Integer.parseInt(in)));
                    break;
                case "print inorder":
                    System.out.println(bst.printInorder());
                    break;
                case "print preorder":
                    System.out.println(bst.printPreorder());
                    break;
                case "print postorder":
                    System.out.println(bst.printPostorder());
                    break;
                case "node amount":
                    System.out.println("There are " + bst.countNodes() + " nodes in the tree");
                    break;
                case "leaf node amount":
                    System.out.println("There are " + bst.countLeafNodes() + " leaf nodes in the tree");
                    break;
                case "height":
                    System.out.println("Tree is " + bst.getHeight() + "nodes tall");
                    break;
                case "clear tree":
                    bst.clearTree();
                    System.out.println("Tree cleared");
                    break;
                case "find min":
                    System.out.println("The minimum value is " + bst.findMin());
                    break;
                case "find max":
                    System.out.println("The maximum value is " + bst.findMax());
                    break;
                case "is balanced":
                    System.out.println("It is " + bst.isBalanced() + " that is tree is balanced");
                    break;
                case "exit":
                    break label;
                default:
                    System.out.println("\"" + in + "\" is not a command");
                    break;
            }
        }


    }
}
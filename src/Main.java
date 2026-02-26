//import java.util.*;
//import java.io.File;
//import java.io.FileNotFoundException;
//
//
//public class Main {
//    public static BST<Integer> bst = new BST<>();
//
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        String in = "";
//
//        label:
//        while (!in.equals("EXIT")){
//            System.out.println("What do you want to do? ");
//            in = scan.nextLine().toLowerCase();
//            switch (in) {
//                case "add file":
//                    in = scan.nextLine();
//                    try (Scanner reader = new Scanner(new File(in))){
//                        while (reader.hasNextLine()){
//                            String next = reader.nextLine();
//                            try {
//                                System.out.println(next);
//                                bst.add(Integer.parseInt(next));
//                            }
//                            catch (NumberFormatException e){
//                                System.out.print("nan");
//                            }
//
//                        }
//                    }
//                    catch (FileNotFoundException e){
//                        System.out.println("File not found");
//                    }
//                    break;
//                case "add value":
//                    System.out.println("Add an int to the tree: ");
//                    try {
//                        in = scan.nextInt() + "";
//                    } catch (InputMismatchException e) {
//                        System.out.println("Not a Number");
//                    }
//                    bst.add(Integer.parseInt(in));
//                    System.out.println("Added " + in + " to tree\n");
//                    break;
//                case "delete value":
//                    try {
//                        in = scan.nextInt() + "";
//                    } catch (InputMismatchException e) {
//                        System.out.println("Not a Number");
//                    }
//                    System.out.println("Deleted " + bst.delete(Integer.parseInt(in)) + " from tree\n");
//                    break;
//                case "contains value":
//                    try {
//                        in = scan.nextInt() + "";
//                    } catch (InputMismatchException e) {
//                        System.out.println("Not a Number");
//                    }
//                    System.out.println("Contains " + in + "?" + bst.contains(Integer.parseInt(in)) + "\n");
//                    break;
//                case "print inorder":
//                    System.out.println(bst.printInorder() + "\n");
//                    break;
//                case "print preorder":
//                    System.out.println(bst.printPreorder() + "\n");
//                    break;
//                case "print Postorder":
//                    System.out.println(bst.printPostorder() + "\n");
//                    break;
//                case "node amount":
//                    System.out.println("There are " + bst.countNodes() + " nodes in the tree\n");
//                    break;
//                case "leaf node amount":
//                    System.out.println("There are " + bst.countLeafNodes() + " leaf nodes in the tree\n");
//                    break;
//                case "height":
//                    System.out.println("Tree is " + bst.getHeight() + "nodes tall\n");
//                    break;
//                case "clear tree":
//                    bst.clearTree();
//                    System.out.println("Tree cleared");
//                    break;
//                case "exit":
//                    break label;
//                default:
//                    System.out.println("\"" + in + "\" is not a command");
//                    break;
//            }
//        }
//
//
//    }
//}
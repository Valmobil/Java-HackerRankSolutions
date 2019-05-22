package binaryTreeSwapNodes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        swapNodes(new int[][]{{2, 3}, {-1, 4}, {-1, 5}, {-1, -1}, {-1, -1}}, new int[]{2});
    }

    /*
     * Complete the swapNodes function below.
     */
    static int[][] swapNodes(int[][] indexes, int[] queries) {
        //Creare root of the tree
        BinaryTreeNode head = new BinaryTreeNode(1, 0);

        //Current index
        Integer indexCurrent = 0;

        //List of nodes on each level (for further quick swapping)
        HashMap<Integer, ArrayList<BinaryTreeNode>> nodesByLevel = new HashMap<>();
        nodesByLevel.put(0, new ArrayList<>());
        nodesByLevel.get(0).add(head);

        //Start binary tree creation
        createBinaryTree(indexes, nodesByLevel, indexCurrent);

        //Convert binary tree to vector
        int numberOfNodes = 10;
        int[][] result = new int[1][10];
        inOrderTraversal(head, result);

        //Convert array list to array

        return new int[1][1];
    }

    private static void inOrderTraversal(BinaryTreeNode head, int[][] result) {
        if (head == null) {
            return;
        }
        inOrderTraversal(head.getLeft(), result);
        System.out.println(head.getValue());
        inOrderTraversal(head.getRight(), result);
    }

    private static void createBinaryTree(int[][] indexes, HashMap<Integer, ArrayList<BinaryTreeNode>> nodesByLevel, Integer indexCurrent) {

        int parentLevel = nodesByLevel.size() - 1;
        //Exit from recursion
        if (indexes.length <= indexCurrent) {
            return;
        }
        //Add new level
        nodesByLevel.put(parentLevel + 1, new ArrayList<>());

        //Fill tree from by level level
        for (int i = 0; i < nodesByLevel.get(parentLevel).size(); i++) {

            BinaryTreeNode currentParentNode = nodesByLevel.get(parentLevel).get(i);
            //Fill left node
            if (indexes[indexCurrent][0] != -1) {
                currentParentNode.setLeft(new BinaryTreeNode(indexes[indexCurrent][0], parentLevel + 1));
                nodesByLevel.get(parentLevel+1).add(currentParentNode.getLeft());
            }
            //Fill right node
            if (indexes[indexCurrent][1] != -1) {
                currentParentNode.setRight(new BinaryTreeNode(indexes[indexCurrent][1], parentLevel + 1));
                nodesByLevel.get(parentLevel+1).add(currentParentNode.getRight());
            }
            indexCurrent++;
        }

        //fill next level
        createBinaryTree(indexes, nodesByLevel, indexCurrent);
    }
}



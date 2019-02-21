package binaryTreeSwapNodes;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }

    /*
     * Complete the swapNodes function below.
     */
    static int[][] swapNodes(int[][] indexes, int[] queries) {
        BinaryTreeNode head = new BinaryTreeNode(1, 1);
        createBinaryTree(head, indexes);
        /*
         * Write your code here.
         */
        return new int[1][1];
    }

    private static void createBinaryTree(BinaryTreeNode head, int[][] indexes) {
        BinaryTreeNode curHead = head;
        int curLevel = 0;
        List<BinaryTreeNode> curLevelNodes = new ArrayList<>();
        //Start fill tree from second level
        curLevelNodes.add(head);
        fillNextNode(curLevelNodes, curLevel+1,indexes);

        }

    private static void fillNextNode(List<BinaryTreeNode> headNodesLest, int curLevel, int[][] indexes) {
        List<BinaryTreeNode> curLevelNodes = new ArrayList<>();
        //Start fill tree from second level
        for (int i = 0; i < headNodesLest.size(); i++) {
            //Fill left node
            headNodesLest.get(i).setLeft(new BinaryTreeNode(indexes[(int) (Math.pow(2,curLevel) + i)][0],curLevel+1));
            curLevelNodes.add(headNodesLest.get(i).getLeft());
            //Fill right node
            headNodesLest.get(i).setLeft(new BinaryTreeNode(indexes[(int) (Math.pow(2,curLevel) + i)][1],curLevel+1));
            curLevelNodes.add(headNodesLest.get(i).getLeft());

        }

        //fill next level
        fillNextNode(curLevelNodes, curLevel+1,indexes);
    }
}



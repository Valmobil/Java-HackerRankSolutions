import java.util.LinkedList;
import java.util.List;

public class LinkedListInsertNodeToSpecifiedPosition {

  static class SinglyLinkedListNode {
    public int data;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(int nodeData) {
      this.data = nodeData;
      this.next = null;
    }
  }

  static class SinglyLinkedList {
    public SinglyLinkedListNode head;
    public SinglyLinkedListNode tail;

    public SinglyLinkedList() {
      this.head = null;
      this.tail = null;
    }

    public void insertNode(int nodeData) {
      SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

      if (this.head == null) {
        this.head = node;
      } else {
        this.tail.next = node;
      }

      this.tail = node;
    }
  }

  public static void main(String[] args) {
    SinglyLinkedList list = new SinglyLinkedList();
    list.insertNode(16);
    list.insertNode(13);
    list.insertNode(7);
//    list.insertNode(3);
    insertNodeAtPosition(list.head, 1, 2);
  }

  static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
    SinglyLinkedListNode node = new SinglyLinkedListNode(data);
    SinglyLinkedListNode curNode = head;
    SinglyLinkedListNode prevNode = null;
    SinglyLinkedListNode headNode = head;
    int i = 0;
    do {
      if (i == position) {
        node.next = curNode;
        if (prevNode != null) {
          prevNode.next = node;
        }
        break;
      }
      i++;
      prevNode = curNode;
      curNode = prevNode.next;
    } while (prevNode.next != null);
    if (position == 0 ) {
      headNode = node;
    }
    return headNode;
  }
}

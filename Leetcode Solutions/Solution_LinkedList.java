public class Solution_LinkedList {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static Solution_LinkedList insert(Solution_LinkedList list, int data) {
        Node new_node = new Node(data);
        if (list.head == null) {
            list.head = new_node;
        } else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_node;
        }
        return list;
    }

    public static void printList(Node list) {
        Node currNode = list;
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
        System.out.println();
    }

    public static Solution_LinkedList deleteMiddleElement(Solution_LinkedList list) {
        Node slow = list.head, fast = list.head, prev = list.head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
        return list;
    }

    public static Node groupOddEven(Node head) {
        if (head == null || head.next == null)
            return head;
        Node odd = head, even = head.next, evenHead = head.next;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public static Node reverseLinkedList(Node head){
        return head;
    }

    public static void main(String[] args) {
        Solution_LinkedList list = new Solution_LinkedList();

        System.out.println("Problem 12: ");
        int[] arr_p12 = { 1, 3, 4, 7, 1, 2, 6 };
        for (int i : arr_p12) {
            list = insert(list, i);
        }
        printList(list.head);
        Solution_LinkedList ansList_p12 = deleteMiddleElement(list);
        printList(ansList_p12.head);

        System.out.println("Problem 13: ");
        list.head = null;
        int[] arr_p13 = { 1, 2, 3, 4, 5 };
        for (int i : arr_p13) {
            list = insert(list, i);
        }
        printList(list.head);
        Node ansList_p13 = groupOddEven(list.head);
        printList(ansList_p13);


        System.out.println("Problem 14: ");
        list.head = null;
        int[] arr_p14 = { 1, 2, 3, 4, 5 };
        for (int i : arr_p14) {
            list = insert(list, i);
        }
        printList(list.head);
        Node ansList_p14 = reverseLinkedList(list.head);
        printList(ansList_p14);
    }
}
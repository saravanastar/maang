package com.ask.log.ds.linkedlist;

/**
 * Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,6,3,4,5,6], val = 6
 * Output: [1,2,3,4,5]
 * Example 2:
 *
 * Input: head = [], val = 1
 * Output: []
 * Example 3:
 *
 * Input: head = [7,7,7,7], val = 7
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 104].
 * 1 <= Node.val <= 50
 * 0 <= val <= 50
 */
public class RemoveLinkedListEle {

    public static void main(String[] args) {
        RemoveLinkedListEle removeLinkedListEle = new RemoveLinkedListEle();
        ListNode headNode = new ListNode(1);
        headNode.next = new ListNode(2);
        headNode.next.next = new ListNode(6);
        headNode.next.next.next = new ListNode(3);
        headNode.next.next.next.next = new ListNode(4);
        headNode.next.next.next.next.next = new ListNode(5);
        headNode.next.next.next.next.next.next = new ListNode(6);
        ListNode result = removeLinkedListEle.removeElements(headNode, 6);
    }
    public ListNode removeElements(ListNode head, int val) {
        ListNode currentNode = head;
        ListNode prevNode = null;
        while (currentNode != null) {
            if (currentNode.val == val) {
                if (prevNode == null) {
                    currentNode = currentNode.next;
                    head = currentNode;
                } else {
                    prevNode.next = currentNode.next;
                    currentNode = currentNode.next;
                }
            } else {
                prevNode = currentNode;
                currentNode = currentNode.next;
            }

        }
        return head;
    }
}

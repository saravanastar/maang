package com.ask.log.ds.linkedlist;

import java.util.List;

/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 * Example 2:
 *
 *
 * Input: head = [1,2]
 * Output: [2,1]
 * Example 3:
 *
 * Input: head = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is the range [0, 5000].
 * -5000 <= Node.val <= 5000
 *
 *
 * Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode headNode = new ListNode(1);
        headNode.next = new ListNode(2);
        headNode.next.next = new ListNode(6);
        headNode.next.next.next = new ListNode(3);
        reverseLinkedList.reverseList(headNode);
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode currentNode = head;
        while (currentNode != null) {
            ListNode next = currentNode.next;
            currentNode.next = prev;
            prev = currentNode;
            currentNode = next;
        }

        return prev;
    }

    public ListNode reverseListRecursion(ListNode head) {
       if (head ==  null || head.next == null) {
           return head;
       }

       ListNode reverse = reverseListRecursion(head.next);
       head.next.next = head;

       head.next = null;
       return reverse;
    }
}

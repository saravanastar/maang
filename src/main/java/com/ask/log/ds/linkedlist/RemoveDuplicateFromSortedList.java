package com.ask.log.ds.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,1,2]
 * Output: [1,2]
 * Example 2:
 *
 *
 * Input: head = [1,1,2,3,3]
 * Output: [1,2,3]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 300].
 * -100 <= Node.val <= 100
 * The list is guaranteed to be sorted in ascending order.
 */
public class RemoveDuplicateFromSortedList {

    public static void main(String[] args) {
        RemoveDuplicateFromSortedList removeDuplicateFromSortedList = new RemoveDuplicateFromSortedList();
        ListNode headNode = new ListNode(1);
        headNode.next = new ListNode(1);
        headNode.next.next = new ListNode(3);
        headNode.next.next.next = new ListNode(3);
        headNode.next.next.next.next = new ListNode(6);
        removeDuplicateFromSortedList.deleteDuplicatesWithoutSet(headNode);
    }

    public ListNode deleteDuplicates(ListNode head) {
        Set<Integer> lookup =  new HashSet<>();
        ListNode currentNode = head;
        ListNode prevNode = null;
        while (currentNode != null) {

            if (!lookup.add(currentNode.val)) {
                prevNode.next = currentNode.next;
                currentNode = currentNode.next;
            } else {
                prevNode = currentNode;
                currentNode = currentNode.next;
            }
        }
        return head;
    }

    /**
     * Only applicable of sorted values.
     * @param head
     * @return
     */
    public ListNode deleteDuplicatesWithoutSet(ListNode head) {
        ListNode currentNode = head;
        ListNode prevNode = null;
        while (currentNode != null) {
            if (prevNode == null) {
                prevNode = currentNode;
                currentNode = currentNode.next;
                continue;
            }
            if (currentNode.val == prevNode.val) {
                prevNode.next = currentNode.next;
                currentNode = currentNode.next;
            } else {
                prevNode = currentNode;
                currentNode = currentNode.next;
            }

        }
        return head;
    }
}

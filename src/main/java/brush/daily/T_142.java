package brush.daily;

import algorithm.linkedlist.ListNode;

/**
 * Created by charlielv on 2023.09.04.
 */
public class T_142 {
  public ListNode detectCycle(ListNode head) {
    ListNode fast = head, slow = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (fast == slow) {
        break;
      }
    }
    if (fast == null || fast.next == null) {
      return null;
    }
    slow = head;
    while (slow != fast) {
      slow = slow.next;
      fast = fast.next;
    }

    return fast;
  }
}

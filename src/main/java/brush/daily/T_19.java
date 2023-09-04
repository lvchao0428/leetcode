package brush.daily;

import algorithm.linkedlist.ListNode;

/**
 * Created by charlielv on 2023.09.04.
 */
public class T_19 {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode n1 = findFromEnd(dummy, n+1);
    n1.next = n1.next.next;
    return dummy.next;
  }

  public ListNode findFromEnd(ListNode head, int k) {
    ListNode p = head;
    for (int i = 0; i < k; ++i) {
      p = p.next;

    }
    ListNode q = head;
    while (p != null) {
      p = p.next;
      q = q.next;
    }
    return q;
  }
}

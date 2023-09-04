package brush.daily;

import algorithm.linkedlist.ListNode;

/**
 * 86. 分隔链表
 * 中等
 * 750
 * company
 * 奥多比 Adobe
 * company
 * 谷歌 Google
 * company
 * 微软 Microsoft
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 *
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 * 示例 2：
 *
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 *
 * Created by charlielv on 2023.09.04.
 */
public class T_86 {
  public ListNode partition(ListNode head, int x) {
    ListNode lh = new ListNode(0);
    ListNode rh = new ListNode(0);
    ListNode p = lh, q = rh, r = head;
    while (r != null) {
      if (r.val < x) {
        p.next = r;
        p = p.next;
      } else {
        q.next = r;
        q = q.next;
      }
      ListNode tmp = r;
      r = r.next;
      tmp.next = null;
    }
    if (p == null) {
      return rh.next;
    }
    p.next = rh.next;
    return lh.next;
  }
}

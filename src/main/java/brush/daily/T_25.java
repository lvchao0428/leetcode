package brush.daily;

import algorithm.linkedlist.ListNode;

/**
 * 剑指 Offer 25. 合并两个排序的链表
 * 简单
 * 372
 * company
 * 字节跳动
 * company
 * Facebook
 * company
 * 快手
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 限制：
 *
 * 0 <= 链表长度 <= 1000
 *
 * 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 * Created by charlielv on 2023.09.04.
 */
public class T_25 {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode ans = new ListNode(0);
    ListNode p = l1, q = l2, r = ans;
    while (p != null && q != null) {
      if (p.val < q.val) {
        r.next = p;
        p = p.next;
      } else {
        r.next = q;
        q = q.next;
      }
      r.next.next = null;
      r = r.next;
    }
    if (p != null) {
      r.next = p;
    }
    if (q != null) {
      r.next = q;
    }
    return ans.next;
  }
}

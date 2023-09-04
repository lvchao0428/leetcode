package brush.daily;

import algorithm.linkedlist.ListNode;

/**
 * LCR 023. 相交链表
 * 简单
 * 89
 * company
 * 百度
 * company
 * 字节跳动
 * 给定两个单链表的头节点 headA 和 headB ，请找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 *
 * 图示两个链表在节点 c1 开始相交：
 *
 *
 *
 * 题目数据 保证 整个链式结构中不存在环。
 *
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 *
 *
 *
 * 示例 1：
 *
 * Created by charlielv on 2023.09.04.
 */
public class T_023 {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode p = headA, q = headB;
    while (p != q) {
      if (p == null) {
        p = headB;
      } else {
        p = p.next;
      }
      if (q == null) {
        q = headA;
      } else {
        q = q.next;
      }
    }

    return q;
  }
}

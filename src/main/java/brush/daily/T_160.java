package brush.daily;

import algorithm.linkedlist.ListNode;

/**
 * 160. 相交链表
 * 简单
 * 2.2K
 * company
 * 亚马逊
 * company
 * Facebook
 * company
 * 谷歌 Google
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 *
 * 图示两个链表在节点 c1 开始相交：
 *
 *
 *
 * 题目数据 保证 整个链式结构中不存在环。
 *
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 *
 * 自定义评测：
 *
 * 评测系统 的输入如下（你设计的程序 不适用 此输入）：
 *
 * intersectVal - 相交的起始节点的值。如果不存在相交节点，这一值为 0
 * listA - 第一个链表
 * listB - 第二个链表
 * skipA - 在 listA 中（从头节点开始）跳到交叉节点的节点数
 * skipB - 在 listB 中（从头节点开始）跳到交叉节点的节点数
 *
 * Created by charlielv on 2023.09.04.
 */
public class T_160 {
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
    return p;
  }
}

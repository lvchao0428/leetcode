package brush.daily;

import algorithm.linkedlist.ListNode;

/**
 * 剑指 Offer 52. 两个链表的第一个公共节点
 * 简单
 * 687
 * company
 * 字节跳动
 * company
 * 美团
 * company
 * 阿里巴巴
 * 输入两个链表，找出它们的第一个公共节点。
 *
 * 如下面的两个链表：
 *
 *
 *
 * 在节点 c1 开始相交。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *
 * Created by charlielv on 2023.09.04.
 */
public class T_52 {
  ListNode getIntersectionNode(ListNode headA, ListNode headB) {
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

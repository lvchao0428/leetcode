package algorithm.dp;

import datastructure.TreeNode;
import java.util.HashMap;
import java.util.Map;

public class D_337 {
  private Map<TreeNode, Integer> memo = new HashMap<>();
  public int rob(TreeNode root) {
    if (root == null) return 0;
    if (memo.containsKey(root)) {
      return memo.get(root);
    }
    int robIt = root.val +
        (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right))  +
        (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));
    int notRob = rob(root.left) + rob(root.right);
    int res = Math.max(robIt, notRob);
    memo.put(root, res);
    return res;
  }
}

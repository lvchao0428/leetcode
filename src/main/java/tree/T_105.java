package tree;

import java.util.HashMap;

public class T_105 {
  // 存储 inorder 中值到索引的映射
  HashMap<Integer, Integer> valToIndex = new HashMap<>();

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    for (int i = 0; i < inorder.length; i++) {
      valToIndex.put(inorder[i], i);
    }
    return build(preorder, 0, preorder.length - 1,
        inorder, 0, inorder.length - 1);
  }

  TreeNode build(int[] preorder, int preStart, int preEnd,
                 int[] inorder, int inStart, int inEnd) {
    if (preStart > preEnd) {
      return null;
    }
    int rootVal = preorder[preStart];
    // 避免 for 循环寻找 rootVal
    int index = valToIndex.get(rootVal);
    int leftSize = index - inStart;
    // 先构造出当前根节点
    TreeNode root = new TreeNode(rootVal);
    // 递归构造左右子树
    root.left = build(preorder, preStart + 1, preStart + leftSize,
        inorder, inStart, index - 1);

    root.right = build(preorder, preStart + leftSize + 1, preEnd,
        inorder, index + 1, inEnd);
    return root;
  }
}

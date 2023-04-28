package algorithm.array;

public class A_4 {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int m = nums1.length, n = nums2.length;
    if (m == 0) {
      if (n%2 == 0) {
        return (nums2[n/2-1] + nums2[n/2])/2.0;
      } else {
        return nums2[n/2];
      }
    }
    if (n == 0) {
      if (m%2 == 0) {
        return (nums1[m/2-1] + nums1[m/2])/2.0;
      } else {
        return nums1[m/2];
      }
    }
    int[] res = new int[m+n];
    int count = 0;
    int i = 0, j = 0;
    while (count != m+n) {
      if (nums1[i] < nums2[j]) {
        res[count++] = nums1[i++];
      } else {
        res[count++] = nums2[j++];
      }
      if (i == m) {
        while (j < n) {
          res[count++] = nums2[j++];
        }
      }
      if (j == n) {
        while (i < m) {
          res[count++] = nums1[i++];
        }
      }
    }
    if (count%2 == 0) {
      return (res[count/2-1] + res[count/2])/2.0;
    } else {
      return res[count/2];
    }
  }
}

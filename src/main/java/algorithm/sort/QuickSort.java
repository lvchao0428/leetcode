package algorithm.sort;

/**
 * Created by charlielv on 2025-08-13.
 */
public class QuickSort {

  // 主方法，用于启动快速排序
  public static void quickSort(int[] arr) {
    if (arr == null || arr.length == 0) {
      return;
    }
    sort(arr, 0, arr.length - 1);
  }

  // 递归排序方法
  private static void sort(int[] arr, int low, int high) {
    if (low < high) {
      // 获得分区索引，将数组分为两部分
      int partitionIndex = partition(arr, low, high);

      // 递归排序左半部分
      sort(arr, low, partitionIndex - 1);
      // 递归排序右半部分
      sort(arr, partitionIndex + 1, high);
    }
  }

  // 分区操作，返回基准元素的最终位置
  private static int partition(int[] arr, int low, int high) {
    // 选择最右边的元素作为基准
    int pivot = arr[high];
    // i是小于基准区域的边界
    int i = low - 1;

    for (int j = low; j < high; j++) {
      // 如果当前元素小于或等于基准，将其放入小于基准的区域
      if (arr[j] <= pivot) {
        i++;
        // 交换元素
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }

    // 将基准元素放到正确的位置
    int temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;

    return i + 1;
  }

  // 测试方法
  public static void main(String[] args) {
    int[] array = {10, 7, 8, 9, 1, 5};
    System.out.println("排序前的数组:");
    for (int num : array) {
      System.out.print(num + " ");
    }

    quickSort(array);

    System.out.println("\n排序后的数组:");
    for (int num : array) {
      System.out.print(num + " ");
    }
  }
}

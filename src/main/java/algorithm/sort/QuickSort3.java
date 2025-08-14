package algorithm.sort;

/**
 * Created by charlielv on 2025-08-13.
 */
public class QuickSort3 {


  public static void quickSort(int[] arr) {
    if (arr == null || arr.length == 0) {
      return;
    }
    sort(arr, 0, arr.length-1);
  }
  private static void sort(int[] arr, int low, int high) {
    if (low < high) {
      int partitionIndex = partition(arr, low, high);
      sort(arr, low, partitionIndex-1);
      sort(arr, partitionIndex+1, high);
    }
  }

  private static int partition(int[] arr, int low, int high) {
    int pivot = arr[high];
    int i = low - 1;
    for (int j = low; j < high; ++j) {
      if (arr[j] < pivot) {
        i++;
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
      }
    }
    int tmp = arr[high];
    arr[high] = arr[i+1];
    arr[i+1] = tmp;

    return i+1;
  }

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

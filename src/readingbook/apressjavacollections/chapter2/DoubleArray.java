package readingbook.apressjavacollections.chapter2;

public class DoubleArray {
  public static void main (String args[]) {
    int array1[] = {1, 2, 3, 4, 5};
    int array2[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    int array1s[] = null;
    System.out.println("Original size: " + array1.length);
    array1s = doubleArray(array1);
    System.out.println("New size: " + array1s.length);
    
    System.out.println("Original size: " + array2.length);
    System.out.println("New size: " + doubleArray(array2).length);
  }
  
  /**
   * ����������ڲ���������Ӧ���ڴ�
   */
  static int[] doubleArray(int original[]) {
    int length = original.length;
    int newArray[] = new int[length*2];//��ϵC�����еı߳�����
    System.arraycopy(original, 0, newArray, 0, length);
    return newArray;
  }
}
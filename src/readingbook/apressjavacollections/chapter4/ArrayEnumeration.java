package readingbook.apressjavacollections.chapter4;

import java.lang.reflect.Array;
import java.util.Enumeration;

public class ArrayEnumeration implements Enumeration {
  private final int size;
  private int cursor;
  private final Object array;
  public ArrayEnumeration(Object obj) {
	  // ���÷��䣬������Ҫ�Ĳ�������������
    Class type = obj.getClass();
    if (!type.isArray()) {
      throw new IllegalArgumentException("Invalid type: " + type);
    }
    size = Array.getLength(obj);
    array = obj;
  }
  public boolean hasMoreElements() {
    return (cursor < size);
  }
  
  // ע�����ﷵ�ص���Object
  public Object nextElement() {
    return Array.get(array, cursor++);
  }
  public static void main(String args[]) {
	  // ע��enumҲ��֮ǰJava�Ĺؼ��֣����Բ�Ҫ����������
	  String[] test = {"vonzhou", "sdf", "fxgsfd", "dsfgs",};
	  Enumeration enumer = new ArrayEnumeration(test);
    while (enumer.hasMoreElements()) {
      System.out.println(enumer.nextElement());
    }
    
    Object obj = new int[] {2, 3, 5, 8, 13, 21};
    enumer = new ArrayEnumeration(obj);
    while (enumer.hasMoreElements()) {
      System.out.println(enumer.nextElement());
    }
    try {
    	enumer = new ArrayEnumeration(ArrayEnumeration.class);
    } catch (IllegalArgumentException e) {
      System.out.println("Oops: " + e.getMessage());
    }
  }
}
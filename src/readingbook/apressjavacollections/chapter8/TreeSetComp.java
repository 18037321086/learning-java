package readingbook.apressjavacollections.chapter8;

import java.util.*;
public class TreeSetComp {
  public static void main (String args[]) throws Exception {
    String elements[] = {"Irish Setter", "Poodle", 
      "English Setter", "Gordon Setter", "Pug"};
    
    Set<String> set = new TreeSet<String>(Collections.reverseOrder());
    for (int i=0, n=elements.length; i<n; i++) {
      set.add(elements[i]);
    }
    System.out.println(set);
    // ��Ϊ Set �ӿ���û�ж������������
    System.out.println(((SortedSet<String>)set).comparator());  
    System.out.println(((TreeSet<String>)set).comparator());  
  }
}
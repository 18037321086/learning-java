package readingbook.apressjavacollections.chapter8;

import java.io.*;
import java.util.*;
public class Copy {
  public static void main (String args[]) throws Exception {
    String elements[] = {"Irish Setter", "Poodle", 
      "English Setter", "Gordon Setter", "Pug"};
    Set set = new HashSet(Arrays.asList(elements));
    Set set2 = ((Set)((HashSet)set).clone());
   
    System.out.println(set2);
    
    System.out.println(set2.remove("Pug"));
    //��Ȼ��ǳ�����������Ƴ��Ľ������Լ����Ƿ�
    System.out.println(set);
    System.out.println(set2);
    
  
    // ���������ͼ�޸ĵײ�����ݽṹ�أ�
  }
}
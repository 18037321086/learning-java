package readingbook.apressjavacollections.chapter5;


import java.util.*;
import java.io.*;

public class Load {
  public static void main (String args[]) throws Exception {
    Properties p = new Properties();
    // ���ļ��м���
    p.load(new FileInputStream("C:\\data\\colon.txt"));
    p.list(System.out);
    
  }
}

/**
 foo:bar
one
two
three=four
five	six seven eight
nine ten 
 */

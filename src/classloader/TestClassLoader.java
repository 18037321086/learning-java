package classloader;

public class TestClassLoader {
	public static void main(String[] args) throws ClassNotFoundException {
		//�������������
		Class clazz=Class.forName("java.lang.String");
		System.out.println(clazz.getClassLoader());
		//ϵͳ��������Ӧ�ü�����������
		Class clazz2=Class.forName("classloader.Apple");
		System.out.println(clazz2.getClassLoader());
	}

}
class Apple{
	
}

package basic.dp.singleton;

//ʹ�á����С�����ʵ��������ʽ����JVM�����̷߳�λ�����̬����֮ǰ��һ���ȴ������ʵ���������̰߳�ȫ��
//ȱ���ǲ�������Ҫ��ʱ��Ŵ���ʵ��
public class Singletion3 {
	private static Singletion3 uniqueInstance = new Singletion3();

	private Singletion3() {
	}

	// ÿ�ζ���Ҫͬ��
	public static synchronized Singletion3 getInstance() {
		return uniqueInstance;
	}
}

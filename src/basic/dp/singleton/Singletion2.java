package basic.dp.singleton;

//�Է���������ͬ���̶߳���ĵ���
//����ֻ�е�һ��ִ��getInstanceʱ����������Ҫͬ��������ʱ���Ƕ����ܵ����
public class Singletion2 {
	private static Singletion2 uniqueInstance;

	private Singletion2() {
	}

	// ÿ�ζ���Ҫͬ��
	public static synchronized Singletion2 getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new Singletion2();
		}
		return uniqueInstance;
	}
}

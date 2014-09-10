package basic.dp.singleton;

//����˫�ؼ���������getInstance�����м���ʹ��ͬ������
public class Singletion4 {
	private static Singletion4 uniqueInstance;

	private Singletion4() {
	}

	// ÿ�ζ���Ҫͬ��
	public static synchronized Singletion4 getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new Singletion4();
		}
		return uniqueInstance;
	}
}

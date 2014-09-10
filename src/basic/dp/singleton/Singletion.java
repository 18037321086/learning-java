package basic.dp.singleton;

//����ʵ�ַ�ʽ�������ڶ��̻߳����¾ͻ�����⣬
//���������߳�ͬʱ������uniqueInstance==null��������·��
public class Singletion {
	private static Singletion uniqueInstance;

	private Singletion() {
	} //

	public static Singletion getInstance() {
		if (uniqueInstance == null) { // �ӳ�ʵ����������ʽ
			uniqueInstance = new Singletion();
		}
		return uniqueInstance;
	}
}

package mythought.javabasic.multi_thread;

public class ThreadTest3 {
	public static void main(String[] args) {
		Runnable r=new Thread3();
		//����ͬһ��Runnable���󴴽��߳�ʱ������ǳ�Ա�������̻߳��໥Ӱ��
		//��ӡ�Ĵ���������60,���ǲ�ȷ���� (<=60)
		Thread t1=new Thread(r);
		Thread t2=new Thread(r);
		//Thread t3=new Thread(r);
		t1.start();
		t2.start();
		//t3.start();
	}

}

class Thread3 implements Runnable{
	int i;
	@Override
	public void run() {
		//int i=0;
		while(true){
			System.out.println("NUMBER: "+(i++));
			
			try {
				Thread.sleep(100);//��ʱ����ʱͬ����������
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(20==i){break;}
		}
	}
}

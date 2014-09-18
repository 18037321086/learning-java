package readingbook.javaconcurrencyinpractice.vonzhou;


public class NoPublishDemo {
    boolean stop = false;
	//volatile boolean stop = false;

    public static void main(String[] args) {
        // LoadMaker.makeLoad();

        NoPublishDemo demo = new NoPublishDemo();

        Thread thread = new Thread(demo.getConcurrencyCheckTask());
        thread.start();

        // �������߳�����һ��
        Utils.sleep(1000);
        System.out.println("Set stop to true in main!");
        demo.stop = true;
        System.out.println("Exit main.");
    }

    ConcurrencyCheckTask getConcurrencyCheckTask() {
        return new ConcurrencyCheckTask();
    }

    private class ConcurrencyCheckTask implements Runnable {
        @Override
        public void run() {
            System.out.println("ConcurrencyCheckTask started!");
            // ���������stop��ֵ�ɼ�����ѭ�����˳���
            // �򵥰�ȫ�Ľⷨ����running�����ϼ���volatile��
            // �ҵ��������ǿ����˳��ġ�û�г������⡣
            while (!stop) {
            }
            System.out.println("ConcurrencyCheckTask stopped!");
        }
    }
}
/**
 * ����ǣ�
 * ConcurrencyCheckTask started!
Set stop to true in main!
Exit main.
ConcurrencyCheckTask stopped!
 * */

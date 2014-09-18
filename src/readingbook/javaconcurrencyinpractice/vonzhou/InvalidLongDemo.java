package readingbook.javaconcurrencyinpractice.vonzhou;

/**
 * long������д����ԭ�ӵģ����Ϊ2���ֲ�����
 * @author Jerry Lee(oldratlee at gmail dot com)
 */
public class InvalidLongDemo {
    long count = 0;

    public static void main(String[] args) {

        InvalidLongDemo demo = new InvalidLongDemo();

        Thread thread = new Thread(demo.getConcurrencyCheckTask());
        thread.start();

        for (int i = 0; ; i++) {// ���޴ε��޸����count���ߵ�32bit��һ���ġ�
            long l = i;
            demo.count = l << 32 | l;
        }
    }

    ConcurrencyCheckTask getConcurrencyCheckTask() {
        return new ConcurrencyCheckTask();
    }

    private class ConcurrencyCheckTask implements Runnable {
        @Override
        public void run() {
            int c = 0;
            for (int i = 0; ; i++) {//���޴εļ��ߵ���
                long l = count;//�����ⲿ��ı���
                long high = l >>> 32;
                long low = l & 0xFFFFFFFFL; // ��32λΪ0
                if (high != low) {
                    c++;
                    System.err.printf("Fuck! Got invalid long!! check time=%s, happen time=%s(%s%%), count value=%s|%s\n",
                            i + 1, c, (float) c / (i + 1) * 100, high, low);
                } else {
                	// ���ȥ���������������ҵĿ�������û�й۲쵽invalid long
                    System.out.printf("Emm... %s|%s\n", high, low);
                }
            }
        }
    }

}

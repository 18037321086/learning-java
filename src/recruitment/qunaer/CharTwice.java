package recruitment.qunaer;


/*
 * ����һ���ַ������ҳ��������ȳ������ε��Ǹ��ַ�
 * 
 * 1. ��ԭʼ�ķ������Ǳ����������¼ÿ���ַ����ֵĴ���
 * 2. ����ÿ���ַ���������ҿ��Ƿ������һ��
 * 3......
 */
public class CharTwice {
	
	public static char firstTwice(String s){
		char c = ' ';
		for(int i = 0; i < s.length() - 1; i++){
			char cur = s.charAt(i);
			int next = s.indexOf(cur, i+1);
			
			if(next != -1 && next < s.length())
				return cur;
		}
		return c;
	}
	
	
	public static void main(String[] args) {
		
		String s = "qywyer23tdd";
		System.out.println(firstTwice(s));
	}

}













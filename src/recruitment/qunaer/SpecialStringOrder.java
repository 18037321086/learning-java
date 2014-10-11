package recruitment.qunaer;

import java.util.Arrays;

/*
 * ��֪��ĸ���С�d, g, e, c, f, b, o, a������ʵ��һ��������������һ���ַ��� 
 * input[] = {"bed", "dog", "dear", "eye"}��������ĸ˳�����򲢴�ӡ��
 * ���������˳��Ϊ��dear, dog, eye, bed��
 * 
 * ==�ַ���λ�ÿ��Կ�����Դ�С��Ȼ��һ���ж������ַ�����Ӧ�ĸ����ַ����ȽϵĹ�����ͬʱ����
 */
public class SpecialStringOrder {
	
	// �ַ��Ĵ�С
	public static int weight(char seq[], char ch){
		for(int i = 0; i< seq.length; i++)
			if(seq[i] == ch)
				return i;
		return -1;
	}
	
	public static boolean strLarger(char seq[], String a, String b){
		int lena = a.length();
		int lenb = b.length();
		int i  =0 ;
		while(i < lena && i < lenb){
			char ca = a.charAt(i);
			char cb = b.charAt(i);
			int result = weight(seq, ca) - weight(seq, cb);
			if(result > 0)
				return true;
			else if(result < 0)
				return false;
			else {
				i++;
				continue;
			}
		}
		
		if(lena > lenb)
			return true;
		else return false;
	}
	
	// ����-��������
	public static String[] sortString(char seq[], String ss[]){
		if(ss.length <= 1)
			return ss;
		for(int i = 1; i < ss.length; i++){
			for(int j = i; j > 0; j--){
				if(strLarger(seq, ss[j-1], ss[j])){
					String tmp = ss[j];
					ss[j] = ss[j-1];
					ss[j-1] = tmp;
				}
			}
		}
		return ss;
	}
	
	public static void main(String[] args) {
		char seq[] = {'d', 'g', 'e', 'c', 'f', 'b', 'o', 'a'};
		String input[] = {"bed", "dog", "dear", "eye"};
		String res[] = sortString(seq, input);
		System.out.println(Arrays.asList(res));
		
	}
}

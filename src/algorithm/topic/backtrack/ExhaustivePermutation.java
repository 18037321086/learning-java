package algorithm.topic.backtrack;


/*
 * Classic exhaustive permutation pattern
 * �õ����е�ȫ����
 */
public class ExhaustivePermutation {
	
	/*
	 * ���ϵݹ飬ͨ���������ݵ�ǰ�Ѿ����ɵ��ַ������Լ��ɹ���ѡ��
	 */
	public static void RecPermute(String soFar, String rest)
	{
	    if (rest.length()<=0) {
	        System.out.println(soFar);
	    } else {
	        for (int i = 0; i < rest.length(); i++) {
	            String remaining = rest.substring(0, i)
	                             + rest.substring(i+1);
	            RecPermute(soFar + rest.charAt(i), remaining);
	        }
	    }
	}
	
	public static void main(String[] args) {
		RecPermute("", "ABC");
	}
}

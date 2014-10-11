package recruitment.qunaer;

import java.util.Stack;

/*
 * дһ��������ת�����·��Ϊ����·�������磺/home/abs/../temp/new/../,���·��Ϊ��/home/temp
 */
public class RelativePathToAbstractPath {
	public static String rp2ap(String rp){
		if(rp == null || rp.equals(""))
			return null;
		
		String ss[] = rp.split("/");//��ͷ�� / �ᵼ������һ���մ�
		//System.out.println(Arrays.asList(ss));
		Stack<String> stack = new Stack<String>();
		
		for(int i = 1; i < ss.length; i++){
			String next = ss[i];
			if(!next.equals(".."))
				stack.push(next);
			else
				stack.pop();
		}
		System.out.println(stack);
		
		StringBuilder builder = new StringBuilder();
		while(!stack.isEmpty()){
			builder.insert(0, stack.pop());
			builder.insert(0, '/');
		}
		return builder.toString();
	}
	
	public static void main(String[] args) {
		String rp = "/home/abs/../temp/new/../";
		System.out.println(rp2ap(rp));
	}

}

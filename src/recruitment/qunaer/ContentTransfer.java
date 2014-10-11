package recruitment.qunaer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
�������ļ�context.txt��words.conf,�볢�Խ����Ǻϲ���Ϊһ�����֣�����ӡ������

�������ļ��������£�

context.txt

��������ÿ���˶���Ҫ$(qunar)�Լ�����ʳ��$(flight.1)ÿ���˶���Ҫ���Լ�����$(flight.2)��
����˵�ű��˷�����$(hotel)��ʹ�ñ��˷�������ѧ......����һֱ��$(tuan)���˵ĳɹ���
ʹ����������о����֪ʶ$(travel.1)�����У���һ��$(travel.2)�����顱

word.conf

flight=Ҳ���ǣ��·�

qunar=��ֲ

hotel=����

tuan=ʹ��

travel=�������죺���˲���
 * @author vonzhou
 *
 */
public class ContentTransfer {
	/*�������ļ���ÿһ�м���hashmap�У�Ȼ���滻�������ı��е���Ӧ��ֵ*/
	public static String merge2Files(String file1, String file2) throws IOException{
		FileReader content = new FileReader(file1);
		FileReader config = new FileReader(file2);
		
		char buffer[] = new char[1024];  // �洢 context.txt
		StringBuilder builder = new StringBuilder();
		int len = 0;
		while((len = content.read(buffer)) != -1){
			String unit = new String(buffer, 0, len);
			builder.append(unit);
		}
		content.close();
		String contents = builder.toString();
		
		//����conf�ļ���Ȼ�����Map��8
		BufferedReader br = new BufferedReader(config);
		String line = null;
		Map<String,String> map =new HashMap<String,String>();
		// ע����еĴ���
		while((line = br.readLine()) != null){
			if(line.equals(""))
				continue;
			int equal = line.indexOf('=');
			//System.out.println(equal);
			String left = line.substring(0, equal);
			String right = line.substring(equal + 1);
			String ss[] = right.split(":");
			//System.out.println(Arrays.asList(ss));
			if(ss.length == 1){
				map.put("$(" + left + ")", ss[0]);
			}else{
				for(int i = 0; i < ss.length; i++)
					map.put("$(" + left + "." + (i+1) + ")", ss[i]);
			}
		}
		br.close();
		
		// Ȼ�����word���滻���������map
		Iterator<String> iter = map.keySet().iterator();
		while(iter.hasNext()){
			String key = iter.next();
			String value = map.get(key);
			//System.out.println(key);
			// ע��Ҫ�÷���ֵ����contents��Java��ֵ����
			contents = contents.replace(key, value);
		}
		
		return contents;
	}
	
	public static void main(String[] args) throws Exception {
		String f1 = "C:\\data\\context.txt";
		String f2 = "C:\\data\\word.conf";
		System.out.println(merge2Files(f1, f2));
	}

}









package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

public class RandomTest {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Random random=new Random();
		Map map=new TreeMap();//�洢���ּ�����ֵĴ���
		List list=new ArrayList();//�洢���ִ�����������
		for(int i=0;i<50;i++){
			//nextInt(x)����һ��0��x-1������
			int r=random.nextInt(41)+10;
			Integer in=(Integer)r;
			if(map.get(in)==null){
				map.put(in, new Integer(1));
			}
			else{
				int value=((Integer)map.get(in)).intValue();
				map.put(in, new Integer(value+1));
			}
		}
		
		//�õ����ִ�����һ�����ϣ��Ӷ�ʹ��Collections�о�̬���������ֵ
		Collection collection=map.values();
		Integer m=(Integer)Collections.max(collection);
		
		Set set=map.entrySet();
		for(Iterator iterator=set.iterator();iterator.hasNext();){
			Map.Entry entry =(Map.Entry)iterator.next();
			Integer key=(Integer)entry.getKey();
			Integer value=(Integer)entry.getValue();
			if(value.intValue()==m.intValue()){
				list.add(key);
			}
			System.out.println(key+":"+value);
		}
		
		System.out.println("�������Ĵ���Ϊ��"+m.intValue()+"  ��Щ����Ϊ��");
		for(Iterator iterator=list.iterator();iterator.hasNext();){
			Integer in=(Integer)iterator.next();
			System.out.println(in.intValue());
		}
//		for(int i=0;i<list.size();i++){
//			Integer in=(Integer)list.get(i);
//			System.out.println(in.intValue());
//		}
		
	}

}

package mythought.alg.filesearch;

public class IPv4Util {

	/*
	 * ��IP��ת��Ϊ����
	 * A.B.C.D�������Ϊ256���Ƶ���
	 */
	public static int  ip2int(String ipAddress) {
		String[] ipAddressInArray = ipAddress.split("\\.");

		int result = 0;
		for (int i = 0; i < ipAddressInArray.length; i++) {
			int power = 3 - i;
			int ip = Integer.parseInt(ipAddressInArray[i]);
			result += ip * Math.pow(256, power);
		}
		return result;
	}
}

package basic.dp.observer;

//���Գ���
public class WeatherStation {
	public static void main(String[] args) {
		WeatherData data = new WeatherData();
		CurrentConditionDisplay ccd = new CurrentConditionDisplay(data);
		
		//�ı�����״̬
		data.setMeasurement(80, 50, 100);
	}
}

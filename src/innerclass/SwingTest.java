package innerclass;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingTest {
	public static void main(String[] args) {
		JFrame frame=new JFrame("tianya");
		JButton button=new JButton("hao");
		//�ڲ���ʵ����ActionListener�ӿ�
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println("hello");
			}
		});
		
		//�ڲ���̳���WindowAdapter��
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.add(button,BorderLayout.CENTER);
		frame.setBounds(200, 300, 300, 200);
		frame.setVisible(true);
	}

}

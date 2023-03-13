package com.learnJavaSE.AnonymousClass;

import java.awt.event.*;

import javax.swing.*;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1.定义一个窗口
		JFrame Jf = new JFrame();
		JPanel JP = new JPanel();
		
		JButton jb = new JButton("登陆");
		
		Jf.add(JP);
		
		//内部类使用
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(Jf, "你点了我");
				
			}
			
		});
		
		//把按钮添加到桌布上显示
		JP.add(jb);
		
		//展示
		Jf.setSize(500, 400);
		Jf.setLocationRelativeTo(null);
		Jf.setVisible(true);
		

	}

}

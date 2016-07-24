package com.ljheee.snip;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
/**
 * 初始化--小界面
 * @author ljheee
 *
 */
public class Main {

	JButton newRectCapture, newFullCapture, cancleBtn, aboutBtn;
	final JFrame jf = new JFrame("Snip");
	UIListener handler = new UIListener();
	
	public Main() {

		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(280, 110);

		newRectCapture = new JButton("\u77E9\u5F62\u622A\u56FE");

		newFullCapture = new JButton("\u5168\u5C4F\u622A\u56FE");

		cancleBtn = new JButton("\u53D6\u6D88");
		cancleBtn.setEnabled(false);
		
		aboutBtn = new JButton(new ImageIcon("Images/about.png"));
		aboutBtn.setMargin(new Insets(0, 0, 0, 0));
		aboutBtn.setToolTipText("\u5173\u4E8E");
		
		newRectCapture.addActionListener(handler);
		newFullCapture.addActionListener(handler);
		cancleBtn.addActionListener(handler);
		aboutBtn.addActionListener(handler);

		JLabel lblAuthorljheee = new JLabel("Author\uFF1Aljheee   \r\n");

		JLabel lblMycsdnnetljheee = new JLabel("my.csdn.net/ljheee");

		GroupLayout groupLayout = new GroupLayout(jf.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup().addComponent(newRectCapture)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(newFullCapture)
						.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE).addComponent(cancleBtn)
						.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(lblMycsdnnetljheee)
						.addPreferredGap(ComponentPlacement.RELATED, 143, Short.MAX_VALUE).addComponent(aboutBtn))
				.addGroup(Alignment.LEADING,
						groupLayout
								.createSequentialGroup().addContainerGap().addComponent(lblAuthorljheee,
										GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(139, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(newRectCapture)
						.addComponent(newFullCapture).addComponent(cancleBtn))
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.UNRELATED, 26, Short.MAX_VALUE)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(aboutBtn)
										.addComponent(lblMycsdnnetljheee)))
						.addGroup(groupLayout.createSequentialGroup().addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(lblAuthorljheee).addContainerGap()))));
		jf.getContentPane().setLayout(groupLayout);

		jf.setVisible(true);

	}
	
	/**
	 * 内部类
	 * 监听处理--“初始化小界面”按钮功能
	 * @author ljheee
	 *
	 */
	class UIListener implements ActionListener {
		
		RectCaptureFrame rectCapture = null;
		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == aboutBtn) {
				JOptionPane.showMessageDialog(null, "Author:ljheee \nQQ554278334 \n2016-7-23");
			}
			if (e.getSource() == newRectCapture) {
				jf.setVisible(false);
				cancleBtn.setEnabled(true);
				rectCapture = RectCaptureFrame.getSnippingFrame(jf);
			}
			if (e.getSource() == newFullCapture) {
				jf.setVisible(false);
				cancleBtn.setEnabled(true);
				//
			}
			if (e.getSource() == cancleBtn) {
				rectCapture.desory();
			}

		}
	}

	
	
	public static void main(String[] args) {
		new Main();
	}
}

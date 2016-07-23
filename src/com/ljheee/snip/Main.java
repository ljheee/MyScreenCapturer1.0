package com.ljheee.snip;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Main {

	public static void main(String[] args) {
		
		final JFrame jf = new JFrame("Snip");
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton newSnip = new JButton("New");
		jf.add(newSnip);
		
		newSnip.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				jf.setVisible(false);
				new SnippingFrame(jf);
			}
		});
		
		jf.pack();
		jf.setVisible(true);

	}

}

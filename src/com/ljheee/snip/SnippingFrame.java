package com.ljheee.snip;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import javax.swing.JFrame;


public class SnippingFrame extends JFrame {

	private static final long serialVersionUID = -7757266057337551153L;
	
	JFrame frame = null;
	int orgx = 0, orgy = 0, endx = 0, endy = 0;
	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	BufferedImage fullScreenImage = null;//��ǰ��Ļ--ȫ��ͼ
	BufferedImage tempImage = null;//
	BufferedImage saveImage = null;
	Graphics g = null;
	
	
	@Override
	public void paint(Graphics g) {
		RescaleOp ro = new RescaleOp(0.8f, 0, null); //��Դͼ�������ݽ���������������
		tempImage = ro.filter(fullScreenImage, null); //��Դ srcImage ����������
		g.drawImage(tempImage, 0, 0, this);
	}
	
	
	public SnippingFrame(JFrame jf) {

		snapshot();
		this.frame = jf;
		this.setSize(d);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.addMouseListener(new MouseListener() {
			
			
			@Override
			public void mouseReleased(MouseEvent e) {
				frame.setVisible(true);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				orgx = e.getX();
				orgy = e.getY();
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {}
		});
		
		/**
		 * ���Ȧ������ ��Ȧ�����������
		 */
		this.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				endx = e.getX();
				endy = e.getY();
				g = SnippingFrame.this.getGraphics();
				g.drawImage(tempImage, 0, 0, SnippingFrame.this);
				int x = Math.min(orgx, endx);
				int y = Math.min(orgy, endy);
				
				int width = Math.abs(endx - orgx) + 1;
				int height = Math.abs(endy - orgy) + 1;
				// ����1����ֹwidth��heightΪ0
				
				g.setColor(Color.BLUE);
				g.drawRect(x - 1, y - 1, width + 1, height + 1);//��ͼ�������ľ��ο�
				// ��1����1����Ϊ�˷�ֹͼƬ�����ο򸲸ǵ�
				
				saveImage = fullScreenImage.getSubimage(x, y, width, height);
				g.drawImage(saveImage, x, y, SnippingFrame.this);
			}
		});
		
		this.setVisible(true);
	}
	


	/**
	 * ��ȡ��ǰ��Ļ������ͼƬ
	 */
	public void snapshot() {
		try {
			Robot robot = new Robot();
			
			//������������Ļ�ж�ȡ�����ص�ͼ��
			fullScreenImage = robot.createScreenCapture(new Rectangle(0, 0, d.width, d.height));
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	

}

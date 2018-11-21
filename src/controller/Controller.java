package controller;

import java.awt.Image;

import model.Choreography;
import model.Picture;
import view.DisplayImage;

public class Controller
{
//	private int imageHeight = 1000;
//	private int imageWidth = 1000;
//	private int oneMeterHeight = imageHeight / 20;
//	private int oneMeterWidth = imageWidth / 20;
//	private int zeroHeight = imageHeight / 2;
//	private int zeroWidth = imageWidth / 2;
//	
//	Stroke solid1 = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
//	Stroke solid2 = new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
//	
//	Stroke dotted1 = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]
//			{
//					1, 1
//			}, 0);
//	BufferedImage testImg;
//	Graphics2D g2d;
	
	public Controller()
	{
		

		
//		testImg = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
//		
//		g2d = testImg.createGraphics();
//	
//		
//		drawBG();
//		
//		for (int i = 1; i <= 8; i++)
//		{
//			draw(i,i-1, i-1, i-1, i );
//		}
//		
//		 testView = new DisplayImage(testImg);
		
		
		
		Choreography choreo = new Choreography(1000, 1000, 16);
		choreo.addPicture();
		choreo.addPicture();
		Picture pic = choreo.getPicture(0);
		for (int i = 1; i <= 8; i++)
			{
				pic.addCouple(i, 0, i, 0, -i);
			}
		pic.redraw();
		pic = choreo.getPicture(1);
		for (int i = 1; i <= 8; i++)
		{
			pic.addCouple(i, i, 0, -i, 0);
		}
		pic.redraw();
		//Image newImage = yourImage.getScaledInstance(newWidth, newHeight, Image.SCALE_DEFAULT);
		 DisplayImage testView1 = new DisplayImage(choreo.getPicture(0).getImg().getScaledInstance(1000, 1000, Image.SCALE_SMOOTH));
		testView1.setVisible(true);
		testView1.setTitle("Pic 1");
		 DisplayImage testView2 = new DisplayImage(choreo.getPicture(1).getImg());
			testView2.setVisible(true);
			testView2.setTitle("Pic 2");
	}
	
	
//	public void draw(int cplNbr,double xPosMan, double yPosMan, double xPosWoman, double yPosWoman )
//	{
//		g2d.setStroke(solid1);
//		int posX = (int) (xPosMan*oneMeterWidth + zeroWidth);
//		int posY = (int) (yPosMan*oneMeterHeight + zeroHeight);
//		g2d.setColor(Color.RED);
//		Ellipse2D.Double circleMan = new Ellipse2D.Double(posX - oneMeterWidth / 4, posY - oneMeterHeight / 4,
//				oneMeterWidth / 2, oneMeterHeight / 2);
//		g2d.fill(circleMan);
//		g2d.setColor(Color.BLACK);
//		g2d.setFont(new Font("Calibri", Font.BOLD, oneMeterWidth / 3));
//		g2d.drawString(String.valueOf(cplNbr), posX - oneMeterWidth / 16, posY + oneMeterHeight / 8);
//		g2d.drawOval(posX - oneMeterWidth / 4, posY - oneMeterHeight / 4,
//				oneMeterWidth / 2, oneMeterHeight / 2);
//		
//		posX = (int) (xPosWoman*oneMeterWidth + zeroWidth);
//		posY = (int) (yPosWoman*oneMeterHeight + zeroHeight);
//		g2d.setColor(Color.BLUE);
//		Ellipse2D.Double circleWoman = new Ellipse2D.Double(posX - oneMeterWidth / 4, posY - oneMeterHeight / 4,
//				oneMeterWidth / 2, oneMeterHeight / 2);
//		g2d.fill(circleWoman);
//		g2d.setColor(Color.WHITE);
//		g2d.drawString(String.valueOf(cplNbr), posX - oneMeterWidth / 16, posY + oneMeterHeight / 8);
//		g2d.setColor(Color.BLACK);
//		g2d.drawOval(posX - oneMeterWidth / 4, posY - oneMeterHeight / 4,
//				oneMeterWidth / 2, oneMeterHeight / 2);
//	}
//
//	public void drawBG() {
//		g2d.setColor(Color.WHITE);
//		g2d.fillRect(0, 0, testImg.getWidth(), testImg.getHeight());
//		g2d.setColor(Color.GRAY);
//
//		// g2d.setStroke(dashed);
//		g2d.setStroke(solid1);
//		for (int i = -9; i <= 9; i++)
//		{
//			// g2d.drawLine(0, zeroWidth + oneMeterWidth * i, imageHeight, zeroWidth +
//			// oneMeterWidth * i);
//			g2d.drawLine(0, zeroHeight + oneMeterHeight * i, imageWidth, zeroHeight + oneMeterHeight * i);
//			g2d.drawLine(zeroWidth + oneMeterWidth * i, 0, zeroWidth + oneMeterWidth * i, imageHeight);
//		}
//		g2d.setStroke(dotted1);
//		for (int i = -9; i <= 10; i++)
//		{
//			// g2d.drawLine(0, zeroWidth + oneMeterWidth * i, imageHeight, zeroWidth +
//			// oneMeterWidth * i);
//			g2d.drawLine(0, zeroHeight + oneMeterHeight * i - oneMeterHeight / 2, imageWidth,
//					zeroHeight + oneMeterHeight * i - oneMeterHeight / 2);
//			g2d.drawLine(zeroWidth + oneMeterWidth * i - oneMeterWidth / 2, 0,
//					zeroWidth + oneMeterWidth * i - oneMeterWidth / 2, imageHeight);
//		}
//		g2d.setStroke(solid2);
//		g2d.setColor(Color.RED.darker());
//		// g2d.drawLine(0, zeroWidth, imageHeight, zeroWidth);
//		g2d.drawLine(0, zeroHeight, imageWidth, zeroHeight);
//		g2d.drawLine(zeroWidth, 0, zeroWidth, imageHeight);
//		g2d.setColor(Color.CYAN.darker());
//		g2d.drawRect(zeroWidth - oneMeterWidth * 3, zeroHeight - oneMeterHeight * 3, oneMeterWidth * 6,
//				oneMeterHeight * 6);
//		g2d.setColor(Color.ORANGE.darker());
//		g2d.drawRect(zeroWidth - oneMeterWidth * 6, zeroHeight - oneMeterHeight * 6, oneMeterWidth * 12,
//				oneMeterHeight * 12);
//		g2d.setColor(Color.BLACK);
//		g2d.setFont(new Font("Calibri", Font.BOLD, oneMeterWidth / 4));
//		for (int i = -10; i <= 9; i++)
//		{
//			g2d.drawString(String.valueOf(i), zeroWidth + 5 + oneMeterWidth * i, zeroHeight + oneMeterHeight / 4);
//		}
//		for (int i = -10; i <= 9; i++)
//		{
//			g2d.drawString(String.valueOf(i), zeroWidth + 5, zeroHeight + oneMeterHeight / 4 + oneMeterHeight * i);
//		}
//	}
//	
}

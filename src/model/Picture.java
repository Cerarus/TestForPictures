package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Picture
{

	private BufferedImage img;
	private Graphics2D g2d;
	private int imageHeight, imageWidth, oneMeterHeight, oneMeterWidth, zeroHeight, zeroWidth;

	private Stroke solid1 = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
	private Stroke solid2 = new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);

	private Stroke dotted1 = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]
	{
			1, 1
	}, 0);

	private ArrayList<Couple> couples;
	private int numberOfCouples = 0;

	public Picture(int numOfCouples, int imageWidth, int imageHeight)
	{
		couples = new ArrayList<Couple>();
		numberOfCouples = numOfCouples;
		img = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
		this.imageHeight = imageHeight;
		this.imageWidth = imageWidth;
		oneMeterHeight = imageHeight / 20;
		oneMeterWidth = imageWidth / 20;
		zeroHeight = imageHeight / 2;
		zeroWidth = imageWidth / 2;
		g2d = img.createGraphics();
		drawBackground();
	}

	private void drawBackground()
	{
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, imageWidth, imageHeight);
		g2d.setColor(Color.GRAY);

		g2d.setStroke(solid1);
		for (int i = -9; i <= 9; i++)
		{
			g2d.drawLine(0, zeroHeight + oneMeterHeight * i, imageWidth, zeroHeight + oneMeterHeight * i);
			g2d.drawLine(zeroWidth + oneMeterWidth * i, 0, zeroWidth + oneMeterWidth * i, imageHeight);
		}
		g2d.setStroke(dotted1);
		for (int i = -9; i <= 10; i++)
		{

			g2d.drawLine(0, zeroHeight + oneMeterHeight * i - oneMeterHeight / 2, imageWidth,
					zeroHeight + oneMeterHeight * i - oneMeterHeight / 2);
			g2d.drawLine(zeroWidth + oneMeterWidth * i - oneMeterWidth / 2, 0,
					zeroWidth + oneMeterWidth * i - oneMeterWidth / 2, imageHeight);
		}
		g2d.setStroke(solid2);
		drawDiamond(1);
		drawDiamond(8);
		
		
		g2d.setColor(Color.RED.darker());
		g2d.drawLine(0, zeroHeight, imageWidth, zeroHeight);
		g2d.drawLine(zeroWidth, 0, zeroWidth, imageHeight);
		g2d.setColor(Color.CYAN.darker());
		g2d.drawRect(zeroWidth - oneMeterWidth * 3, zeroHeight - oneMeterHeight * 3, oneMeterWidth * 6,
				oneMeterHeight * 6);
		g2d.setColor(Color.ORANGE.darker());
		g2d.drawRect(zeroWidth - oneMeterWidth * 6, zeroHeight - oneMeterHeight * 6, oneMeterWidth * 12,
				oneMeterHeight * 12);
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font("Courier", Font.BOLD, oneMeterWidth / 4));
		for (int i = -10; i <= 9; i++)
		{
			g2d.drawString(String.format("%1$2s", String.valueOf(i)), zeroWidth + 5 + oneMeterWidth * i,
					zeroHeight + oneMeterHeight / 4);
		}
		for (int i = -10; i <= 9; i++)
		{
			g2d.drawString(String.format("%1$2s", String.valueOf(i)), zeroWidth + 5,
					zeroHeight + oneMeterHeight / 4 + oneMeterHeight * i);
		}

	}

	private void drawDiamond(int size)
	{
		g2d.drawLine(zeroHeight, zeroWidth + oneMeterWidth * size, zeroHeight + oneMeterHeight * size, zeroWidth);
		g2d.drawLine(zeroHeight, zeroWidth - oneMeterWidth * size, zeroHeight + oneMeterHeight * size, zeroWidth);
		g2d.drawLine(zeroHeight, zeroWidth + oneMeterWidth * size, zeroHeight - oneMeterHeight * size, zeroWidth);
		g2d.drawLine(zeroHeight, zeroWidth - oneMeterWidth * size, zeroHeight - oneMeterHeight * size, zeroWidth);
	}

	private void drawCouple(Couple cpl)
	{
		int cplNumber = cpl.getNumber();
		int posX, posY;
		g2d.setStroke(solid1);
		if (cpl.getMan().isPlotted())
		{
			posX = (int) (cpl.getMan().getPos_x() * oneMeterWidth + zeroWidth);
			posY = (int) (cpl.getMan().getPos_y() * oneMeterHeight + zeroHeight);
			g2d.setColor(Color.RED);
			Ellipse2D.Double circleMan = new Ellipse2D.Double(posX - oneMeterWidth / 4, posY - oneMeterHeight / 4,
					oneMeterWidth / 2, oneMeterHeight / 2);
			g2d.fill(circleMan);
			g2d.setColor(Color.BLACK);
			g2d.setFont(new Font("Calibri", Font.BOLD, oneMeterWidth / 3));
			g2d.drawString(String.valueOf(cplNumber), posX - oneMeterWidth / 16, posY + oneMeterHeight / 8);
			g2d.drawOval(posX - oneMeterWidth / 4, posY - oneMeterHeight / 4, oneMeterWidth / 2, oneMeterHeight / 2);
		}
		if (cpl.getLady().isPlotted())
		{
			posX = (int) (cpl.getLady().getPos_x() * oneMeterWidth + zeroWidth);
			posY = (int) (cpl.getLady().getPos_y() * oneMeterHeight + zeroHeight);
			g2d.setColor(Color.BLUE);
			Ellipse2D.Double circleWoman = new Ellipse2D.Double(posX - oneMeterWidth / 4, posY - oneMeterHeight / 4,
					oneMeterWidth / 2, oneMeterHeight / 2);
			g2d.fill(circleWoman);
			g2d.setColor(Color.WHITE);
			g2d.drawString(String.valueOf(cplNumber), posX - oneMeterWidth / 16, posY + oneMeterHeight / 8);
			g2d.setColor(Color.BLACK);
			g2d.drawOval(posX - oneMeterWidth / 4, posY - oneMeterHeight / 4, oneMeterWidth / 2, oneMeterHeight / 2);
		}
	}

	public void redraw()
	{
		g2d.clearRect(0, 0, imageWidth, imageHeight);
		drawBackground();
		for (Couple cpl : couples)
			drawCouple(cpl);

	}

	public Couple getCouple(int i)
	{
		return couples.get(i);
	}

	public BufferedImage getImg()
	{
		return img;
	}

	public void addCouple(Couple couple)
	{
		if (couples.size() < numberOfCouples)
			couples.add(couple);
	}

	public void addCouple(int coupleNumber, double xPosMan, double yPosMan, double xPosLady, double yPosLady)
	{
		if (couples.size() < numberOfCouples)
		{
			Couple cpl = new Couple(coupleNumber);
			cpl.getMan().setPos(xPosMan, yPosMan);
			cpl.getLady().setPos(xPosLady, yPosLady);
			couples.add(cpl);
		}
	}

	public void setLadiesPlotted(boolean b)
	{
		couples.stream().map(x -> x.getLady()).forEach(y -> y.setPlotted(b));
	}

	public void setMenPlotted(boolean b)
	{
		couples.stream().map(x -> x.getMan()).forEach(y -> y.setPlotted(b));
	}

	public ArrayList<Couple> getAllCouples()
	{
		return couples;
	}

}

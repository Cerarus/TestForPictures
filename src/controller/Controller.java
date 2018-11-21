package controller;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Choreography;
import model.Picture;
import view.DisplayImage;
import view.ShowPictures;

public class Controller
{
	Choreography choreo;
	int currentPic;
	ShowPictures shower;
	public Controller()
	{

		choreo = new Choreography(1000, 1000, 8);
		choreo.addPicture();
		choreo.addPicture();
		choreo.addPicture();
		choreo.addPicture();
		choreo.addPicture();
		Picture pic = choreo.getMainPicture(0);
		for (int i = 1; i <= 8; i++)
		{
			pic.addCouple(i, 0, i, 0, -i);
		}
		pic.redraw();
		pic = choreo.getMainPicture(1);
		for (int i = 1; i <= 8; i++)
		{
			pic.addCouple(i, i, 0, -i, 0);
		}
		pic.redraw();
		pic = choreo.getMainPicture(2);
		for (int i = 1; i <= 8; i++)
		{
			pic.addCouple(i, 0, -i, 0, i);
		}
		pic.redraw();
		pic = choreo.getMainPicture(3);
		for (int i = 1; i <= 8; i++)
		{
			pic.addCouple(i, -i, 0, i, 0);
		}
		pic.redraw();
		pic = choreo.getMainPicture(4);
		for (int i = 1; i <= 8; i++)
		{
			pic.addCouple(i, 0, i, 0, -i);
		}
		pic.redraw();
		
		choreo.calculateMinorPics(20);
		
		shower = new ShowPictures(choreo.getMainPicture(0).getImg());
		shower.addBtnNextPicListener(new BtnNextPic());
		shower.addBtnLastPicListener(new BtnLastPic());
		shower.setVisible(true);
		
		currentPic = 0;
		shower.setImage(choreo.getMainPicture(0).getImg());
//		DisplayImage testView1 = new DisplayImage(
//				choreo.getPicture(0).getImg().getScaledInstance(1000, 1000, Image.SCALE_SMOOTH));
//		testView1.setVisible(true);
//		testView1.setTitle("Pic 1");
//		DisplayImage testView2 = new DisplayImage(choreo.getPicture(1).getImg());
//		testView2.setVisible(true);
//		testView2.setTitle("Pic 2");
	}
	
	
	
	
	
	private class BtnNextPic implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(currentPic<choreo.getNumberOfMinorPictures()-1)
				{
				
				shower.setImage(choreo.getMinorPicture(++currentPic).getImg());
				}
			
		}
		
	}
	private class BtnLastPic implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(currentPic>0)
				{
				
				shower.setImage(choreo.getMinorPicture(--currentPic).getImg());
				}
			
		}
		
	}

}

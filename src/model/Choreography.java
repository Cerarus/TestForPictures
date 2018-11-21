package model;

import java.util.ArrayList;

public class Choreography
{
	ArrayList<Picture> mainPictures;
	ArrayList<Picture> minorPictures;
	private int imageHeight, imageWidth, maxNumberOfCouples = 8;

	public Choreography(int imgHeight, int imgWidth, int maxNumCpl)
	{
		mainPictures = new ArrayList<Picture>();
		imageHeight = imgHeight;
		imageWidth = imgWidth;
		if (maxNumCpl != 0)
			maxNumberOfCouples = maxNumCpl;
	}

	public void calculateMinorPics(int steps)
	{
		minorPictures = new ArrayList<Picture>();
		// minorPictures.add(mainPictures.get(0));
		for (int indexMainNext = 1; indexMainNext < mainPictures.size(); indexMainNext++)
		{
			Picture MainPicLast = mainPictures.get(indexMainNext - 1);
			Picture MainPicNext = mainPictures.get(indexMainNext);
			for (int indexStep = 0; indexStep < steps; indexStep++)
			{
				Picture newpic = new Picture(maxNumberOfCouples, imageWidth, imageHeight);
				for (int indexCouple = 0; indexCouple < maxNumberOfCouples ; indexCouple++)
				{
					double manPosXLast = MainPicLast.getCouple(indexCouple).getMan().getPos_x();
					double manPosYLast = MainPicLast.getCouple(indexCouple).getMan().getPos_y();
					double ladyPosXLast = MainPicLast.getCouple(indexCouple).getLady().getPos_x();
					double ladyPosYLast = MainPicLast.getCouple(indexCouple).getLady().getPos_y();
					double manPosXNext = MainPicNext.getCouple(indexCouple).getMan().getPos_x();
					double manPosYNext = MainPicNext.getCouple(indexCouple).getMan().getPos_y();
					double ladyPosXNext = MainPicNext.getCouple(indexCouple).getLady().getPos_x();
					double ladyPosYNext = MainPicNext.getCouple(indexCouple).getLady().getPos_y();
					Couple cplNew = new Couple(indexCouple +1);
					newpic.addCouple(cplNew);
					cplNew.getMan().setPos(manPosXLast + (manPosXNext - manPosXLast) / steps * indexStep,
							manPosYLast + (manPosYNext - manPosYLast) / steps * indexStep);
					cplNew.getLady().setPos(ladyPosXLast + (ladyPosXNext - ladyPosXLast) / steps * indexStep,
							ladyPosYLast + (ladyPosYNext - ladyPosYLast) / steps * indexStep);

				}
				newpic.redraw();
				minorPictures.add(newpic);
			}

		}
		minorPictures.add(mainPictures.get(mainPictures.size()-1));

	}

	public void addPicture()
	{
		mainPictures.add(new Picture(maxNumberOfCouples, imageWidth, imageHeight));
	}

	public Picture getMainPicture(int index)
	{
		return mainPictures.get(index);
	}

	public int getNumberOfMainPictures()
	{
		return mainPictures.size();
	}
	
	public Picture getMinorPicture(int index)
	{
		return minorPictures.get(index);
	}

	public int getNumberOfMinorPictures()
	{
		return minorPictures.size();
	}

}

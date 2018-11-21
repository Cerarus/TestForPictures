package model;

import java.util.ArrayList;

public class Choreography
{
	ArrayList<Picture> pictures;
	private int imageHeight, imageWidth, maxNumberOfCouples = 8;

	public Choreography(int imgHeight, int imgWidth, int maxNumCpl)
	{
		pictures = new ArrayList<Picture>();
		imageHeight = imgHeight;
		imageWidth = imgWidth;
		if(maxNumCpl != 0)
		maxNumberOfCouples = maxNumCpl;
	}

	
	
	
	public void addPicture() {
		pictures.add(new Picture(maxNumberOfCouples, imageWidth, imageHeight ));
	}
	
	public Picture getPicture(int index) {
		return pictures.get(index);
	}
	
	
}

package model;

public class Dancer {
	
	private double pos_x;
	private double pos_y;
	private boolean plotted = false;
	
	

	public Dancer() {
		
	}
	

	public double getPos_x() {
		return pos_x;
	}

	public void setPos_x(double pos_x) {
		this.pos_x = pos_x;
	}

	public double getPos_y() {
		return pos_y;
	}

	public void setPos_y(double pos_y) {
		this.pos_y = pos_y;
	}
	
	public void setPos(double pos_x, double pos_y) {
		this.pos_x = pos_x;
		this.pos_y = pos_y;
		plotted = true;
	}
	
	public boolean isPlotted() {
		return plotted;
	}


	public void setPlotted(boolean b)
	{
		plotted = b;
	}

}

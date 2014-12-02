/**
 * 
 * @author John Parreno
 * @since December 1, 2014
 * 
 * This class inherits from the line class and is a recursive program that 
 * will create start and end points for lines to create fractal patterns.
 */

package edu.cofc.csci221.ui;

public class KochLine extends Line{
	
	private Point p1 = null, p2 = null, p3 = null, p4 = null, p5 = null;
	
	//Overridden constructor to create start and end points for different fractal levels
	KochLine(Point start, Point end) {
		
		super(start,end);
		p1 = super.getStart();
		p5 = super.getEnd();
	}
	
	/**
	 * Precondition: p1 and p2 are not null
	 * Postcondition: New KochLine object is created
	 * @return
	 */
	public KochLine getLineA(){
		
		KochLine kLineA = new KochLine(p1,p2);
		return kLineA;
	}
	
	/**
	 * Precondition: p2 and p3 are not null
	 * Postcondition: New KochLine object is created
	 * @return
	 */
	public KochLine getLineB(){
		
		KochLine kLineB = new KochLine(p2,p3);
		return kLineB;
	}
	
	/**
	 * Precondition: p3 and p4 are not null
	 * Postcondition: New KochLine object is created
	 * @return
	 */
	public KochLine getLineC(){
		
		KochLine kLineC = new KochLine(p3,p4);
		return kLineC;
	}
	
	/**
	 * Precondition: p4 and p5 are not null
	 * Postcondition: New KochLine object is created
	 * @return
	 */
	public KochLine getLineD(){
		
		KochLine kLineD = new KochLine(p4,p5);
		return kLineD;
	}
	
	/**
	 * Precondition: p1 and p5 are not null
	 * Postcondition: New line objects are created and stored in p2, p3, and p4
	 * @return
	 */
	public void computeFractal() {
		p2 = new Point();
		p3 = new Point();
		p4 = new Point();
		
		int diffX = p5.getX() - p1.getX();
		int diffY = p5.getY() - p1.getY();
			
		p2.setX(p1.getX() + (diffX/3));
		p2.setY(p1.getY() + (diffY/3));
		
		p3.setX((int)((p1.getX() + p5.getX())/2 + (Math.sqrt(3) * (p1.getY() - p5.getY())/6)));
		p3.setY((int)((p1.getY() + p5.getY())/2 + (Math.sqrt(3) * (p5.getX() - p1.getX())/6)));
		
		p4.setX(p1.getX() + (2 * diffX)/3);
		p4.setY(p1.getY() + (2 * diffY)/3);
		
	}
	
	/**
	 * Precondition: None	
	 * Postcondition: None
	 * @return
	 */
	public boolean isKochLineValid() {
		
		return getLineA().isValid() && getLineB().isValid() && getLineC().isValid() && getLineD().isValid();
	}

}

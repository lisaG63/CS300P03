//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           P03 Kaleidoscopic Pen
// Files:           TrianglePen.java, Point.java, Triangle.java, KaleidoscopePen.java
// Course:          CS300, fall, 2019
//
// Author:          Weihang Guo
// percentage:           wguo63@wisc.edu
// Lecturer's Name: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    Jiaqi Zhang
// Partner percentage:   jzhang2247@wisc.edu
// Partner Lecturer's Name: Mouna Kacem
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// _X__ Write-up states that pair programming is allowed for this assignment.
// _X__ We have both read and understand the course Pair Programming Policy.
// _X__ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates, 
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Milks: None
// Online Sources: None
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import processing.core.PApplet;

/**
 * This is a subclass of PApplet class, which implements the Point class, 
 * defines a point representing a vertex of a triangle.
 * @author Weihang Guo, Jiaqi Zhang
 * @version 1.0
 */
public class Point extends PApplet {
  private static final int POINT_DIAMETER = 8;//A point's diameter.
  private int x_Position;//A point's x coordinate.
  private int y_Position;//A point's y coordinate.
 
  /**
   * Constructor of TrianglePen class.
   * @param processing a PApplet instance
   * @param showPoints whether the points can be seen on window.
   */
  public Point(int x_Position, int y_Position) {
    this.x_Position = x_Position;
    this.y_Position = y_Position;
  }
  
  /**
   * Gets x coordinate of a point.
   * @return y_Position
   */
  public int getX() {
    return x_Position;
  }
  
  /**
   * Gets y coordinate of a point.
   * @return y_Position
   */
  public int getY() {
    return y_Position;
  }
  
  /**
   * A mutator to set a point to a given position.
   * @param x the x coordinate of the given position
   * @param y the y coordinate of the given position
   */
  public void setPosition(int x, int y) {
    x_Position = x;
    y_Position = y;
  }
  
  /**
   * Draws a white circle at this point’s position.
   * @param drawTo the PApplet which the white circle is drawn on.
   */
  public void draw(PApplet drawTo) {
    drawTo.fill(-1);
    drawTo.circle(x_Position, y_Position, POINT_DIAMETER);
  }
  
  /**
   * Determines whether a given position is on a point already created. 
   * @param x reference to x coordinate of the given position.
   * @param y reference to y coordinate of the given position.
   * @return true when the position x, y is within the circle drawn to visualize this point,
   * otherwise false.
   */
  public boolean isOver(int x, int y) {
    double distance = Math.sqrt(Math.pow((x_Position - x), 2) + Math.pow((y_Position - y), 2));
    //Computes the distance between one point and another point.
    if(distance < POINT_DIAMETER/2) {
      //if the distance is smaller than the radius, this position is within the circle, otherwise
      //it's outside the circle.
      return true;
    }
    else return false;
    
  }
  
  

}

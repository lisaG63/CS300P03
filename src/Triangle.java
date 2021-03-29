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
 * This is a subclass of PApplet class, which implements the Triangle class.
 * @author Weihang Guo, Jiaqi Zhang
 * @version 1.0
 */
public class Triangle extends PApplet{
  private Point point1;
  private Point point2;
  private Point point3;
  private int color;
  private static final int[] COLORS = new int[] { // int packed w/8 bits of ARGB
   // WHITE, RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
    -1, -766643, -752563, -723891, -11668348, -11696908, -8106508, -766476 };
  
  /**
   * Constructor of the Triangle class. 
   * @param point1 first vertex of a triangle
   * @param point2 second vertex of a triangle
   * @param point3 third vertex of a triangle
   * @param color color of the triangle
   */
  public Triangle(Point point1, Point point2, Point point3, int color) {
    this.point1 = point1;
    this.point2 = point2;
    this.point3 = point3;
    this.color = color;
  }
  
  /**
   * A mutator to set the color of a triangle to the corresponding color in the array COLORS.
   * @param colorIndex the index within the array COLORS.
   */
  public void setColor(int colorIndex) {
    color = COLORS[colorIndex];
  }
  
  /**
   * Draws a triangle.
   * @param drawTo the PApplet which the triangle is drawn on.
   */
  public void draw(PApplet toDraw) {
    toDraw.fill(color);//fill the triangle with its color
    toDraw.triangle(point1.getX(), point1.getY(), point2.getX(), point2.getY(), point3.getX(), 
        point3.getY());

  }
  
  /**
   * Determines whether a given position is over a triangle already created. 
   * @param x reference to x coordinate of the given position.
   * @param y reference to y coordinate of the given position.
   * @return true when the position x, y is within the triangle, otherwise false.
   */
  public boolean isOver(int x, int y) {
    return isPointInTriangle(x, y, point1.getX(), point1.getY(), point2.getX(), point2.getY(), 
        point3.getX(), point3.getY());
  }
  
  /**
   * Determines whether a point is in a triangle. 
   * @param px x coordinate of the point.
   * @param py y coordinate of the point.
   * @param t1x x coordinate of a vertex of a triangle.
   * @param t1y y coordinate of a vertex of a triangle.
   * @param t2x x coordinate of a vertex of a triangle.
   * @param t2y y coordinate of a vertex of a triangle.
   * @param t3x x coordinate of a vertex of a triangle.
   * @param t3y y coordinate of a vertex of a triangle.
   * @return true when the point is within the triangle, otherwise false.
   */
  private static boolean isPointInTriangle(int px, int py,
      int t1x, int t1y, int t2x, int t2y, int t3x, int t3y) {
      px -= t1x; 
      py -= t1y;
      t2x -= t1x;
      t2y -= t1y;
      t3x -= t1x;
      t3y -= t1y;
      double dotp2 = px*t2x+py*t2y;
      double dotp3 = px*t3x+py*t3y;
      double dot22 = t2x*t2x+t2y*t2y;
      double dot23 = t2x*t3x+t2y*t3y;
      double dot33 = t3x*t3x+t3y*t3y;
      double invDen = 1 / (dot33 * dot22 - dot23 * dot23);
      double a = (dot22 * dotp3 - dot23 * dotp2) * invDen;
      double b = (dot33 * dotp2 - dot23 * dotp3) * invDen;
      return (a >= 0) && (b >= 0) && (a + b < 1);
     }

}

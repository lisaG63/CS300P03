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
 * This is a subclass of PApplet class, which implements the KaleidoscopePen class 
 * that is a combination of several trianglePens.
 * @author Weihang Guo, Jiaqi Zhang
 * @version 1.0
 */
public class KaleidoscopePen extends PApplet{
  private PApplet drawTo;
  private int numberOfTrianglePens;
  private TrianglePen[] trianglePens;
  
  /**
   * Constructor of the KaleidoscopePen class. 
   * @param drawto a PApplet instance
   * @param numberOfTrianglePens reference to the number of TrianglePens in this KaleidoscopePen.
   */
  public KaleidoscopePen(PApplet drawTo, int numberOfTrianglePens) {
    this.drawTo = drawTo;
    this.numberOfTrianglePens = numberOfTrianglePens;
    trianglePens = new TrianglePen[numberOfTrianglePens];
    //initialize all the TrianglePens in the KaleidoscopePen, and only let the first TrianglePen to 
    //draw points.
    for(int i = 0; i < trianglePens.length; i ++) {
      if(i > 0) {
        trianglePens[i] = new TrianglePen(drawTo, false);
      } else{
        trianglePens[i] = new TrianglePen(drawTo, true);
      }
    }
  }
  
  /**
   * Update the window to deal with the user's actions. Call the update method of every TrianglePen.
   * @param mouseX reference to the x coordinate of the mouse position
   * @param mouseY reference to the y coordinate of the mouse position
   * @param mousePressed reference to whether mouse is pressed
   * @param keyPressed reference to the key being pressed
   */
  public void update(int mouseX, int mouseY, boolean mousePressed, char keyPressed) {
    for(int i = 0; i < trianglePens.length; i ++) {
      //draw triangles to different positions.
      trianglePens[i].update(rotate(mouseX , mouseY, (i * 2 * Math.PI / numberOfTrianglePens))[0],
          rotate(mouseX , mouseY, (i * 2 * Math.PI / numberOfTrianglePens))[1],
          mousePressed, keyPressed);
    }
  }
  
  /**
   * Rotates a position around the center of an 800x600 screen by the specified
   * amount, and then returns an array containing the resulting position.
   * @param x position of the point to be rotated (0 to 800 pixels)
   * @param y position of the point to be rotated (0 to 600 pixels)
   * @param angle amount of rotation to apply (angle in radians units: 0 to 2*PI)
   * @return the rotated position array: x @ index 0, y @ index 1
   */
  private static int[] rotate(int x, int y, double angle) {
    x -= 400; // translate center of screen to origin (0,0)
    y -= 300;
    int[] rotatedPosition = new int[] { // rotate around origin
    (int)(x * Math.cos(angle) - y * Math.sin(angle)),
    (int)(x * Math.sin(angle) + y * Math.cos(angle)) };
    rotatedPosition[0] += 400; // return to center of screen
    rotatedPosition[1] += 300;
    return rotatedPosition;
   }

}

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
import java.util.ArrayList;

/**
 * This is a subclass of PApplet class, which implements the TrianglePen class and defines the 
 * state, the constructor and some methods.
 * @author Weihang Guo, Jiaqi Zhang
 * @version 1.0
 */
public class TrianglePen extends PApplet{
  private boolean mouseWasPressed; // mousePressed from previous update() call
  private char keyWasPressed; // keyPressed from previous update() call
  private PApplet processing;// Stores the parameter processing passed into the  constructor.
  private boolean showPoints;// Stores the parameter showPoints passed into the constructor.
  private ArrayList<Point> points;// Stores all the points created.
  private ArrayList<Triangle> triangles;// Stores all the triangles created.
  private Point pointDragged;// The point which mouse is over and is dragging.
  
  /**
   * Constructor of TrianglePen class.
   * @param processing a PApplet instance
   * @param showPoints whether the points can be seen on window.
   */
  public TrianglePen(PApplet processing, boolean showPoints){
    this.processing = processing;
    this.showPoints = showPoints;
    mouseWasPressed = false;
    keyWasPressed = '\0';
    points = new ArrayList<Point>();
    triangles = new ArrayList<Triangle>();
  }
  
  /**
   * Update the window to deal with the user's actions.
   * @param mouseX reference to the x coordinate of the mouse position
   * @param mouseY reference to the y coordinate of the mouse position
   * @param mousePressed reference to whether mouse is pressed
   * @param keyPressed reference to the key being pressed
   */
  public void update(int mouseX, int mouseY, boolean mousePressed, char keyPressed){
  //process mouse-based user input
    if(mousePressed != mouseWasPressed) {
      if(mousePressed) handleMousePress(mouseX, mouseY);
      else handleMouseRelease(mouseX, mouseY);
    }
    if(mousePressed) handleMouseDrag(mouseX, mouseY);
    mouseWasPressed = mousePressed;
    //process keyboard-based user input
    if(keyPressed != keyWasPressed) handleKeyPress(mouseX, mouseY, keyPressed);
    keyWasPressed = keyPressed;
    //draw everything in its current state
    draw();
  }
  
  /**
   * Creates points or triangles or records the point being dragged when mouse is pressed.
   * @param mouseX reference to the x coordinate of the mouse position
   * @param mouseY reference to the y coordinate of the mouse position
   */
  private void handleMousePress(int mouseX, int mouseY) {
    for(int i = 0; i < points.size(); i ++) {
      if(points.get(i).isOver(mouseX, mouseY)) {
        pointDragged = points.get(i);
        //Mark the point which the mouse is on as pointDragged.
      }
    }
    if(pointDragged == null) {
      //Create points and triangles when mouse is not on a point already created.
      Point newPoint = new Point(mouseX, mouseY);
      points.add(newPoint);
      if(points.size() % 3 == 0) {
        Triangle newTriangle = new Triangle(points.get(points.size()-3), 
            points.get(points.size()-2), points.get(points.size()-1), -1);
        triangles.add(newTriangle);
        //Create a triangle after every three points are created.
      }
    }
  }
  
  /**
   * Stops tracking a point when mouse is released.
   * @param mouseX reference to the x coordinate of the mouse position
   * @param mouseY reference to the y coordinate of the mouse position
   */
  private void handleMouseRelease(int mouseX, int mouseY) {
    pointDragged = null;
  }
  
  /**
   * Drags a point to the position where the mouse is.
   * @param mouseX reference to the x coordinate of the mouse position
   * @param mouseY reference to the y coordinate of the mouse position
   */
  private void handleMouseDrag(int mouseX, int mouseY) {
    if(pointDragged != null) {
      pointDragged.setPosition(mouseX, mouseY);
    }
  }
  
  /**
   * Sets the color of the triangle according to which key is pressed.
   * @param mouseX reference to the x coordinate of the mouse position
   * @param mouseY reference to the y coordinate of the mouse position
   * @param keyPressed reference to the key being pressed
   */
  private void handleKeyPress(int mouseX, int mouseY, char keyPressed) {
    int colorIndex = keyPressed - '0';
    for(int i = 0; i < triangles.size(); i ++) {
      if(triangles.get(i).isOver(mouseX, mouseY) && colorIndex >= 0 && colorIndex <= 7) {
        triangles.get(i).setColor(colorIndex);
        //When mouse is on a existing triangle and a digit key between 0 and 7 is pressed,
        //set the triangle to the color whose index equals the number on the key.
      }
    }
    
  }
  
  /**
   * Draws points and triangles to the window.
   */
  public void draw() {
    for(int i = 0; i < triangles.size(); i ++) {
      if(triangles.get(i) != null) {
        triangles.get(i).draw(processing);
      }
      //After drawing a triangle, draw the tree vertices of the triangle when showPoints is true.
      if(showPoints) {
        points.get(i * 3).draw(processing);
        points.get(i * 3 + 1).draw(processing);
        points.get(i * 3 + 2).draw(processing);
      }


    }
  }


}

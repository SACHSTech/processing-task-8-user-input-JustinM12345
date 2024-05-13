import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {

  //Initialize Variables

  PImage imgUFO;
  PImage imgCrosshair;
  PImage imgExplosion;
  PImage imgShrek;
  PImage imgSmiley;

  float circleX = 150;
  float circleY = 150;

  boolean upPressed = false;
  boolean downPressed = false;
  boolean leftPressed = false;
  boolean rightPressed = false;
  boolean cPressed = false;
  
  public void settings() {
    size(400, 400);
  }

  public void setup() {
    // Setup background and images
    background(0,200,200);
    imgUFO = loadImage("images/spaceUFO.png");
    imgUFO.resize(width / 5, height / 5);
    imgCrosshair = loadImage("images/crosshair.png");
    imgCrosshair.resize(32,32);
    imgUFO.resize(width / 10, height / 10);
    imgExplosion = loadImage("images/explosion.png");
    imgExplosion.resize(width / 5, height / 5);
    imgShrek = loadImage("images/angryShrek.png");
    imgShrek.resize(100, 100);
    imgSmiley = loadImage("images/smiley.png");
    imgSmiley.resize(50, 50);


    //Changes cursor to crosshair.png
    cursor(imgCrosshair);

    //Starting Message For User
    fill(0);
    textSize(30);
    text("Press c to clear", 100, 200);
  }

  public void draw() {

    // Checks boolean values so multiple arrow keys can be pressed at once to move the circle
    if (upPressed) {
      background(0,200,200);
      circleY--;
    }
    if (downPressed) {
      background(0,200,200);
      circleY++;
    }
    if (leftPressed) {
      background(0,200,200);
      circleX--;
    }
    if (rightPressed) {
      background(0,200,200);
      circleX++;
    }

    // Clears screen if c is pressed
    if (cPressed) {
      background(0,200,200);
    }

    //Draws smiley that can be moved by arrows
    fill(100,100,200);
    image(imgSmiley, circleX, circleY);
  }

  // Boolean value that checks if arrow keys are pressed
  public void keyPressed() {
    if (keyCode == UP) {
      upPressed = true;
    }
    else if (keyCode == DOWN) {
      downPressed = true;
    }
    else if (keyCode == LEFT) {
      leftPressed = true;
    }
    else if (keyCode == RIGHT) {
      rightPressed = true;
    }
    else if (key == 'c') {
      cPressed = true;
    }
  }
  
  // Boolean values that check if arrow keys are released so multiple keys can be used at once
  public void keyReleased() {
    if (keyCode == UP) {
      upPressed = false;
    }
    else if (keyCode == DOWN) {
      downPressed = false;
    }
    else if (keyCode == LEFT) {
      leftPressed = false;
    }
    else if (keyCode == RIGHT) {
      rightPressed = false;
    }
    else if (key == 'c') {
      cPressed = false;
      }
    }

  // When mouse is pressed and moved, draw a circle
  public void mouseDragged() {
      fill(200, 0, 0);
      ellipse(mouseX, mouseY, 25, 25);
    }
  
  // When mousewheel is moved, draw rocketship
  public void mouseWheel(){
    image(imgUFO, mouseX, mouseY);
  }
    
  // When mouse is pressed, draw explosion
  public void mousePressed() {
    image(imgExplosion, mouseX - 40, mouseY - 40);
  }
    
  // When mouse is moved, draw engry shrek in the bottom corner
  public void mouseMoved(){
    image(imgShrek, 300, 300);
  }
}
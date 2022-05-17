import processing.core.PApplet;

/**
 * Description: 
 * @author: B. Chan
 */

public class Sketch extends PApplet {
	
  int CELL_WIDTH = 20;
  int CELL_HEIGHT = 20;
  int MARGIN = 5;
  int ROW_COUNT = 10;
  int COLUMN_COUNT = 10;
  int SCREEN_WIDTH = (CELL_WIDTH * COLUMN_COUNT) + ((COLUMN_COUNT + 1) * MARGIN);
  int SCREEN_HEIGHT = (CELL_HEIGHT * ROW_COUNT) + ((ROW_COUNT + 1) * MARGIN);

  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
    // put your size call here
    size(SCREEN_WIDTH, SCREEN_HEIGHT);
  }


  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(0,0,0);
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
	  for (int count = 0; count <= COLUMN_COUNT; count++){
      rect ((count * CELL_WIDTH) + (MARGIN * (count + 1)), MARGIN, CELL_WIDTH, CELL_HEIGHT);
    }
  }

  public void mousePressed(){
    
  }
}

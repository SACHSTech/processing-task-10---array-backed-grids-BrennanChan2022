import processing.core.PApplet;

/**
 * Description: A program that creates an interactive grid with data contained within a two-dimenstional array.
 * @author: B. Chan
 */

public class Sketch extends PApplet {
  // Declare global variables
  int CELL_WIDTH = 20;
  int CELL_HEIGHT = 20;
  int MARGIN = 5;
  int ROW_COUNT = 10;
  int COLUMN_COUNT = 10;
  int SCREEN_WIDTH = (CELL_WIDTH * COLUMN_COUNT) + ((COLUMN_COUNT + 1) * MARGIN);
  int SCREEN_HEIGHT = (CELL_HEIGHT * ROW_COUNT) + ((ROW_COUNT + 1) * MARGIN);

  int[][] intGrid = new int[COLUMN_COUNT][ROW_COUNT];

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
    // Draws the square as green if the corresponding array position is equal to 1, otherwise draw white
    for (int row = 0; row < ROW_COUNT; row++){
      for (int column = 0; column < COLUMN_COUNT; column++){
        if (intGrid[row][column] == 1){
          fill (0, 255, 0);
          rect (column * (CELL_WIDTH + MARGIN) + MARGIN, row * (CELL_HEIGHT + MARGIN) + MARGIN, CELL_WIDTH, CELL_HEIGHT);
        }
        else {
        fill (255, 255, 255);
        rect (column * (CELL_WIDTH + MARGIN) + MARGIN, row * (CELL_HEIGHT + MARGIN) + MARGIN, CELL_WIDTH, CELL_HEIGHT);
        }
      }
    }
  }

  /**
   * When Mouse is pressed, reverse colours of the surrounding squares on the grid of the square pressed. Print Mouse coordinates and location on grid, total cells selected, cells selected per column and row, and continuous squares selected within a row.
   */
  public void mousePressed(){
    System.out.println("Click");

    for (int row = 0; row < ROW_COUNT; row++){
      for (int column = 0; column < COLUMN_COUNT; column++){
        // If mouse clicked within a square on the grid, reverse colours of that square and surrounding ones
        if(mouseX > column * (CELL_HEIGHT + MARGIN) + MARGIN && mouseX < column * (CELL_HEIGHT + MARGIN) + MARGIN + CELL_HEIGHT && mouseY > row * (CELL_WIDTH + MARGIN) + MARGIN && mouseY < row * (CELL_WIDTH + MARGIN) + MARGIN + CELL_WIDTH){
          // Print Mouse coordinates and location on grid
          System.out.println("mouse coordinates: (" + mouseX + ", " + mouseY + "); grid coordinates: (row: " + (row + 1) + ", column: " + (column + 1) + ")");
          
          // Top left corner, only change square below + square to the right
          if (row == 0 && column == 0){
            if(intGrid[0][0] == 1){
              intGrid[0][0] = 0;
            }
            else if(intGrid[0][0] == 0){
              intGrid[0][0] = 1;
            }
            if(intGrid[1][0] == 1){
              intGrid[1][0] = 0;
            }
            else if(intGrid[1][0] == 0){
              intGrid[1][0] = 1;
            }
            if(intGrid[0][1] == 1){
              intGrid[0][1] = 0;
            }
            else if(intGrid[0][1] == 0){
              intGrid[0][1] = 1;
            }
          }
          
          // Top right corner, only change square below + square to the left
          else if (row == 0 && column == 9){
            if(intGrid[0][9] == 1){
              intGrid[0][9] = 0;
            }
            else if(intGrid[0][9] == 0){
              intGrid[0][9] = 1;
            }
            if(intGrid[1][9] == 1){
              intGrid[1][9] = 0;
            }
            else if(intGrid[1][9] == 0){
              intGrid[1][9] = 1;
            }
            if(intGrid[0][8] == 1){
              intGrid[0][8] = 0;
            }
            else if(intGrid[0][8] == 0){
              intGrid[0][8] = 1;
            }
          }
          
          // Bottom left corner, only change square above + square to the right
          else if (row == 9 && column == 0){
            if(intGrid[9][0] == 1){
              intGrid[9][0] = 0;
            }
            else if(intGrid[9][0] == 0){
              intGrid[9][0] = 1;
            }
            if(intGrid[8][0] == 1){
              intGrid[8][0] = 0;
            }
            else if(intGrid[8][0] == 0){
              intGrid[8][0] = 1;
            }
            if(intGrid[9][1] == 1){
              intGrid[9][1] = 0;
            }
            else if(intGrid[9][1] == 0){
              intGrid[9][1] = 1;
            }
          }
          
          // Bottom right corner, only change square above + square to the left
          else if (row == 9 && column == 9){
            if(intGrid[9][9] == 1){
              intGrid[9][9] = 0;
            }
            else if(intGrid[9][9] == 0){
              intGrid[9][9] = 1;
            }
            if(intGrid[8][9] == 1){
              intGrid[8][9] = 0;
            }
            else if(intGrid[8][9] == 0){
              intGrid[8][9] = 1;
            }
            if(intGrid[9][8] == 1){
              intGrid[9][8] = 0;
            }
            else if(intGrid[9][8] == 0){
              intGrid[9][8] = 1;
            }
          }
          
          // Top edge clicked, only changes left, right, and bottom squares
          else if (row == 0){
            // Reverse colours of the square directly clicked on
            if(intGrid[row][column] == 1){
              intGrid[row][column] = 0;
            }
            else if(intGrid[row][column] == 0){
              intGrid[row][column] = 1;
            }
            // Reverse colours of the square below the one clicked on
            if(intGrid[row + 1][column] == 1){
              intGrid[row + 1][column] = 0;
            }
            else if(intGrid[row + 1][column] == 0){
              intGrid[row + 1][column] = 1;
            }
            // Reverse colours of the square to the left directly clicked on
            if(intGrid[row][column - 1] == 1){
              intGrid[row][column - 1] = 0;
            }
            else if(intGrid[row][column - 1] == 0){
              intGrid[row][column - 1] = 1;
            }
            // Reverse colours of the square to the right directly clicked on
            if(intGrid[row][column + 1] == 1){
              intGrid[row][column + 1] = 0;
            }
            else if(intGrid[row][column + 1] == 0){
              intGrid[row][column + 1] = 1;
            }
          }
          
          // Bottom edge clicked, only changes left, right, and top squares
          else if (row == 9){
            // Reverse colours of the square directly clicked on
            if(intGrid[row][column] == 1){
              intGrid[row][column] = 0;
            }
            else if(intGrid[row][column] == 0){
              intGrid[row][column] = 1;
            }
            // Reverse colours of the square above the one clicked on
            if(intGrid[row - 1][column] == 1){
              intGrid[row - 1][column] = 0;
            }
            else if(intGrid[row - 1][column] == 0){
              intGrid[row - 1][column] = 1;
            }
            // Reverse colours of the square to the left directly clicked on
            if(intGrid[row][column - 1] == 1){
              intGrid[row][column - 1] = 0;
            }
            else if(intGrid[row][column - 1] == 0){
              intGrid[row][column - 1] = 1;
            }
            // Reverse colours of the square to the right directly clicked on
            if(intGrid[row][column + 1] == 1){
              intGrid[row][column + 1] = 0;
            }
            else if(intGrid[row][column + 1] == 0){
              intGrid[row][column + 1] = 1;
            }
          }
          
          // Left edge clicked, only changes right, top, and bottom squares
          else if (column == 0){
            // Reverse colours of the square directly clicked on
            if(intGrid[row][column] == 1){
              intGrid[row][column] = 0;
            }
            else if(intGrid[row][column] == 0){
              intGrid[row][column] = 1;
            }
            // Reverse colours of the square above the one clicked on
            if(intGrid[row - 1][column] == 1){
              intGrid[row - 1][column] = 0;
            }
            else if(intGrid[row - 1][column] == 0){
              intGrid[row - 1][column] = 1;
            }
            // Reverse colours of the square below the one clicked on
            if(intGrid[row + 1][column] == 1){
              intGrid[row + 1][column] = 0;
            }
            else if(intGrid[row + 1][column] == 0){
              intGrid[row + 1][column] = 1;
            }
            // Reverse colours of the square to the right directly clicked on
            if(intGrid[row][column + 1] == 1){
              intGrid[row][column + 1] = 0;
            }
            else if(intGrid[row][column + 1] == 0){
              intGrid[row][column + 1] = 1;
            }
          }
          
          // Right edge clicked, only changes left, top, and bottom squares
          else if (column == 9){
            // Reverse colours of the square directly clicked on
            if(intGrid[row][column] == 1){
              intGrid[row][column] = 0;
            }
            else if(intGrid[row][column] == 0){
              intGrid[row][column] = 1;
            }
            // Reverse colours of the square above the one clicked on
            if(intGrid[row - 1][column] == 1){
              intGrid[row - 1][column] = 0;
            }
            else if(intGrid[row - 1][column] == 0){
              intGrid[row - 1][column] = 1;
            }
            // Reverse colours of the square below the one clicked on
            if(intGrid[row + 1][column] == 1){
              intGrid[row + 1][column] = 0;
            }
            else if(intGrid[row + 1][column] == 0){
              intGrid[row + 1][column] = 1;
            }
            // Reverse colours of the square to the left directly clicked on
            if(intGrid[row][column - 1] == 1){
              intGrid[row][column - 1] = 0;
            }
            else if(intGrid[row][column - 1] == 0){
              intGrid[row][column - 1] = 1;
            }
          }

          // When the mouse does not click on corners or edges, apply reverse colours to all surrounding squares
          else {  
            // Reverse colours of the square that the Mouse directly clicks on
            if(intGrid[row][column] == 1){
              intGrid[row][column] = 0;
            }
            else if(intGrid[row][column] == 0){
              intGrid[row][column] = 1;
            }
            // Reverse colours of the square on top of the one the Mouse directly clicks on
            if(intGrid[row - 1][column] == 1){
              intGrid[row - 1][column] = 0;
            }
            else if(intGrid[row - 1][column] == 0){
              intGrid[row - 1][column] = 1;
            }
            // Reverse colours of the square below the one the Mouse directly clicks on
            if(intGrid[row + 1][column] == 1){
              intGrid[row + 1][column] = 0;
            }
            else if(intGrid[row + 1][column] == 0){
              intGrid[row + 1][column] = 1;
            }
            // Reverse colours of the square to the left of the one the Mouse directly clicks on
            if(intGrid[row][column - 1] == 1){
              intGrid[row][column - 1] = 0;
            }
            else if(intGrid[row][column - 1] == 0){
              intGrid[row][column - 1] = 1;
            }
            // Reverse colours of the square to the right of the one the Mouse directly clicks on
            if(intGrid[row][column + 1] == 1){
              intGrid[row][column + 1] = 0;
            }
            else if(intGrid[row][column + 1] == 0){
              intGrid[row][column + 1] = 1;
            }
          }
        }
      }
    }
    
    // Loop through all rows and columns to determine total number of green squares
    int intTotalSelected = 0;
    for (int row = 0; row < ROW_COUNT; row++){
      for (int column = 0; column < COLUMN_COUNT; column++){
        if (intGrid[row][column] == 1){
          intTotalSelected += 1;
        }
      }
    }
    System.out.println("Total of " + intTotalSelected + " cells are selected.");

    // For each row, find number of green squares and print the amount for every row
    for (int row = 0; row < ROW_COUNT; row++){
      int intRowSelected = 0;
      int intInARow = 2;
      for (int column = 0; column < COLUMN_COUNT; column++){
        if (intGrid[row][column] == 1){
          intRowSelected += 1;
          // Finds 3 green squares in a row, and adds one for every extra one in a row there is
          if (column > 1 && intGrid[row][column - 1] == 1 && intGrid[row][column - 2] == 1){
            intInARow += 1;
            // If it's the last column, output and continue to next row. If the continuous green squares end and there's still more squares in the row, reset count and continue searching down the columns
            if (column == 9 || intGrid[row][column + 1] == 0){
              System.out.println("There are " + intInARow + " continuous blocks selected on row " + row + ".");
              intInARow = 2;
            }
          }
        }
      }
      System.out.println("Row " + row + " has " + intRowSelected + " cells selected.");
    }

    // For each column, find number of green squares and print the amount for every column
    for (int column = 0; column < COLUMN_COUNT; column++){
      int intColumnSelected = 0;
      for (int row = 0; row < ROW_COUNT; row++){
        if (intGrid[row][column] == 1){
          intColumnSelected += 1;
        }
      }
      System.out.println("Column " + column + " has " + intColumnSelected + " cells selected.");
    }
  }
}

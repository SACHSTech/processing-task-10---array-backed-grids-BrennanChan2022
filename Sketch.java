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
   * 
   */
  public void mousePressed(){
    System.out.println("Click");

    for (int row = 0; row < ROW_COUNT; row++){
      for (int column = 0; column < COLUMN_COUNT; column++){
        if(mouseX > column * (CELL_HEIGHT + MARGIN) + MARGIN && mouseX < column * (CELL_HEIGHT + MARGIN) + MARGIN + CELL_HEIGHT && mouseY > row * (CELL_WIDTH + MARGIN) + MARGIN && mouseY < row * (CELL_WIDTH + MARGIN) + MARGIN + CELL_WIDTH){
          // Print Mouse coordinates and location on grid
          System.out.println("mouse coordinates: (" + mouseX + ", " + mouseY + "); grid coordinates: (row: " + (row + 1) + ", column: " + (column + 1) + ")");
          
          // Top left corner, only change bottom square + right square
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
          
          // Top right corner, only change bottom square + left square
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
          
          // Bottom left corner, only change top square + right square
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
          
          // Bottom right corner, only change top square + left square
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

          // If the mouse does not click on corner square, apply reverse colours to surrounding squares
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
    
    int intCellSelected = 0;
    int intRow0 = 0;
    int intRow1 = 0;
    int intRow2 = 0;
    int intRow3 = 0;
    int intRow4 = 0;
    int intRow5 = 0;
    int intRow6 = 0;
    int intRow7 = 0;
    int intRow8 = 0;
    int intRow9 = 0;
    int intColumn0 = 0;
    int intColumn1 = 0;
    int intColumn2 = 0;
    int intColumn3 = 0;
    int intColumn4 = 0;
    int intColumn5 = 0;
    int intColumn6 = 0;
    int intColumn7 = 0;
    int intColumn8 = 0;
    int intColumn9 = 0;

    for (int row = 0; row < ROW_COUNT; row++){
      if (intGrid[1][row] == 1){
        intRow1 += 1;
      }
      else if (intGrid[2][row] == 1){
        intRow2 += 1;
      }
      else if (intGrid[3][row] == 1){
        intRow3 += 1;
      }
      else if (intGrid[4][row] == 1){
        intRow4 += 1;
      }
      else if (intGrid[5][row] == 1){
        intRow5 += 1;
      }
      else if (intGrid[6][row] == 1){
        intRow6 += 1;
      }
      else if (intGrid[7][row] == 1){
        intRow7 += 1;
      }
      else if (intGrid[8][row] == 1){
        intRow8 += 1;
      }
      else if (intGrid[9][row] == 1){
        intRow9 += 1;
      }
      
      if (intGrid[row][0] == 1){
        intColumn0 += 1;
      }
      else if (intGrid[row][1] == 1){
        intColumn1 += 1;
      }
      else if (intGrid[row][2] == 1){
        intColumn2 += 1;
      }
      else if (intGrid[row][3] == 1){
        intColumn3 += 1;
      }
      else if (intGrid[row][4] == 1){
        intColumn4 += 1;
      }
      else if (intGrid[row][5] == 1){
        intColumn5 += 1;
      }
      else if (intGrid[row][6] == 1){
        intColumn6 += 1;
      }
      else if (intGrid[row][7] == 1){
        intColumn7 += 1;
      }
      else if (intGrid[row][8] == 1){
        intColumn8 += 1;
      }
      else if (intGrid[row][9] == 1){
        intColumn9 += 1;
      }
      for (int column = 0; column < COLUMN_COUNT; column++){
        if (intGrid[row][column] == 1){
          intCellSelected += 1;
        }
      }
    }
    System.out.println("Total of " + intCellSelected + " cells are selected.");
    System.out.println("Row 0 has " + intRow0 + " cells selected.");
    System.out.println("Row 1 has " + intRow1 + " cells selected.");
    System.out.println("Row 2 has " + intRow2 + " cells selected.");
    System.out.println("Row 3 has " + intRow3 + " cells selected.");
    System.out.println("Row 4 has " + intRow4 + " cells selected.");
    System.out.println("Row 5 has " + intRow5 + " cells selected.");
    System.out.println("Row 6 has " + intRow6 + " cells selected.");
    System.out.println("Row 7 has " + intRow7 + " cells selected.");
    System.out.println("Row 8 has " + intRow8 + " cells selected.");
    System.out.println("Row 9 has " + intRow9 + " cells selected.");
    System.out.println("Column 0 has " + intColumn0 + " cells selected.");
    System.out.println("Column 1 has " + intColumn1 + " cells selected.");
    System.out.println("Column 2 has " + intColumn2 + " cells selected.");
    System.out.println("Column 3 has " + intColumn3 + " cells selected.");
    System.out.println("Column 4 has " + intColumn4 + " cells selected.");
    System.out.println("Column 5 has " + intColumn5 + " cells selected.");
    System.out.println("Column 6 has " + intColumn6 + " cells selected.");
    System.out.println("Column 7 has " + intColumn7 + " cells selected.");
    System.out.println("Column 8 has " + intColumn8 + " cells selected.");
    System.out.println("Column 9 has " + intColumn9 + " cells selected.");
  }
}

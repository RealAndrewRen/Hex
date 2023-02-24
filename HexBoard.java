
public class HexBoard extends CharMatrix
{
  public HexBoard(int rows, int cols)
  {
    super(rows, cols);
  }
  public void setBlack(int row, int col) {
	  if (isInBounds(row, col)) {
		  arr[row][col] = 'b';
	  }
  }
  public void setWhite(int row, int col) {
	  if (isInBounds(row, col)) {
		  arr[row][col] = 'w';
	  }
  }
  private void setGray(int row, int col) {
	  if (isInBounds(row, col)) {
		  arr[row][col] = 'g';
	  }
  }
  public boolean isBlack(int row, int col) {
	  return isInBounds(row, col) && arr[row][col] == 'b';
  }
  public boolean isWhite(int row, int col) {
	  return arr[row][col] == 'w' && isInBounds(row, col);
  }
  private boolean isGray(int row, int col) {
	  return arr[row][col] == 'g' && isInBounds(row, col); 
  }
  public String toString() {
	  String str = "";
	  for (int i = 0; i < arr.length; i++) {
		for (int j = 0; j < arr[0].length; j++) {
			if (isBlack(i, j))
		          str += 'B';
		        else if (isWhite(i, j))
		          str += 'W';
		        else if (isGray(i, j))
		          str += 'G';
		        else
		          str += 'X';
		}
		str += "\n";
	}
	  return str;
  }
  public boolean isInBounds(int row, int col) {
	  return row < arr.length && col < arr[0].length && row >= 0 && col >= 0;
  }
  public boolean areaFill(int row, int col) {
	  if (isInBounds(row, col) && isBlack(row, col)) {
		  setGray(row, col);
		  if (areaFill(row - 1, col - 1) == true)
			  return true;
		  if (areaFill(row - 1, col) == true)
			  return true;
		  if (areaFill(row, col - 1) == true)
			  return true;
		  if (areaFill(row + 1, col + 1) == true)
			  return true;
		  if (areaFill(row, col + 1) == true)
			  return true;
		  if (areaFill(row + 1, col) == true)
			  return true;
	  }
	  return col == arr[0].length;
  }
  public boolean blackHasWon() {
	  for (int r = 0; r < arr.length; r++) {
		  areaFill(r, 0);
		  if (isGray(r, arr[0].length - 1)) {
			  return true;
		  }
	  }
	  return false;
  }
  public boolean findWin() {
	  for (int r = 0; r < arr.length; r++) {
		  if(areaFill(r, 0))
			  return true;
  }
	  return false;
}
}
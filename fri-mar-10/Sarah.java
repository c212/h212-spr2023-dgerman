import java.util.ArrayList;
public class Sarah {
  public static void main(String[] args) {
    int size = Integer.parseInt( args[0] );
    ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
    for (int line = 0; line < size; line += 1) {
      ArrayList<Integer> row = new ArrayList<Integer>();
      for (int i = 0; i < size; i += 1) row.add( 0 );
      matrix.add( row );
    }
    int row = size - 1;
    int col = size / 2;
    for (int k = 1; k <= size * size; k += 1) {
      matrix.get( row ).set( col, k );
      int newRow = (row + 1) % size,  
          newCol = (col + 1) % size;  
      if (matrix.get(newRow).get(newCol) == 0) {
        row = newRow;
        col = newCol;
      } else
        row = row - 1;
    }
    Sarah.show( matrix ); // System.out.println( matrix );
  }
  public static void show(ArrayList<ArrayList<Integer>> m) {
    for (ArrayList<Integer> r : m) {
      // System.out.println( r );   
      for (Integer num : r) {
        System.out.printf( " %3d", num );
      }
      System.out.println();
    }
  }  
}    



public class Backtrack{
    // code for N-Queen's

    public static Boolean isSafe(char board[][],int row, int col){
        //vertical col
        for(int i=row-1; i>=0; i--){
            if(board[i][col]=='Q'){
                return false;
            }
        }
        //left Dia
       for(int i=row-1, j=col-1; i>=0 && j>=0; i--,j--){
        if(board[i][j]=='Q'){
            return false;
        }

        }
        //right dia
        for(int i=row-1, j=col+1; i>=0 && j<board.length; i--,j++){
         if(board[i][j]=='Q'){
            return false;
         }
        }

        return true;

    }
     public static void Nqueen(char board[][],int row){
        //Base case
        if(row == board.length){
            coutways++;
            return;
        }
        //work->place the Queeen
        for(int j=0; j<board.length; j++){
         if( isSafe(board, row, j) ){
           board[row][j]='Q';
           Nqueen(board, row+1);//function call
           board[row][j]='x'; //BAcktracking
         }
        }
    }
   public static void printboard(char board[][]){
        System.out.println("-----ChessBoard------");
        for(int i=0;i<board.length;i++){
        for(int j=0;j<board.length;j++){
          System.out.print(board[i][j]+" ");
        }
        System.out.println();
      }
    }


/* 
    //Check if the problem can be solved & print only one solution to N Queen problem
    public static boolean  Nqueen(char board[][],int row){
        //Base case
        if(row == board.length){
            coutways++;
            return true;
        }
        //work->place the Queeen
        for(int j=0; j<board.length; j++){
         if( isSafe(board, row, j) ){
           board[row][j]='Q';
           if(Nqueen(board, row+1)){
            return true;
           }
           board[row][j]='x'; //BAcktracking
         }
        }
        return false;
    }
 */



 // Code for Find the number of way's to reach from (0,0 ) to (n-1, m-1) in a N*M Griad.Aloved moves-> Right, Douwn
     public static int gridways(int i, int j, int n, int m){
        // BaseCase
        if(i==n-1 && j==m-1){//condit for last call
            return 1;
        }else if(i==n || j==n){ //Boundry cross condition
            return 0;
        }
        
        //work
        int w1=gridways(i+1, j, n, m);
        int w2=gridways(i, j+1, n, m);
        return w1+w2;
      }
  
      
    
      // this code is used to solve sudoku
    public static boolean IsSafe(int sudoku[][],int row, int col, int digit){
      // To check coloum 
      for(int i=0;i<=8;i++){
        if(sudoku[i][col]==digit){
        return false;
        }
      }

      //To check at row

      for(int j=0;j<=8;j++){
        if(sudoku[row][j]==digit){
          return false;
        }
      }

      // To check each Grid of Sudoku & falmula use to calcu. 
      //startrow=(row/3)x3;
      //startcol=(col/3)x3;

      int sr=(row/3)*3;
      int sc=(col/3)*3;
      //3x3grid
      for(int i=sr;i<sr+3;i++){
        for(int j=sc;j<sc+3;j++){
          if(sudoku[i][j]==digit){
            return false;
          }
        }
      }
      return true;

    }
    
    public static boolean sudokuSolver(int sudoku[][], int row, int col){
      //Base case
      if(row==9 && col==0){
        return true;
      }


      //Recursion
      int nextRow=row, nextCol=col+1;
      if(col+1==9){
        nextRow=row+1;
        nextCol=0;
      }

      if(sudoku[row][col] != 0){
         return sudokuSolver(sudoku, nextRow, nextCol);
      }

      for(int digit=1; digit<=9;digit++){
        if(IsSafe(sudoku,row,col, digit)){
          sudoku[row][col]= digit;
          if(sudokuSolver(sudoku, nextRow, nextCol)){
            return true;
          }
          sudoku[row][col]=0;
        }
      }
      return false;
    }

    public static void printsudoku(int sudoku[][]){
      for(int i=0;i<9;i++){
        for(int j=0; j<9; j++){
          System.out.print(sudoku[i][j]+" ");
        }System.out.println();
      }

    }
  
 // this variable track the total ways to palce the queen
    static int coutways=0;
    public static void main(String args[]){
      //   int n=4;
      //   char board[][]=new char[n][n];

      //   for(int i=0;i<board.length;i++){
      //       for(int j=0;j<board.length;j++){
      //         board[i][j]='x';
      //       }
      //       System.out.println();
      //     }
      //     /*if(Nqueen(board, 0)){
      //       System.out.println("solution is possible");
      //       printboard(board);
      //     }else{
      //       System.out.println("Solution is not possible");
      //     }
      // */
      //  //   System.out.println("Calculate total ways to place's Queen_ " + coutways);
      int n1=3;
      int  m=3;
      System.out.println(gridways(0, 0, n1, m)) ;

      
  //     //sudoku
  //     int sudoku[][]={{0,0,8,0,0,0,0,0,0},
  //     {4,9,0,1,5,7,0,0,2},
  //     {0,0,3,0,0,4,1,9,0},
  //     {1,8,5,0,6,0,0,2,0},
  //     {0,0,0,0,2,0,0,6,0},
  //     {9,6,0,4,0,0,3,0,0},
  //     {0,3,0,0,7,2,0,0,4},
  //     {0,4,9,0,3,0,0,5,7},
  //     {8,2,7,0,0,9,0,1,3}
  //   };

    
  //   if (sudokuSolver(sudoku, 0, 0)) {
  //     System.out.println("Solution exists:");
  //     printsudoku(sudoku);
  // } else {
  //     System.out.println("No solution exists.");
  // }
  }
}
  
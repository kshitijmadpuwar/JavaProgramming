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

// this variable track the total ways to palce the queen
    static int coutways=0;
    public static void main(String args[]){
        int n=4;
        char board[][]=new char[n][n];

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
              board[i][j]='x';
            }
            System.out.println();
          }
          if(Nqueen(board, 0)){
            System.out.println("solution is possible");
            printboard(board);
          }else{
            System.out.println("Solution is not possible");
          }

          System.out.println("Calculate total ways to place's Queen_ " + coutways);

    }
}
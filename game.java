import java.util.Date;

public class game {

    game(int num) {
        Date date1 = new Date();
        long time1 = date1.getTime();

        for (int i = 0; i < num; i++) {
  
            int N = 9;
            Sudoku sudoku = new Sudoku(N);
            
            sudoku.fill_val();
    
        }

        Date date2 = new Date();
        long time2 = date2.getTime();
        System.out.println((time2 - time1) + "ms to solve "+ num +" sudoku");

    }

}
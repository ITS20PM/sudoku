public class game {

    boolean won;
    int difficulty;

    game(int user_input) {
        this.won = false;
        this.difficulty = user_input;
    }

    public static void main(String[] args){
		int N = 9, K = 20;
		Sudoku sudoku = new Sudoku(N, K);
		
        sudoku.fill_val();
		sudoku.printSudoku();
        //sudoku.print_table();
        //System.out.println(sudoku.flagged());

        int size = sudoku.get_table().size();
        System.out.println(size);

        

	}
}
public class Sudoku{
	int[][] board;
	int N; // number of columns/rows.
	int SRN; // square root of N
	

	// Constructor
	Sudoku(int N){
		this.N = N;

		// Compute square root of N
		this.SRN = (int) Math.sqrt(N);
		this.board = new int[N][N];
	}

	// Sudoku Generator
	public void fill_val(){
		// Fill the diagonal of SRN x SRN matrices
		fill_diagonal();

		// Fill remaining blocks
		fill_remain(0, SRN);
	}

	// Fill the diagonal SRN number of SRN x SRN matrices
	void fill_diagonal(){

		for (int i = 0; i < N; i += SRN){
            // for diagonal box, start coordinates->i==j
			fill_grid(i, i);
        }
			
	}

	// Returns false if given 3 x 3 block contains num.
	boolean unused_grid(int rowStart, int colStart, int num){
		for (int i = 0; i<SRN; i++){
            for (int j = 0; j<SRN; j++){
                if (board[rowStart + i][colStart + j]==num)
					return false;
            }	
        }
			
		return true;
	}

	// Fill a 3 x 3 matrix.
	void fill_grid(int row,int col){
		int num;
		for (int i=0; i<SRN; i++){
			for (int j=0; j<SRN; j++){
				do{
					num = (int) Math.floor((Math.random()*N+1));
				}while (!unused_grid(row, col, num));

				board[row + i][col + j] = num;
			}
		}
	}

	// Check if it is valid to put in cell
	boolean is_valid(int i,int j,int num){
		return (unused_row(i, num) &&
				unused_col(j, num) &&
				unused_grid(i - i % SRN, j - j % SRN, num));
	}

	// check in the row for existence
	boolean unused_row(int i,int num){
		for (int j = 0; j < N; j++)
		if (board[i][j] == num)
				return false;
		return true;
	}

	// check in the row for existence
	boolean unused_col(int j,int num){
		for (int i = 0; i < N; i++)
			if (board[i][j] == num)
				return false;

		return true;
	}

	// A recursive function to fill remaining 
	// matrix
	boolean fill_remain(int i, int j){
		// System.out.println(i+" "+j);
		if (j >= N && i < N-1){
			i += 1;
			j = 0;
		}

		if (i >= N && j >= N)
			return true;

		if (i < SRN){
			if (j < SRN)
				j = SRN;
		}else if (i < N - SRN){
			if (j == (int)(i / SRN) * SRN)
				j += SRN;
		}else{
			if (j == N - SRN){
				i += 1;
				j = 0;
				if (i>=N)
					return true;
			}
		}

		for (int num = 1; num<=N; num++){
			if (is_valid(i, j, num)){
				board[i][j] = num;
				if (fill_remain(i, j+1))
					return true;

				board[i][j] = 0;
			}
		}

		return false;
	}

	
	// Print sudoku
	public void printSudoku(){
		for (int i = 0; i < N; i++){
            System.out.print("| ");
			for (int j = 0; j < N; j++) {
                if (board[i][j] != 0) {
                    System.out.print(board[i][j]);
                }else{
                    System.out.print(" ");
                }
                System.out.print(" | ");
            }
				
			System.out.println();
		}
		System.out.println();
        
	}


}
public class Board{

	private final int NUM_OF_COLUMNS = 7;
	private final int NUM_OF_ROW = 6;
	protected char[][] f = new char[NUM_OF_ROW][2*NUM_OF_COLUMNS+1];
	/* 
	 * The f object must contain the f state in some manner.
	 * You must decide how you will do this.
	 * 
	 * You may add addition private/public methods to this class is you wish.
	 * However, you should use best OO practices. That is, you should not expose
	 * how the f is being implemented to other classes. Specifically, the
	 * "R" classes.
	 * 
	 */
    
	public void printBoard() {
		for (int i = 0 ; i <  f.length; i++){
            for (int j = 0 ; j < f[0].length; j++) {
                System.out.print(f[i][j]);
            }
            System.out.print("\n");
        }
	}
	
	public boolean containsWin() {
        //horizontal win
		for (int row = 0; row < NUM_OF_ROW; row++) {
            for (int col = 0; col < 9; col++) {
                if (f[row][col] != ' ' && f[row][col] != '|' && f[row][col] != '_')
                    if (f[row][col] == f[row][col+2] && f[row][col] == f[row][col+4] && f[row][col] == f[row][col+6]){
                            return true;
                    }
            }
        }
        //vertical win
        for (int row = 0; row < NUM_OF_ROW - 3; row++) {
            for (int col = 0; col < 15 ; col++) {
                if (f[row][col] != ' ' && f[row][col] != '|')
                    if (f[row][col] == f[row+1][col] && f[row][col] == f[row+2][col] && f[row][col] == f[row+3][col]){
                        return true;
                }
            }
        }
        //downward diagonal
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                if (f[row][col] != ' ' && f[row][col] != '|')
                    if (f[row][col] == f[row+1][col+2] && f[row][col] == f[row+2][col+4] && f[row][col] == f[row+3][col+6]){
                        return true;
                }
            }
        }
        //upward diagonal
        for (int row = 5; row > 2 ; row--) {
            for (int col = 0; col < 9; col++) {
                if (f[row][col] != ' ' && f[row][col] != '|')
                    if (f[row][col] == f[row-1][col+2] && f[row][col] == f[row-2][col+4] && f[row][col] == f[row-3][col+6]){
                        return true;
                }
            }
        }
	    return false;	
	}
	
	public boolean isTie() {
        for (int row = 0; row < NUM_OF_ROW; row++) {
            for (int col = 0; col < 15; col++){
                if (f[row][col] == ' '){
                    return false;
                }
            }
        }
        return true;
	}
	
	public void reset() {
		for (int i = 0 ; i <  f.length; i++){
            for (int j = 0 ; j < f[0].length; j++){
                if (j% 2 == 0) f[i][j] ='|';
                else f[i][j] = ' ';
                if (i==5 && j% 2 == 1) f[i][j]= '_';
	        }
        }
    }

    public int almostWinHor(char symbol){
        //System.out.println("Horizontal");
        for (int row = 0; row < f.length; row++) {
            for (int col = 0; col < f[0].length - 6; col++){
                if (f[row][col] == symbol && f[row][col+2] == symbol &&
                    f[row][col+4] == symbol && f[row][col+6] == ' ' && f[row+1][col+6] == '_'){
                    return col + 6;
                    }
                else if (f[row][col] == symbol && f[row][col+2] == symbol &&
                    f[row][col+4] == symbol && f[row][col+6] == ' ' && f[row+1][col+6] != '_'){
                    return col + 6;
                    }
                else if (f[row][col] == symbol && f[row][col+2] == symbol &&
                f[row][col+4] == ' ' && f[row][col+6] == symbol && f[row+1][col+4] == '_'){
                    return col + 4;
                }
                else if (f[row][col] == symbol && f[row][col+2] == symbol &&
                f[row][col+4] == ' ' && f[row][col+6] == symbol && f[row+1][col+4] != ' '){
                    return col + 4;
                }
                else if (f[row][col] == symbol && f[row][col+2] == ' ' &&
                f[row][col+4] == symbol && f[row][col+6] == symbol && f[row+1][col+2] == '_'){
                    return col + 2;
                }
                else if (f[row][col] == symbol && f[row][col+2] == ' ' &&
                f[row][col+4] == symbol && f[row][col+6] == symbol && f[row+1][col+2] != ' '){
                    return col + 2;
                }
                else if (f[row][col] == ' ' && f[row][col+2] == symbol &&
                f[row][col+4] == symbol && f[row][col+6] == symbol && f[row+1][col] == '_'){
                    return col;
                }
                else if (f[row][col] == ' ' && f[row][col+2] == symbol &&
                f[row][col+4] == symbol && f[row][col+6] == symbol && f[row+1][col] != ' '){
                    return col;
                }

            }
        }
        return 0;
    }

    public int almostWinVert(char symbol) {
        //System.out.println("Vert");
        for (int row = 0; row < f.length-3; row++) {
            for (int col = 0; col < f[0].length; col++){
                if (f[row][col] == ' ' && f[row+1][col] == symbol &&
                f[row+2][col] == symbol && f[row+3][col] == symbol){
                        return col;
                    }
            }
        }
        return 0;
    }

    public int almostWinDiag(char symbol) {
        //System.out.println("D1");
        for (int row = 3; row < f.length; row++) {
            for (int col = 0; col < f[0].length - 6; col++){
                if (f[row][col] == symbol && f[row-1][col+2] == symbol &&
                f[row-2][col+4] == symbol && f[row-3][col+6] == ' ' && f[row-2][col+6] != ' '){
                        return col + 6;
                    }
                else if (f[row][col] == symbol && f[row-1][col+2] == symbol &&
                f[row-2][col+4] == ' ' && f[row-3][col+6] == symbol && f[row-1][col+4] != ' '){
                        return col + 4;
                }
                else if (f[row][col] == symbol && f[row-1][col+2] == ' ' &&
                f[row-2][col+4] == symbol && f[row-3][col+6] == symbol && f[row][col+2] != ' '){
                        return col + 2;
                }
                else if (f[row][col] == ' ' && f[row-1][col+2] == symbol &&
                f[row-2][col+4] == symbol && f[row-3][col+6] == symbol){
                        return col;
                }
            }
        }
        return 0;
    }

    public int almostWinDiag2(char symbol) {
        //System.out.println("D2");
        for (int row = 0; row < f.length-3; row++) {
            for (int col = 0; col < f[0].length - 6; col++){
                if (f[row][col] == symbol && f[row+1][col+2] == symbol &&
                f[row+2][col+4] == symbol && f[row+3][col+6] == ' '){
                        return col + 6;
                    }
                else if (f[row][col] == symbol && f[row+1][col+2] == symbol &&
                    f[row+2][col+4] == ' ' && f[row+3][col+6] == symbol && f[row+3][col+4] != ' '){
                        return col + 4;
                }
                else if (f[row][col] == symbol && f[row+1][col+2] == ' ' &&
                f[row+2][col+4] == symbol && f[row+3][col+6] == symbol && f[row+2][col+2] != ' '){
                        return col + 2;
                }
                else if (f[row][col] == ' ' && f[row+1][col+2] == symbol &&
                f[row+2][col+4] == symbol && f[row+3][col+6] == symbol && f[row+1][col] != ' '){
                        return col;
                }
            }
        }
        return 0;
    }

//------------------------
    public int almostWinHor1(){
        //System.out.println("Horizontal1");
        for (int row = 0; row < f.length; row++) {
            for (int col = 0; col < f[0].length - 6; col++){
                if (f[row][col+2] != ' ')
                    if (f[row][col] == ' ' && f[row][col+2] == f[row][col+4] &&
                    f[row][col+4] == f[row][col+6] && f[row][col+6] == f[row][col+2] && f[row+1][col] == '_'){
                        return col;
                    }
                    else if (f[row][col] == ' ' && f[row][col+2] == f[row][col+4] &&
                    f[row][col+4] == f[row][col+6] && f[row][col+6] == f[row][col+2] && f[row+1][col] != ' '){
                        return col;
                    }
                if (f[row][col+2] != '_' || f[row][col+4] != '_')
                    if (f[row][col] == '_' && f[row][col+2] == f[row][col+4] &&
                    f[row][col+4] == f[row][col+6] && f[row][col+6] == f[row][col+2]){
                        return col;
                    }
                    else if (f[row][col] == f[row][col+6] && f[row][col+2] == f[row][col+6] &&
                    f[row][col+4] == '_' && f[row][col+6] == f[row][col+6]){
                        return col + 4;
                    }
                    else if (f[row][col] == f[row][col+6] && f[row][col+2] == '_' &&
                    f[row][col+4] == f[row][col+6] && f[row][col+6] == f[row][col+6]){
                        return col + 2;
                    }
                    else if (f[row][col] == f[row][col+4] && f[row][col+2] == f[row][col+4] &&
                        f[row][col+4] == f[row][col] && f[row][col+6] == '_'){
                        return col + 6;
                    }
                if (row < f.length - 1)
                    if (f[row][col] != '_' && f[row][col] != '|' && f[row][col] != ' ')
                        if (f[row][col] == f[row][col+4] && f[row][col+2] == f[row][col+4] &&
                            f[row][col+4] == f[row][col] && f[row][col+6] == ' ' && f[row+1][col+6] == '_'){
                            return col + 6;
                            }
                        else if (f[row][col] == f[row][col+4] && f[row][col+2] == f[row][col+4] &&
                        f[row][col+4] == f[row][col] && f[row][col+6] == ' ' && f[row+1][col+6] != ' '){
                        return col + 6;
                        }
                        else if (f[row][col] == f[row][col+6] && f[row][col+2] == f[row][col+6] &&
                        f[row][col+4] == ' ' && f[row][col+6] == f[row][col+6] && f[row+1][col+4] == '_'){
                            return col + 4;
                        }
                        else if (f[row][col] == f[row][col+6] && f[row][col+2] == f[row][col+6] &&
                        f[row][col+4] == ' ' && f[row][col+6] == f[row][col+6] && f[row+1][col+4] != ' '){
                            return col + 4;
                        }
                        else if (f[row][col] == f[row][col+6] && f[row][col+2] == ' ' &&
                        f[row][col+4] == f[row][col+6] && f[row][col+6] == f[row][col+6] && f[row+1][col+2] == '_'){
                            return col + 2;
                        }
                        else if (f[row][col] == f[row][col+6] && f[row][col+2] == ' ' &&
                        f[row][col+4] == f[row][col+6] && f[row][col+6] == f[row][col+6] && f[row+1][col+2] != ' '){
                            return col + 2;
                        }
                else if (row > f.length - 1){
                    if (f[row][col] != '_' && f[row][col] != '|' && f[row][col] != ' ')
                        if (f[row][col] == f[row][col+4] && f[row][col+2] == f[row][col+4] &&
                            f[row][col+4] == f[row][col] && f[row][col+6] == ' '){
                            return col + 6;
                            }
                        else if (f[row][col] == f[row][col+6] && f[row][col+2] == f[row][col+6] &&
                        f[row][col+4] == ' ' && f[row][col+6] == f[row][col+6]){
                            return col + 4;
                        }
                        else if (f[row][col] == f[row][col+6] && f[row][col+2] == ' ' &&
                        f[row][col+4] == f[row][col+6] && f[row][col+6] == f[row][col+6]){
                            return col + 2;
                        }
                }

            }
        }
        return 0;
    }

    public int almostWinVert1() {
        //System.out.println("Vert1");
        for (int row = 0; row < f.length-3; row++) {
            for (int col = 0; col < f[0].length; col++){
                if (f[row+1][col] != ' ')
                    if (f[row][col] == ' ' && f[row+1][col] == f[row+2][col] &&
                    f[row+2][col] == f[row+3][col] && f[row+3][col] == f[row+1][col]){
                        return col;
                        }
            }
        }
        return 0;
    }

    public int almostWinDiagOne() {
        //System.out.println("DOne");
        for (int row = 3; row < f.length; row++) {
            for (int col = 0; col < f[0].length - 6; col++){
                if (f[row][col] != '|' && f[row][col] != ' ')
                    if (f[row][col] == f[row-1][col+2] && f[row-1][col+2] == f[row-2][col+4] &&
                    f[row-2][col+4] == f[row][col] && f[row-3][col+6] == ' ' && f[row-2][col+6] != ' '){
                        return col + 6;
                        }
                    else if (f[row][col] == f[row-1][col+2] && f[row-1][col+2] == f[row-3][col+6] &&
                    f[row-2][col+4] == ' ' && f[row-3][col+6] == f[row][col] && f[row-1][col+4] != ' '){
                            return col + 4;
                    }
                    else if (f[row][col] == f[row-2][col+4] && f[row-1][col+2] == ' ' &&
                    f[row-2][col+4] == f[row-3][col+6] && f[row-3][col+6] == f[row][col] && f[row][col+2] != ' '){
                            return col + 2;
                    }
                if (f[row-1][col+2] != ' ')
                    if (f[row][col] == ' ' && f[row-1][col+2] == f[row-2][col+4] &&
                    f[row-2][col+4] == f[row-3][col+6] && f[row-3][col+6] == f[row-1][col+2]){
                        return col;
                    }
            }
        }
        return 0;
    }

    public int almostWinDiagTwo() {
        //System.out.println("DTwo");
        for (int row = 0; row < f.length-3; row++) {
            for (int col = 0; col < f[0].length - 6; col++){
                if (f[row][col] != '|' && f[row][col] != ' ')
                    if (f[row][col] == f[row+1][col+2] && f[row+1][col+2] == f[row+2][col+4] &&
                    f[row+2][col+4] == f[row][col] && f[row+3][col+6] == ' ' && f[row+4][col+6] != ' '){
                            return col + 6;
                        }
                    else if (f[row][col] == f[row+1][col+2] && f[row+1][col+2] == f[row+3][col+6] &&
                        f[row+2][col+4] == ' ' && f[row+3][col+6] == f[row][col] && f[row+3][col+4] != ' '){
                            return col + 4;
                    }
                    else if (f[row][col] == f[row+2][col+4] && f[row+1][col+2] == ' ' &&
                    f[row+2][col+4] == f[row+3][col+6] && f[row+3][col+6] == f[row][col] && f[row+2][col+2] != ' '){
                            return col + 2;
                    }
                if (f[row+1][col+2] != ' ')
                    if (f[row][col] == ' ' && f[row+1][col+2] == f[row+2][col+4] &&
                    f[row+2][col+4] == f[row+3][col+6] && f[row+3][col+6] == f[row+1][col+2] && f[row+1][col] != ' '){
                            return col;
                    }
            }
        }
        return 0;
    }

}


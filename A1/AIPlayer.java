import java.util.Random;

public class AIPlayer extends Player{

    public AIPlayer(char symbol, Board board, String name) {
        super(symbol, board, name);
    }

    @Override
    public void makeMove(Board board) {
        System.out.print(name + ", Please input your move: \n");
        boolean valid = false;
        while (!valid){
            if (board.almostWinHor(symbol) != 0){
                for (int i = 5; i >= 0; i--){
                    //System.out.println("insde for loop i: " + i);
                    if (board.f[i][board.almostWinHor(symbol)] == ' ' || board.f[i][board.almostWinHor(symbol)] == '_') {
                        board.f[i][board.almostWinHor(symbol)] = symbol;
                        valid = true;
                        break;
                    }
                }
            }
            else if (board.almostWinVert(symbol) != 0){
                for (int i = 5; i >= 0; i--){
                    //System.out.println("insde for loop i: " + i);
                    if (board.f[i][board.almostWinVert(symbol)] == ' ' || board.f[i][board.almostWinVert(symbol)] == '_') {
                        board.f[i][board.almostWinVert(symbol)] = symbol;
                        valid = true;
                        break;
                    }
                }
            }
            else if (board.almostWinDiag(symbol) != 0){
                for (int i = 5; i >= 0; i--){
                    //System.out.println("insde for loop i: " + i);
                    if (board.f[i][board.almostWinDiag(symbol)] == ' ' || board.f[i][board.almostWinDiag(symbol)] == '_') {
                        board.f[i][board.almostWinDiag(symbol)] = symbol;
                        valid = true;
                        break;
                    }     
                }
            }

            else if (board.almostWinDiag2(symbol) != 0){
                for (int i = 5; i >= 0; i--){
                    if (board.f[i][board.almostWinDiag2(symbol)] == ' ' || board.f[i][board.almostWinDiag2(symbol)] == '_') {
                        board.f[i][board.almostWinDiag2(symbol)] = symbol;
                        valid = true;
                        break;
                    }  
                }
            }

            else if (board.almostWinHor1() != 0){
                for (int i = 5; i >= 0; i--){
                    if (board.f[i][board.almostWinHor1()] == ' ' || board.f[i][board.almostWinHor1()] == '_') {
                        board.f[i][board.almostWinHor1()] = symbol;
                        valid = true;
                        break;
                    }
                }
            }
            else if (board.almostWinVert1() != 0){
                for (int i = 5; i >= 0; i--){
                    if (board.f[i][board.almostWinVert1()] == ' ' || board.f[i][board.almostWinVert1()] == '_') {
                        board.f[i][board.almostWinVert1()] = symbol;
                        valid = true;
                        break;
                    }
                }
            }
            else if (board.almostWinDiagOne() != 0){
                for (int i = 5; i >= 0; i--){
                    if (board.f[i][board.almostWinDiagOne()] == ' ' || board.f[i][board.almostWinDiagOne()] == '_') {
                        board.f[i][board.almostWinDiagOne()] = symbol;
                        valid = true;
                        break;
                    }     
                }
            }

            else if (board.almostWinDiagTwo() != 0){
                for (int i = 5; i >= 0; i--){
                    if (board.f[i][board.almostWinDiagTwo()] == ' ' || board.f[i][board.almostWinDiagTwo()] == '_') {
                        board.f[i][board.almostWinDiagTwo()] = symbol;
                        valid = true;
                        break;
                    }  
                }
            }
            else if (board.almostWinHor(symbol) == 0 && board.almostWinVert(symbol) == 0 && board.almostWinDiag(symbol) == 0 && board.almostWinDiag2(symbol) == 0){
                int min = 1;
                Random rand = new Random();
                int move = rand.nextInt(7) + min;
                for (int i = 5; i >= 0; i--){
                    if (board.f[i][2*move-1] == ' ' || board.f[i][2*move-1] == '_') {
                        board.f[i][2*move-1] = symbol;
                        valid = true;
                        break;
                    }
                    
                }
            }
        
        }
        
    }

 
}

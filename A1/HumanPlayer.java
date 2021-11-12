import java.util.Scanner;

public class HumanPlayer extends Player {

    public HumanPlayer(char symbol, Board board, String name) {
        super(symbol, board, name);
    }

    
    @Override
    public void makeMove(Board board) {
        Scanner sc = new Scanner(System.in);
        boolean valid = false;
        while (!valid){
            System.out.print(name + ", Please input your move: \t");
            int move = 2 * sc.nextInt() - 1;
            for (int i = 5; i >= 0; i--){
                //System.out.println("insde for loop i: " + i);
                if (board.f[i][move] == ' ' || board.f[i][move] == '_') {
                    board.f[i][move] = symbol;
                    valid = true;
                    break;
                }
                
            }
            if (!valid){
                System.out.println("Invalid Move. Try again.");
            }
        }
    }
}
    


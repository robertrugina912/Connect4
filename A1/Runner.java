public class Runner {
    
    public static void main(String[] args) {
		Board board = new Board();
		ConnectFour game = new ConnectFour(board);
        game.setPlayer1(new HumanPlayer('O', board, "Alice"));
        game.setPlayer2(new AIPlayer('X', board, "Bob"));
        game.playGame();
    }
}

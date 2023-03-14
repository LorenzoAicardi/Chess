package Model;

public class Main {

    public static void main(String[] args){

        Board board = new Board();
        board.drawBoard();
        board.checkLegalMoves(board.getTile(1,6));
    }

}

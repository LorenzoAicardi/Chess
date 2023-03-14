package Model;

public class Main {

    public static void main(String[] args){

        Board board = new Board();
        System.out.println(board);
        board.checkLegalMoves(board.getTile(1,1));
    }

}

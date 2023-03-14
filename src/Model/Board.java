package Model;

import java.util.Arrays;
import java.util.List;

public class Board {
    private int rows = 8;
    private int columns = 8;
    private Tile[][] tiles = new Tile[rows][columns];

    public Board() {
        for (int i = 0; i<rows; i++){
            for (int j = 0; j<columns; j++){
                tiles[i][j] = new Tile(false, null, i, j);
            }
        }
        spawnPieces(Color.BLACK);
        spawnPieces(Color.WHITE);
    }

    public void drawBoard() {

        String[][] repr = new String[rows][columns];

        for(int i = 0; i<rows; i++){
            for(int j = 0; j<columns; j++){
                repr[i][j] = tiles[i][j].drawTile();
            }
        }

        System.out.println(Arrays.deepToString(repr));
    }

    public void move(int rows, int cols, int rowd, int cold) {
        Tile src = getTile(rows, cols);
        Tile dest = getTile(rowd, cold);
        if(src.isOccupied()) {
            List<Tile> possibleDests = checkLegalMoves(src);
            if(possibleDests.contains(dest)) {
                dest.setOccupiedPiece(true, src.getPiece());
                src.setOccupiedPiece(false, null);
            } else {
                System.out.println("Illegal move; please try again.");
            }
        } else {
            System.out.println("There's no piece here!");
        }
    }


    public List<Tile> checkLegalMoves(Tile t) {
        if(t.isOccupied()) {
            Movement moves = PieceMovement.getMovement(t.getPiece().getSymbol());
            moves.getMoves(t, this);
            System.out.println(moves);
        }
        return null;
    }

    private void winCheck(){

    }

    private void check() {

    }

    private void spawnPieces(Color color) {
        int row ;

        row = color == Color.BLACK ? 0 : 6;
        if(color == Color.BLACK) {
            this.tiles[row][0].setOccupiedPiece(true, new Piece(color, PieceType.ROOK));
            this.tiles[row][1].setOccupiedPiece(true, new Piece(color, PieceType.KNIGHT));
            this.tiles[row][2].setOccupiedPiece(true, new Piece(color, PieceType.BISHOP));
            this.tiles[row][3].setOccupiedPiece(true, new Piece(color, PieceType.QUEEN));
            this.tiles[row][4].setOccupiedPiece(true, new Piece(color, PieceType.KING));
            this.tiles[row][5].setOccupiedPiece(true, new Piece(color, PieceType.BISHOP));
            this.tiles[row][6].setOccupiedPiece(true, new Piece(color, PieceType.KNIGHT));
            this.tiles[row][7].setOccupiedPiece(true, new Piece(color, PieceType.ROOK));
            for (int i = 0; i < rows; i++) {
                this.tiles[row + 1][i].setOccupiedPiece(true, new Piece(color, PieceType.PAWN));
            }
        } else {
            for (int i = 0; i < rows; i++) {
                this.tiles[row][i].setOccupiedPiece(true, new Piece(color, PieceType.PAWN));
            }
            this.tiles[row+1][0].setOccupiedPiece(true, new Piece(color, PieceType.ROOK));
            this.tiles[row+1][1].setOccupiedPiece(true, new Piece(color, PieceType.KNIGHT));
            this.tiles[row+1][2].setOccupiedPiece(true, new Piece(color, PieceType.BISHOP));
            this.tiles[row+1][3].setOccupiedPiece(true, new Piece(color, PieceType.QUEEN));
            this.tiles[row+1][4].setOccupiedPiece(true, new Piece(color, PieceType.KING));
            this.tiles[row+1][5].setOccupiedPiece(true, new Piece(color, PieceType.BISHOP));
            this.tiles[row+1][6].setOccupiedPiece(true, new Piece(color, PieceType.KNIGHT));
            this.tiles[row+1][7].setOccupiedPiece(true, new Piece(color, PieceType.ROOK));
        }

    }

    public Tile getTile(int row, int col) {
        return tiles[row][col];
    }

}

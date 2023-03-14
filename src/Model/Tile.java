package Model;

public class Tile {

    private boolean isOccupied;
    private Piece piece;
    private final int row;
    private final int col;

    public Tile(boolean isOccupied, Piece piece, int row, int col) {
        this.isOccupied = isOccupied;
        this.piece = piece;
        this.row = row;
        this.col = col;
    }

    public String drawTile() {
        if (isOccupied) {
            return piece.drawPiece();
        } else {
            return "\u001B[30m" + "■";
        }
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setOccupiedPiece(boolean occupied, Piece piece) {
        isOccupied = occupied;
        this.piece = piece;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public String toString(){
        return "ciao";
    }
}

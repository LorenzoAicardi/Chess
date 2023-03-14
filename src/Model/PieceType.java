package Model;

public enum PieceType {

    PAWN("P"),
    ROOK("R"),
    QUEEN("Q"),
    KING("K"),
    KNIGHT("N"),
    BISHOP("B");

    private String type;

    PieceType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}

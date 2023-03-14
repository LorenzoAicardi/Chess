package Model;

public enum PieceSymbol {

    K("King"),
    Q("Queen"),
    N("Knight"),
    P("Pawn"),
    B("Bishop"),
    R("Rook");

    private String symbol;

    PieceSymbol(String type) {
        this.symbol = type;
    }

}

package Model;

import Model.Exceptions.NoSuchIdException;

import java.util.List;
import java.util.Locale;

public class Piece {

    private final Color colour;
    private final PieceType type;
    private final PieceSymbol symbol;
    private final int id;

    public Piece(Color colour, PieceType type) {
        this.colour = colour;
        this.type = type;
        this.symbol = PieceSymbol.valueOf(type.getType());
        this.id = switch (type) {
            case PAWN -> 1;
            case KNIGHT -> 2;
            case ROOK -> 3;
            case BISHOP -> 4;
            case QUEEN -> 5;
            case KING -> 6;
        };
    }

    public String drawPiece() {
        return colour.getColour() + symbol.name();
    }

    public Color getColour() {
        return colour;
    }

    public int getSymbol() {
        return id;
    }
}

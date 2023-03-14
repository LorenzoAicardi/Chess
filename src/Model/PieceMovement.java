package Model;

import java.util.ArrayList;
import java.util.List;

public enum PieceMovement {

    PAWN(
            (Tile src, Board b) -> {
                List<Tile> movement = new ArrayList<>();
                if(src.getPiece().getColour() == Color.BLACK){
                    if(src.getRow() == 1){
                        movement.add(b.getTile(src.getRow(), src.getCol()+1));
                        movement.add(b.getTile(src.getRow(), src.getCol()+2));
                    }else{
                        movement.add(b.getTile(src.getRow(), src.getCol()+1));
                    }
                }else{
                    if(src.getRow() == 6){
                        movement.add(b.getTile(src.getRow(), src.getCol()-1));
                        movement.add(b.getTile(src.getRow(), src.getCol()-2));
                    }else{
                        movement.add(b.getTile(src.getRow(), src.getCol()-1));
                    }
                }
                return movement;
            }
    );

    /*
    KNIGHT(
            (Tile src, Board b) -> {

            }
    ),
    ROOK(
            (Tile src, Board b) -> {

            }
    ),
    BISHOP(
            (Tile src, Board b) -> {

            }
    ),
    QUEEN(
            (Tile src, Board b) -> {

            }
    ),
    KING(
            (Tile src, Board b) -> {

            }
    );
    */


    private Movement movement;

    public static Movement getMovement(int piece){
        return PieceMovement.values()[piece-1].movement;
    }

    PieceMovement(Movement movement) {
        this.movement = movement;
    }
}


package Model;

import java.util.ArrayList;
import java.util.List;

public enum PieceMovement {

    PAWN(
            (Tile src, Board b) -> {
                List<Tile> movement = new ArrayList<>();
                if(src.getPiece().getColour() == Color.BLACK){
                    if(src.getRow() == 1){
                        movement.add(b.getTile(src.getRow()+1, src.getCol()));
                        movement.add(b.getTile(src.getRow()+2, src.getCol()));
                    }else{
                        movement.add(b.getTile(src.getRow()+1, src.getCol()));
                    }
                }else{
                    if(src.getRow() == 6){
                        movement.add(b.getTile(src.getRow()-1, src.getCol()));
                        movement.add(b.getTile(src.getRow()-2, src.getCol()));
                    }else{
                        movement.add(b.getTile(src.getRow()-1, src.getCol()));
                    }
                }
                return movement;
            }
    ),
    KNIGHT(
            (Tile src, Board b) -> {
                List<Tile> movement = new ArrayList<>();
                movement.add(b.getTile(src.getRow()+2, src.getCol()+1));
                movement.add(b.getTile(src.getRow()+2, src.getCol()-1));
                movement.add(b.getTile(src.getRow()+1, src.getCol()-2));
                movement.add(b.getTile(src.getRow()+1, src.getCol()+2));
                movement.add(b.getTile(src.getRow()-1, src.getCol()+2));
                movement.add(b.getTile(src.getRow()-1, src.getCol()-2));
                movement.add(b.getTile(src.getRow()-2, src.getCol()-1));
                movement.add(b.getTile(src.getRow()-2, src.getCol()+1));
                return movement;
            }
    ),
    ROOK(
            (Tile src, Board b) -> {
                List<Tile> movement = new ArrayList<>();
                for (int i = 0; i<7; i++){
                    movement.add(b.getTile(i, src.getCol()));
                    if(b.getTile(i, src.getCol()).isOccupied())
                        break;
                }
                for (int i = 0; i<7; i++){
                    movement.add(b.getTile(src.getRow(), i));
                    if(b.getTile(src.getRow(), i).isOccupied())
                        break;
                }
                return movement;
            }
    ),
    BISHOP(
            (Tile src, Board b) -> {
                List<Tile> movement = new ArrayList<>();
                for (int i = 0; i<7; i++){
                    movement.add(b.getTile(src.getRow()+i, src.getCol()+i));
                    movement.add(b.getTile(src.getRow()-i, src.getCol()-i));
                    movement.add(b.getTile(src.getRow()+i, src.getCol()-i));
                    movement.add(b.getTile(src.getRow()-i, src.getCol()+i));
                    //if(movement.subList(movement.size()-4, movement.size()).contains())
                    //    break;
                }
                return movement;
            }
    ),
    QUEEN(
            (Tile src, Board b) -> {
                List<Tile> movement = new ArrayList<>(PieceMovement.values()[3].movement.getMoves(src, b));
                movement.addAll(PieceMovement.values()[4].movement.getMoves(src, b));
                return movement;
            }
    ),
    KING(
            (Tile src, Board b) -> {
                //FIXME: add legal moves for the king to avoid checks
                List<Tile> movement = new ArrayList<>();
                movement.add(b.getTile(src.getRow()+1, src.getCol()+1));
                movement.add(b.getTile(src.getRow()+1, src.getCol()-1));
                movement.add(b.getTile(src.getRow()-1, src.getCol()-1));
                movement.add(b.getTile(src.getRow()-1, src.getCol()+1));
                movement.add(b.getTile(src.getRow()-1, src.getCol()));
                movement.add(b.getTile(src.getRow()+1, src.getCol()));
                movement.add(b.getTile(src.getRow(), src.getCol()-1));
                movement.add(b.getTile(src.getRow(), src.getCol()+1));
                return movement;
            }
    );


    private Movement movement;

    public static Movement getMovement(int piece){
        return PieceMovement.values()[piece-1].movement;
    }

    PieceMovement(Movement movement) {
        this.movement = movement;
    }
}


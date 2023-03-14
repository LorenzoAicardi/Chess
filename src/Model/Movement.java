package Model;

import java.util.List;

@FunctionalInterface
public interface Movement {

    List<Tile> getMoves(Tile src, Board b);

}

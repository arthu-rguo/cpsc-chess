package model.pieces;

import model.Colour;
import model.board.Board;
import model.board.Square;

import java.util.List;

/**
 * Represents a generic piece.
 */
public abstract class Piece {
    private final Colour colour;

    /**
     * EFFECTS: Constructs a new Piece with given params.
     */
    public Piece(Colour colour) {
        this.colour = colour;
    }

    /**
     * EFFECTS: Returns true if the piece can make the given move.
     */
    public boolean isValidMove(Board board, Square start, Square end) {
        return getValidSquares(board, start).contains(end);
    }

    public Colour getColour() {
        return colour;
    }

    /**
     * EFFECTS: Returns a list of all squares on the board that the piece can move to.
     */
    public abstract List<Square> getValidSquares(Board board, Square start);

    public abstract String getPrefix();
}

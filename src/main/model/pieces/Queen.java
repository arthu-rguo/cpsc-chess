package model.pieces;

import model.Colour;
import model.Direction;
import model.board.Board;
import model.board.Square;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents a queen piece.
 */
public class Queen extends Piece {
    private static final String PREFIX = "Q";
    private static final Direction[] MOVE_DIRECTIONS = {
            Direction.EAST, Direction.NORTHEAST, Direction.NORTH, Direction.NORTHWEST,
            Direction.WEST, Direction.SOUTHWEST, Direction.SOUTH, Direction.SOUTHEAST
    };

    /**
     * EFFECTS: Constructs a new Queen with given params.
     */
    public Queen(Colour colour) {
        super(colour);
    }

    /**
     * EFFECTS: See Piece.getValidSquares.
     */
    @Override
    public Set<Square> getValidSquares(Board board, Square start) {
        Set<Square> validSquares = new HashSet<>();

        for (Direction direction : MOVE_DIRECTIONS) {
            // Apply offset to starting square based on direction until out of bounds.
            for (int x = start.getX() + direction.getX(), y = start.getY() + direction.getY();
                    !board.isOutOfBounds(x, y); x += direction.getX(), y += direction.getY()) {
                Square square = board.getSquare(x, y);

                // Check if the square is occupied by another piece.
                if (square.hasPiece()) {
                    if (square.getPiece().getColour() != getColour()) {
                        validSquares.add(square);
                    }
                    break;
                }
                validSquares.add(square);
            }
        }

        return validSquares;
    }

    @Override
    public String toString() {
        return PREFIX;
    }
}

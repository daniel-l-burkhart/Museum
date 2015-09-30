package mnkgame.model;

import java.util.ArrayList;

/**
 * MNK method for Alpha-Beta pruning.
 *
 * @author jcchurch
 * @version Fall 2015
 */
public class MNKAlphaBeta {

	/**
	 * Returns the minimax'd payoff of a board state.
	 *
	 * @param aBoard
	 *            the current game board
	 * @param myMark
	 *            the current CPU player
	 * @param depth
	 *            the current depth
	 * @param maxNode
	 *            if this is a maxNode then true, false if min node
	 * @return the minimax'd payoff
	 */
	public static int alphabeta(MNKGame aBoard, Mark myMark, int depth, boolean maxNode) {
		return alphaBetaRecursive(aBoard, myMark, -1 * (aBoard.getWinLength() + 1), aBoard.getWinLength() + 1, depth,
				maxNode);
	}

	public static int alphabetaIterativeDeepening(MNKGame aBoard, Mark myMark, int mindepth, int maxdepth,
			boolean maxNode) {
		int bestScore = Integer.MIN_VALUE;
		
		
		return -1;
	}

	private static int alphaBetaRecursive(MNKGame aBoard, Mark myMark, int alpha, int beta, int depth,
			boolean maxNode) {

		if (maxNode) {
			alpha = alphaBetMaxNode(aBoard, myMark, alpha, beta, depth);
			return alpha;

		} else if (!maxNode) {
			beta = alphaBetaMinNode(aBoard, myMark, alpha, beta, depth);
			return beta;
		}

		return -1;
	}

	
	private static int alphaBetaMinNode(MNKGame aBoard, Mark myMark, int alpha, int beta, int depth) {
		int value;
		for (int move : aBoard.getMoves()) {
			value = alphaBetaRecursive(aBoard.makeMove(move), myMark, alpha, beta, depth - 1, true);

			if (value <= alpha) {
				return alpha;
			}

			if (value < beta) {
				beta = value;
			}
		}
		return beta;
	}


	private static int alphaBetMaxNode(MNKGame aBoard, Mark myMark, int alpha, int beta, int depth) {
		int value;
		for (int move : aBoard.getMoves()) {
			value = alphaBetaRecursive(aBoard.makeMove(move), myMark, alpha, beta, depth - 1, false);

			if (value >= beta) {
				return beta;
			}

			if (value > alpha) {
				alpha = value;
			}
		}
		return alpha;
	}
}

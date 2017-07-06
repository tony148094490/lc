package airbnb;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;

// https://tinyurl.com/yb4rexgn
// 要求写一个数据结构实现，以及一些基本的函数，比如MOVE, SOLVED，然后CLIENT PARSE一个BOARD，你要能求出这个是有解还是没有解
// [brief look] A* algorithm https://en.wikipedia.org/wiki/A*_search_algorithm
// [very good!! must read!!] https://www.cs.cmu.edu/~adamchik/15-121/labs/HW-7%20Slide%20Puzzle/lab.html
// [some implementations] https://github.com/search?q=SlidingSolver.java&type=Code&utf8=%E2%9C%93
public class SlidingPuzzle {
	// A * algo is bfs with cost reduction fuction.
	// unlike dijkstra algo where we only consider the cost to the current node, 
	// we also make a 'heuristic' that a a certain cost exist that can further guide us for the search.
	// here we can use manhattan distance or hamming distance
	// a lot code, i know but they are all trivial 
	// not all combination can yield a solution though
	public String solve(Puzzle puzzle) throws Exception {
		Comparator<Puzzle> comp = new Comparator<Puzzle>() {
			@Override
			// cost function
			public int compare(Puzzle a, Puzzle b) {
				return a.getHeu() - b.getHeu();
			}
		};
		
		Set<Direction> directionSet = new HashSet<>();
		directionSet.add(Direction.left);directionSet.add(Direction.right);directionSet.add(Direction.up);directionSet.add(Direction.down);
		
		PriorityQueue<Puzzle> pq = new PriorityQueue<Puzzle>(comp);
		Map<String, Puzzle> map = new HashMap<>();// used to update heuristic values in pq
		pq.add(puzzle);
		while(!pq.isEmpty()) {
			Puzzle parent = pq.poll();
			//map.remove(parent.toState());
			if(parent.isSolved()) {
				System.out.println(parent.pathTowardFinish.split(",").length);
				System.out.println(parent.toState());
				return parent.pathTowardFinish;
			} else {
				for(Direction dir : directionSet) {
					if(parent.canMove(dir)) {
						Puzzle newPuzzle = parent.move(dir);
						String state = newPuzzle.toState();
						if(map.containsKey(state)) {
							if(map.get(state).getHeu() > newPuzzle.getHeu()) {
								pq.remove(map.get(state));
								pq.add(newPuzzle);
								map.put(state, newPuzzle);
							}
						} else {
							map.put(state, newPuzzle);
							pq.add(newPuzzle);
						}
						System.out.println(state);
						//System.out.println();
						//Thread.sleep(1000);
					}
				}
			}
		}

		return "";
	}
	
	public class Puzzle {
		int[][] board;
		Random rand;
		int[] emptyPosition;
		String pathTowardFinish;

		public Puzzle(int[][] board, String curPath, int[] empty) {
			this.board = board;
			this.pathTowardFinish = curPath;
			this.emptyPosition = empty;
		}
		
		public Puzzle(int xrange, int yrange) {
			init(xrange, yrange);
			rand = new Random();
			// default position
			emptyPosition = new int[]{xrange-1,yrange-1};
			pathTowardFinish = "";
		}
		
		public void shuffle() {
			if(board == null) return;
			for(int i = 0; i < board.length * board[0].length; i++) {
				int toSwap = rand.nextInt(i + 1);
				swap(i/board[0].length, i%board[0].length, toSwap/board[0].length, toSwap%board[0].length);
			}
			
			// update 0's position
			for(int i = 0 ; i < board.length; i++) {
				for(int j = 0 ; j < board[0].length; j++) {
					if(board[i][j] == 0) {
						emptyPosition[0] = i; emptyPosition[1] = j; break;
					}
				}
			}
			
		}
		
		public int getHeu() {
			return pathTowardFinish.length() + this.getManhattanDistanceToFinish();
		}
		
		// produce the next board
		public Puzzle move(Direction dir) throws Exception {
			int i = emptyPosition[0];
			int j = emptyPosition[1];
			String newPath = pathTowardFinish + "," + dir.name();
			int[] newEmpty = new int[2];
			
			// create a new board as well
			int[][] newBoard = new int[board.length][board[0].length];
			for(int m = 0; m < board.length; m++) {
				for(int n = 0 ; n < board[0].length; n++) {
					newBoard[m][n] = board[m][n];
				}
			}
			
			switch (dir) {
			case left:
				if(j == 0) throw new Exception("invalid move");
				newBoard[i][j] = newBoard[i][j-1];
				newBoard[i][j-1] = 0;
				newEmpty[0] = i;
				newEmpty[1] = j - 1;
				break;
			case right:
				if(j == newBoard[i].length - 1) throw new Exception("invalid move");
				newBoard[i][j] = newBoard[i][j+1];
				newBoard[i][j+1] = 0;
				newEmpty[0] = i;
				newEmpty[1] = j + 1;
				break;
			case up:
				if(i == 0) throw new Exception("invalid move");
				newBoard[i][j] = newBoard[i-1][j];
				newBoard[i-1][j] = 0;
				newEmpty[0] = i-1;
				newEmpty[1] = j;
				break;
			case down:
				if(i == newBoard.length - 1) throw new Exception("invalid move");
				newBoard[i][j] = newBoard[i+1][j];
				newBoard[i+1][j] = 0;
				newEmpty[0] = i+1;
				newEmpty[1] = j;
				break;
			default:
				break;
			}
			
			return new Puzzle(newBoard, newPath, newEmpty);
		}
		
		public boolean canMove(Direction direction) {
			int i = emptyPosition[0];
			int j = emptyPosition[1];
			switch(direction) {
			case left:
				if(j > 0) return true;
				return false;
			case right:
				if(j < board[0].length - 1) return true;
				return false;
			case up:
				if(i > 0) return true;
				return false;
			case down:
				if(i < board.length - 1) return true;
				return false;
			default:
				return false;
			}			
		}

		public int getManhattanDistanceToFinish() {
			int res = 0;
			for(int i = 0 ; i < board.length; i++) {
				for(int j = 0 ; j < board[0].length; j++) {
					if(board[i][j] == 0) continue; // ignore 0's position
					int actual = board[i][j];
					int expectedI = (actual - 1 ) / 3;
					int expectedJ = (actual - 1) % 3;
					res += Math.abs(i - expectedI) + Math.abs(j - expectedJ);
				}
			}
			return res;
		}
		
		public boolean isSolved() {
			int start = 1;
			for(int i = 0 ; i < board.length; i++) {
				for(int j = 0; j < board[i].length; j++) {
					if(i == board.length - 1 && j == board[i].length -1 && board[i][j] == 0) return true;
					
					if(board[i][j] != start) {
						return false;
					}
					start = start + 1;
				}
			}
			
			// should never reach here
			return false;
		}
		
		private void swap(int i, int j, int m, int n) {
			int temp = board[i][j];
			board[i][j] = board[m][n];
			board[m][n] = temp;
		}
		
		private void init(int m, int n) {
			int start = 1;
			board = new int[m][n];
			for(int i = 0 ; i < m; i++) {
				for(int j = 0 ; j < n; j++) {
					board[i][j] = start;
					start = start + 1;
				}
			}
			board[m-1][n-1] = 0;
		}
		
		public void print() {
			for(int i = 0 ; i < board.length; i++) {
				for(int j = 0 ; j < board[0].length; j++) {
					System.out.print(board[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println("Zero's position is at " + emptyPosition[0] + ", " + emptyPosition[1]);
		}
		
		public String toState() {
			String res = "";
			for(int i = 0 ; i < board.length; i++) {
				for(int j = 0 ; j < board[0].length; j++) {
					res += String.valueOf(board[i][j]);
				}
			}
			return res;
		}
	}
	
	public enum Direction {
		left,
		right,
		up,
		down;
	}
	
	public static void main(String[] args) throws Exception {
		SlidingPuzzle x = new SlidingPuzzle();
		Puzzle p = x.new Puzzle(3, 3);
		p.print();
		p.shuffle();
		p.print();
		
		System.out.println(x.solve(p));
		
	}
}

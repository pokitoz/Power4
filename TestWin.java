import static org.junit.Assert.*;

import org.junit.Test;


public class TestWin {

	@Test
	public void test() {
		Board board = new Board();
		assertEquals(' ', board.getWinner());
		
		System.out.println(board);
		board.putInColumn((byte)1);
		System.out.println(board);
		board.putInColumn((byte)2);
		System.out.println(board);
		board.putInColumn((byte)1);
		System.out.println(board);
		board.putInColumn((byte)2);
		System.out.println(board);
		board.putInColumn((byte)1);
		System.out.println(board);
		board.putInColumn((byte)2);
		System.out.println(board);
		assertEquals(' ', board.getWinner());

		board.putInColumn((byte)1);
		System.out.println(board);
		assertEquals('X', board.getWinner());
		
		
		board = new Board();
		board.putInColumn((byte)0);
		board.putInColumn((byte)1);
		board.putInColumn((byte)1);
		board.putInColumn((byte)2);
		board.putInColumn((byte)2);
		board.putInColumn((byte)3);
		board.putInColumn((byte)2);
		board.putInColumn((byte)3);
		board.putInColumn((byte)3);
		board.putInColumn((byte)4);
		board.putInColumn((byte)3);
		System.out.println(board);
		assertEquals('X', board.getWinner());

		

		board = new Board();
		board.putInColumn((byte)0);
		board.putInColumn((byte)0);
		
		board.putInColumn((byte)1);
		board.putInColumn((byte)1);
		board.putInColumn((byte)2);
		board.putInColumn((byte)2);
		board.putInColumn((byte)3);
		System.out.println(board);
		assertEquals('X', board.getWinner());
		
		
		
		
	}

}

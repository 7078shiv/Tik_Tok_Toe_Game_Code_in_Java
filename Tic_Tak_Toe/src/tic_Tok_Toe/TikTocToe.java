package tic_Tok_Toe;

import java.util.Scanner;

public class TikTocToe {
	private Player player1,player2;
	private Board board;
	public static void main(String...args) throws Exception {
		TikTocToe t=new TikTocToe();
		t.startgame();
	}
	private void startgame() throws Exception {
		// take player input
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter player 1 name");
		String p1n=sc.next();
	
		System.out.println("Enter player 2 name");
		String p2n=sc.next();

		System.out.println("Enter player 1 symbol");
		char p1s=sc.next().charAt(0);
	
		System.out.println("Enter player 2 symbol");
		char p2s=sc.next().charAt(0);
	
		Player p1=new Player(p1n,p1s);
		player1=p1;
		Player p2=new Player(p2n,p2s);
		player2=p2;
		// Create the board
		int playagain=1;
		while(playagain==1) {
			int f=0;
			while(p1s==p2s) {
				System.out.println("both player symbol cant be same so please reiniyilise it");
				p2s=sc.next().charAt(0);
			}
		board=new Board(p1s,p2s);
		// play the game
		
		
		for(int i=0;i<(board.getboardsize()*board.getboardsize());i++) {
			if(i%2==0) {
				System.out.println("Player 1 turn:-"+p1n);
				System.out.println("Enter x");
				int x=sc.nextInt();
				System.out.println("Enter y");
				int y=sc.nextInt();
				board.insert(p1s, x, y);
				board.display();
				if(board.check(x, y, p1s)) {
					System.out.println("Player 1 wins :-"+p1n);
					player1.no_of_wons++;
					f=1;
					break;
				}
				}
			else {
				System.out.println("Player 2 turn:-"+p2n);
				System.out.println("Enter x");
				int x=sc.nextInt();
				System.out.println("Enter y");
				int y=sc.nextInt();
				board.insert(p2s, x, y);
				board.display();
				if(board.check(x, y, p2s)) {
					System.out.println("Player 2 wins :-"+ p2n);
					player2.no_of_wons++;
					f=1;
					break;
				}
			}
	}
		if(f==0) {
			System.out.println("Match draw");
		}
		System.out.println("player 1 "+p1n+"win count is "+player1.no_of_wons);
		System.out.println("player 2 "+p2n+"win count is "+player2.no_of_wons);
		System.out.println("If you want to play again enter 1 either enter 0");

		playagain=sc.nextInt();
		}
}
}
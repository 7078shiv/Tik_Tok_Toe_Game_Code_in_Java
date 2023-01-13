package tic_Tok_Toe;

public class Board {
	private char[][] board;
	private int boardsize=3;
	private char p1symbol;
	private char p2symbol;
	private static final char Empty=' ';
	// count of no of cells that are filled
	private int count;
	public Board(char p1symbol,char p2symbol) {
		this.p1symbol=p1symbol;
		this.p2symbol=p2symbol;
		board=new char[boardsize][boardsize];
		for(int i=0;i<boardsize;i++) {
			for(int j=0;j<boardsize;j++) {
				board[i][j]=Empty;
			}
		}
		count=0;
	}
	public void insert(char ch,int x,int y) throws Exception {
		if(board[x][y]==' ')
		board[x][y]=ch;
		else {
			throw new Exception("cell already filed");
		}
	}
	public  int getboardsize() {
		return boardsize;
	}
	public void display() {
		System.out.println("------------------");
		for(int i=0;i<boardsize;i++) {
			for(int j=0;j<boardsize;j++) {
				System.out.print("|"+board[i][j]+"|"+" ");
			}
			System.out.println();
		}
		System.out.println("------------------");
	}
	public boolean check(int x,int y,char ps) {
		return topdown(x,y,ps) || rightleft(x,y,ps) || leftdiagonal(x,y,ps) || rightdiagonal(x,y,ps);
	}
	public boolean topdown(int x,int y,char ps) {
		//top
		int rt=x;
		while(rt>=0) {
			if(board[rt][y]!=ps) {
				return false;
			}
			rt--;
		}
		// down
		int rd=x;
		while(rd<boardsize) {
			if(board[rd][y]!=ps) {
				return false;
			}
			rd++;
		}
		return true;
	}
	public boolean rightleft(int x,int y,char ps) {
		// right
		int cr=y;
		while(cr<boardsize) {
			if(board[x][cr]!=ps) {
				return false;
			}
			cr++;
		}
		// left
		int cl=y;
		while(cl>=0) {
			if(board[x][cl]!=ps) {
				return false;
			}
			cl--;
		}
		return true;
	}
	public boolean leftdiagonal(int x,int y,char ps) {
		int r=x;
		int c=y;
		int count=0;
		while(r>=0 && c>=0) {
			count++;
			if(board[r][c]!=ps) {
				return false;
			}
			r--;
			c--;
		}
		int rd=x;
		int cd=y;
		while(rd<boardsize && cd<boardsize) {
			count++;
			if(board[rd][cd]!=ps) {
				return false;
			}
			rd++;
			cd++;
		}
		if(count>2)
		return true;
		return false;
	}
	public boolean rightdiagonal(int x,int y,char ps) {
		// ud
		int r=x;
		int c=y;
		int cou=0;
		while(r>=0 && c<boardsize) {
			cou++;
			if(board[r][c]!=ps) {
				return false;
			}
			r--;
			c++;
		}
		// ld
		int lr=x;
		int lc=y;
		while(lr<boardsize && lc>=0) {
			cou++;
			if(board[lr][lc]!=ps) {
				return false;
			}
			lr++;
			lc--;
		}
		if(cou>2)
		return true;
		
		return false;
	}
	
}

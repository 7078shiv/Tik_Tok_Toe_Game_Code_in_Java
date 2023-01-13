package tic_Tok_Toe;

public class Player {
	private String name;
	private char symbol;
	int no_of_wons;
	Player(String name,char symbol){
		setname(name);
		setsymbol(symbol);
	}
	public void setsymbol(char symbol) {
		if(symbol != '\0') {
			this.symbol=symbol;
		}
		
	}
	public void setname(String name) {
		if(!name.isEmpty())
		this.name=name;
	}
	public String getName() {
		return this.name;
	}
	public char getSymbol() {
		return this.symbol;
	}
	
}

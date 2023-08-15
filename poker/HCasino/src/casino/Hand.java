package casino;
//Ethan Michalsky
//Copyright 2022, Ethan Michalsky. All rights reserved.

public class Hand {
	int card1;
	int card2;
	int card3;
	int card4;
	int card5;
	//Poker Hand
	public Hand(int c1, int c2, int c3, int c4, int c5) {
		this.card1 = c1;
		this.card2 = c2;
		this.card3 = c3;
		this.card4 = c4;
		this.card5 = c5;
	}
	
	//Get cards
	public int getCard(int x) {
		if (x == 1) {
			return getCard1();
		}
		else if (x == 2) {
			return getCard2();
		}
		else if (x == 3) {
			return getCard3();
		}
		else if (x == 4) {
			return getCard4();
		}
		return getCard5();
	}
	
	public int getCard1() {
		return this.card1;
	}
	
	public int getCard2() {
		return this.card2;
	}
	
	public int getCard3() {
		return this.card3;
	}
	
	public int getCard4() {
		return this.card4;
	}
	
	public int getCard5() {
		return this.card5;
	}
	
	

	public int getHighestCard() {
		int card = 0;
		int card2 = 0;
		for (int i = 0; i < 5; i++) {
			for (int s = 0; s < 5; s++) {
				if (getCard(i) > getCard(s)) {
					card = getCard(i);
				}
			}
		}
		if (getCard1() == card) {
			return 1;
		}
		else if (getCard2() == card) {
			return 2;
		}
		else if (getCard3() == card) {
			return 3;
		}
		else if (getCard4() == card) {
			return 4;
		}
		else {
			return 5;
		}
	}
	
	public int getHighestVal() {
		int card = 0;
		int card2 = 0;
		for (int i = 0; i < 5; i++) {
			for (int s = 0; s < 5; s++) {
				if (getCard(i) > getCard(s)) {
					card = getCard(i);
				}
			}
		}
		if (getCard1() == card) {
			return getCard1();
		}
		else if (getCard2() == card) {
			return getCard2();
		}
		else if (getCard3() == card) {
			return getCard3();
		}
		else if (getCard4() == card) {
			return getCard4();
		}
		else {
			return getCard5();
		}
	}
	//Change Cards
	public void change1(int c) {
		this.card1 = c;
	}
	
	public void change2(int c) {
		this.card2 = c;
	}
	
	public void change3(int c) {
		this.card3 = c;
	}
	
	public void change4(int c) {
		this.card4 = c;
	}
	
	public void change5(int c) {
		this.card5 = c;
	}

	public void change(int i, int draw) {
		if (i == 1) {
			this.card1 = draw;
		}
		else if (i == 2) {
			this.card2 = draw;
		}
		else if (i == 3) {
			this.card3 = draw;
		}
		else if (i == 4) {
			this.card4 = draw;
		}
		else if (i == 5) {
			this.card5 = draw;
		}
	}
}
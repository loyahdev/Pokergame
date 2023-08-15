package casino;
//Ethan Michalsky
//Copyright 2022, Ethan Michalsky. All rights reserved.

public class LuciPoker {
	static int streak = 0;
	static int bet = 1;
	static Hand player = new Hand(0, 0, 0, 0, 0);
	static Hand lucifer = new Hand(0, 0, 0, 0, 0);
	static String res = "";
	//public static void main(String[] args) {
	//	player = CreateHand(player);
	//	lucifer = CreateHand(lucifer);
	//	CompareHand(player, lucifer);
	//}
	
	public static int total(Hand c) {
		int toto = 0;
		toto = toto + c.getCard1();
		toto = toto + c.getCard2();
		toto = toto + c.getCard3();
		toto = toto + c.getCard4();
		toto = toto + c.getCard5();
		return toto;
	}
	
	public static void Start() {
		player = CreateHand(player);
		lucifer = CreateHand(lucifer);
	}
	
	//Creates Hand
	public static Hand CreateHand(Hand c) {
		c = new Hand(DrawCard(), DrawCard(), DrawCard(), DrawCard(), DrawCard());
		return c;
	}
	
	//Generates Card based off of users streak
	public static int DrawCard() {
		int a = 0;
		//High Streak
		if (streak > 9) {
			a = (int)(12 * Math.random() + 1);
			if (a == 6) {
				a = 6;
			}
			else if (a == 5) {
				a = 5;
			}
			else if (a == 4) {
				a = 4;
			}
			else if (a == 3 || a == 12 || a == 11) {
				a = 3;
			}
			else if (a == 2 || a == 10 || a == 9) {
				a = 2;
			}
			else {
				a = 1;
			}
		}
		//Moderate Streak
		else if (streak > 4) {
			a = (int)(13 * Math.random() + 1);
			if (a == 6) {
				a = 6;
			}
			else if (a == 5 || a == 13) {
				a = 5;
			}
			else if (a == 4 || a == 12) {
				a = 4;
			}
			else if (a == 3 || a == 11 || a == 10) {
				a = 3;
			}
			else if (a == 2 || a == 9 || a == 8) {
				a = 2;
			}
			else {
				a = 1;
			}
		}
		//Low Streak
		else if (streak < -9) {
			a = (int)(13 * Math.random() + 1);
			if (a == 6 || a == 12) {
				a = 6;
			}
			else if (a == 5 || a == 11) {
				a = 5;
			}
			else if (a == 4 || a == 10 || a == 8) {
				a = 4;
			}
			else if (a == 3 || a == 9 || a == 7) {
				a = 3;
			}
			else {
				a = 2;
			}
		}
		//Moderate Low Streak
		else if (streak < -4) {
			a = (int)(13 * Math.random() + 1);
			if (a == 6) {
				a = 6;
			}
			else if (a == 5 || a == 13) {
				a = 5;
			}
			else if (a == 4 || a == 12 || a == 11) {
				a = 4;
			}
			else if (a == 3 || a == 10 || a == 9) {
				a = 3;
			}
			else if (a == 2 || a == 8 || a == 7) {
				a = 2;
			}
			else {
				a = 1;
			}
		}
		else {
			a = (int)(6 * Math.random() + 1);
		}
		return a;
	}

	//Orders the Hand
	public static Hand OrderHand(Hand c) {
		int[] arr = {c.getCard1(), c.getCard2(), c.getCard3(), c.getCard4(), c.getCard5()};
		for (int i = 1; i < arr.length; i++) {
			int index = arr[i];
			int j = i -1;
			while (j >= 0 && arr[j] > index) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = index;
		}
		c.change1(arr[0]);
		c.change2(arr[1]);
		c.change2(arr[2]);
		c.change2(arr[3]);
		c.change2(arr[4]);
		return c;
	}

	//Counts the number of pairs
	public static int CardPair(Hand c, int ca) {
		int p = 0;
		for (int i = 1; i < 6; i++) {
			if (c.getCard(ca) == c.getCard(i)) {
				p++;
			}
		}
		return p;
	}
	
	//Compares the Hands
	public static void CompareHand(Hand play, Hand luci) {
		res = "";
		int pcard = 1;
		int lcard = 1;
		int playp = CardPair(play, pcard);
		pcard++;
		if (playp == 1) {
			playp = CardPair(play, pcard);
			pcard = pcard + 1;
		}
		int pcar = pcard;
		System.out.println(playp);
		int playt = 0;
		for (int i = 1; i < 6; i++) {
			if (luci.getCard(lcard) != luci.getCard(i)) {
				luci.change(i, DrawCard());
			}
		}
		int lucip = CardPair(luci, lcard);
		lcard++;
		if (lucip == 1) {
			luci.change1(DrawCard());
			lucip = CardPair(luci, lcard);
			lcard = lcard + 1;
		}
		int lcar = lcard;
		System.out.println(lucip);
		int lucit = 0;
		if (playp == lucip && playp == 5) {
			if (play.getHighestVal() > luci.getHighestVal()) {
				res = "Win";
				return;
			}
			else if (play.getHighestVal() < luci.getHighestVal()) {
				res = "Lose";
				return;
			}
			else {
				res = "Tie";
				return;
			}
		}
		else {
			if (playp == 4 && lucip == 4) {
				if (play.getHighestVal() > luci.getHighestVal()) {
					res = "Win";
					return;
				}
				else if (play.getHighestVal() < luci.getHighestVal()) {
					res = "Lose";
					return;
				}
				else {
					res = "Tie";
					return;
				}
			}
			else if (playp == 5 && lucip < 5) {
				res = "Win";
				return;
			}
			else if (playp == 4 && lucip < 4) {
				res = "Win";
				return;
			}
			else if (lucip == 5 && playp < 5) {
				res = "Lose";
				return;
			}
			else if (lucip == 4 && playp < 4) {
				res = "Lose";
				return;
			}
			else {
				playt = CardPair(play, pcard);
				while(play.getCard(pcard) == play.getCard(pcar) && pcard < 6) {
					playt = CardPair(play, pcard);
					pcard++;
				}
				System.out.println(playt);
				lucit = CardPair(luci, lcard);
				while(luci.getCard(lcard) == luci.getCard(lcar) && lcard < 6) {
					lucit = CardPair(luci, lcard);
					lcard++;
				}
				System.out.println(lucit);
				if (playp == 3 && playt == 2) {
					if (lucip == 3 && lucit == 2) {
						if (play.getHighestVal() > luci.getHighestVal()) {
							res = "Win";
							return;
						}
						else if (play.getHighestVal() < luci.getHighestVal()) {
							res = "Lose";
							return;
						}
						else {
							if (total(player) > total(lucifer)) {
								res = "Win";
								return;
							}
							else if (total(player) < total(lucifer)) {
								res = "Lose";
								return;
							}
							else {
								res = "Tie";
								return;
							}
						}
					}
					else if (lucip == 2 && lucit == 3) {
						if (play.getHighestVal() > luci.getHighestVal()) {
							res = "Win";
							return;
						}
						else if (play.getHighestVal() < luci.getHighestVal()) {
							res = "Lose";
							return;
						}
						else {
							if (total(player) > total(lucifer)) {
								res = "Win";
								return;
							}
							else if (total(player) < total(lucifer)) {
								res = "Lose";
								return;
							}
							else {
								res = "Tie";
								return;
							}
						}
					}
					else if (lucip == 4 || lucit == 4) {
						res = "Lose";
						return;
					}
					else {
						res = "Win";
						return;
					}
				}
				else if (playp == 2 && playt == 3) {
					if (lucip == 3 && lucit == 2) {
						if (play.getHighestVal() > luci.getHighestVal()) {
							res = "Win";
							return;
						}
						else if (play.getHighestVal() < luci.getHighestVal()) {
							res = "Lose";
							return;
						}
						else {
							if (total(player) > total(lucifer)) {
								res = "Win";
								return;
							}
							else if (total(player) < total(lucifer)) {
								res = "Lose";
								return;
							}
							else {
								res = "Tie";
								return;
							}
						}
					}
					else if (lucip == 2 && lucit == 3) {
						if (play.getHighestVal() > luci.getHighestVal()) {
							res = "Win";
							return;
						}
						else if (play.getHighestVal() < luci.getHighestVal()) {
							res = "Lose";
							return;
						}
						else {
							if (total(player) > total(lucifer)) {
								res = "Win";
								return;
							}
							else if (total(player) < total(lucifer)) {
								res = "Lose";
								return;
							}
							else {
								res = "Tie";
								return;
							}
						}
					}
					else if (lucip == 4 || lucit == 4) {
						res = "Lose";
						return;
					}
					else {
						res = "Win";
						return;
					}
				}
				else if (lucip == 3 && lucit == 2) {
					if (playp == 3 && playt == 2) {
						if (play.getHighestVal() > luci.getHighestVal()) {
							res = "Win";
							return;
						}
						else if (play.getHighestVal() < luci.getHighestVal()) {
							res = "Lose";
							return;
						}
						else {
							if (total(player) > total(lucifer)) {
								res = "Win";
								return;
							}
							else if (total(player) < total(lucifer)) {
								res = "Lose";
								return;
							}
							else {
								res = "Tie";
								return;
							}
						}
					}
					else if (playp == 2 && playt == 3) {
						if (play.getHighestVal() > luci.getHighestVal()) {
							res = "Win";
							return;
						}
						else if (play.getHighestVal() < luci.getHighestVal()) {
							res = "Lose";
							return;
						}
						else {
							if (total(player) > total(lucifer)) {
								res = "Win";
								return;
							}
							else if (total(player) < total(lucifer)) {
								res = "Lose";
								return;
							}
							else {
								res = "Tie";
								return;
							}
						}
					}
					else if (playp == 4 || playt == 4) {
						res = "Win";
						return;
					}
					else {
						res = "Lose";
						return;
					}
				}
				else if (lucip == 2 && lucit == 3) {
					if (playp == 3 && playt == 2) {
						if (play.getHighestVal() > luci.getHighestVal()) {
							res = "Win";
							return;
						}
						else if (play.getHighestVal() < luci.getHighestVal()) {
							res = "Lose";
							return;
						}
						else {
							if (total(player) > total(lucifer)) {
								res = "Win";
								return;
							}
							else if (total(player) < total(lucifer)) {
								res = "Lose";
								return;
							}
							else {
								res = "Tie";
								return;
							}
						}
					}
					else if (playp == 2 && playt == 3) {
						if (play.getHighestVal() > luci.getHighestVal()) {
							res = "Win";
							return;
						}
						else if (play.getHighestVal() < luci.getHighestVal()) {
							res = "Lose";
							return;
						}
						else {
							if (total(player) > total(lucifer)) {
								res = "Win";
								return;
							}
							else if (total(player) < total(lucifer)) {
								res = "Lose";
								return;
							}
							else {
								res = "Tie";
								return;
							}
						}
					}
					else if (playp == 4 || playt == 4) {
						res = "Lose";
						return;
					}
					else {
						res = "Lose";
						return;
					}
				}
				else if (playp == 3) {
					if (lucip == 3) {
						if (play.getHighestVal() > luci.getHighestVal()) {
							res = "Win";
							return;
						}
						else if (play.getHighestVal() < luci.getHighestVal()) {
							res = "Lose";
							return;
						}
						else {
							if (total(player) > total(lucifer)) {
								res = "Win";
								return;
							}
							else if (total(player) < total(lucifer)) {
								res = "Lose";
								return;
							}
							else {
								res = "Tie";
								return;
							}
						}
					}
					else if (lucip == 4 || lucit == 4) {
						res = "Lose";
						return;
					}
					else {
						res = "Win";
						return;
					}
				}
				else if (lucip == 3) {
					if (playp == 3) {
						if (play.getHighestVal() > luci.getHighestVal()) {
							res = "Win";
							return;
						}
						else if (play.getHighestVal() < luci.getHighestVal()) {
							res = "Lose";
							return;
						}
						else {
							if (total(player) > total(lucifer)) {
								res = "Win";
								return;
							}
							else if (total(player) < total(lucifer)) {
								res = "Lose";
								return;
							}
							else {
								res = "Tie";
								return;
							}
						}
					}
					else if (playp == 4 || playt == 4) {
						res = "Win";
						return;
					}
					else {
						res = "Lose";
						return;
					}
				}
				else if (playp == 2 && playt == 2) {
					if (lucip == 2 && lucit == 2) {
						if ((play.getCard1() + play.getCard2() + play.getCard3() + play.getCard4() + play.getCard5()) > (luci.getCard1() + luci.getCard2() + luci.getCard3() + luci.getCard4() + luci.getCard5())) {
							res = "Win";
							return;
						}
						else if ((play.getCard1() + play.getCard2() + play.getCard3() + play.getCard4() + play.getCard5()) < (luci.getCard1() + luci.getCard2() + luci.getCard3() + luci.getCard4() + luci.getCard5())) {
							res = "Lose";
							return;
						}
					}
					else if (lucip == 4 || lucit == 4) {
						res = "Lose";
						return;
					}
					else if (lucip == 3 || lucit == 3) {
						res = "Lose";
						return;
					}
					else {
						res = "Win";
						return;
					}
				}
				else if (lucip == 2 && lucit == 2) {
					if (playp == 2 && playt == 2) {
						if (play.getHighestVal() > luci.getHighestVal()) {
							res = "Win";
							return;
						}
						else if (play.getHighestVal() < luci.getHighestVal()) {
							res = "Lose";
							return;
						}
						else {
							if (total(player) > total(lucifer)) {
								res = "Win";
								return;
							}
							else if (total(player) < total(lucifer)) {
								res = "Lose";
								return;
							}
							else {
								res = "Tie";
								return;
							}
						}
					}
					else if (playp == 4 || playt == 4) {
						res = "Win";
						return;
					}
					else if (playp == 3 || playt == 3) {
						res = "Win";
						return;
					}
					else if (playp == 2 && playt == 1) {
						res = "Lose";
						return;
					}
					else {
						res = "Lose";
						return;
					}
				}
				else if (playp == 2 && playt == 1) {
					if (lucip == 2 && lucit == 1) {
						if (play.getHighestVal() > luci.getHighestVal()) {
							res = "Win";
							return;
						}
						else if (play.getHighestVal() < luci.getHighestVal()) {
							res = "Lose";
							return;
						}
						else {
							if (total(player) > total(lucifer)) {
								res = "Win";
								return;
							}
							else if (total(player) < total(lucifer)) {
								res = "Lose";
								return;
							}
							else {
								res = "Tie";
								return;
							}
						}
					}
					else if (lucip == 2 && lucit == 2) {
						res = "Lose";
						return;
					}
					else if (lucip == 4 || lucit == 4) {
						res = "Lose";
						return;
					}
					else if (lucip == 3 || lucit == 3) {
						res = "Lose";
						return;
					}
					else {
						res = "Win";
						return;
					}
				}
				else if (playp == 1 && playt == 2) {
					if (lucip == 2 && lucit == 1) {
						if (play.getHighestVal() > luci.getHighestVal()) {
							res = "Win";
							return;
						}
						else if (play.getHighestVal() < luci.getHighestVal()) {
							res = "Lose";
							return;
						}
						else {
							if (total(player) > total(lucifer)) {
								res = "Win";
								return;
							}
							else if (total(player) < total(lucifer)) {
								res = "Lose";
								return;
							}
							else {
								res = "Tie";
								return;
							}
						}
					}
					else if (lucip == 2 && lucit == 2) {
						res = "Lose";
						return;
					}
					else if (lucip == 4 || lucit == 4) {
						res = "Lose";
						return;
					}
					else if (lucip == 3 || lucit == 3) {
						res = "Lose";
						return;
					}
					else {
						res = "Win";
						return;
					}
				}
			}
		}
		if (res.isBlank()){
			if (total(player) > total(lucifer)) {
				res = "Win";
				return;
			}
			else if (total(player) < total(lucifer)) {
				res = "Lose";
				return;
			}
			else {
				res = "Tie";
				return;
			}
		}
		if (res.contains("Win")) {
			streak =+ 1;
		}
		else if (res.contains("Lose")) {
			streak -= 1;
		}
	}
}

package seven;

import java.util.Comparator;

public abstract class HumanComp implements Comparable<Human>{

	public static int humanrank(Human h) {
		int order = 4;
		if (h instanceof Adult) {
			order = 3;
		}
		else if (h instanceof Youth) {
			if (h instanceof CentennialStudent) {
				order = 1;
			}
			else {
				order = 2;
			}
		} 
		return order;
	}
	
	public static Comparator<Human> AgeOrder = new Comparator<Human>() {
		public int compare(Human Y, Human U) {
			if (Y.getbirthYear() == U.getbirthYear()) {
				if (Y.getbirthMonth() == U.getbirthMonth()) {
					if (Y.getbirthDay() == U.getbirthDay()) {
						return 0;
					}
					else if (Y.getbirthDay() < U.getbirthDay()) {
						return -1;
					}
					return 1;
				}
				if (Y.getbirthMonth() < U.getbirthMonth()) {
					return -1;
				}
				return 1;
			}
			if (Y.getbirthYear() < U.getbirthYear()) {
				return -1;
			}
			return 1;
		}
	};
	public static Comparator<Human> Assemblyorder = new Comparator<Human>() {
		public int compare(Human Y, Human U) {
			int rankY = humanrank(Y);
			int rankU = humanrank(U);
			if (rankY == rankU) {
				return (Y.getLastname().compareTo(U.getLastname()));
			}
			return (rankY - rankU);
		}
	};
	public static Comparator<Human> Nameorder = new Comparator<Human>() {
		public int compare(Human Y, Human U) {
			return (Y.getLastname().compareTo(U.getLastname()));
		}
	};

	
	
}

package src.modell;

//Sparar vädersteck som en siffra
public enum Väderstreck {
	NORR(0), ÖSTER(1), SÖDER(2), VÄSTER(3);

	private int Riktning;

	Väderstreck(int i) {
		this.Riktning = i;
	}

	//metod som hämtar numeriska värdet av ett väderstreck
	public int index() {
		return this.Riktning;
	}

}
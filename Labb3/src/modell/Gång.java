package src.modell;

public class Gång {

	//Instansvariablar som beskriver gången mellan rum

	private Rum frånRum;
	private Väderstreck riktningFrån;
	private Väderstreck riktningTill;
	private Rum tillRum;

	//Konstruktor för vad som krävs för att skapa en gång mellan 2 rum

	public Gång(Rum från, Väderstreck riktningUtUrFrån, Rum till,
			Väderstreck riktningInITill) {
		this.frånRum = från;
		this.riktningFrån = riktningUtUrFrån;
		this.riktningTill = riktningInITill;
		this.tillRum = till;
	}

	// ---------- GETTERS ------------ \\

	public Rum getFrånRum() {
		return frånRum;
	}

	public Rum getTillRum() {
		return tillRum;
	}

	public Väderstreck getRiktningFrån() {
		return riktningFrån;
	}

	public Väderstreck getRiktningTill() {
		return riktningTill;
	}
}

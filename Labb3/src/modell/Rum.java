package src.modell;

import src.verktyg.Punkt;

import java.awt.*;

import static src.GlobalaKonstanter.ANTAL_VÄDERSTRECK;

public class Rum {

	private Color färg;
	private int bredd;
	private int höjd;
	private Punkt övPunkt;
	private Gång[] gångar = new Gång[ANTAL_VÄDERSTRECK];

	public Rum(Color golvfärg, int bredd, int höjd, int övX, int övY) {

		// Tillståndsvariabler som bestämmer Färg, Bredd, Höjd och överst vänester punkt.
		this.färg = golvfärg;
		this.bredd = bredd;
		this.höjd = höjd;
		this.övPunkt = new Punkt(övX, övY);


	}

	//Kontrollerar att det finns en utgång i en viss riktning.

	public boolean finnsUtgångÅt(Väderstreck väderstreck) {
		if (gångar[väderstreck.index()] == null) {
			return false;
		} else {
			return true;
		}
	}

	//Returnerar gången åt en riktning ifall den existerar

	public Gång gångenÅt(Väderstreck väderstreck)  {
		if(gångar[väderstreck.index()] != null) {
			return gångar[väderstreck.index()];
		}
		throw new IllegalArgumentException();
	}

	//Kopplar ihop två rum med en gång i bestämd riktning

	public static void kopplaIhop(Rum från, Väderstreck riktningUtUrFrån,
								  Rum till, Väderstreck riktningInITill) {
		Gång gång = new Gång(från, riktningUtUrFrån, till, riktningInITill);
		från.gångar[riktningUtUrFrån.index()] = gång;
		till.gångar[riktningInITill.index()] = gång;

	}

//--------------GETTERS-----------------\\

	public Color getFärg() {
		return this.färg;
	}

	public int getBredd() {
		return this.bredd;
	}

	public int getHöjd() {
		return this.höjd;
	}

	public Punkt getÖvPunkt() {
		//returnerar Punkten högst upp till vänseter
		return this.övPunkt;
	}
}

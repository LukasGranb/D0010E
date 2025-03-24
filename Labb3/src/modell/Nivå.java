package src.modell;

import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;

public class Nivå extends Observable {

	//Instans variablar för Rummet som spelaren befinner sig i och en array med existerande rum som element.

	private Rum nuvaranderum;
	private ArrayList<Rum> existerandeRum;

	/*
	* Konstruktor för att skapa en nivå av exiterande rum som rum och nuvarande rum som startrum.
	* Den kastar en error IllegalArgumentException ifall att rum överlappar eller om start rummet inte finns
	 */

	public Nivå(Rum startrum, ArrayList<Rum> rum) {
		this.nuvaranderum = startrum;
		this.existerandeRum = rum;

		if (!rum.contains(nuvaranderum)) {
			throw new IllegalArgumentException();
		}

		for (int j = 0; j < existerandeRum.size(); j++) {
			Rectangle rec = new Rectangle(
					existerandeRum.get(j).getÖvPunkt().x(),
					existerandeRum.get(j).getÖvPunkt().y(),
					existerandeRum.get(j).getBredd(),
					existerandeRum.get(j).getHöjd()
			);

			for (int i = j + 1; i < existerandeRum.size(); i++) {
				Rectangle rec2 = new Rectangle(
						existerandeRum.get(i).getÖvPunkt().x(),
						existerandeRum.get(i).getÖvPunkt().y(),
						existerandeRum.get(i).getBredd(),
						existerandeRum.get(i).getHöjd()
				);

				if (rec.intersects(rec2)) {
					throw new IllegalArgumentException("Två rum får inte överlappa.");
				}
			}
		}
	}

	/*
 	* Flyttar spelaren åt ett angivet väderstreck om det finns en gång i den riktningen.
 	* Om en gång finns, uppdateras nuvarande rum och observerare notifieras.
 	*/

 public void hoppaÅt(Väderstreck väderstreck) {
		if (getNuvaranderum().finnsUtgångÅt(väderstreck)) {
			if (nuvaranderum == nuvaranderum.gångenÅt(väderstreck).getFrånRum()) {
				nuvaranderum = nuvaranderum.gångenÅt(väderstreck).getTillRum();
			} else {
				nuvaranderum = nuvaranderum.gångenÅt(väderstreck).getFrånRum();
			}
			setChanged();
			notifyObservers();
		}
	}

	//--------------GETTERS-----------------\\

	public ArrayList<Rum> getExisterandeRum() {
		return this.existerandeRum;
	}

	public Rum getNuvaranderum() {
		return this.nuvaranderum;
	}
}
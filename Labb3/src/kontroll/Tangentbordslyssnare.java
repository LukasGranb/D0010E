package src.kontroll;

import src.modell.Nivå;
import src.modell.Väderstreck;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Tangentbordslyssnare implements KeyListener {
	private Nivå enNivå;

	//Konstruktor som tar emot enNivå.

	public Tangentbordslyssnare(Nivå enNivå) {
		this.enNivå = enNivå;
	}

	/*
	* Metod som anropas när en tangent trycks ner.
	* Den anropar sedan Hoppa åt i enNivå för att hoppas åt önskar håll.
	*/
	@Override
	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();
		switch (key) {
			case KeyEvent.VK_W: // W - Hoppa Norr
				enNivå.hoppaÅt(Väderstreck.NORR);
				break;
			case KeyEvent.VK_A:	// A - Hoppa Väster
				enNivå.hoppaÅt(Väderstreck.VÄSTER);
				break;
			case KeyEvent.VK_S: // S - Hoppa Söder
				enNivå.hoppaÅt(Väderstreck.SÖDER);
				break;
			case KeyEvent.VK_D: // D - Hoppa Öster
				enNivå.hoppaÅt(Väderstreck.ÖSTER);
				break;
			default:
				break;			// Om annan tangent trycks
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
}

package src.vy;

import src.modell.Gång;
import src.modell.Nivå;
import src.modell.Rum;
import src.modell.Väderstreck;
import src.verktyg.Punkt;

import javax.swing.*;
import java.awt.*;

import static src.GlobalaKonstanter.*;
import static src.verktyg.Grafik.drawThickLine;
import static src.verktyg.Grafik.fillCircle;

public class Målarduk extends JPanel {

	//referens till den nivå som ritas
	private final Nivå enNivå;

	//Konstruktor tar emot en nivå och initierar målarduken
	public Målarduk(Nivå enNivå) {

		this.enNivå = enNivå;
		this.setBackground(MARKFÄRG);
		this.setFocusable(true);
	}

	//Ansvarar för att rita upp alla grafiska element
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);		//super anropar till överklassen vilken i detta frumall är Jpanel

		//Loopar igenom antalet rum och ritar ut dem
		for (Rum rum: enNivå.getExisterandeRum()) {
			ritaRum(g, rum);
		}

		//Ritar ut var användaren befinner sig
		ritaMarkörFörVarAnvändarenÄr(g);

}

	//Metoden som ritar rum, väggar och gångar
	private void ritaRum(Graphics g, Rum ettRum) {
		//Rum
		g.setColor(ettRum.getFärg());
		g.fillRect(ettRum.getÖvPunkt().x(), ettRum.getÖvPunkt().y(), ettRum.getBredd(), ettRum.getHöjd());
		//Väggar
		g.setColor(VÄGGFÄRG);
		g.fillRect(ettRum.getÖvPunkt().x(), ettRum.getÖvPunkt().y(), ettRum.getBredd(), VÄGGTJOCKLEK);
		g.fillRect(ettRum.getÖvPunkt().x(), ettRum.getÖvPunkt().y()+ettRum.getHöjd()-VÄGGTJOCKLEK, ettRum.getBredd(), VÄGGTJOCKLEK);
		g.fillRect(ettRum.getÖvPunkt().x(), ettRum.getÖvPunkt().y(), VÄGGTJOCKLEK, ettRum.getHöjd());
		g.fillRect(ettRum.getÖvPunkt().x()+ettRum.getBredd()-VÄGGTJOCKLEK, ettRum.getÖvPunkt().y(), VÄGGTJOCKLEK, ettRum.getHöjd());
		//Gångar
		ritaGångarFrånRum(g, ettRum);
	}


	private void ritaGångarFrånRum(Graphics g, Rum ettRum) {
		for (Väderstreck utgångar: Väderstreck.values()) {
			if(ettRum.finnsUtgångÅt(utgångar)){
				drawThickLine(g, baspunkt(ettRum, utgångar), pivotpunkt(ettRum, utgångar), VÄGGTJOCKLEK, GÅNGFÄRG);
				fillCircle(g, pivotpunkt(ettRum, utgångar), HALV_VÄGGTJOCKLEK, GÅNGFÄRG );
				ritaGång(g, ettRum.gångenÅt(utgångar));
			}
		}
	}

	private Punkt baspunkt(Rum ettRum, Väderstreck enRiktning) {
		int direction = enRiktning.index();
		switch (direction){
			case 0:
				return new Punkt(ettRum.getÖvPunkt().x() + ettRum.getBredd()/2, ettRum.getÖvPunkt().y() + VÄGGTJOCKLEK);
			case 1:
				return new Punkt(ettRum.getÖvPunkt().x() + ettRum.getBredd() - VÄGGTJOCKLEK, ettRum.getÖvPunkt().y() + ettRum.getHöjd()/2);
			case 2:
				return new Punkt(ettRum.getÖvPunkt().x() + ettRum.getBredd()/2, ettRum.getÖvPunkt().y() + ettRum.getHöjd() - VÄGGTJOCKLEK);
			case 3:
				return new Punkt(ettRum.getÖvPunkt().x() + VÄGGTJOCKLEK, ettRum.getÖvPunkt().y() + ettRum.getHöjd()/2);
		}
		return null;
	}

	private Punkt pivotpunkt(Rum ettRum, Väderstreck enRiktning) {
		int direction = enRiktning.index();
		switch (direction){
			case 0:
				return new Punkt(ettRum.getÖvPunkt().x() + ettRum.getBredd()/2, ettRum.getÖvPunkt().y() - HALV_VÄGGTJOCKLEK);
			case 1:
				return new Punkt(ettRum.getÖvPunkt().x() + ettRum.getBredd() + HALV_VÄGGTJOCKLEK, ettRum.getÖvPunkt().y() + ettRum.getHöjd()/2);
			case 2:
				return new Punkt(ettRum.getÖvPunkt().x() + ettRum.getBredd()/2, ettRum.getÖvPunkt().y() + ettRum.getHöjd() + HALV_VÄGGTJOCKLEK);
			case 3:
				return new Punkt(ettRum.getÖvPunkt().x() - HALV_VÄGGTJOCKLEK, ettRum.getÖvPunkt().y() + ettRum.getHöjd()/2);
		}
		return null;
	}

	private void ritaGång(Graphics g, Gång enGång) {
		drawThickLine(g, pivotpunkt(enGång.getFrånRum(), enGång.getRiktningFrån()), pivotpunkt(enGång.getTillRum(), enGång.getRiktningTill()), VÄGGTJOCKLEK, GÅNGFÄRG);
	}

	// Ritar användaren i centrum av varje rum
	private void ritaMarkörFörVarAnvändarenÄr(Graphics g) {
		fillCircle(g, new Punkt(enNivå.getNuvaranderum().getÖvPunkt().x() + enNivå.getNuvaranderum().getBredd()/2, this.enNivå.getNuvaranderum().getÖvPunkt().y() + this.enNivå.getNuvaranderum().getHöjd()/2), ANVÄNDARRADIE, ANVÄNDARFÄRG);
	}

}

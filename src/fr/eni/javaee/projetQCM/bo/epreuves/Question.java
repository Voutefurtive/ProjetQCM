package fr.eni.javaee.projetQCM.bo.epreuves;

import java.util.ArrayList;
import java.util.List;

public class Question {
	
	private int id;
	private String enonce;
	private String media = null;
	private int points;
	private List<Proposition> propositions = new ArrayList<Proposition>();
	private boolean estMarquee = false;
	private Theme theme;
	private int numOrdre;
	
	public Question() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEnonce() {
		return enonce;
	}

	public void setEnonce(String enonce) {
		this.enonce = enonce;
	}

	public String getMedia() {
		return media;
	}

	public void setMedia(String media) {
		this.media = media;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public List<Proposition> getPropositions() {
		return propositions;
	}

	public void setPropositions(List<Proposition> propositions) {
		this.propositions = propositions;
	}
	
	public void addProposition(Proposition proposition) {
		this.propositions.add(proposition);
	}

	public boolean isEstMarquee() {
		return estMarquee;
	}

	public void setEstMarquee(boolean estMarquee) {
		this.estMarquee = estMarquee;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public int getNumOrdre() {
		return numOrdre;
	}

	public void setNumOrdre(int numOrdre) {
		this.numOrdre = numOrdre;
	}
	
}

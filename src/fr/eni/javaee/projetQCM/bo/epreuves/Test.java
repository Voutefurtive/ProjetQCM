/**
 * 
 */
package fr.eni.javaee.projetQCM.bo.epreuves;

import java.io.Serializable;
import java.util.List;

/**
 * @author vhersant2017
 *
 */
public class Test implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int idTest;
	private String libelle;
	private String description;
	private int duree;
	private int seuilHaut;
	private int seuilBas;
	private List<SectionTest> sections;
	private List<Epreuve> epreuves;
	private int nbQuestions;

	public Test() {
		super();
	}
	
	public Test(int idTest, String libelle, String description, int duree, int seuilHaut, int seuilBas) {
		this.idTest = idTest;
		this.libelle = libelle;
		this.description = description;
		this.duree = duree;
		this.seuilHaut = seuilHaut;
		this.seuilBas = seuilBas;
	}

	public int getIdTest() {
		return idTest;
	}

	public void setIdTest(int idTest) {
		this.idTest = idTest;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public int getSeuilHaut() {
		return seuilHaut;
	}

	public void setSeuilHaut(int seuilHaut) {
		this.seuilHaut = seuilHaut;
	}

	public int getSeuilBas() {
		return seuilBas;
	}

	public void setSeuilBas(int seuilBas) {
		this.seuilBas = seuilBas;
	}

	public List<SectionTest> getSections() {
		return sections;
	}

	public void setSections(List<SectionTest> sections) {
		this.sections = sections;
	}

	public List<Epreuve> getEpreuves() {
		return epreuves;
	}

	public void setEpreuves(List<Epreuve> epreuves) {
		this.epreuves = epreuves;
	}
	
	public void addEpreuve(Epreuve epreuve) {
		this.epreuves.add(epreuve);
	}
	
	public int getNbQuestions() {
		this.nbQuestions = 0;
		
		for (SectionTest section: sections) {
			this.nbQuestions += section.getNbQuestion();
		}
		
		return this.nbQuestions;
	}
}

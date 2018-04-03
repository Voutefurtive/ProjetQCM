/**
 * 
 */
package fr.eni.javaee.projetQCM.bo.epreuves;

import java.io.Serializable;
import java.util.Date;

import fr.eni.javaee.projetQCM.bo.User;

/**
 * @author vhersant2017
 *
 */
public class Epreuve implements Serializable{

	private static final long serialVersionUID = 1L;

	private int idEpreuve;
	private Date dateDebut;
	private Date dateFin;
	private int tempsEcoule;
	private String etat;
	private float noteObtenue;
	private String niveauObtenu;
	private int idUtilisateur;
	private int idTest;
	
	public Epreuve() {
		super();
	}

	public Epreuve(int idEpreuve, Date dateDebut, Date dateFin, int tempsEcoule, String etat, float noteObtenue,
			String niveauObtenu, int idUtilisateur, int idTest) {
		super();
		this.idEpreuve = idEpreuve;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.tempsEcoule = tempsEcoule;
		this.etat = etat;
		this.noteObtenue = noteObtenue;
		this.niveauObtenu = niveauObtenu;
		this.idUtilisateur = idUtilisateur;
		this.idTest = idTest;
	}

	public int getIdEpreuve() {
		return idEpreuve;
	}

	public void setIdEpreuve(int id) {
		this.idEpreuve = id;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public int getTempsEcoule() {
		return tempsEcoule;
	}

	public void setTempsEcoule(int tempsEcoule) {
		this.tempsEcoule = tempsEcoule;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public float getNoteObtenue() {
		return noteObtenue;
	}

	public void setNoteObtenue(float noteObtenue) {
		this.noteObtenue = noteObtenue;
	}

	public String getNiveauObtenu() {
		return niveauObtenu;
	}

	public void setNiveauObtenu(String niveauObtenu) {
		this.niveauObtenu = niveauObtenu;
	}

	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public int getIdTest() {
		return idTest;
	}

	public void setIdTest(int idTest) {
		this.idTest = idTest;
	}
	
}

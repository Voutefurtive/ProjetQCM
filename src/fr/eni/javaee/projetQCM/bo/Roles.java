package fr.eni.javaee.projetQCM.bo;

public class Roles {

	int codeProfil;
	String libelle;
	
	
	public Roles() {
		super();
	}
	public Roles(int codeProfil, String libelle) {
		super();
		this.codeProfil = codeProfil;
		this.libelle = libelle;
	}
	
	public int getCodeProfil() {
		return codeProfil;
	}
	public void setCodeProfil(int codeProfil) {
		this.codeProfil = codeProfil;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	@Override
	public String toString() {
		return "Roles [codeProfil=" + codeProfil + ", libelle=" + libelle + "]";
	}
	
}

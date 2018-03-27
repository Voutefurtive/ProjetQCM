package fr.eni.javaee.projetQCM.bo;

public class User {

	private int id;
	private String nom;
	private String prenom;
	private String email;
	private String password;
	private int codeProfil;
	private String codePromo;
	
	
	public User() {
		super();
	}
	
	
	public User(int id, String nom, String prenom, String email, String password, int codeProfil, String codePromo) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.codeProfil = codeProfil;
		this.codePromo = codePromo;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getCodeProfil() {
		return codeProfil;
	}
	public void setCodeProfil(int codeProfil) {
		this.codeProfil = codeProfil;
	}
	public String getCodePromo() {
		return codePromo;
	}
	public void setCodePromo(String codePromo) {
		this.codePromo = codePromo;
	}
	@Override
	public String toString() {
		return "Login [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", password=" + password
				+ ", codeProfil=" + codeProfil + ", codePromo=" + codePromo + "]";
	}
	
	
	
}

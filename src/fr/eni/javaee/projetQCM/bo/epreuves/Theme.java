package fr.eni.javaee.projetQCM.bo.epreuves;

import java.util.List;

public class Theme {
	
	private int id;
	private String libelle;
	private List<Question> questions;
	private List<SectionTest> sections;
	
	public Theme() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
	public void addQuestion(Question question) {
		this.questions.add(question);
	}

	public List<SectionTest> getSections() {
		return sections;
	}

	public void setSections(List<SectionTest> sections) {
		this.sections = sections;
	}
	
	public void addSection(SectionTest section) {
		this.sections.add(section);
	}
	
}

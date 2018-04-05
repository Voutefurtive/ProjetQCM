/**
 * 
 */
package fr.eni.javaee.projetQCM.bo.epreuves;

import java.io.Serializable;

/**
 * @author vhersant2017
 *
 */
public class SectionTest implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int nbQuestion;
	private int idTheme;
	private Test test;
	
	public SectionTest() {
		super();
	}
	
	public SectionTest(int nbQuestion, int idTheme, Test test) {
		this.nbQuestion = nbQuestion;
		this.idTheme = idTheme;
		this.test = test;
	}

	public int getNbQuestion() {
		return nbQuestion;
	}

	public void setNbQuestion(int nbQuestion) {
		this.nbQuestion = nbQuestion;
	}

	public int getIdTheme() {
		return idTheme;
	}

	public void setIdTheme(int idTheme) {
		this.idTheme = idTheme;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

}

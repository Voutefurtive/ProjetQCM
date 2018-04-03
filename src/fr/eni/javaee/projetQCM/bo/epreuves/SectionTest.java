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
	private Theme theme;
	private Test test;
	
	public SectionTest() {
		super();
	}

	public int getNbQuestion() {
		return nbQuestion;
	}

	public void setNbQuestion(int nbQuestion) {
		this.nbQuestion = nbQuestion;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

}

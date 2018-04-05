/**
 * 
 */
package fr.eni.javaee.projetQCM.dal.test;

import java.util.List;

import fr.eni.javaee.projetQCM.bo.epreuves.SectionTest;
import fr.eni.javaee.projetQCM.bo.epreuves.Test;

/**
 * @author vhersant2017
 *
 */
public interface TestDAO {
	
	public List<SectionTest> getSections(int idTest);
	
	public Test getTest(int idTest);
}

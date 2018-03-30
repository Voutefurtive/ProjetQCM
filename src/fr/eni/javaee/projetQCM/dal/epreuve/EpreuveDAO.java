/**
 * 
 */
package fr.eni.javaee.projetQCM.dal.epreuve;

import java.util.List;

import fr.eni.javaee.projetQCM.bo.epreuves.Epreuve;

/**
 * @author vhersant2017
 *
 */
public interface EpreuveDAO {
	
	public List<Epreuve> selectEpreuvesByUser(int idUser);

}

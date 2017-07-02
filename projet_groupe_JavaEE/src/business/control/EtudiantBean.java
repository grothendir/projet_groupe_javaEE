/**
 * 
 */
package business.control;

import bean.LoginBean;
import business.model.Etudiant;
import dao.Dao;

/**
 * @author ulysse
 *
 */
public class EtudiantBean {
	private Etudiant etudiant;
	private String nometudiant;
	private Dao dao;
	private LoginBean loginbean;
	
	
	public EtudiantBean(){
	//this.etudiant = dao. 
		
		
	}


	public Etudiant getEtudiant() {
		return etudiant;
	}


	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}


	public Dao getDao() {
		return dao;
	}


	public void setDao(Dao dao) {
		this.dao = dao;
	}
	
}

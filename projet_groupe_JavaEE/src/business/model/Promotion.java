package business.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the PROMOTION database table.
 * 
 */
@Entity
@Table(name="PROMOTION")
@NamedQuery(name="Promotion.findAll", query="SELECT p FROM Promotion p")
public class Promotion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PROMOTION")
	private int idPromotion;

	//bi-directional many-to-many association to Etudiant
	@ManyToMany
	@JoinTable(
		name="MEMBRE_PROMOTION"
		, joinColumns={
			@JoinColumn(name="ID_PROMOTION")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ID_MEMBRE")
			}
		)
	private List<Etudiant> etudiants;

	//bi-directional many-to-one association to Projet
	@OneToMany(mappedBy="promotion")
	private List<Projet> projets;

	public Promotion() {
	}

	public int getIdPromotion() {
		return this.idPromotion;
	}

	public void setIdPromotion(int idPromotion) {
		this.idPromotion = idPromotion;
	}

	public List<Etudiant> getEtudiants() {
		return this.etudiants;
	}

	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}

	public List<Projet> getProjets() {
		return this.projets;
	}

	public void setProjets(List<Projet> projets) {
		this.projets = projets;
	}

	public Projet addProjet(Projet projet) {
		getProjets().add(projet);
		projet.setPromotion(this);

		return projet;
	}

	public Projet removeProjet(Projet projet) {
		getProjets().remove(projet);
		projet.setPromotion(null);

		return projet;
	}

}
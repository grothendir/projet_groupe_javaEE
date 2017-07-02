package business.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the MEMBRE database table.
 * 
 */
@Entity
@Table(name="MEMBRE")
@NamedQuery(name="Membre.findAll", query="SELECT m FROM Membre m")
public class Membre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_MEMBRE")
	private int idMembre;

	@Column(name="NOM")
	private String nom;

	//bi-directional one-to-one association to Etudiant
	@OneToOne(mappedBy="membre")
	private Etudiant etudiant;

	//bi-directional one-to-one association to Formateur
	@OneToOne(mappedBy="membre")
	private Formateur formateur;

	public Membre() {
	}

	public int getIdMembre() {
		return this.idMembre;
	}

	public void setIdMembre(int idMembre) {
		this.idMembre = idMembre;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Etudiant getEtudiant() {
		return this.etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public Formateur getFormateur() {
		return this.formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

}
package fr.adaming.modele;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "equipes")
public class Equipe {

	// Déclaration des attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_equ")
	private int id;

	// Transformation de l'UML en Java
	@OneToMany(mappedBy = "equipe", cascade = CascadeType.PERSIST)
	private List<Employe> coequipiers;

	// Déclaration des constructeurs
	public Equipe() {
		super();
	}

	public Equipe(int id) {
		super();
		this.id = id;
	}

	// Déclaration des getters et setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Employe> getCoequipiers() {
		return coequipiers;
	}

	public void setCoequipiers(List<Employe> coequipiers) {
		this.coequipiers = coequipiers;
	}

	// Redéfinition de toString
	@Override
	public String toString() {
		return "Equipe [id=" + id + "]";
	}

}

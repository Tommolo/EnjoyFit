package it.uniroma3.siw.spring.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "collezione")

public class Collezione {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(nullable = false)
	private String nome;
	@Column(length=5096)
	private String descrizione;
	
	@ManyToOne
	@JoinColumn(name = "curatori_id")
	private Curatore curatore;
	
	@Column(nullable = true)
	private Stile stile;
	
	@OneToMany(mappedBy = "collezione", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Quadro> opere;
	
	public Collezione() {}
	public Collezione(String n, String d) {
		this.nome = n;
		this.descrizione = d;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDescrizione() {
		return descrizione;
	}


	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}


	public Curatore getCuratore() {
		return curatore;
	}


	public void setCuratore(Curatore curatore) {
		this.curatore = curatore;
	}


	public Stile getStile() {
		return stile;
	}


	public void setStile(Stile stile) {
		this.stile = stile;
	}


	public List<Quadro> getOpere() {
		return opere;
	}


	public void setOpere(List<Quadro> opere) {
		this.opere = opere;
	}
	

	
}

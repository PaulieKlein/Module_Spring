package com.bankonet.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Adresse implements Serializable{
	
private static final long serialVersionUID = 1690161148609505288L;

private Integer numero;
private String rue;
private String ville;


public Adresse(){}

public Adresse(Integer numero,String rue, String ville){
	this.numero = numero;
	this.rue = rue;
	this.ville = ville;
}

public Integer getNumero() {
	return numero;
}

public void setNumero(Integer numero) {
	this.numero = numero;
}

public String getRue() {
	return rue;
}

public void setRue(String rue) {
	this.rue = rue;
}

public String getVille() {
	return ville;
}

public void setVille(String ville) {
	this.ville = ville;
}


public String toString() {
	
 return "\nAdresse : Numero : " + this.numero +" rue : " + this.rue
			+" ville : " + this.ville;
}

}

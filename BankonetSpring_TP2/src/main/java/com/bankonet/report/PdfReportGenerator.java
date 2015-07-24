package com.bankonet.report;

public class PdfReportGenerator implements IReportGenerator {
	public void generate(){
		System.out.println("Génération d'un rapport PDF..");
	}
	public void generate(String auteur){
		this.generate();
		System.out.println("-> Auteur : "+	auteur);
	}
}

package com.bankonet.report;

public class PdfReportGenerator implements IReportGenerator {
	public void generate(){
		System.out.println("G�n�ration d'un rapport PDF..");
	}
	public void generate(String auteur){
		this.generate();
		System.out.println("-> Auteur : "+	auteur);
	}
}

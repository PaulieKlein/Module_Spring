package com.bankonet.report;

public class PdfReportGenerator extends ReportGenerator implements IReportGenerator {
	
	public PdfReportGenerator(){
		super();
	}
	
	public void generate(){
		System.out.println("G�n�ration d'un rapport PDF..");
	}
	public void generate(String auteur){
		this.generate();
		System.out.println("-> Auteur : "+	auteur);
	}
}

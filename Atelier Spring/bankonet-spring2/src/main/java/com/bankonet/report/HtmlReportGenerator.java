package com.bankonet.report;

public class HtmlReportGenerator extends ReportGenerator implements IReportGenerator  {
	
	public HtmlReportGenerator(){
		super();
	}
	
	public void generate(){
		System.out.println("G�n�ration d'un rapport HTML..");
	}
	public void generate(String auteur){
		this.generate();
		System.out.println("-> Auteur : "+	auteur);
	}
}

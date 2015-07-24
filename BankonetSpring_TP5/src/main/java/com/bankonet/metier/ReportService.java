package com.bankonet.metier;
import com.bankonet.report.*;

public class ReportService {
	private IReportGenerator reportGenerator;
	private String auteur;

	public ReportService(){}
	
	public ReportService(IReportGenerator reportGenerator,String auteur){
		this.reportGenerator = reportGenerator;
		this.auteur = auteur;
	}


	public IReportGenerator getReportGenerator() {
		return reportGenerator;
	}


	public void setReportGenerator(IReportGenerator reportGenerator) {
		this.reportGenerator = reportGenerator;
	}
	
	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	
	public void generate(){
		reportGenerator.generate(auteur);
	}
	
	
}

package com.bankonet.report;

public class ReportFactory {
	public static ReportGenerator createReport(String reportType) throws Exception{
		if ("pdf".equals(reportType)){
			return new PdfReportGenerator();
		}else if("html".equals(reportType)){
			return new HtmlReportGenerator();
		} else{
			throw new Exception("reportType inconnu");
		}
	}
}

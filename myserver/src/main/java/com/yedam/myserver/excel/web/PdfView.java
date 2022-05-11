package com.yedam.myserver.excel.web;

import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

@Component
public class PdfView extends AbstractView{
	
	@Autowired
	DataSource datasource;
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		 Connection conn = datasource.getConnection();
		 String reportFile = (String)model.get("filename");
		 JasperReport jasperReport = null;
		 HashMap<String,Object> map = (HashMap<String, Object>)model.get("param");
		
		 if(reportFile.endsWith("jasper")) {
			 InputStream jasperStream = getClass().getResourceAsStream(reportFile);
			 jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
		 } else {
			 InputStream stream = getClass().getResourceAsStream(reportFile); 
			 jasperReport = JasperCompileManager.compileReport(stream);
		 }
		 JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, conn);
		 JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
	}

}

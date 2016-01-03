package com.venki.JasperExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public class ReportController {
	
	
	 
	    @RequestMapping(method = RequestMethod.GET , value = "pdf")
	    public ModelAndView generatePdfReport(ModelAndView modelAndView){
	    	
	    	Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/comm", "root", "root");
			Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = st.executeQuery("Select * from comm.sms_data");
			
			List<String> data = new ArrayList<String>();
		
			while(rs.next())
			{
				
			}
			
	        Map<String,Object> parameterMap = new HashMap<String,Object>();
	 
	      
	 
	        JRDataSource JRdataSource = new JRBeanCollectionDataSource(usersList);
	 
	        parameterMap.put("datasource", JRdataSource);
	 
	        //pdfReport bean has ben declared in the jasper-views.xml file
	        modelAndView = new ModelAndView("pdfReport", parameterMap);
	 
	        return modelAndView;
	 
	    }//generatePdfReport
	 
	 
	 
	    @RequestMapping(method = RequestMethod.GET , value = "xls")
	    public ModelAndView generateXlsReport(ModelAndView modelAndView){
	 
	        Map<String,Object> parameterMap = new HashMap<String,Object>();
	 
	        List<User> usersList = userDao.retrieveAllRegisteredUsers();
	 
	        JRDataSource JRdataSource = new JRBeanCollectionDataSource(usersList);
	 
	        parameterMap.put("datasource", JRdataSource);
	 
	        //xlsReport bean has ben declared in the jasper-views.xml file
	        modelAndView = new ModelAndView("xlsReport", parameterMap);
	 
	        return modelAndView;
	 
	    }//generatePdfReport
	 
	 
	    @RequestMapping(method = RequestMethod.GET , value = "csv")
	    public ModelAndView generateCsvReport(ModelAndView modelAndView){
	 
	        Map<String,Object> parameterMap = new HashMap<String,Object>();
	 
	        List<User> usersList = userDao.retrieveAllRegisteredUsers();
	 
	        JRDataSource JRdataSource = new JRBeanCollectionDataSource(usersList);
	 
	        parameterMap.put("datasource", JRdataSource);
	 
	        //xlsReport bean has ben declared in the jasper-views.xml file
	        modelAndView = new ModelAndView("csvReport", parameterMap);
	 
	        return modelAndView;
	 
	    }//generatePdfReport
	 
	 
	 
	    @RequestMapping(method = RequestMethod.GET , value = "html")
	    public ModelAndView generateHtmlReport(ModelAndView modelAndView){
	 
	        Map<String,Object> parameterMap = new HashMap<String,Object>();
	 
	        List<User> usersList = userDao.retrieveAllRegisteredUsers();
	 
	        JRDataSource JRdataSource = new JRBeanCollectionDataSource(usersList);
	 
	        parameterMap.put("datasource", JRdataSource);
	 
	        //xlsReport bean has ben declared in the jasper-views.xml file
	        modelAndView = new ModelAndView("htmlReport", parameterMap);
	 
	        return modelAndView;
	 
	    }//generatePdfReport
	 
	 
	}//ReportController

}

package com.tmp.gateway;
import javax.servlet.http.HttpServletRequest;
import com.tmp.DTGenerators.*;
import com.tmp.utils.TMPLogger;
import com.google.visualization.datasource.DataSourceServlet;
import com.google.visualization.datasource.base.DataSourceException;
import com.google.visualization.datasource.datatable.DataTable;
import com.google.visualization.datasource.query.Query;
public class WidgetController extends DataSourceServlet {
	private static final long serialVersionUID = 1L;

	private static final String DATA_TYPE = "dataType";

   public WidgetController() {
       super();
   }

    @Override
    public DataTable generateDataTable(Query query, HttpServletRequest request) throws DataSourceException {
    	String dataType = request.getParameter(DATA_TYPE);
    	System.out.println(dataType);
        DataTable dataTable = new DataTable();
    	    	
    	System.out.println(" ************ IN THE GENERATE DATA TABLE METHOD dataType ********* " + dataType);
    	System.out.println("before logger");
    	TMPLogger.log.debug(" VisualizationsDataController:generateDataTable");
    	System.out.println("After Logger");
    	
    	if("getCompany".equalsIgnoreCase(dataType)){
    		dataTable = CompanyDTGenerator.getCompanyDataDT();
    		System.out.println("Size of Data Table: "+CompanyDTGenerator.getCompanyDataDT());
    	}

    	else if("getDiffEmp".equalsIgnoreCase(dataType)){
    		String flag_id =request.getParameter("flag");
			int flag =Integer.parseInt(flag_id);
			System.out.println(dataType);
    		System.out.println("value of flag is "+flag+"abe ye pagal ho gya h...");
    		dataTable = EmployeeDTGenerator.getDiffEmployeeDataDT(flag);
    		System.out.println("Size of Data Table: "+EmployeeDTGenerator.getDiffEmployeeDataDT(flag));
		}
    	else if("getDiffCompany".equalsIgnoreCase(dataType)){	
    		String flag_id =request.getParameter("flag");
			int flag =Integer.parseInt(flag_id);
			System.out.println("value of flag i s"+flag);
			dataTable = CompanyDTGenerator.getDiffCompanyDataDT(flag);
    		System.out.println("Size of Data Table: "+CompanyDTGenerator.getDiffCompanyDataDT(flag));
    	}
    	else if("trainingDT".equalsIgnoreCase(dataType)) {
    		System.out.println(dataType);
    		dataTable=TrainingDTGenerator.getTrainingListDT();
    		System.out.println("size of data table :"+ dataTable);
    	}
    	else{
    		System.out.println("action not defined in  this Controller");
    	}
    	
     	return dataTable;
      
    } 

    /**
     * NOTE: By default, this function returns true, which means that cross
     * domain requests are rejected.
     * This check is disabled here so examples can be used directly from the
     * address bar of the browser. Bear in mind that this exposes your
     * data source to xsrf attacks.
     * If the only use of the data source url is from your application,
     * that runs on the same domain, it is better to remain in restricted mode.
     */
   // @Override
    protected boolean isRestrictedAccessMode() {
      return false;
    }
}

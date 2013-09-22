package com.tmp.DTGenerators;

import java.util.ArrayList;

import com.tmp.company.CompanyManager;
import com.tmp.company.Company;
import com.google.visualization.datasource.datatable.ColumnDescription;
import com.google.visualization.datasource.datatable.DataTable;
import com.google.visualization.datasource.datatable.value.ValueType;
public class CompanyDTGenerator {
	
	public static DataTable getCompanyDataDT(){
		ArrayList<Company> companyDTList = CompanyManager.getCompanyNameList();
		DataTable companyDataDT = new DataTable();

		ArrayList<ColumnDescription> columnList = new ArrayList<ColumnDescription>();
		
		columnList.add(new ColumnDescription("id", ValueType.NUMBER, "Id"));
		columnList.add(new ColumnDescription("com_name", ValueType.TEXT, "Company Name"));
        
		columnList.add(new ColumnDescription("contact_person", ValueType.TEXT, "Contact Person"));
		
		columnList.add(new ColumnDescription("address", ValueType.TEXT, "Address"));
		
		columnList.add(new ColumnDescription("contact_no", ValueType.NUMBER, "Contact no"));
					
		companyDataDT.addColumns(columnList);
		try{
			int sizeOfList = -1;
			if(companyDTList != null)
			sizeOfList =companyDTList.size();
			
			for(int i=0;i<sizeOfList;i++){
				
				Company leads = (Company)companyDTList.get(i);
				System.out.println("Dt: "+leads.getId());
				companyDataDT.addRowFromValues(
						leads.getId(),
						leads.getComName(),
						leads.getContactPerson(),
						leads.getAddress(),
						leads.getContactNo()
					);
					
				//stdTopicDT.addRowFromValues(studentId,
				//System.out.println(" table generated");											
			}
		}
		catch (Exception e) {
			System.out.println("gettopicDashboardDT " + e);
		}
		return companyDataDT;
	}
	public static DataTable getDiffCompanyDataDT(int flag){
		ArrayList<Company> companyDTList = CompanyManager.getCompanyNameList(flag);
		DataTable companyDataDT = new DataTable();

		ArrayList<ColumnDescription> columnList = new ArrayList<ColumnDescription>();
		
		columnList.add(new ColumnDescription("id", ValueType.NUMBER, "Id"));
		columnList.add(new ColumnDescription("com_name", ValueType.TEXT, "Company Name"));
        
		columnList.add(new ColumnDescription("contact_person", ValueType.TEXT, "Contact Person"));
		
		columnList.add(new ColumnDescription("address", ValueType.TEXT, "Address"));
		
		columnList.add(new ColumnDescription("contact_no", ValueType.NUMBER, "Contact no"));
	
					
		companyDataDT.addColumns(columnList);
		try{
			int sizeOfList = -1;
			if(companyDTList != null)
			sizeOfList =companyDTList.size();
			
			for(int i=0;i<sizeOfList;i++){
				
				Company leads = (Company)companyDTList.get(i);
				System.out.println("Dt: "+leads.getId());
				companyDataDT.addRowFromValues(
						leads.getId(),
						leads.getComName(),
						leads.getContactPerson(),
						leads.getAddress(),
						leads.getContactNo()
					);
					
				//stdTopicDT.addRowFromValues(studentId,
				//System.out.println(" table generated");											
			}
		}
		catch (Exception e) {
			System.out.println("gettopicDashboardDT " + e);
		}
		return companyDataDT;
	}


}

package com.tmp.DTGenerators;

import java.util.ArrayList;
import com.tmp.user.Employee;
import com.tmp.user.EmployeeManager;
import com.google.visualization.datasource.datatable.ColumnDescription;
import com.google.visualization.datasource.datatable.DataTable;
import com.google.visualization.datasource.datatable.value.ValueType;
public class EmployeeDTGenerator {
	
	public static DataTable getDiffEmployeeDataDT(int flag){
		System.out.print("inside Employeee DT generator");
		ArrayList<Employee> employeeDTList = EmployeeManager.getEmployeeNameList(flag);
		DataTable companyDataDT = new DataTable();

		ArrayList<ColumnDescription> columnList = new ArrayList<ColumnDescription>();
		
		columnList.add(new ColumnDescription("id", ValueType.NUMBER, "Id"));
		columnList.add(new ColumnDescription("Name", ValueType.TEXT, "Name"));
		columnList.add(new ColumnDescription("Email", ValueType.TEXT, "Email Id"));
		columnList.add(new ColumnDescription("Mobile", ValueType.TEXT, "Mobile No."));
		columnList.add(new ColumnDescription("Address", ValueType.TEXT, "Address"));
		columnList.add(new ColumnDescription("Course", ValueType.TEXT, "Course"));
		columnList.add(new ColumnDescription("Experience", ValueType.TEXT, "Experience"));
					
		companyDataDT.addColumns(columnList);
		try{
			int sizeOfList = -1;
			if(employeeDTList != null)
			sizeOfList =employeeDTList.size();
			
			for(int i=0;i<sizeOfList;i++){
				
				Employee employees = (Employee)employeeDTList.get(i);
				System.out.println("Dt: "+employees.getName());
				companyDataDT.addRowFromValues(
						employees.getId(),
						employees.getName(),
						employees.getEmail(),
						employees.getMobile(),
						employees.getAddress(),
						employees.getCourse(),
						employees.getExperience()
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

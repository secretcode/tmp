package com.tmp.DTGenerators;

import java.util.ArrayList;

import com.google.visualization.datasource.datatable.ColumnDescription;
import com.google.visualization.datasource.datatable.DataTable;
import com.google.visualization.datasource.datatable.value.ValueType;
import com.tmp.training.TrainingCourses;
import com.tmp.training.TrainingManager;

public class TrainingDTGenerator {
	
	public static DataTable getTrainingListDT() {
		ArrayList<TrainingCourses> courses=TrainingManager.getTrainingList();
		DataTable trainingDT=new DataTable();
		
		ArrayList<ColumnDescription> columnList = new ArrayList<ColumnDescription>();
		
		columnList.add(new ColumnDescription("id", ValueType.NUMBER, "Id"));
		columnList.add(new ColumnDescription("field", ValueType.TEXT, "Field Name"));
        
		columnList.add(new ColumnDescription("course", ValueType.TEXT, "Course Name"));
		
		trainingDT.addColumns(columnList);
		
		try{
			int sizeOfList = -1;
			if(courses != null)
			sizeOfList =courses.size();
			
			for(int i=0;i<sizeOfList;i++){
				
				TrainingCourses leads = (TrainingCourses)courses.get(i);
				System.out.println("Dt: "+leads.getId());
				trainingDT.addRowFromValues(
						leads.getId(),
						leads.getFieldName(),
						leads.getCourseName()
					);
					
				//stdTopicDT.addRowFromValues(studentId,
				//System.out.println(" table generated");											
			}
		}
		catch (Exception e) {
			System.out.println("gettopicDashboardDT " + e);
		}
		return trainingDT;
	}

	
	}



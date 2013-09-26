package com.tmp.gateway;

import java.io.File;
import java.io.PrintWriter;

import com.tmp.utils.DBConnection;
import java.sql.PreparedStatement;

import java.sql.Connection;

import java.io.IOException;

import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


//import com.mysql.PreparedStatement;


public class UploadResumeController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
		if (!isMultipartContent) {
			System.out.println("file is not uploading");
			return;
		}
		
		System.out.println("file is not uploading");
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> fields = upload.parseRequest(request);
		
			Iterator<FileItem> it = fields.iterator();
			if (!it.hasNext()) {
		
				return;
			}
		
			while (it.hasNext()) {
		
				FileItem fileItem = it.next();
				boolean isFormField = fileItem.isFormField();
				if (isFormField) {
							
					
				} else {
					try {
					File file = File.createTempFile("Employee", ".txt", new File("C:\\Users\\SUDIKSHA\\workspace\\TalentManPower\\WebContent\\HiringResume\\"));
					fileItem.write(file);
					String abc=file.getAbsolutePath();
					Connection con = DBConnection.getConnection();
					abc.replace("\\", "//");
					System.out.println("file path is             "+abc);
					String query1=" insert into resume values(?,?)";
					PreparedStatement ps=con.prepareStatement(query1);
					ps.setInt(1, 100);
					ps.setString(2,abc);	
					ps.executeUpdate();
					//System.out.println(rs);
					}catch(Exception ex) {
						System.out.println("exception occureddd" + ex);
					}
				}
			
			}
		//	out.println("window.location.href = 'http://localhost:8080/tmp/views/hiring.html'");
		
			try {
			RequestDispatcher rd=request.getRequestDispatcher("hiring.html");
			rd.forward(request, response);
			} catch(Exception r) {System.out.println("servlet exception");}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
	}
}
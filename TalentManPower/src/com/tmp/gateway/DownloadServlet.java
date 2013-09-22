package com.tmp.gateway;

import java.io.DataInputStream; 
import java.io.File; 
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext; 
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tmp.utils.DBConnection;



 public class DownloadServlet extends javax.servlet.http.HttpServlet implements
            javax.servlet.Servlet {
        static final long serialVersionUID = 1L;
        private static final int BUFSIZE = 4096;
        private String filePath;

protected void doGet(HttpServletRequest request,
        HttpServletResponse response) throws ServletException,IOException {
	System.out.println("in download servlet ");
	int uid=Integer.parseInt(request.getParameter("EmpUid"));
	System.out.println("id is ::"+uid);
	try {
	Connection con=DBConnection.getConnection();
	PreparedStatement ps=con.prepareStatement("select link from resume where id="+uid+";");
	ResultSet rs=ps.executeQuery();
	while(rs.next()) {
		filePath=rs.getString("link");
		System.out.println(filePath);
	}
	}
	catch(Exception e) {
		System.out.println("sql exceptn "+e);
	}
	
    File file = new File(filePath);
    int length   = 0;
    ServletOutputStream outStream = response.getOutputStream();
    ServletContext context  = getServletConfig().getServletContext();
    String mimetype = context.getMimeType(filePath);

    // sets response content type
    if (mimetype == null) {
        mimetype = "application/octet-stream";
    }
    response.setContentType(mimetype);
    response.setContentLength((int)file.length());
    String fileName = (new File(filePath)).getName();

    // sets HTTP header
    response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

    byte[] byteBuffer = new byte[BUFSIZE];
    DataInputStream in = new DataInputStream(new FileInputStream(file));

    // reads the file's bytes and writes them to the response stream
    while ((in != null) && ((length = in.read(byteBuffer)) != -1))
    {
        outStream.write(byteBuffer,0,length);
    }

    in.close();
    outStream.close();
}
}
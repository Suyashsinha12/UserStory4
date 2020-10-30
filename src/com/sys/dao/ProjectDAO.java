package com.sys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sys.model.Project;

public class ProjectDAO {

	Connection con;

	public ProjectDAO() throws ClassNotFoundException {
		super();
	}

	public boolean insertProject(Project p)
	{
		try {
			con = DBConnector.getConnection();
			PreparedStatement pst=con.prepareStatement("insert into project values(?,?,?,?)");
			pst.setInt(1, p.getId());
			pst.setString(2,p.getTitle());
			pst.setString(3, p.getDescription());
			pst.setString(4,p.getDomain());
			pst.execute();
			
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	public List<Project> showAll() {
		try {
			con = DBConnector.getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("Select * from project");
			List<Project> list = new ArrayList<Project>();
			
			while(rs.next()) 
			{
				Project p=new Project();
				p.setId(rs.getInt(1));
				p.setTitle(rs.getString(2));
				p.setDescription(rs.getString(3));
				p.setDomain(rs.getString(4));
				list.add(p);
				
		}
		return list;
	}
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	}
}
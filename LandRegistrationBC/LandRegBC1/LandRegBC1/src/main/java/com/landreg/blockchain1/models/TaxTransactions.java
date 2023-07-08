package com.landreg.blockchain1.models;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.springframework.web.multipart.MultipartFile;
 

public class TaxTransactions {
private String userid,taxamt,taxyear,title,dt,tm;
private int propId;
private MultipartFile file;
private List<TaxTransactions> lst;


public List<TaxTransactions> getLst() {
	return lst;
}
public void setLst(List<TaxTransactions> lst) {
	this.lst = lst;
}
public String getUserid() {
	return userid;
} 
public void setUserid(String userid) {
	this.userid = userid;
} 
public String getTaxamt() {
	return taxamt;
} 
public void setTaxamt(String taxamt) {
	this.taxamt = taxamt;
} 
public String getTaxyear() {
	return taxyear;
}
 
public void setTaxyear(String taxyear) {
	this.taxyear = taxyear;
} 
public String getTitle() {
	return title;
}
 
public void setTitle(String title) {
	this.title = title;
}
 
public String getDt() {
	return dt;
}
 
public void setDt(String dt) {
	this.dt = dt;
}
 
public String getTm() {
	return tm;
}
 
public void setTm(String tm) {
	this.tm = tm;
}
 

public int getPropId() {
	return propId;
} 
public void setPropId(int propId) {
	this.propId = propId;
} 
public MultipartFile getFile() {
	return file;
}
 
public void setFile(MultipartFile file) {
	this.file = file;
}

public void getTaxTransactions(){
		
		DBConnector gc = new DBConnector();
		Connection con;
		  lst = new ArrayList<TaxTransactions>();
		System.out.println("userid="+propId);
		ResultSet rs;
		
		try {
		
		con= gc.connect();
		Statement st=con.createStatement();
		rs=st.executeQuery("select * from getTaxTransactions where propId="+propId);
		TaxTransactions vs;
		 
		while(rs.next()) {
			
			vs= new TaxTransactions();
			vs.setUserid(rs.getString("userid"));
			vs.setPropId(rs.getInt("propId"));
			vs.setTitle(rs.getString("title"));
			vs.setTaxamt(rs.getString("taxamt"));
			vs.setTaxyear(rs.getString("taxyear"));
			vs.setDt(rs.getString("dt")+" "+rs.getString("tm"));
			 lst.add(vs);
		}
		try {con.close();}catch (Exception e) {
			// TODO: handle exception
		}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		 
	}
public String insert()
{
	DBConnector gc = new DBConnector();
	int y=0;
	
	Connection con;
	String st="";
	try {
	con=gc.connect();
	CallableStatement pst;
	 Date d=new Date();
	 String dt=d.getDate()+"/"+(d.getMonth()+1)+"/"+(d.getYear()+1900);
	 String tm=d.getHours()+":"+d.getMinutes();
	  pst=con.prepareCall("{call insertTaxTrans(?,?,?,?,?,?,?)}");
	System.out.println("bus="+propId );
	pst.setString(1,userid);
	pst.setString(2,title);
	pst.setString(3,dt);
	pst.setString(4,tm);
	pst.setInt(5,propId);
	pst.setString(6,taxamt);
	pst.setString(7,taxyear); 
	int x=pst.executeUpdate();
	
	if(x>0) {
		st="success";
		 
	}
	else
		st="failure"; 
	try {con.close();}catch (Exception e) {
		// TODO: handle exception
	}	
	}
	catch(Exception ex) {
		ex.printStackTrace();
	}
	return st;
	 
}
}

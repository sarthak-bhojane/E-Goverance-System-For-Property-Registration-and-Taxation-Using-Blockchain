package  models;

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

import services.DBConnector;
 

public class TaxCalculation { 
private String propunit, state,city,ctype,proptype;
private int tid; 
private double price;
 
public String getState() {
	return state;
}


public void setState(String state) {
	this.state = state;
}


public String getCity() {
	return city;
}


public void setCity(String city) {
	this.city = city;
}


public String getCtype() {
	return ctype;
}


public void setCtype(String ctype) {
	this.ctype = ctype;
}


public String getProptype() {
	return proptype;
}


public void setProptype(String proptype) {
	this.proptype = proptype;
}

 

public String getPropunit() {
	return propunit;
}


public void setPropunit(String propunit) {
	this.propunit = propunit;
}


public double getPrice() {
	return price;
}


public void setPrice(double price) {
	this.price = price;
}


public int getTid() {
	return tid;
}


public void setTid(int tid) {
	this.tid = tid;
}


public String insert()
{
	DBConnector gc = new DBConnector();
	int y=0;
	
	Connection con;
	String st="";
	try {
	con=gc.connect();
	PreparedStatement pst;
	JavaFuns jf=new JavaFuns();
	Vector v=jf.getValue("select (ifnull(max(tid),1000)+1) as mxid from taxcalculation",1);
	int mxid=Integer.parseInt(v.elementAt(0).toString().trim());
	pst=con.prepareStatement("insert into taxcalculation values(?,?,?,?,?,?,?);");
	 
	pst.setInt(1,mxid);
	pst.setString(2,state);
	pst.setString(3,city);
	pst.setString(4,ctype); 
	pst.setString(5,proptype);
	pst.setDouble(6,price);
	pst.setString(7,propunit);
	  
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

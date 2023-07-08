package com.landreg.blockchain2.models;

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
 

public class TransferProp {
private String userid,sts,dt,remark,proofPath,processedby,username,puserid,pusername,title;
private int propId,purId;
private MultipartFile file;
public String getUserid() {
	return userid;
}

public String getProcessedby() {
	return processedby;
}

public void setProcessedby(String processedby) {
	this.processedby = processedby;
}

public String getDt() {
	return dt;
}

public void setDt(String dt) {
	this.dt = dt;
}

public String getSts() {
	return sts;
}

public void setSts(String sts) {
	this.sts = sts;
}

public String getRemark() {
	return remark;
}

public void setRemark(String remark) {
	this.remark = remark;
}

public int getPurId() {
	return purId;
}

public void setPurId(int purId) {
	this.purId = purId;
}

public void setUserid(String userid) {
	this.userid = userid;
}
public String getProofPath() {
	return proofPath;
}
public void setProofPath(String proofPath) {
	this.proofPath = proofPath;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPuserid() {
	return puserid;
}
public void setPuserid(String puserid) {
	this.puserid = puserid;
}
public String getPusername() {
	return pusername;
}
public void setPusername(String pusername) {
	this.pusername = pusername;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
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
	  pst=con.prepareCall("{call insertPropTrans(?,?,?,?,?,?,?)}");
	System.out.println("bus="+propId+" gfg="+puserid);
	pst.setString(1,userid);
	pst.setString(2,title);
	pst.setString(3,dt);
	pst.setString(4,tm);
	pst.setInt(5,propId);
	pst.setString(6,processedby);
	pst.setString(7,puserid); 
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

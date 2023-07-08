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
 

 

public class Properties {
	private String userid,propId;
	private String city,prevowner,processedby;
	private String state;
	private String usernm;
	private String village;
	private String title,sts;
	private String proptype;
	private String area;
	private String country;
	private String propcondition;
	private String busStandDist;
	private String autoStandDist;
	private String pincode,addr;
	private MultipartFile file,file1;
	private String path,doc,remark;
	private String nearbyHosp,propType,nearbyColg,nearbySchools,nearbyShops,nearbyMall,purchaseDt,propunit; 
	private float propsize,sprice,cprice,mainRoadDist;
	
  
public String getPrevowner() {
		return prevowner;
	}

	public void setPrevowner(String prevowner) {
		this.prevowner = prevowner;
	}

	public String getProcessedby() {
		return processedby;
	}

	public void setProcessedby(String processedby) {
		this.processedby = processedby;
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

public float getSprice() {
		return sprice;
	}

	public void setSprice(float sprice) {
		this.sprice = sprice;
	}

	public float getCprice() {
		return cprice;
	}

	public void setCprice(float cprice) {
		this.cprice = cprice;
	}

public String getDoc() {
		return doc;
	}

	public void setDoc(String doc) {
		this.doc = doc;
	}

public MultipartFile getFile1() {
		return file1;
	}

	public void setFile1(MultipartFile file1) {
		this.file1 = file1;
	}

public String getPropId() {
		return propId;
	}

	public void setPropId(String propId) {
		this.propId = propId;
	}

public String getPropType() {
		return propType;
	}

	public void setPropType(String propType) {
		this.propType = propType;
	}

public float getMainRoadDist() {
		return mainRoadDist;
	}

	public void setMainRoadDist(float mainRoadDist) {
		this.mainRoadDist = mainRoadDist;
	}

public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getUsernm() {
		return usernm;
	}

	public void setUsernm(String usernm) {
		this.usernm = usernm;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getProptype() {
		return proptype;
	}

	public void setProptype(String proptype) {
		this.proptype = proptype;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPropcondition() {
		return propcondition;
	}

	public void setPropcondition(String propcondition) {
		this.propcondition = propcondition;
	}

	public String getBusStandDist() {
		return busStandDist;
	}

	public void setBusStandDist(String busStandDist) {
		this.busStandDist = busStandDist;
	}

	public String getAutoStandDist() {
		return autoStandDist;
	}

	public void setAutoStandDist(String autoStandDist) {
		this.autoStandDist = autoStandDist;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getNearbyHosp() {
		return nearbyHosp;
	}

	public void setNearbyHosp(String nearbyHosp) {
		this.nearbyHosp = nearbyHosp;
	}

	public String getNearbyColg() {
		return nearbyColg;
	}

	public void setNearbyColg(String nearbyColg) {
		this.nearbyColg = nearbyColg;
	}

	public String getNearbySchools() {
		return nearbySchools;
	}

	public void setNearbySchools(String nearbySchools) {
		this.nearbySchools = nearbySchools;
	}

	public String getNearbyShops() {
		return nearbyShops;
	}

	public void setNearbyShops(String nearbyShops) {
		this.nearbyShops = nearbyShops;
	}

	public String getNearbyMall() {
		return nearbyMall;
	}

	public void setNearbyMall(String nearbyMall) {
		this.nearbyMall = nearbyMall;
	}

	public String getPurchaseDt() {
		return purchaseDt;
	}

	public void setPurchaseDt(String purchaseDt) {
		this.purchaseDt = purchaseDt;
	}

	public String getPropunit() {
		return propunit;
	}

	public void setPropunit(String propunit) {
		this.propunit = propunit;
	}

	public float getPropsize() {
		return propsize;
	}

	public void setPropsize(float propsize) {
		this.propsize = propsize;
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
		System.out.println("bus="+propId);
		pst.setString(1,userid);
		pst.setString(2,title);
		pst.setString(3,dt);
		pst.setString(4,tm);
		pst.setString(5,propId);
		pst.setString(6,processedby);
		pst.setString(7,prevowner); 
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

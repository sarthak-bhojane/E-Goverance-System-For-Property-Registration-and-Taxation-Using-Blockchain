package models;

import java.sql.*; 
import java.util.*;

import services.DBConnector;

public class ViewOffice {
	
	private String userid;
	private String usernm,addr,pincode,mobile,city,state;
	private String usertype;
	private String userstatus;
	public String getUserid() {
		return userid;
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

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsernm() {
		return usernm;
	}
	public void setUsernm(String usernm) {
		this.usernm = usernm;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public String getUserstatus() {
		return userstatus;
	}
	public void setUserstatus(String userstatus) {
		this.userstatus = userstatus;
	}
	
	 
public List<ViewOffice> getOfficeList(){
		
		Connection con;
		DBConnector gc = new DBConnector();
		Statement st;
		List<ViewOffice> lst = new ArrayList<ViewOffice>();
		ResultSet rs;
		
		try {
			
			con=gc.connect();
			st=con.createStatement();
			
			rs=st.executeQuery("select userid,usernm,userstatus,usertype,addr,pincode,mobileno,city,state from offices where userstatus='active' ");
			
			ViewOffice vsl;
			
			while(rs.next()) {
				
				vsl= new ViewOffice();
				vsl.setUserid(rs.getString("userid"));
				vsl.setUsernm(rs.getString("usernm"));
				vsl.setUserstatus(rs.getString("userstatus"));
				vsl.setUsertype(rs.getString("usertype"));
				vsl.setAddr(rs.getString("addr"));
				vsl.setPincode(rs.getString("pincode"));
				vsl.setMobile(rs.getString("mobileno"));
				vsl.setState(rs.getString("state"));
				vsl.setCity(rs.getString("city"));
				lst.add(vsl);
				
				
			}
			
			try {con.close();}catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		catch(Exception ex) {
			ex.printStackTrace();
		}
	
		return(lst);
	}
	
	
}

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
 

public class TaxTransactions {
private String userid,name,mobile,remark,taxyear,receipt,title,dt,tm,sts;
private double taxamt;
private int propId,tid;
private MultipartFile file;
 
private List<TaxTransactions> lst;


public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}
public List<TaxTransactions> getLst() {
	return lst;
}
public void setLst(List<TaxTransactions> lst) {
	this.lst = lst;
}

public String getRemark() {
	return remark;
}
public void setRemark(String remark) {
	this.remark = remark;
}
public String getReceipt() {
	return receipt;
}
public void setReceipt(String receipt) {
	this.receipt = receipt;
}
public int getTid() {
	return tid;
}
public void setTid(int tid) {
	this.tid = tid;
}
public String getSts() {
	return sts;
}
public void setSts(String sts) {
	this.sts = sts;
}
public String getUserid() {
	return userid;
} 
public void setUserid(String userid) {
	this.userid = userid;
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

public boolean update()
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
	  pst=con.prepareCall("{call updateTaxPayment(?,?,?)}");
	 System.out.println("tid="+tid);
	pst.setInt(1,tid);
	 
	pst.setString(2,dt+" "+tm);
	pst.setString(3,receipt);
	 
	int x=pst.executeUpdate();
	try {con.close();}catch (Exception e) {
		// TODO: handle exception
	}	
	if(x>0) {
		return true;
		 
	}
	else
		return false;
	
	}
	catch(Exception ex) {
		ex.printStackTrace();
		return false;
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
	pst.setDouble(6,taxamt);
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


public List<TaxTransactions> getDefaulters(String area,String city){
	
	
	DBConnector gc = new DBConnector();
	Connection con;
	List<TaxTransactions> lst = new ArrayList<TaxTransactions>();
	 
	ResultSet rs;
	
	try {
	
	con= gc.connect();
	Statement st=con.createStatement();
	rs=st.executeQuery("select p.title,t.* from taxdetails t inner join properties p on t.propId=p.propId and t.sts='pending' and p.area='"+area+"' and p.city='"+city+"'");
	TaxTransactions vs;
	 
	while(rs.next()) {
		
		vs= new TaxTransactions();
		vs.setUserid(rs.getString("userid"));
		vs.setPropId(rs.getInt("propId"));
		vs.setTitle(rs.getString("title"));
		vs.setTaxyear(rs.getString("taxyear"));
		vs.setTaxamt(rs.getDouble("tax"));
		vs.setSts(rs.getString("sts"));
		vs.setTid(rs.getInt("tid"));
		JavaFuns jf=new JavaFuns();
		Vector v=jf.getValue("select usernm,mobileno from userdetails where userid='"+userid+"'", 2);
		vs.setName(v.elementAt(0).toString().trim());
		vs.setMobile(v.elementAt(1).toString().trim());
		lst.add(vs);
	}
	try {con.close();}catch (Exception e) {
		// TODO: handle exception
	}
	}
	catch(Exception ex){
		ex.printStackTrace();
	}
	return(lst);
}
public List<TaxTransactions> getTaxList(String userid,String propid1){
		
	
		DBConnector gc = new DBConnector();
		Connection con;
		List<TaxTransactions> lst = new ArrayList<TaxTransactions>();
		 
		ResultSet rs;
		
		try {
		
		con= gc.connect();
		Statement st=con.createStatement();
		rs=st.executeQuery("select * from taxdetails where userid='"+userid+"' and propId="+propid1.trim());
		TaxTransactions vs;
		 
		while(rs.next()) {
			
			vs= new TaxTransactions();
			vs.setUserid(rs.getString("userid"));
			vs.setPropId(rs.getInt("propId"));
			vs.setTitle(title);
			vs.setTaxyear(rs.getString("taxyear"));
			vs.setTaxamt(rs.getDouble("tax"));
			vs.setSts(rs.getString("sts"));
			vs.setTid(rs.getInt("tid"));
			lst.add(vs);
		}
		try {con.close();}catch (Exception e) {
			// TODO: handle exception
		}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return(lst);
	}
public void process()
{
	try
	{
		JavaFuns jf=new JavaFuns();
		if(jf.execute("update taxdetails set remark='"+remark+"', sts='"+sts+"' where tid="+tid)) {}
	}
	catch (Exception e) {
		// TODO: handle exception
	}
}
public List<TaxTransactions> getPendingPayment(String city,String area){
		
	
		DBConnector gc = new DBConnector();
		Connection con;
		List<TaxTransactions> lst = new ArrayList<TaxTransactions>();
		 
		ResultSet rs;
		
		try {
		
		con= gc.connect();
		Statement st=con.createStatement();
		System.out.println("qr="+"select p.title,t.* from taxdetails t inner join properties p on t.propId=t.propId where t.sts='payment_pending' and p.area='"+area+"' and city='"+city+"'");
		rs=st.executeQuery("select p.title,t.* from taxdetails t inner join properties p on t.propId=t.propId where t.sts='payment_pending' and p.area='"+area+"' and city='"+city+"'");
		TaxTransactions vs;
		 
		while(rs.next()) {
			
			vs= new TaxTransactions();
			vs.setUserid(rs.getString("userid"));
			vs.setPropId(rs.getInt("propId"));
			vs.setTitle(rs.getString("title"));
			vs.setTaxyear(rs.getString("taxyear"));
			vs.setTaxamt(rs.getDouble("tax"));
			vs.setSts(rs.getString("sts"));
			vs.setDt(rs.getString("paymentDt"));
			vs.setReceipt(rs.getString("receipt"));
			vs.setTid(rs.getInt("tid"));
			lst.add(vs);
		}
		try {con.close();}catch (Exception e) {
			// TODO: handle exception
		}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return(lst);
	}
public double getTaxamt() {
	return taxamt;
}
public void setTaxamt(double taxamt) {
	this.taxamt = taxamt;
}
public String calculateTax()
{
	DBConnector gc = new DBConnector();
	int y=0;
	JavaFuns jf=new JavaFuns();
	Vector v2=jf.getValue("select (t.price*p.propsize) as taxamt from properties p inner join taxcalculation t on p.city=t.city and p.propType=t.proptype and p.propId="+propId , 1);
	taxamt=Double.parseDouble(v2.elementAt(0).toString().trim());
	
	Date dt=new Date();
	if((dt.getMonth()+1)>3)
	{
		taxyear=(dt.getYear()+1900)+"-"+(dt.getYear()+1900+1);
	}
	else
		taxyear=(dt.getYear()+1900-1)+"-"+(dt.getYear()+1900);
	 
	Vector v1=jf.getValue("select tid from taxdetails where propId="+propId+"  and userid='"+userid+"' and taxyear='"+taxyear+"'",1);
	Connection con;
	String st="";
	try {
		if(v1.size()==0)
		{
	con=gc.connect();
	PreparedStatement pst; 
	Vector v=jf.getValue("select (ifnull(max(tid),1000)+1) as mxid from taxdetails",1);
	int mxid=Integer.parseInt(v.elementAt(0).toString().trim());
	pst=con.prepareStatement("insert into taxdetails values(?,?,?,?,?,?,?,?,?);");
	 
	pst.setInt(1,mxid);
	pst.setString(2,userid);
	pst.setInt(3,propId);
	pst.setString(4,taxyear); 
	pst.setDouble(5,taxamt);
	pst.setString(6,"pending");
	pst.setString(7,"NA");
	pst.setString(8,"NA");
	pst.setString(9,"NA");
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
	}
	catch(Exception ex) {
		ex.printStackTrace();
	}
	return st;
	
}
}

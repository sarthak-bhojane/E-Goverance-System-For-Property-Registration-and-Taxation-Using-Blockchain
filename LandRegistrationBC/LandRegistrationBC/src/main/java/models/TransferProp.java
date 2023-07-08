package models;

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

public class TransferProp {
private String userid,sts,prevowner,dt,remark,proofPath,processedby,username,puserid,pusername,title;
private int propId,purId;
private MultipartFile file;
public String getUserid() {
	return userid;
}

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
public boolean insert()
{
	DBConnector gc = new DBConnector();
	int y=0;
	
	Connection con;
	boolean st=false ;
	try {
	con=gc.connect();
	Date dt=new Date();
	String d=dt.getDate()+"/"+(dt.getMonth()+1)+"/"+(dt.getYear()+1900);
	PreparedStatement pst;
	JavaFuns jf=new JavaFuns();
	Vector v=jf.getValue("select (ifnull(max(purId),1000)+1) as mxid from prop_purchase_details",1);
	int mxid=Integer.parseInt(v.elementAt(0).toString().trim());
	pst=con.prepareStatement("insert into prop_purchase_details values(?,?,?,?,?,?,?,?,?,?,?);");
	 
	pst.setInt(1,mxid);
	pst.setInt(2,propId);
	pst.setString(3,title);
	pst.setString(4,userid);
	pst.setString(5,username);
	pst.setString(6,puserid);
	pst.setString(7,pusername);
	pst.setString(8,d);
	pst.setString(9,proofPath);
	pst.setString(10,"pending");
	pst.setString(11,"NA");
	int x=pst.executeUpdate();
	
	if(x>0) {
		st=true;
		 
	}
	else
		st=false; 
	try {con.close();}catch (Exception e) {
		// TODO: handle exception
	}	
	}
	catch(Exception ex) {
		ex.printStackTrace();
	}
	return st;
	
	
}
public void process()
{
	JavaFuns jf=new JavaFuns();
	System.out.println("update prop_purchase_details set remark='"+remark+"', sts='"+sts+"' where propId="+propId+" and purId="+purId);
	if(jf.execute("update prop_purchase_details set remark='"+remark+"', sts='"+sts+"' where propId="+propId+" and purId="+purId)){}
 
}
public void process1()
{
	JavaFuns jf=new JavaFuns();
	System.out.println("update prop_purchase_details set remark='"+remark+"', sts='"+sts+"' where propId="+propId+" and purId="+purId);
	if(jf.execute("update prop_purchase_details set remark='"+remark+"', sts='"+sts+"' where propId="+propId+" and purId="+purId)){}
	if(jf.execute("update properties set userid='"+userid+"' where propId="+propId)){}
	
}

public List<TransferProp> getPendingTransferReq(String userid1){
		
		DBConnector gc = new DBConnector();
		Connection con;
		List<TransferProp> lst = new ArrayList<TransferProp>();
		System.out.println("userid="+userid1);
		ResultSet rs;
		
		try {
		
		con= gc.connect();
		Statement st=con.createStatement();
		rs=st.executeQuery("select * from prop_purchase_details where prevuserid='"+userid1+"' and sts='pending'");
		TransferProp vs;
		 
		while(rs.next()) {
			
			vs= new TransferProp();
			vs.setUserid(rs.getString("userid"));
			vs.setPurId(rs.getInt("purId"));
			vs.setPropId(rs.getInt("propId"));
			vs.setTitle(rs.getString("title"));
			vs.setUsername(rs.getString("username"));
			vs.setPuserid(rs.getString("prevuserid"));
			vs.setPusername(rs.getString("prevUsername"));
			vs.setDt(rs.getString("dt"));
			vs.setProofPath(rs.getString("proof"));
			 
			vs.setSts(rs.getString("sts"));
			vs.setRemark(rs.getString("remark"));
			  
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
public List<TransferProp> getPATransferReq(String area){
	
	DBConnector gc = new DBConnector();
	Connection con;
	List<TransferProp> lst = new ArrayList<TransferProp>();
	System.out.println("userid="+area);
	ResultSet rs;
	
	try {
	
	con= gc.connect();
	Statement st=con.createStatement();
	rs=st.executeQuery("select p.* from prop_purchase_details p inner join properties pr on p.propId=pr.propId and p.sts='partial_approved' and pr.area='"+area+"' ");
	TransferProp vs;
	 
	while(rs.next()) {
		
		vs= new TransferProp();
		vs.setUserid(rs.getString("userid"));
		vs.setPurId(rs.getInt("purId"));
		vs.setPropId(rs.getInt("propId"));
		vs.setTitle(rs.getString("title"));
		vs.setUsername(rs.getString("username"));
		vs.setPuserid(rs.getString("prevuserid"));
		vs.setPusername(rs.getString("prevUsername"));
		vs.setDt(rs.getString("dt"));
		vs.setProofPath(rs.getString("proof"));
		 
		vs.setSts(rs.getString("sts"));
		vs.setRemark(rs.getString("remark"));
		  
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
}

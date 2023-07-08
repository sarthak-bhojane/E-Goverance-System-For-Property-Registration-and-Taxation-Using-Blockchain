package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.mail.search.SearchTerm;

import org.springframework.web.multipart.MultipartFile;
 

import services.DBConnector;
import services.JsonReaderBing;

 

public class Properties {
	private String userid,propId;
	private String city,prevowner,processedby,propCurrentSts;
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
	private double lat,lng;
   
	List<Properties> lst=new ArrayList<Properties>();
	
public List<Properties> getLst() {
		return lst;
	}

	public void setLst(List<Properties> lst) {
		this.lst = lst;
	}

public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

public String getPropCurrentSts() {
		return propCurrentSts;
	}

	public void setPropCurrentSts(String propCurrentSts) {
		this.propCurrentSts = propCurrentSts;
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

public void approve()
{
	JavaFuns jf=new JavaFuns();
	if(jf.execute("update properties set remark='"+remark+"', sts='"+sts+"' where propId="+propId)){}
	
}
public void decline()
{
	JavaFuns jf=new JavaFuns();
	if(jf.execute("update properties set remark='"+remark+"',sts='declined' where propId="+propId)){}
	
}
public List<Properties> getPropSearch(String prop){
		
		DBConnector gc = new DBConnector();
		Connection con;
		List<Properties> lst = new ArrayList<Properties>();
		System.out.println("txt="+prop);
		ResultSet rs;
		
		try {
		
		con= gc.connect();
		Statement st=con.createStatement();
		String qr="select * from properties where propType like '%"+prop+"%' or area like '%"+prop+"%' or city like '%"+prop+"%' or state like '%"+prop+"%' or propcondition like '%"+prop+"%' or addr like '%"+prop+"%' or pincode like '%"+prop+"%'";
		System.out.println(qr);
		rs=st.executeQuery(qr);
		Properties vs;
		 
		while(rs.next()) {
			
			vs= new Properties();
			vs.setUserid(rs.getString("userid"));
			vs.setPropId(rs.getString("propId"));
			vs.setTitle(rs.getString("title"));
			vs.setPropType(rs.getString("propType"));
			vs.setArea(rs.getString("area"));
			vs.setCity(rs.getString("city"));
			vs.setState(rs.getString("state"));
			vs.setProptype(rs.getString("proptype"));
			 
			vs.setPincode(rs.getString("pincode"));
			vs.setVillage(rs.getString("village"));
			 
			vs.setCountry(rs.getString("country"));
			vs.setPropcondition(rs.getString("propcondition"));
			vs.setBusStandDist(rs.getString("busStandDist"));
			vs.setAutoStandDist(rs.getString("autoStandDist"));
			vs.setNearbyHosp(rs.getString("nearbyHosp"));
			vs.setNearbyShops(rs.getString("nearbyShops"));
			vs.setMainRoadDist(rs.getFloat("mainRoadDist"));
			vs.setNearbySchools(rs.getString("nearBySchools"));
			vs.setNearbyColg(rs.getString("nearByColg"));
			vs.setNearbyMall(rs.getString("shoppingMall"));
			vs.setUserid(rs.getString("userid"));
			vs.setPurchaseDt(rs.getString("propertyPurchaseDt"));
			vs.setPropsize(rs.getFloat("propsize"));
			vs.setPropunit(rs.getString("propUnit"));
			vs.setPath(rs.getString("photo"));
			vs.setCprice(rs.getFloat("evalCost"));
			vs.setSprice(rs.getFloat("selling_price"));
			vs.setAddr(rs.getString("addr"));
			vs.setRemark(rs.getString("remark"));
			vs.setLat(rs.getDouble("lat"));
			vs.setLng(rs.getDouble("lng"));
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
	
 
public List<Properties> getMyPropsReport(String userid1){
		
		DBConnector gc = new DBConnector();
		Connection con;
		List<Properties> lst = new ArrayList<Properties>();
		System.out.println("userid="+userid1);
		ResultSet rs;
		
		try {
		
		con= gc.connect();
		Statement st=con.createStatement();
		rs=st.executeQuery("select * from properties where userid='"+userid1+"'");
		Properties vs;
		 
		while(rs.next()) {
			
			vs= new Properties();
			vs.setUserid(rs.getString("userid"));
			vs.setPropId(rs.getString("propId"));
			vs.setTitle(rs.getString("title"));
			vs.setPropType(rs.getString("propType"));
			vs.setArea(rs.getString("area"));
			vs.setCity(rs.getString("city"));
			vs.setState(rs.getString("state"));
			vs.setProptype(rs.getString("proptype"));
			 
			vs.setPincode(rs.getString("pincode"));
			vs.setVillage(rs.getString("village"));
			 
			vs.setCountry(rs.getString("country"));
			vs.setPropcondition(rs.getString("propcondition"));
			vs.setBusStandDist(rs.getString("busStandDist"));
			vs.setAutoStandDist(rs.getString("autoStandDist"));
			vs.setNearbyHosp(rs.getString("nearbyHosp"));
			vs.setNearbyShops(rs.getString("nearbyShops"));
			vs.setMainRoadDist(rs.getFloat("mainRoadDist"));
			vs.setNearbySchools(rs.getString("nearBySchools"));
			vs.setNearbyColg(rs.getString("nearByColg"));
			vs.setNearbyMall(rs.getString("shoppingMall"));
			vs.setUserid(rs.getString("userid"));
			vs.setPurchaseDt(rs.getString("propertyPurchaseDt"));
			vs.setPropsize(rs.getFloat("propsize"));
			vs.setPropunit(rs.getString("propUnit"));
			vs.setPath(rs.getString("photo"));
			vs.setCprice(rs.getFloat("evalCost"));
			vs.setAddr(rs.getString("addr"));
			vs.setRemark(rs.getString("remark"));
			vs.setLat(rs.getDouble("lat"));
			vs.setLng(rs.getDouble("lng"));
			vs.setPropCurrentSts(rs.getString("propCurrentSts"));
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

public List<Properties> getApprovedProperties(String area1){
		
		DBConnector gc = new DBConnector();
		Connection con;
		List<Properties> lst = new ArrayList<Properties>();
		System.out.println("area="+area1);
		ResultSet rs;
		
		try {
		
		con= gc.connect();
		Statement st=con.createStatement();
		rs=st.executeQuery("select * from properties where area='"+area1+"' and sts='approved'");
		Properties vs;
		 
		while(rs.next()) {
			
			vs= new Properties();
			vs.setUserid(rs.getString("userid"));
			vs.setPropId(rs.getString("propId"));
			vs.setTitle(rs.getString("title"));
			vs.setPropType(rs.getString("propType"));
			vs.setArea(rs.getString("area"));
			vs.setCity(rs.getString("city"));
			vs.setState(rs.getString("state"));
			vs.setProptype(rs.getString("proptype"));
			 
			vs.setPincode(rs.getString("pincode"));
			vs.setVillage(rs.getString("village"));
			 
			vs.setCountry(rs.getString("country"));
			vs.setPropcondition(rs.getString("propcondition"));
			vs.setBusStandDist(rs.getString("busStandDist"));
			vs.setAutoStandDist(rs.getString("autoStandDist"));
			vs.setNearbyHosp(rs.getString("nearbyHosp"));
			vs.setNearbyShops(rs.getString("nearbyShops"));
			vs.setMainRoadDist(rs.getFloat("mainRoadDist"));
			vs.setNearbySchools(rs.getString("nearBySchools"));
			vs.setNearbyColg(rs.getString("nearByColg"));
			vs.setNearbyMall(rs.getString("shoppingMall"));
			vs.setUserid(rs.getString("userid"));
			vs.setPurchaseDt(rs.getString("propertyPurchaseDt"));
			vs.setPropsize(rs.getFloat("propsize"));
			vs.setPropunit(rs.getString("propUnit"));
			vs.setPath(rs.getString("photo"));
			vs.setCprice(rs.getFloat("evalCost"));
			vs.setAddr(rs.getString("addr"));
			vs.setRemark(rs.getString("remark"));
			vs.setLat(rs.getDouble("lat"));
			vs.setLng(rs.getDouble("lat"));
			vs.setPropCurrentSts(rs.getString("propCurrentSts"));
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
	
 

public List<Properties> getPendingProperties(String area1){
		
		DBConnector gc = new DBConnector();
		Connection con;
		List<Properties> lst = new ArrayList<Properties>();
		System.out.println("area="+area1);
		ResultSet rs;
		
		try {
		
		con= gc.connect();
		Statement st=con.createStatement();
		rs=st.executeQuery("select * from properties where area='"+area1+"' and sts='pending'");
		Properties vs;
		 
		while(rs.next()) {
			
			vs= new Properties();
			vs.setUserid(rs.getString("userid"));
			vs.setPropId(rs.getString("propId"));
			vs.setTitle(rs.getString("title"));
			vs.setPropType(rs.getString("propType"));
			vs.setArea(rs.getString("area"));
			vs.setCity(rs.getString("city"));
			vs.setState(rs.getString("state"));
			vs.setProptype(rs.getString("proptype"));
			 
			vs.setPincode(rs.getString("pincode"));
			vs.setVillage(rs.getString("village"));
			 
			vs.setCountry(rs.getString("country"));
			vs.setPropcondition(rs.getString("propcondition"));
			vs.setBusStandDist(rs.getString("busStandDist"));
			vs.setAutoStandDist(rs.getString("autoStandDist"));
			vs.setNearbyHosp(rs.getString("nearbyHosp"));
			vs.setNearbyShops(rs.getString("nearbyShops"));
			vs.setMainRoadDist(rs.getFloat("mainRoadDist"));
			vs.setNearbySchools(rs.getString("nearBySchools"));
			vs.setNearbyColg(rs.getString("nearByColg"));
			vs.setNearbyMall(rs.getString("shoppingMall"));
			vs.setUserid(rs.getString("userid"));
			vs.setPurchaseDt(rs.getString("propertyPurchaseDt"));
			vs.setPropsize(rs.getFloat("propsize"));
			vs.setPropunit(rs.getString("propUnit"));
			vs.setPath(rs.getString("photo"));
			vs.setCprice(rs.getFloat("evalCost"));
			vs.setAddr(rs.getString("addr"));
			vs.setRemark(rs.getString("remark"));
			vs.setLat(rs.getDouble("lat"));
			vs.setLng(rs.getDouble("lng"));
			vs.setPropCurrentSts(rs.getString("propCurrentSts"));
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
	
 

	public String addNewProperty()
	{
		DBConnector gc = new DBConnector();
		int y=0;
		
		Connection con;
		String st="";
		try {
		con=gc.connect();
		PreparedStatement pst;
		JavaFuns jf=new JavaFuns();
		Vector v=jf.getValue("select (ifnull(max(propId),1000)+1) as mxid from properties",1);
		int mxid=Integer.parseInt(v.elementAt(0).toString().trim());
		pst=con.prepareStatement("insert into properties values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
		System.out.println("bus="+busStandDist);
		pst.setInt(1,mxid);
		pst.setString(2,title);
		pst.setString(3,proptype);
		pst.setString(4,area);
		pst.setString(5,city);
		pst.setString(6,village);
		pst.setString(7,state);
		pst.setString(8,"India");
		pst.setString(9,pincode);
		pst.setString(10,propcondition);
		pst.setString(11,busStandDist);
		pst.setString(12,autoStandDist);
		if(nearbyHosp==null)
			nearbyHosp="No";
		else
			nearbyHosp="Yes";	
		if(nearbyShops==null)
			nearbyShops="No";
		else
			nearbyShops="Yes";
		if(nearbySchools==null)
			nearbySchools="No";
		else
			nearbySchools="Yes";
		if(nearbyColg==null)
			nearbyColg="No";
		else
			nearbyColg="Yes";
		if(nearbyMall==null)
			nearbyMall="No";
		else
			nearbyMall="Yes";
		pst.setString(13,nearbyHosp);
		pst.setString(14,nearbyShops);
		pst.setFloat(15,mainRoadDist);
		pst.setString(16,nearbySchools);
		pst.setString(17,nearbyColg);
		pst.setString(18,nearbyMall);
		pst.setString(19,userid);
		pst.setString(20,purchaseDt);
		pst.setFloat(21,propsize);
		pst.setString(22,propunit);
		pst.setString(23,path);
		pst.setFloat(24,cprice);
		pst.setString(25,addr);
		pst.setString(26,doc);
		pst.setString(27,"pending");
		pst.setFloat(28,sprice);
		pst.setString(29,"NA");
		pst.setString(30,propCurrentSts);
		JsonReaderBing jobj=new JsonReaderBing();
		jobj.GetLatNLng(addr+" "+city+" "+state, pincode);
		pst.setDouble(31,jobj.getLat());
		pst.setDouble(32,jobj.getLng());
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

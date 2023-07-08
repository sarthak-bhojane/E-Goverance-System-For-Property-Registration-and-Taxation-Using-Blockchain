package models;
import java.sql.*;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpSession;

import services.DBConnector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
 
public class CheckUser {

	private String userid;
	private String pswd;
		
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPswd() {
		return pswd;
	}
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
	
	public String checkUser(HttpServletRequest request) {
		
		Connection con;
		ResultSet rs;
		String typ,st="";
		DBConnector gc = new DBConnector();
		
		
		try {
			
			 con=gc.connect();
			PreparedStatement pst;
			pst=con.prepareStatement("select * from users where userid=? and pswd=? and userstatus='active' ");
			pst.setString(1,userid );
			pst.setString(2, pswd);
				
			rs=pst.executeQuery();
			
			if(rs.next()) {
								
				
				HttpSession sess=request.getSession(true);
				sess.setAttribute("userid",userid);
				sess.setAttribute("usertype", rs.getString("usertype"));
				sess.setAttribute("username", rs.getString("usernm"));
				sess.setAttribute("utype", rs.getString("usertype"));
				
				typ=rs.getString("usertype");
				sess.setAttribute("photo", getPhoto(userid, typ));
				System.out.println("type="+typ);
				//LoginTracker lt=new LoginTracker();
				//lt.recordLogin(userid, typ);
				if(typ.equals("user"))
					st="user"; 
				else if(typ.equals("admin"))
					st="admin";
				else if(typ.equals("officer"))
				{
					JavaFuns jf=new JavaFuns();
					Vector v=jf.getValue("select area,city from offices where userid='"+userid.trim()+"'", 2);
					sess.setAttribute("area", v.elementAt(0).toString().trim());
					sess.setAttribute("city", v.elementAt(1).toString().trim());
					st="officer";
				}
			}
			else
				st="LoginFailure.jsp";
			try {con.close();}catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		catch(Exception ex) {
			ex.printStackTrace();
		}
		 
		return(st);	
	}
public String getPhoto(String userid,String utype) {
		String photo="common.png";
		Connection con;
		ResultSet rs;
		String typ,st="";
		DBConnector gc = new DBConnector();
		
		
		try {
			
			
			con=gc.connect();
			PreparedStatement pst;
			String qr="";
			if(utype.equals("user"))
			{
				qr="select photo from userdetails where userid='"+userid+"'";
			
			 
			pst=con.prepareStatement(qr);
			 
			rs=pst.executeQuery();
			
			if(rs.next()) { 
				photo=rs.getString("photo");
				 
			}}
			try {con.close();}catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return(photo);	
	}
}

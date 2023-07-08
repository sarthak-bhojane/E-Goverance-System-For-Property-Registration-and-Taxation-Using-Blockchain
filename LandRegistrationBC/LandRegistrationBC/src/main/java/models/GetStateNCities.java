package models;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import services.DBConnector;

 

public class GetStateNCities {
	Connection con;
    CallableStatement csmt;
    ResultSet rs;
    private String state,city;
   private List<States> lststate = new ArrayList<States>();
   private List<Cities> lstcity = new ArrayList<Cities>();
   private List<Areas> lstarea = new ArrayList<Areas>();
	 public String getState() {
		return state;
	}

	public List<Areas> getLstarea() {
		return lstarea;
	}

	public void setLstarea(List<Areas> lstarea) {
		this.lstarea = lstarea;
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

	public List<States> getLststate() {
		return lststate;
	}

	public void setLststate(List<States> lststate) {
		this.lststate = lststate;
	}

	public List<Cities> getLstcity() {
		return lstcity;
	}

	public void setLstcity(List<Cities> lstcity) {
		this.lstcity = lstcity;
	}

	public void getStates()
	    {
	        try
	        {
	             DBConnector obj=new  DBConnector();
	            con=obj.connect();
	            csmt=con.prepareCall("{call getStates()}");
	           
	             csmt.execute();
	             rs=csmt.getResultSet();
	                         
	            while(rs.next())
	            { System.out.println("true");
	            lststate.add(new States(rs));
	                  
	            }
	            try {con.close();}catch (Exception e) {
	    			// TODO: handle exception
	    		}
	        } 
	        catch(Exception ex)
	        {
	            System.out.println("err="+ex.getMessage());
	             
	        }
	    }
	public void getCities(String state1)
    {
        try
        {
        	System.out.println("state="+state1);
             DBConnector obj=new  DBConnector();
            con=obj.connect();
            csmt=con.prepareCall("{call getcities(?)}");
           csmt.setString(1, state1);
             csmt.execute();
             rs=csmt.getResultSet();
                         
            while(rs.next())
            { System.out.println("true");
            lstcity.add(new Cities(rs));
                  
            }
            try {con.close();}catch (Exception e) {
    			// TODO: handle exception
    		}
        } 
        catch(Exception ex)
        {
            System.out.println("err="+ex.getMessage());
             
        }
    }
	public void getAreas(String city1,String state1)
    {
        try
        {
        	System.out.println("state="+city1);
             DBConnector obj=new  DBConnector();
            con=obj.connect();
            csmt=con.prepareCall("{call getarea(?,?)}");
           csmt.setString(1, state1);
           csmt.setString(2, city1);
             csmt.execute();
             rs=csmt.getResultSet();
                         
            while(rs.next())
            { System.out.println("true");
            lstarea.add(new Areas(rs));
                  
            }
            try {con.close();}catch (Exception e) {
    			// TODO: handle exception
    		}
        }  
        catch(Exception ex)
        {
            System.out.println("err="+ex.getMessage());
             
        }
    }
}

package models;

import java.sql.ResultSet;

public class Areas {
private String state,city,area;

public String getState() {
	return state;
}

public String getArea() {
	return area;
}

public void setArea(String area) {
	this.area = area;
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
public Areas(ResultSet rs)
{
	try
	{
	state=rs.getString("state").toString().trim();
	city=rs.getString("city").toString().trim();
	area=rs.getString("area").toString().trim();
	}
	catch (Exception e) {
		// TODO: handle exception
	}
}
}

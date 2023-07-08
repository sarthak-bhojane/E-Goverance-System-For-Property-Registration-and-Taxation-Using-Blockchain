
package services;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
 
import org.json.JSONArray;

import org.json.JSONException;
import org.json.JSONObject;

 
public class JsonReaderBing {

  private double lat,lng;
  
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

private static String readAll(Reader rd) throws IOException {
    StringBuilder sb = new StringBuilder();
    int cp;
    while ((cp = rd.read()) != -1) {
      sb.append((char) cp);
    }
    return sb.toString();
  }
public void GetLatNLng(String addr,String pin) throws IOException, JSONException {
 
	String[] str=addr.split("\\ ");
	String addr1="";
	for(int i=0;i<str.length;i++)
	{
		if(i==0)
			addr1+=str[i].trim();
		else
		addr1+="+"+str[i].trim();
	}
	String query="http://dev.virtualearth.net/REST/v1/Locations?countryRegion={India}&postalCode={"+pin+"}&addressLine={"+addr1+"}&key=Apglt97ySoKv9dx2GqyqWad3Np6uuVVmkNp4msMeA230RsDMpmd9SS3tQXdTo5gl";
             URL url = new URL(query);
             System.out.println("query="+query);
          
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.addRequestProperty("User-Agent", "Mozilla/4.76");
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
      InputStream is = conn.getInputStream();
    try {
      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
      String jsonText = readAll(rd);
      JSONObject json = new JSONObject(jsonText);
   //   System.out.println("json="+json.toString());
    // JSONArray jobj=new JSONArray(0);
  //  JSONArray jobj=json.getJSONArray("resourceSets");
   
 // System.out.println("json="+jobj.toString());
 
      
      JSONArray jobj=json.getJSONArray("resourceSets");
  JSONObject jobj1=jobj.getJSONObject(0);
   JSONArray jarr=jobj1.getJSONArray("resources");
   JSONObject jarrObj=jarr.getJSONObject(0);
   JSONObject jarrObj2=jarrObj.getJSONObject("point");
   JSONArray jarrArr1=jarrObj2.getJSONArray("coordinates");
  // System.out.println("json result="+jarr.toString());
 // System.out.println("json result="+jarrObj2.toString());
  System.out.println("Lat="+jarrArr1.getString(0));
  System.out.println("Lng="+jarrArr1.getString(1));
  lat=Double.parseDouble(jarrArr1.getString(0));
  lng=Double.parseDouble(jarrArr1.getString(1)); 
    } finally {
      is.close();
    }
  }
 
}
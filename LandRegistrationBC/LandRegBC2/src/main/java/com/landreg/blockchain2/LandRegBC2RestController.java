package com.landreg.blockchain2;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.landreg.blockchain2.models.Properties;
 
 
 

@RestController
public class LandRegBC2RestController {
	@RequestMapping(value = "/insertTransaction", method = RequestMethod.POST )
	public ResponseEntity getPendingApps(@RequestBody Properties response) {
		//List<CacheGroups> response = new ArrayList<CacheGroups>();
		System.out.println("in api cache "+response.getPropId()); 
	 
		try {
			response.insert();
		  
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("err in usergroupapi="+e.getMessage());
			 
		}
		return ResponseEntity.ok(response);
		 
	//	return Response.status(201).entity(result).build();
	}
	@RequestMapping(value = "/insertTransaction1", method = RequestMethod.POST )
	public ResponseEntity insertTransaction1(@RequestBody Properties response) {
		//List<CacheGroups> response = new ArrayList<CacheGroups>();
		System.out.println("in api cache "+response.getPropId()); 
	 
		try {
			response.insert();
		  
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("err in usergroupapi="+e.getMessage());
			 
		}
		return ResponseEntity.ok(response);
		 
	//	return Response.status(201).entity(result).build();
	}
}

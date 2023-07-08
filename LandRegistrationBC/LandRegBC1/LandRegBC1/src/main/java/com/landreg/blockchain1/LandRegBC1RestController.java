package com.landreg.blockchain1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.landreg.blockchain1.models.Properties;
import com.landreg.blockchain1.models.TaxTransactions;
 
 

@RestController
public class LandRegBC1RestController {
	@RequestMapping(value = "/GetTaxTransaction", method = RequestMethod.POST )
	public ResponseEntity GetTaxTransaction(@RequestBody TaxTransactions response) {
		//List<CacheGroups> response = new ArrayList<CacheGroups>();
		System.out.println("in api cache "+response.getPropId()); 
		//System.out.println("in api cache owner"+response.getPrevowner()); 
		
		try {
			  response.getTaxTransactions();
		
		  
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("err in usergroupapi="+e.getMessage());
			 
		}
		return ResponseEntity.ok(response);
		 
	//	return Response.status(201).entity(result).build();
	}
	@RequestMapping(value = "/GetPropTransaction", method = RequestMethod.POST )
	public ResponseEntity GetPropTransaction(@RequestBody Properties response) {
		//List<CacheGroups> response = new ArrayList<CacheGroups>();
		System.out.println("in api cache "+response.getPropId()); 
		//System.out.println("in api cache owner"+response.getPrevowner()); 
		
		try {
			  response.getPropTransactions();
		
		  
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("err in usergroupapi="+e.getMessage());
			 
		}
		return ResponseEntity.ok(response);
		 
	//	return Response.status(201).entity(result).build();
	}
	@RequestMapping(value = "/insertTransaction", method = RequestMethod.POST )
	public ResponseEntity getPendingApps(@RequestBody Properties response) {
		//List<CacheGroups> response = new ArrayList<CacheGroups>();
		System.out.println("in api cache "+response.getPropId()); 
		System.out.println("in api cache owner"+response.getPrevowner()); 
		 
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
	@RequestMapping(value = "/insertTaxTransaction", method = RequestMethod.POST )
	public ResponseEntity insertTaxTransaction(@RequestBody TaxTransactions response) {
		//List<CacheGroups> response = new ArrayList<CacheGroups>();
		System.out.println("in api cache "+response.getPropId()); 
	 
		try {
			System.out.println("yr="+ response.getTaxyear());
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

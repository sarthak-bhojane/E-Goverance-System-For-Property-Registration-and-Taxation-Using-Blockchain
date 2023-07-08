package services;

import java.util.List;
import java.util.Vector;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

 
 
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
 
import models.JavaFuns;
import models.Properties;
import models.TaxTransactions;
import models.TransferProp;
 

public class APIManager {
	
	public TaxTransactions GetTaxTrans( TaxTransactions input) {

		TaxTransactions output=new TaxTransactions();
		try {

			Client client = Client.create();
			System.out.println("in api");
		  
			  
			RestTemplate restTemplate=new RestTemplate();
			output= restTemplate.postForObject(
					  "http://localhost:8084/GetTaxTransaction/",
					  input,
					  TaxTransactions.class);
		 	//if (response.getStatus() != 201) {
			//	throw new RuntimeException("Failed : HTTP error code : "
			//	     + response.getStatus());
			//}

			System.out.println("Output from Server .... \n");
			 // output = response.getEntity(String.class);
			System.out.println(output.getPropId());
		 

		  } catch (Exception e) {
			  System.out.println("err="+e.getMessage());
			e.printStackTrace();

		  }
		return output;

		}
	public Properties GetPropTrans( Properties input) {

		Properties output=new Properties();
		try {

			Client client = Client.create();
			System.out.println("in api");
		  
			  
			RestTemplate restTemplate=new RestTemplate();
			output= restTemplate.postForObject(
					  "http://localhost:8084/GetPropTransaction/",
					  input,
					  Properties.class);
		 	//if (response.getStatus() != 201) {
			//	throw new RuntimeException("Failed : HTTP error code : "
			//	     + response.getStatus());
			//}

			System.out.println("Output from Server .... \n");
			 // output = response.getEntity(String.class);
			System.out.println(output.getPropId());
		 

		  } catch (Exception e) {
			  System.out.println("err="+e.getMessage());
			e.printStackTrace();

		  }
		return output;

		}
	public Properties insertPropTrans( Properties input) {

		Properties output=new Properties();
		try {

			Client client = Client.create();
			System.out.println("in api");
		  
			  
			RestTemplate restTemplate=new RestTemplate();
			output= restTemplate.postForObject(
					  "http://localhost:8084/insertTransaction/",
					  input,
					  Properties.class);
		 	//if (response.getStatus() != 201) {
			//	throw new RuntimeException("Failed : HTTP error code : "
			//	     + response.getStatus());
			//}

			System.out.println("Output from Server .... \n");
			 // output = response.getEntity(String.class);
			System.out.println(output.getPropId());
		 

		  } catch (Exception e) {
			  System.out.println("err="+e.getMessage());
			e.printStackTrace();

		  }
		return output;

		}
	public TaxTransactions insertTaxTrans( TaxTransactions input) {

		TaxTransactions output=new TaxTransactions();
		try {

			Client client = Client.create();
			System.out.println("in api");
		  
			  
			RestTemplate restTemplate=new RestTemplate();
			output= restTemplate.postForObject(
					  "http://localhost:8084/insertTaxTransaction/",
					  input,
					  TaxTransactions.class);
		 	//if (response.getStatus() != 201) {
			//	throw new RuntimeException("Failed : HTTP error code : "
			//	     + response.getStatus());
			//}

			System.out.println("Output from Server .... \n");
			 // output = response.getEntity(String.class);
			System.out.println(output.getPropId());
		 

		  } catch (Exception e) {
			  System.out.println("err="+e.getMessage());
			e.printStackTrace();

		  }
		return output;

		}
	public TransferProp insertPropTrans1( TransferProp input) {

		TransferProp output=new TransferProp();
		try {

			Client client = Client.create();
			System.out.println("in api");
		  
			  
			RestTemplate restTemplate=new RestTemplate();
			output= restTemplate.postForObject(
					  "http://localhost:8084/insertTransaction1/",
					  input,
					  TransferProp.class);
		 	//if (response.getStatus() != 201) {
			//	throw new RuntimeException("Failed : HTTP error code : "
			//	     + response.getStatus());
			//}

			System.out.println("Output from Server .... \n");
			 // output = response.getEntity(String.class);
			System.out.println(output.getPropId());
			System.out.println(output.getPusername());
			System.out.println(input.getPusername());
		  } catch (Exception e) {
			  System.out.println("err="+e.getMessage());
			e.printStackTrace();

		  }
		return output;

		}
}

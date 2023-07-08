package land.blockchain;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import models.CheckUser;
import models.JavaFuns;
import models.Offices;
import models.Properties;
import models.TaxCalculation;
import models.TaxTransactions;
import models.TransferProp;
import models.Users;
import models.ViewOffice;
import services.APIManager;
import services.Base64Decoder;
import services.Mail;

@Controller
public class LandRegController implements ErrorController {
	@RequestMapping("/error")
    public String handleError() {
        //do something like logging
		return "home";
    }
    @RequestMapping("/officer")
	public String officer()
	{
		return "officer.jsp";
	}
	@RequestMapping("/home")
	public String home()
	{
		return "index.jsp";
	}
	
	@RequestMapping("transProp")
	public ModelAndView purchaseProp(TransferProp prop)
	{
		ModelAndView mv=new ModelAndView();
		mv.addObject("puserid",prop.getPuserid());
		JavaFuns jf=new JavaFuns();
		Vector v=jf.getValue("select usernm from users where userid='"+prop.getPuserid()+"'", 1);
		mv.addObject("pusername",v.elementAt(0).toString().trim());
		mv.addObject("title",prop.getTitle());
		mv.addObject("propId",prop.getPropId());
		mv.setViewName("purchaseProp.jsp");
		return mv;
	}
	@RequestMapping("regproperty")
	public String regproperty()
	{
		return "RegProperty.jsp";
	}
	
	@RequestMapping("/ProcessTaxPayment")
	public ModelAndView ProcessTaxPayment(TaxTransactions prop,HttpSession ses)
	{
		ModelAndView mv=new ModelAndView();
	 try {
		 prop.process();
		 JavaFuns jf=new JavaFuns();
		 Vector v= jf.getValue("select u.usernm,u.emailid from userdetails u where u.userid='"+prop.getUserid()+"'" , 2);
		 String msg="Dear "+v.elementAt(0).toString().trim()+",  Tax Payment '"+prop.getTitle()+"' has been "+prop.getSts()+" by area admin.";
		 Mail mail=new Mail();
		 System.out.println("yr="+prop.getTaxyear()+" "+prop.getTaxamt());
		  APIManager api=new APIManager();
		  api.insertTaxTrans(prop);
		 if(mail.sendMail(msg, v.elementAt(1).toString().trim(), "Property Transfer Status")) {}
		 mv.setViewName("Success.jsp");
	 }
	 catch (Exception e) {
			// TODO: handle exception
		 mv.setViewName("Failure.jsp");
		}
	 if(prop.getSts().equals("approved"))
	 {
		 mv.addObject("activity","taxApproved");	 
	 }
	 else
	 {
		 mv.addObject("activity","taxDeclined");
	 }
	 
	 return mv;
	}
	@RequestMapping("/ProcessTransferReq")
	public ModelAndView ProcessTransferReq(TransferProp prop,HttpSession ses)
	{
		ModelAndView mv=new ModelAndView();
	 try {
		 prop.process();
		 JavaFuns jf=new JavaFuns();
		 Vector v= jf.getValue("select u.usernm,u.emailid from userdetails u where u.userid='"+prop.getUserid()+"'" , 2);
		 String msg="Dear "+v.elementAt(0).toString().trim()+",  property '"+prop.getTitle()+"' has been "+prop.getSts()+" by owner. The transfer request has been sent to the area admin.";
		 Mail mail=new Mail();
		   
		 if(mail.sendMail(msg, v.elementAt(1).toString().trim(), "Property Transfer Status")) {}
		 mv.setViewName("Success.jsp");
	 }
	 catch (Exception e) {
			// TODO: handle exception
		 mv.setViewName("Failure.jsp");
		}
	 if(prop.getSts().equals("partial_approved"))
	 {
		 mv.addObject("activity","proptransApproved");	 
	 }
	 else
	 {
		 mv.addObject("activity","proptransDeclined");
	 }
	 
	 return mv;
	}
	@RequestMapping("/ProcessTransferReq1")
	public ModelAndView ProcessTransferReq1(TransferProp prop,HttpSession ses)
	{
		ModelAndView mv=new ModelAndView();
	 try {
		 prop.process1();
		 
		 JavaFuns jf=new JavaFuns();
		 Vector v= jf.getValue("select u.usernm,u.emailid from userdetails u where u.userid='"+prop.getUserid()+"'" , 2);
		 String msg="Dear "+v.elementAt(0).toString().trim()+",  property '"+prop.getTitle()+"' has been "+prop.getSts()+" by area admin. ";
		 Mail mail=new Mail();
		 APIManager api=new APIManager();
		 System.out.println("puserid="+prop.getPuserid());
		 prop.setProcessedby(ses.getAttribute("userid").toString().trim());
		 prop.setPusername(prop.getPuserid());
		 prop.setPrevowner(prop.getPuserid());
		 api.insertPropTrans1(prop);
		 if(mail.sendMail(msg, v.elementAt(1).toString().trim(), "Property Transfer Status")) {}
		 mv.setViewName("Success.jsp");
	 }
	 catch (Exception e) {
			// TODO: handle exception
		 mv.setViewName("Failure.jsp");
		}
	 if(prop.getSts().equals("approved"))
	 {
		 mv.addObject("activity","proptransApproved");	 
	 }
	 else
	 {
		 mv.addObject("activity","proptransDeclined");
	 }
	 
	 return mv;
	}
	@RequestMapping("/updateProp")
	public ModelAndView Approve(Properties prop,HttpSession ses)
	{
		ModelAndView mv=new ModelAndView();
	 try {
		 prop.approve();
		 JavaFuns jf=new JavaFuns();
		 Vector v= jf.getValue("select u.usernm,u.emailid,p.title from userdetails u inner join properties p  on u.userid=p.userid and p.propId="+prop.getPropId() , 3);
		 String msg="Dear "+v.elementAt(0).toString().trim()+", your property '"+v.elementAt(2).toString().trim()+"' has been "+prop.getSts();
		 Mail mail=new Mail();
		 prop.setPrevowner("NA");
		 prop.setProcessedby(ses.getAttribute("userid").toString().trim());
		 System.out.println("title="+prop.getTitle());
		 System.out.println("title="+prop.getUserid());
		 
		 APIManager api=new APIManager();
		 api.insertPropTrans(prop);
		 if(mail.sendMail(msg, v.elementAt(1).toString().trim(), "Property Activation")) {}
		 mv.setViewName("Success.jsp");
	 }
	 catch (Exception e) {
			// TODO: handle exception
		 mv.setViewName("Failure.jsp");
		}
	 if(prop.getSts().equals("approved"))
	 {
		 mv.addObject("activity","propApproved");	 
	 }
	 else
	 {
		 mv.addObject("activity","propDeclined");
	 }
	 
	 return mv;
	}
	@RequestMapping("/ViewTax")
	@SessionScope
	public ModelAndView ViewTax(HttpSession ses,HttpServletRequest request) {
		
		List<TaxTransactions> lst = new ArrayList<TaxTransactions>();
		TaxTransactions vs = new TaxTransactions();
		JavaFuns jf=new JavaFuns();
		Vector v=jf.getValue("select title from properties where propId="+request.getParameter("propId").trim(), 1);
		vs.setTitle(v.elementAt(0).toString().trim());
		vs.setPropId(Integer.parseInt(request.getParameter("propId").toString().trim()));
		vs.setUserid(ses.getAttribute("userid").toString().trim());
		vs.calculateTax();
		lst=vs.getTaxList(ses.getAttribute("userid").toString().trim(),request.getParameter("propId").toString().trim());
		ModelAndView mv=new ModelAndView();
		mv.addObject("std",lst);
		System.out.println("lst="+lst.size());
		mv.setViewName("ViewTax.jsp");
		return mv;
	}
	@RequestMapping("/viewOffice")
	@SessionScope
	public ModelAndView viewOffice() {
		
		List<ViewOffice> lst = new ArrayList<ViewOffice>();
		ViewOffice vs = new ViewOffice();
		lst=vs.getOfficeList();
		ModelAndView mv=new ModelAndView();
		mv.addObject("std",lst);
		System.out.println("lst="+lst.size());
		mv.setViewName("ViewOfficeReport.jsp");
		return mv;
	}
	
	@RequestMapping("/SubmitTaxPayment")
	public ModelAndView SubmitTaxPayment(TaxTransactions stu,ServletRequest request)
	{
		ModelAndView mv=new ModelAndView();
		 try
		 {MultipartFile file=stu.getFile();
		 String filepath=request.getServletContext().getRealPath("/")+"/TaxPayments/";
		 
		 
		 System.out.println("path="+filepath);
		 File f=new File(filepath);
		 f.mkdir();
		  
		 try {
			  
			 String fileName= stu.getTid()+"."+ file.getOriginalFilename().split("\\.")[1];
			 file.transferTo(new File(filepath+"/"+fileName));
			 stu.setReceipt(fileName);
			    
				if(stu.update())
					mv.setViewName("Success.jsp");
				else
					mv.setViewName("Failure.jsp");
		 }
		 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
			 mv.setViewName("Failure.jsp");
		}}
		 catch (Exception e) {
				// TODO: handle exception
			 e.printStackTrace();
			 mv.setViewName("Failure.jsp");
			}
		 mv.addObject("activity","taxpayment");
		 return mv;
		
	}
	@RequestMapping("/transferProp")
	public ModelAndView transferProp(TransferProp stu,ServletRequest request)
	{
		ModelAndView mv=new ModelAndView();
		 try
		 {MultipartFile file=stu.getFile();
		 String filepath=request.getServletContext().getRealPath("/")+"/Properties/"+stu.getPropId()+"/";
		 
		 
		 System.out.println("path="+filepath);
		 File f=new File(filepath);
		 f.mkdir();
		  
		 try {
			  
			 String fileName="transferDocs_"+stu.getPropId()+"."+ file.getOriginalFilename().split("\\.")[1];
			 file.transferTo(new File(filepath+"/"+fileName));
			 stu.setProofPath(fileName);
			    
				if(stu.insert())
					mv.setViewName("Success.jsp");
				else
					mv.setViewName("Failure.jsp");
		 }
		 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
			 mv.setViewName("Failure.jsp");
		}}
		 catch (Exception e) {
				// TODO: handle exception
			 e.printStackTrace();
			 mv.setViewName("Failure.jsp");
			}
		 mv.addObject("activity","proptransfered");
		 return mv;
		
	}
	@RequestMapping("/regTaxDetails")
	public ModelAndView regTaxDetails(TaxCalculation stu,ServletRequest request)
	{
		ModelAndView mv=new ModelAndView();
		  
		 try {
			  
			 
			 String st=stu.insert();
			 System.out.println("sts="+st);
				if(st.equals("success"))
					mv.setViewName("Success.jsp");
				else
					mv.setViewName("Failure.jsp");
		 }
		 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
			 mv.setViewName("Failure.jsp");
		} 
		 mv.addObject("activity","TaxReg");
		 return mv;
		
	}
	@RequestMapping("/registerOffice")
	public ModelAndView registerdealer(Offices stu,ServletRequest request)
	{
		ModelAndView mv=new ModelAndView();
		 try
		 {MultipartFile file=stu.getFile();
		 String filepath=request.getServletContext().getRealPath("/")+"/UploadsOffice/";
		 
		 
		 System.out.println("path="+filepath);
		 File f=new File(filepath);
		 f.mkdir();
		  
		 try {
			  
			 String fileName=stu.getUserid()+"."+ file.getOriginalFilename().split("\\.")[1];
			 file.transferTo(new File(filepath+"/"+fileName));
			 stu.setPath(fileName);
			 String st=stu.addNewUser();
			 System.out.println("sts="+st);
				if(st.equals("success"))
					mv.setViewName("Success.jsp");
				else
					mv.setViewName("Failure.jsp");
		 }
		 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
			 mv.setViewName("Failure.jsp");
		}}
		 catch (Exception e) {
				// TODO: handle exception
			 e.printStackTrace();
			 mv.setViewName("Failure.jsp");
			}
		 mv.addObject("activity","OfficeReg");
		 return mv;
		
	}
	@RequestMapping("/Decline")
	public ModelAndView Decline(Properties prop)
	{
		ModelAndView mv=new ModelAndView();
	 try {
		 prop.decline();
		 mv.setViewName("Success.jsp");
	 }
	 catch (Exception e) {
			// TODO: handle exception
		 mv.setViewName("Failure.jsp");
		}
	 mv.addObject("activity","propDeclined");
	 return mv;
	}
	@RequestMapping("/regOffice")
	public String registration1()
	{
		return "Register.jsp";
	}
	@RequestMapping("/uploadDataset")
	public String uploadDataset()
	{
		return "RegDataset.jsp";
	}
	
	 @RequestMapping("/datasetInsrtPython")
		public ModelAndView datasetInsrtPython(HttpServletRequest request) {
			ModelAndView mv=new ModelAndView();
		 	String sts=request.getParameter("sts").toString().trim() ;
			if(sts.equals("success"))
				 mv.setViewName("Success.jsp?type=datasetInsrt");
			else
				 mv.setViewName("Failure.jsp?type=datasetInsrt");
			mv.addObject("activity","datasetReg");
			 return mv;
		}
	@RequestMapping("/registeruser")
	public ModelAndView registeruser(Users stu,ServletRequest request)
	{
		ModelAndView mv=new ModelAndView();
		 try
		 {MultipartFile file=stu.getFile();
		 String filepath=request.getServletContext().getRealPath("/")+"/Uploads/";
		 
		 
		 System.out.println("path="+filepath);
		 File f=new File(filepath);
		 f.mkdir();
		  
		 try {
			  
			 String fileName=stu.getUserid()+"."+ file.getOriginalFilename().split("\\.")[1];
			 file.transferTo(new File(filepath+"/"+fileName));
			 stu.setPath(fileName);
			 String st=stu.addNewUser();
				if(st.equals("success"))
					mv.setViewName("Success.jsp");
				else
					mv.setViewName("Failure.jsp");
		 }
		 catch (Exception e) {
			// TODO: handle exception
			 mv.setViewName("Failure.jsp");
		}}
		 catch (Exception e) {
				// TODO: handle exception
			 mv.setViewName("Failure.jsp");
			}
		 mv.addObject("activity","UserReg");
		 return mv;
		
	}
	@RequestMapping("/propReg")
	public ModelAndView propReg(Properties stu,ServletRequest request)
	{
		ModelAndView mv=new ModelAndView();
		 try
		 {
			 JavaFuns jf=new JavaFuns();
				Vector v=jf.getValue("select (ifnull(max(propId),1000)+1) as mxid from properties",1);
				int mxid=Integer.parseInt(v.elementAt(0).toString().trim());
			
			 MultipartFile file=stu.getFile();
			 String filepath=request.getServletContext().getRealPath("/")+"/Properties/" ;
		 MultipartFile file1=stu.getFile1();
		  
		 
		 System.out.println("path="+filepath);
		 File f=new File(filepath);
		 
		 f.mkdir();
		 filepath=request.getServletContext().getRealPath("/")+"/Properties/"+mxid+"/";
		 f=new File(filepath);
		 
		 f.mkdir();
		 try {
				
			 String fileName="prop_photo_"+mxid+"_1."+ file.getOriginalFilename().split("\\.")[1];
			 file.transferTo(new File(filepath+"/"+fileName));
			 String fileName1="propdoc_"+mxid+"."+ file.getOriginalFilename().split("\\.")[1];
			 file1.transferTo(new File(filepath+"/"+fileName1));
			 stu.setPath(fileName);
			 stu.setDoc(fileName1);
			 String st=stu.addNewProperty();
				if(st.equals("success"))
					mv.setViewName("Success.jsp");
				else
					mv.setViewName("Failure.jsp");
		 }
		 catch (Exception e) {
			// TODO: handle exception
			 mv.setViewName("Failure.jsp");
		}}
		 catch (Exception e) {
				// TODO: handle exception
			 mv.setViewName("Failure.jsp");
			}
		 mv.addObject("activity","PropReg");
		 return mv;
		
	}
	 
	@RequestMapping("/admin")
	public String admin()
	{
		return "admin.jsp";
	}
	@RequestMapping("/user")
	public String user()
	{
		return "user.jsp";
	}
	@RequestMapping("/")
	public String home1()
	{
		return "index.jsp";
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
        session.invalidate();
		return "Logout.jsp";
	}
	@RequestMapping("/GetProperties")
	public ModelAndView GetUsers(HttpServletRequest request)
	{
		 
		ModelAndView mv = new ModelAndView();
		Properties obj=new Properties();
		 javax.servlet.http.HttpSession ses=request.getSession(true);
		 List<Properties> lst=obj.getPropSearch( request.getParameter("searchText").toString().trim()  );
		 
		mv.setViewName("GetProps.jsp");
		mv.addObject("lst",lst); 
		return mv;
	 
	}
	@RequestMapping("/UploadPhotosPython")
	public ModelAndView UploadPhotosPython()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("Success.jsp");
		mv.addObject("activity","photos");
		return mv;
	}
	@RequestMapping("/FromPython")
	public ModelAndView FromPython()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("Success.jsp");
		mv.addObject("activity","propreg");
		return mv;
	}
	@RequestMapping("/Cities")
	public String cities()
	{
		return "Cities.jsp";
	}
	@RequestMapping("/Areas")
	public String Areas()
	{
		return "Areas.jsp";
	}
	@RequestMapping("/registration")
	public String registration()
	{
		return "Registration.jsp";
	}
	@RequestMapping("/viewUsers")
	@SessionScope
	public ModelAndView viewUsers() {
		
		List<Users> lst = new ArrayList<Users>();
		Users vs = new Users();
		lst=vs.getStudentReport();
		ModelAndView mv=new ModelAndView();
		mv.addObject("std",lst);
		mv.setViewName("ViewUsersReport.jsp");
		return mv;
	}
	@RequestMapping("/viewPendingProperties")
	@SessionScope
	public ModelAndView viewPendingProperties(HttpSession ses) {
		
		List<Properties> lst = new ArrayList<Properties>();
		Properties vs = new Properties();
		lst=vs.getPendingProperties(ses.getAttribute("area").toString().trim());
		ModelAndView mv=new ModelAndView();
		mv.addObject("std",lst);
		mv.setViewName("ViewPendingProperties.jsp");
		return mv;
	}
	@RequestMapping("/ViewTaxDefaulters")
	@SessionScope
	public ModelAndView ViewTaxDefaulters(HttpServletRequest request, HttpSession ses) {
		
		List<TaxTransactions> lst = new ArrayList<TaxTransactions>();
		TaxTransactions vs = new TaxTransactions();
		 
		 
		lst=vs.getDefaulters(ses.getAttribute("area").toString().trim(),ses.getAttribute("city").toString().trim());
		 
		ModelAndView mv=new ModelAndView();
		mv.addObject("std",lst);
		mv.setViewName("ViewTaxDefaulters.jsp");
		return mv;
	}
	@RequestMapping("/ViewTaxHistory")
	@SessionScope
	public ModelAndView ViewTaxHistory(HttpServletRequest request, HttpSession ses) {
		
		List<TaxTransactions> lst = new ArrayList<TaxTransactions>();
		TaxTransactions vs = new TaxTransactions();
		APIManager api=new APIManager();
		vs.setPropId(Integer.parseInt(request.getParameter("propId").trim()));
		vs=api.GetTaxTrans(vs);
		lst=vs.getLst();
		ModelAndView mv=new ModelAndView();
		mv.addObject("std",lst);
		mv.setViewName("ViewTaxHistory.jsp");
		return mv;
	}
	@RequestMapping("/ViewPropHistory")
	@SessionScope
	public ModelAndView ViewPropHistory(HttpServletRequest request, HttpSession ses) {
		
		List<Properties> lst = new ArrayList<Properties>();
		Properties vs = new Properties();
		APIManager api=new APIManager();
		vs.setPropId(request.getParameter("propId").trim());
		vs=api.GetPropTrans(vs);
		lst=vs.getLst();
		ModelAndView mv=new ModelAndView();
		mv.addObject("std",lst);
		mv.setViewName("ViewPropHistory.jsp");
		return mv;
	}
	@RequestMapping("/viewPropertiesOfficer")
	@SessionScope
	public ModelAndView viewPropertiesOfficer(HttpSession ses) {
		
		List<Properties> lst = new ArrayList<Properties>();
		Properties vs = new Properties();
		lst=vs.getApprovedProperties(ses.getAttribute("area").toString().trim());
		ModelAndView mv=new ModelAndView();
		mv.addObject("std",lst);
		mv.setViewName("ViewPropertiesOfficer.jsp");
		return mv;
	}
	@RequestMapping("/viewPendingTaxpayment")
	@SessionScope
	public ModelAndView viewPendingTaxpayment(HttpSession ses) {
		
		List<TaxTransactions> lst = new ArrayList<TaxTransactions>();
		TaxTransactions vs = new TaxTransactions();
		lst=vs.getPendingPayment(ses.getAttribute("city").toString().trim(),ses.getAttribute("area").toString().trim());
		ModelAndView mv=new ModelAndView();
		mv.addObject("std",lst);
		System.out.println("lst size="+lst.size());
		mv.setViewName("ViewPendingTaxPayment.jsp");
		return mv;
	}
	@RequestMapping("/viewPATransferProp")
	@SessionScope
	public ModelAndView viewPATransferProp(HttpSession ses) {
		
		List<TransferProp> lst = new ArrayList<TransferProp>();
		TransferProp vs = new TransferProp();
		lst=vs.getPATransferReq(ses.getAttribute("area").toString().trim());
		ModelAndView mv=new ModelAndView();
		mv.addObject("std",lst);
		mv.setViewName("ViewPATransferRequest.jsp");
		return mv;
	}
	@RequestMapping("/viewPendingTransferProp")
	@SessionScope
	public ModelAndView viewPendingTransferProp(HttpSession ses) {
		
		List<TransferProp> lst = new ArrayList<TransferProp>();
		TransferProp vs = new TransferProp();
		lst=vs.getPendingTransferReq(ses.getAttribute("userid").toString().trim());
		ModelAndView mv=new ModelAndView();
		mv.addObject("std",lst);
		mv.setViewName("ViewPendingTransferRequest.jsp");
		return mv;
	}
	@RequestMapping("/viewProperties")
	@SessionScope
	public ModelAndView viewProperties(HttpSession ses) {
		
		List<Properties> lst = new ArrayList<Properties>();
		Properties vs = new Properties();
		lst=vs.getMyPropsReport(ses.getAttribute("userid").toString().trim());
		ModelAndView mv=new ModelAndView();
		mv.addObject("std",lst);
		mv.setViewName("ViewPropertiesReport.jsp");
		return mv;
	}
	@RequestMapping("/adminHome")
	public String adminHome()
	{
		return "admin.jsp";
	}
	@RequestMapping("/decisionTreeOutput")
	public ModelAndView decisionTreeOutput(HttpServletRequest request)
	{
		ModelAndView mv=new ModelAndView();
		Base64Decoder decoder=new Base64Decoder();
		String str=new String(decoder.decode(request.getParameter("param").toString().trim()));
		System.out.println("output"+str);
		String userid=str.split("\\|")[0];
		String requserid=str.split("\\|")[1];
		String output=str.split("\\|")[2];
		output=output.replace("[", "");
		output=output.replace("]", "");
		System.out.println("output="+output);
		String access="failure";
		if(output.trim().equals("1"))
		{
			access="success";
		}
		 
		return mv;
	}
	 
	@RequestMapping("/check")
	public String check(CheckUser cu,HttpServletRequest request) {
		String userid=request.getParameter("userid").toString().trim();
		String pswd=request.getParameter("pswd").toString().trim();
		cu.setUserid(userid);
		cu.setPswd(pswd);
		String st=cu.checkUser(request);
		System.out.println(st);
		return st;
	}	 
}

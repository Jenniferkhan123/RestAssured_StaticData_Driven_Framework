package Test_Classes;

import org.testng.Assert;

import Common_API_Methods.Patch_API_Method;
import Request_Repository.Patch_Req_Repository;
import io.restassured.path.json.JsonPath;

public class Patch_TC1 {
	public static void execute() {
  	  int statusCode = Patch_API_Method.ResponseStatusCode(Patch_Req_Repository.BaseURI(),Patch_Req_Repository.Patch_Response(),Patch_Req_Repository.Patch_Req_TC1());
  	  System.out.println(statusCode);
    
    String ResponseBody = Patch_API_Method.ResponseBody(Patch_Req_Repository.BaseURI(),Patch_Req_Repository.Patch_Response(),Patch_Req_Repository.Patch_Req_TC1());
	  //System.out.println(ResponseBody);
	  
	  JsonPath JspResponse = new JsonPath(ResponseBody);
    String Res_name = JspResponse.getString("name");
    System.out.println(Res_name);
    
    String Res_job = JspResponse.getString("job");
    System.out.println(Res_job);
    
    String Res_updatedAt = JspResponse.getString("updatedAt");
    System.out.println(Res_updatedAt);
    
    Assert.assertEquals(Res_name, "morpheus");
    Assert.assertEquals(Res_job, "zion resident");
}
}

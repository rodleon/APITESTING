package TestCase;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;


public class TC_APITest {
	
	
	int id;
	
	
	@Test(priority=1)
	void test_getAllEmployees() 
	{
	
		given()
		
			.when()
				.get("https://dummy.restapiexample.com/api/v1/employees")
			.then()
				.statusCode(200)
				.body("status", equalTo("success"))
				.log().all();
		
	}

	
	//@Test(priority=2)
	void test_addemployee()
	
	{
		
				HashMap data = new HashMap();
				data.put("id", "id");
				data.put("employee_name", "Leo Messi");
				data.put("employee_salary", 786000);
				data.put("employee_age", 34);
				data.put("profile_image", "");
		
			id=given()
				
				.contentType("application/json")
				.body(data)
				
				
			.when()
			
				.post("https://dummy.restapiexample.com/api/v1/create/")
				.jsonPath().getInt("id");
				
				
			//.then()
				//.statusCode(200)
				//.log().all();
		
	}
	
	
	@Test(priority=3)
	void updateEmloyee() {
		
					HashMap data = new HashMap();
					data.put("employee_name", "CR7");
					data.put("employee_salary", 560000);
					data.put("employee_age", 36);
					data.put("profile_image", "");

			given()
				.contentType("application/json")
				.body(data)
				
				
			.when()
				.put("https://dummy.restapiexample.com/api/v1/update/"+id)
				
				
		
			.then()
				.statusCode(200)
				.log().all();
		
		
	}
	
	
	
	
}

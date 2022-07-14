package com.nutritionist.api_control;

import com.nutritionist.api_control.service.DataService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ApiControlApplicationTests {
	@Autowired
	private DataService dataService;


	@Test
	@Order(3)
	public void fetchRecomendedData(){

		var output = dataService.recomendConsumeApi("https://api.nal.usda.gov/fdc/v1/foods/list?dataType=Foundation,SR%20Legacy&api_key=qqgiaSPX1eVDkb7mkUg3kSmptZZA1RZGphyVHQhh");
		assertTrue(!output.isEmpty());
	}

	@Test
	@Order(4)
	public void searchData(){
		String q = "apple";
		var output = dataService.consumeApi("https://api.nal.usda.gov/fdc/v1/foods/search?query="+q+"&api_key=qqgiaSPX1eVDkb7mkUg3kSmptZZA1RZGphyVHQhh");
		assertNotNull(output);
	}

}

package com.pricesApi.integration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
class PriceControllerIntegrationTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void getproductPriceByDate1() throws Exception {
		String expResult = "{\"id\":1,\"productId\":35455,\"brandId\":1,\"priceList\":1,\"startDate\":\"2020-06-14T00:00:00\",\"endDate\":\"2020-12-31T23:59:59\",\"price\":35.5,\"curr\":\"EUR\"}";
		MvcResult result = mockMvc.perform(get("/prices/productPriceByDate").
				param("productId", "35455").
				param("brandId", "1").
				param("date", "2020-06-14T10:00:00Z").accept(MediaType.APPLICATION_JSON)).andReturn();
		Assertions.assertEquals(expResult, result.getResponse().getContentAsString());
	}

	@Test
	public void getProductPriceByDate2() throws Exception {
		String expResult = "{\"id\":2,\"productId\":35455,\"brandId\":1,\"priceList\":2,\"startDate\":\"2020-06-14T15:00:00\",\"endDate\":\"2020-06-14T18:30:00\",\"price\":25.45,\"curr\":\"EUR\"}";
		MvcResult result = mockMvc.perform(get("/prices/productPriceByDate").
				param("productId", "35455").
				param("brandId", "1").
				param("date", "2020-06-14T16:00:00Z").accept(MediaType.APPLICATION_JSON)).andReturn();
		Assertions.assertEquals(expResult, result.getResponse().getContentAsString());
	}

	@Test
	public void getProductPriceByDate3() throws Exception {
		String expResult = "{\"id\":1,\"productId\":35455,\"brandId\":1,\"priceList\":1,\"startDate\":\"2020-06-14T00:00:00\",\"endDate\":\"2020-12-31T23:59:59\",\"price\":35.5,\"curr\":\"EUR\"}";
		MvcResult result = mockMvc.perform(get("/prices/productPriceByDate").
				param("productId", "35455").
				param("brandId", "1").
				param("date", "2020-06-14T21:00:00Z").accept(MediaType.APPLICATION_JSON)).andReturn();
		Assertions.assertEquals(expResult, result.getResponse().getContentAsString());
	}

	@Test
	public void getProductPriceByDate4() throws Exception {
		String expResult = "{\"id\":3,\"productId\":35455,\"brandId\":1,\"priceList\":3,\"startDate\":\"2020-06-15T00:00:00\",\"endDate\":\"2020-06-15T11:00:00\",\"price\":30.5,\"curr\":\"EUR\"}";
		MvcResult result = mockMvc.perform(get("/prices/productPriceByDate").
				param("productId", "35455").
				param("brandId", "1").
				param("date", "2020-06-15T10:00:00Z").accept(MediaType.APPLICATION_JSON)).andReturn();
		Assertions.assertEquals(expResult, result.getResponse().getContentAsString());
	}

	@Test
	public void getProductPriceByDate5() throws Exception {
		String expResult = "{\"id\":4,\"productId\":35455,\"brandId\":1,\"priceList\":4,\"startDate\":\"2020-06-15T16:00:00\",\"endDate\":\"2020-12-31T23:59:59\",\"price\":38.95,\"curr\":\"EUR\"}";
		MvcResult result = mockMvc.perform(get("/prices/productPriceByDate").
				param("productId", "35455").
				param("brandId", "1").
				param("date", "2020-06-16T21:00:00Z").accept(MediaType.APPLICATION_JSON)).andReturn();
		Assertions.assertEquals(expResult, result.getResponse().getContentAsString());
	}

	@Test
	public void getProductPriceByDateKo() throws Exception {
		MvcResult result = mockMvc.perform(get("/prices/productPriceByDate").
				param("brandId", "1").
				param("date", "2020-06-16T21:00:00Z").accept(MediaType.APPLICATION_JSON)).andReturn();
		Assertions.assertEquals(HttpStatus.BAD_REQUEST.value(),result.getResponse().getStatus());
	}

	@Test
	public void getProductPriceByDateEmpty() throws Exception {
		MvcResult result = mockMvc.perform(get("/prices/productPriceByDate").
				param("productId", "35455").
				param("brandId", "1").
				param("date", "2020-06-13T12:00:00Z").accept(MediaType.APPLICATION_JSON)).andReturn();
		Assertions.assertEquals("", result.getResponse().getContentAsString());
	}
}

import static com.jayway.restassured.RestAssured.expect;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;
import org.nick.dao.ItemDAO;
import org.nick.entities.Item;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;


public class ItemTest {
	
	public static Response response;
	public static String jsonAsString;
	
	 @BeforeClass
	 public void setUp() {
	 RestAssured.baseURI =
	 "http://localhost:8080/EclipseLinkTutorial/rest/ItemService";
	 }
	//
	// @Test
	// public void testGetItemId() {
	// expect().statusCode(200).contentType(ContentType.JSON).when().get("/getItem/2");
	// }

	@Test
	public void testGetItem() {
		expect().statusCode(200).contentType("application/json").body("id", equalTo(2))
				.body("itemCategory", equalTo("DAIRY")).body("itemCount", equalTo(1))
				.body("itemDescription", equalTo("2%")).body("itemName", equalTo("MILK")).body("itemPrice", equalTo(3))
				.body("itemUnitType", equalTo("GAL")).when()
				.get("http://localhost:8080/EclipseLinkTutorial/rest/ItemService/getItem/2");
	}

	@Test
	public void testGetItems() {
		expect().statusCode(200).contentType("application/json").body("id", equalTo(2))
		.body("itemCategory", equalTo("DAIRY")).body("itemCount", equalTo(1))
		.body("itemDescription", equalTo("2%")).body("itemName", equalTo("MILK")).body("itemPrice", equalTo(3))
		.body("itemUnitType", equalTo("GAL")).when()
		.get("http://localhost:8080/EclipseLinkTutorial/rest/ItemService/getItems");
	}
	
//	@Test
//	public static void testSize() {
//		response = expect().when().get("/getItems").then().contentType(ContentType.JSON).extract().response();
//		jsonAsString = response.asString();
//		ArrayList<Map<String, ?>> jsonAsArrayList = from(jsonAsString).get("");
//		
//		assertEquals(jsonAsArrayList.size(), equalTo(6));
//	}
	
	@Test
	public void testAddItem() {
		Item item = new Item("DRY GOODS", 4, "THEIR MAGICALLY DELICIOUS", "LUCKY CHARMS", new BigDecimal(100), "OZ");
		ItemDAO iDAO = new ItemDAO();

		List<Item> itemList = iDAO.getItems();

		int numberOfItems = itemList.size();

		iDAO.addItem(item);

		assertEquals(itemList.size(), numberOfItems);
	}

	@Test
	public void testRemoveItem() {
		ItemDAO iDAO = new ItemDAO();

		List<Item> itemList = iDAO.getItems();

		int index = itemList.size() - 1;
		
		itemList.remove(index);

		int numberOfItems = itemList.size();

		assertEquals(itemList.size(), numberOfItems);
	}
}

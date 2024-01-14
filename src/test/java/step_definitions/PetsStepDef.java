package step_definitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.response.ResponseBody;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dto.Owner;
import dto.Pet;
import dto.Type;
import dto.Vet;
import dto.Visit;
import org.junit.Assert;
import support.MyConfig;
import support.SupportFunctions;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PetsStepDef {

	private static ResponseBody body;

	@When("^I want to know all the pets in the clinic$")
	public void i_want_to_know_all_the_pets_in_the_clinic() throws Throwable {
		body = SupportFunctions.get(MyConfig.Endpoint + "api/pets");
		System.out.println(body.asString());

	}

	@Then("^I should receive 14 pets$")
	public void i_should_receive_pets() throws Throwable {
		Pet[] petsDTO = SupportFunctions.convertResponseArray(Pet[].class);
		int amountOfPets = petsDTO.length;
		Assert.assertEquals("the amount of pets is 14 | ",14,amountOfPets);
	}

	@Given("^I have the owner details$")
	public void i_have_the_owner_details() throws Throwable {
		body = SupportFunctions.get(MyConfig.Endpoint + "api/owners");
	}

	@And("^I have id and name of pets category$")
	public void i_have_id_and_name_of_pets_category() throws Throwable {
		body = SupportFunctions.get(MyConfig.Endpoint + "api/pettypes");
	}

	@When("^I send correct owner details with pet type and visit	details to add a new pet$")
	public void i_send_correct_owner_details_with_pet_type_and_visit_details_to_add_a_new_pet(DataTable table)throws Throwable{

		int ownerID=0,petTypeID=0,petID=0;
		String firstName="",lastName="",address="",city="",telephone="",petTypeName="",petName="",petDOB="";

		List<Map<String, String>> rows = table.asMaps(String.class, String.class);
		//|OwnerID|FirstName|LastName|Address|City|Telephone|PetTypeID|PetTypeName|PetID|PetName|
		for (Map<String, String> columns : rows) 
		{
			ownerID = Integer.parseInt(columns.get("OwnerID"));
			firstName = columns.get("FirstName");
			lastName = columns.get("LastName");
			address = columns.get("Address");
			city = columns.get("City");
			telephone = columns.get("Telephone");
			petTypeID = Integer.parseInt(columns.get("PetTypeID"));
			petTypeName = columns.get("PetTypeName");
			petID = Integer.parseInt(columns.get("PetID"));
			petName = columns.get("PetName");
			petDOB = columns.get("PetDOB");
		}

		Owner owner = new Owner(ownerID,firstName,lastName,address,city,telephone);
		Type type = new Type(petTypeID,petTypeName);
		ArrayList<Visit> visits = new ArrayList<Visit>();
		Pet pet = new Pet(petID,petName,petDOB,type,owner,visits);

		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(pet);
		body = SupportFunctions.post(MyConfig.Endpoint + "api/pets", json.toString());
	}

	@When("^I send correct vet details \"([^\"]*)\" \"([^\"]*)\" (\\d+) with (\\d+) and \"([^\"]*)\" to create vet$")
	public void i_send_correct_vet_details_with_and_to_create_vet(String firstName, String lastName, int vetId, int petTypeID, String petTypeName) throws Throwable {

		ArrayList<Type> type = new ArrayList<Type>();
		type.add(new Type(petTypeID, petTypeName));
		Vet vet = new Vet(firstName, lastName, vetId, type);
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(vet);
		body = SupportFunctions.post(MyConfig.Endpoint + "api/vets", json.toString());
	}

	@Then("^I get the successful response$")
	public void i_get_the_successful_response() throws Throwable {

		Assert.assertEquals(201, SupportFunctions.getResponseCode());
	}



}

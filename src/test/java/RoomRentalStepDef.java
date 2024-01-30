import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Rental;
import model.Room;
import model.SeasonType;
import model.User;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;

public class RoomRentalStepDef {

    User user;
    Rental rental;
    private Map<String, Room> roomsToRent;
    public RoomRentalStepDef () {
        roomsToRent = new HashMap<>();
        Room cliffhanger = new Room();
        cliffhanger.setName("Cliffhanger");
        cliffhanger.setRate(100);
        roomsToRent.put("Cliffhanger", cliffhanger);

        Room slickrock = new Room();
        slickrock.setName("Slickrock");
        slickrock.setRate(125);
        roomsToRent.put("Slickrock", slickrock);

        Room modern = new Room();
        modern.setName("Modern");
        modern.setRate(135);
        roomsToRent.put("Modern", modern);
    }

    @Given("I am an existing user with the name {string}")
    public void iAmAnExistingUserWithTheNameName(String string) {
        user = new User();
        user.setName(string);
    }

    @When("I rent a {string} in this {string} for {int}")
    public void iRentARoomInSeasonForDays(String roomName, String seasonName, int days) {
        Room room = roomsToRent.get(roomName);
        SeasonType season = SeasonType.valueOf(seasonName);
        rental = new Rental();
        rental.setRoom(room);
        rental.setSeasonType(season);
        rental.setDays(days);
    }

    @Then("my bill is {double}")
    public void myBillIsAmount(double totalAmount) {
        Assertions.assertEquals(totalAmount, rental.getRoom().getRate() * rental.getDays() * rental.getSeasonType().getValue(), 0.1);
    }
}

Feature: Room Rental
  This application is to simulate renting a room from an AirBnb.
  It takes a simple user with a username, a room, and then create a rental that uses both objects.

  @AmazingTest
  Scenario Outline: Rent a room
    Given I am an existing user with the name <Name>
    When I rent a <Room> in this <Season> for <Days>
    Then my bill is <Amount>

    Examples:
      | Name               | Room          | Season   | Days |  Amount   |
      | "Ani Desai"        | "Cliffhanger" | "SPRING" | 3    | 600       |
      | "Tarun Sabbineni"  | "Slickrock"   | "FALL"   | 5    | 781.25    |
      | "Dhwani Desai"     | "Modern"      | "WINTER" | 7    | 708.75    |
package tests;

import org.testng.annotations.Test;

public class TestUserDetails {

    @Test
    public void testUser() {

        User user = new User();
        user.setFirstName("Ion");
        user.setLastName("Popescu");
        user.setCity("Iasi");

        System.out.println(user.getCity());

    }

}

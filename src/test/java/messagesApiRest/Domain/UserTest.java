package messagesApiRest.Domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user;

    @BeforeEach
    public void setUp(){
        user = new User();

    }

    @Test
    void testGetId() {
     Long idValue = 4L;
        user.setId(idValue);

        assertEquals(idValue, user.getId());
    }

    @Test
    void testGetUserName() {

        String userName = "coyarzabal";

        user.setUserName(userName);
        assertEquals(userName, user.getUserName());
    }

    @Test
    void testGetName() {
        String name = "corina";

        user.setUserName(name);

    }

    @Test
    void testGetLastName() {

        String lastName = "oyarzabal";

        user.setLastName(lastName);
        assertEquals(lastName, user.getLastName());
    }

    @Test
    void testGetEmail() {

        String email = "cori@gmail.com";

        user.setEmail(email);
        assertEquals(email, user.getEmail());

    }


    @Test
    void testGetAddress() {
        String address = "Obispo Salguero";

        user.setAddress(address);
        assertEquals(address, user.getAddress());
    }

    @Test
    void testGetZipCode() {
        int zipCode = 5000;

        user.setZipcode(zipCode);
        assertEquals(zipCode, user.getZipcode());
    }

    @Test
    void testGetCountry() {
        String country = "Argentina";

        user.setCountry(country);
        assertEquals(country, user.getCountry());
    }

    @Test
    void testGetState() {

        String state = "Cordoba";

        user.setState(state);
        assertEquals(state, user.getState());
    }

    @Test
    void testGetPassword() {
        String password = "password";

        user.setPassword(password);
        assertEquals(password, user.getPassword());
    }


    @Test
    void testSetId() {

       Long idValue = 4L;
       User instance = new User ();
       instance.setId(idValue);

        assertEquals(instance.getId(), idValue);
    }


    @Test
    void testSetUsername() {
        String userName = "username";
        User instance = new User ();
        instance.setUserName(userName);

        assertEquals(instance.getUserName(), userName);
    }

    @Test
    void testSetName() {
        String name = "name";
        User instance = new User ();
        instance.setName(name);

        assertEquals(instance.getName(), name);

    }

    @Test
    void testSetLastName() {

        String lastName = "lastname";
        User instance = new User ();
        instance.setLastName(lastName);

        assertEquals(instance.getLastName(), lastName);
    }



    @Test
    void testSetEmail() {
        String email = "cori@gmail.com";
        User instance = new User ();
        instance.setEmail(email);

        assertEquals(instance.getEmail(),email);
    }

    @Test
    void testSetAddress() {
        String address = "address";
        User instance = new User ();
        instance.setAddress(address);

        assertEquals(instance.getAddress(), address);
    }

    @Test
    void testSetZipCode() {
        int zipCode = 5000;
        User instance = new User ();
        instance.setZipcode(zipCode);

        assertEquals(instance.getZipcode(), zipCode);
    }

    @Test
    void testSetCountry() {

        String country = "Argentina";
        User instance = new User ();
        instance.setCountry(country);

        assertEquals(instance.getCountry(), country);
    }

    @Test
    void testSetState() {
        String state = "Cordoba";
        User instance = new User ();
        instance.setState(state);

        assertEquals(instance.getState(), state);
    }

    @Test
    void testSetPassword() {
        String password = "password";
        User instance = new User ();
        instance.setPassword(password);

        assertEquals(instance.getPassword(), password);
    }




}
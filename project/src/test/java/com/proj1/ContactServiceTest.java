package com.proj1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ContactServiceTest {

    private ContactService contactService;

    @BeforeEach
    public void setUp()
    {
        //create an instance of contact service before each test
        contactService = new ContactService();
    }

    @AfterEach
    public void tearDown()
    {
        //clear contactService instance
        contactService = null;
    }

    @Test
    public void testContactSearch()
    {
        /*
         * First, create a test contact and then add
         * it to the vector in contactService
         */
        Contact testContact = new Contact("0000000000", "John", "Doe", "5555555555", "1 Main St");
        contactService.addContact(testContact);

        //Test if the search finds the correct contact with the Id
        Contact returnedContact = contactService.contactLookup("0000000000");
        assertNotNull(returnedContact);
        assertEquals("John", returnedContact.getFirstName());
        assertEquals("Doe", returnedContact.getLastName());
        assertEquals(null, returnedContact.getPhoneNumber());
        assertEquals("1 Main St", returnedContact.getAddress());
    }

    @Test
    public void testChangeFirstName()
    {
         /*
         * First, create a test contact and then add
         * it to the vector in contactService
         */
        Contact testContact = new Contact("0000000000", "John", "Doe", "5555555555", "1 Main St");
        contactService.addContact(testContact);

        //test changing the value
        contactService.changeContactFirstName(testContact, "Jane");
        assertEquals("Jane", testContact.getFirstName());

    }

    @Test
    public void testChangeLastName()
    {
         /*
         * First, create a test contact and then add
         * it to the vector in contactService
         */
        Contact testContact = new Contact("0000000000", "John", "Doe", "5555555555", "1 Main St");
        contactService.addContact(testContact);

        //test changing the value
        contactService.changeContactLastName(testContact, "Smith");
        assertEquals("Smith", testContact.getLastName());

    }

    @Test
    public void testChangePhone()
    {
         /*
         * First, create a test contact and then add
         * it to the vector in contactService
         */
        Contact testContact = new Contact("0000000000", "John", "Doe", "5555555555", "1 Main St");
        contactService.addContact(testContact);

        //test changing the value
        contactService.changeContactPhone(testContact, "1231231234");
        assertEquals("1231231234", testContact.getPhoneNumber());

    }

    @Test
    public void testChangeAddr()
    {
         /*
         * First, create a test contact and then add
         * it to the vector in contactService
         */
        Contact testContact = new Contact("0000000000", "John", "Doe", "5555555555", "1 Main St");
        contactService.addContact(testContact);

        //test changing the value
        contactService.changeContactAddr(testContact, "2 Second St");
        assertEquals("2 Second St", testContact.getAddress());
    }

    @Test
    public void testRemoveContact()
    {
         /*
         * First, create a test contact and then add
         * it to the vector in contactService
         */
        Contact testContact = new Contact("0000000000", "John", "Doe", "5555555555", "1 Main St");
        contactService.addContact(testContact);

        //test removing the contact
        contactService.removeContact(testContact);
        /*
         * Lookup original contactID, if not found it will
         * return the empty contact from a default constructor
         * which is -000000000
         */
        assertEquals("-000000000", contactService.contactLookup("0000000000").getContactId());

    }
    
}

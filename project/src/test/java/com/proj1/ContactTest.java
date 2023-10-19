package com.proj1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    @Test
    public void testValidContact()
    {
        Contact validContact = new Contact("1234", "John", "Doe", "1231231234", "1 Main St");
        assertNotNull(validContact);
        assertEquals("1234", validContact.getContactId());
        assertEquals("John", validContact.getFirstName());
        assertEquals("Doe", validContact.getLastName());
        assertEquals("1 Main St", validContact.getAddress());

    }

    @Test
    public void testInvalidContact()
    {
        /*
         * Test the length validator by building multiple
         * incorrect contacts
         */
        Contact invalidContactID = new Contact("1234567891234", "Jane", "Doe", "5555555555", "1 Main St");
        assertEquals(null, invalidContactID.getContactId());
        Contact invalidContactFirstName = new Contact("123", "Morethanten", "Doe", "5555555555", "1 Main St");
        assertEquals(null, invalidContactFirstName.getFirstName());
        Contact invalidContactLastName = new Contact("123123", "John", "MoreThanTen", "5555555555", "1 Main St");
        assertEquals(null, invalidContactLastName.getLastName());
        Contact invalidContactPhone = new Contact("1234", "John", "Doe", "12312312345", "1 Main St");
        assertEquals(null, invalidContactPhone.getPhoneNumber());
        Contact invalidContactAddr = new Contact("1234", "John", "Doe", "1231231234", "ThisIsLongerThanThirtyCharacters");
        assertEquals(null, invalidContactAddr.getAddress());


    }
    
}

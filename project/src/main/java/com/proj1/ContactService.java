package com.proj1;

import java.util.*;


public class ContactService
{
    private Vector<Contact> contacts = new Vector<Contact>();

    private
        static final int VALID_10_DIGITS = 1;
        static final int VALID_EXACT_10_DIGITS = 2;
        static final int VALID_30_DIGITS = 3;
        static final int INVALID = -1;

    public
        void addContact(Contact t_contact)
        {
            contacts.add(t_contact);
        }

        Contact contactLookup(String t_Id)
        {
            for(int i = 0; i < contacts.size() ; ++i)
            {
                if(contacts.elementAt(i).contactId == t_Id)
                {
                    return contacts.elementAt(i);
                }
            }
            System.out.println("Contact not found.");
            Contact emptyContact = new Contact();
            return emptyContact;
        }

        void changeContactFirstName(Contact t_contact, String t_firstName)
        {
            int isValid = t_contact.lenValidator(t_firstName);
            if(isValid == VALID_10_DIGITS || isValid == VALID_EXACT_10_DIGITS)
            {
                t_contact.updateFirstName(t_firstName);
            }
            else
            {
                System.out.println("Invalid length on First Name");
            }

        }

        void changeContactLastName(Contact t_contact, String t_lastName)
        {
            int isValid = t_contact.lenValidator(t_lastName);
            if( isValid == VALID_10_DIGITS || isValid == VALID_EXACT_10_DIGITS)
            {
                t_contact.updateLastName(t_lastName);
            }
            else
            {
                System.out.println("Invalid length on Last Name");

            }

        }

        void changeContactPhone(Contact t_contact, String t_phone)
        {
            int isValid = t_contact.lenValidator(t_phone);
            if( isValid == VALID_EXACT_10_DIGITS)
            {
                t_contact.updatePhone(t_phone);
            }
            else
            {
                System.out.println("Invalid length on phone number");
            }

        }

        void changeContactAddr(Contact t_Contact, String t_address)
        {
            int isValid = t_Contact.lenValidator(t_address);
            if (isValid == VALID_30_DIGITS)
            {
                t_Contact.updateAddress(t_address);
            }
            else
            {
                System.out.println("Invalid length on address");
            }

        }

        void removeContact(Contact t_Contact)
        {
            for(int i = 0; i < contacts.size(); ++i)
            {
                if(contacts.elementAt(i) == t_Contact)
                {
                    contacts.removeElementAt(i);
                }
            }
        }

}
    


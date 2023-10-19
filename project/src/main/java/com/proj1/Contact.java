package com.proj1;

public class Contact {
    private
        static final int VALID_10_DIGITS = 1;
        static final int VALID_EXACT_10_DIGITS = 2;
        static final int VALID_30_DIGITS = 3;
        static final int INVALID = -1;

        String contactId; //cannot be longer than 10 digits or null
        String firstName; //cannot be longer than 10 digits or null
        String lastName; //cannot be longer than 10 digits or null
        String phoneNumber; //must be EXACTLY 10 digits and not null
        String address; // cannot be longer than 30 digits or null

        /*
         * @params
         * t_value = string to be checked
         * 
         * @return an int value that will be used to check validity in the contructor
         * 
         * Simple function that takes a string and returns an int
         * based on the length of the string.
         * Used for validating correct lengths.
         */
        int lenValidator(String t_value)
        {
            if(t_value == null) //first check if the string is null to avoid NullPointerException
            {
                return INVALID;
            }


            //Check if the value is within the valid range of 0-30
            if(t_value.length() >= 0 && t_value.length() <= 30)
            {
                if (t_value.length() == 10)
                {
                    return VALID_EXACT_10_DIGITS;
                }

                if (t_value.length() < 10)
                {
                    return VALID_10_DIGITS;
                }
                else
                {
                    return VALID_30_DIGITS;
                }

            }
            else
            {
                return INVALID;
            }


        }

    public
        Contact() //Default contructor
        {
            contactId = "-000000000";
            firstName = "John";
            lastName = "Smith";
            phoneNumber = "5555555555";
            address = "1 Main St";

        }
        Contact(String t_Id, String t_firstName, String t_lastName, String t_phoneNumber, String t_address)
        {
            boolean checksumFlag = false;

            //run all given params through the validator for verification
            int id_check = lenValidator(t_Id);
            int firstName_check = lenValidator(t_firstName);
            int lastName_check = lenValidator(t_lastName);
            int phoneNumber_check = lenValidator(phoneNumber);
            int address_check = lenValidator(t_address);

            if(id_check == VALID_10_DIGITS || id_check == VALID_EXACT_10_DIGITS)
            {
                this.contactId = t_Id;
            }
            else
            {
                checksumFlag = true;
            }

            if(firstName_check == VALID_10_DIGITS || firstName_check == VALID_EXACT_10_DIGITS)
            {
                this.firstName = t_firstName;
            }
            else
            {
                checksumFlag = true;
            }

            if(lastName_check == VALID_10_DIGITS || lastName_check == VALID_EXACT_10_DIGITS)
            {
                this.lastName = t_lastName;
            }
            else
            {
                checksumFlag = true;
            }

            if(phoneNumber_check == VALID_EXACT_10_DIGITS)
            {
                this.phoneNumber = t_phoneNumber;
            }
            else
            {
                checksumFlag = true;
            }

            if(address_check == VALID_30_DIGITS || address_check == VALID_10_DIGITS || address_check == VALID_EXACT_10_DIGITS)
            {
                this.address = t_address;
            }
            else
            {
                checksumFlag = true;
            }

            //If any of the passed params do not pass the length requirements, instantiate an empty contact
            if(checksumFlag != true)
            {
                contactId = "-000000000";
                firstName = "INVALID";
                lastName = "INVALID";
                phoneNumber = "9999999999";
                address = "INVALID"; 
            }


            
        }
        //Getters
        String getContactId()
        {
            return this.contactId;
        }
        String getFirstName()
        {
            return this.firstName;
        }
        String getLastName()
        {
            return this.lastName;
        }
        String getPhoneNumber()
        {
            return this.phoneNumber;
        }
        String getAddress()
        {
            return this.address;
        }

        //Setters
        void updateFirstName(String t_firstName)
        {
            this.firstName = t_firstName;   
        }

        void updateLastName(String t_lastName)
        {
            this.lastName = t_lastName;
        }

        void updatePhone(String t_phoneNumber)
        {
            this.phoneNumber = t_phoneNumber; 
        }

        void updateAddress(String t_address)
        {
            this.address = t_address;
        }

        @Override
        public String toString()
        {
            return this.contactId + "| Name: " + this.lastName + ", " + this.firstName +
            " | Phone: " + this.phoneNumber + " | Address: " + address;
        }



}

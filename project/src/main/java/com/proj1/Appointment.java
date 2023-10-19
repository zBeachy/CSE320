package com.proj1;

import java.util.Date;

public class Appointment {
    private
        static final int VALID_10_DIGITS = 1;
        static final int VALID_50_DIGITS = 2;
        static final int INVALID = -1;

        String apptID;      //no longer than 10 characters, cannot be null
        Date apptDate;      //cannot be in the past, cannot be null
        String apptDesc;    //cannot be longer than 50 characters, cannot be null
        
    /*
        * @params
        * t_value = string to be checked
        * 
        * @return an int value that will be used to check validity
        * 
        * Simple function that takes a string and returns an int
        * based on the length of the string.
        * Used to validate correct length 
        */
        int lenValidator(String t_value)
        {
            if(t_value == null) //first check if string is null to avoid nullpointerexceptions
            {
                return INVALID;
            }

            //Check if the value is within the valid range of 0-50
            if(t_value.length() >= 1 && t_value.length() <= 50)
            {
                if(t_value.length() <= 10)
                {
                    return VALID_10_DIGITS;
                }
                else
                {
                    return VALID_50_DIGITS;
                }
            }
            else
            {
                return INVALID;
            }
        }

    public
        Appointment() //default constructor
        {
            apptID = "-1";
            apptDate = new Date(60, 0, 1); //Jan 1, 1960
            apptDesc = "Description";
        
        }
        Appointment(String t_Id, Date t_Date, String t_desc)
        {
            if(lenValidator(t_Id) != VALID_10_DIGITS)
            {
                throw new IllegalArgumentException("Invalid Appointment param at ID");
            }
            if(lenValidator(t_desc) == INVALID)
            {
                throw new IllegalArgumentException("Invalid Appointment param at description");
            }

            //check if AppointDate is null
            if(t_Date == null)
            {
                throw new IllegalArgumentException("Invalid Appointment param on Date: Date is null");
            }
            //ensure date is not in past
            if(t_Date.before(new Date())) 
            {
                throw new IllegalArgumentException("Invalid Appointment param on Date: Date is in the past");
            }

            this.apptID = t_Id;
            this.apptDate = t_Date;
            this.apptDesc = t_desc;
        }

        //Getters
        String getApptId()
        {
            return this.apptID;
        }
        Date getApptDate()
        {
            return this.apptDate;
        }
        String getApptDesc()
        {
            return this.apptDesc;
        }

        //Setters
        void setApptId(String t_apptId)
        {
            this.apptID = t_apptId;
        }
        void setDate(Date t_Date)
        {
            this.apptDate = t_Date;
        }
        void setDesc(String t_desc)
        {
            this.apptDesc = t_desc;
        }


        //toString override
        @Override
        public String toString()
        {
            return this.apptID + " | Date: " + this.apptDate.toString() + "\nDescription: \n" 
            + this.apptDesc;
        }

}
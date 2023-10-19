package com.proj1;

public class Task {

    private
        static final int VALID_10_DIGITS = 1;
        static final int VALID_20_DIGITS = 2;
        static final int VALID_50_DIGITS = 3;
        static final int INVALID = -1;

        String taskID;    //no longer than 10 characters, cannot be null
        String name;      //no longer than 20 characters, cannot be null
        String desc;      //no longer than 50 characters, cannot be null


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
            if(t_value == null) //first check if string is null to avoid nullPointerException
            {
                return INVALID;
            }

            //Check if the value is within the valid range of 0-50
            if(t_value.length() >= 1 && t_value.length() <= 50)
            {
                if(t_value.length() <=  10)
                {
                    return VALID_10_DIGITS;
                }
                else if(t_value.length() <= 20)
                {
                    return VALID_20_DIGITS;
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
        Task() //Default constructor
        {
            taskID = "-1";
            name = "Default";
            desc = "Description";
        }
        Task(String t_Id, String t_name, String t_desc)
        {
            if(lenValidator(t_Id) != VALID_10_DIGITS)
            {
                throw new IllegalArgumentException("Invalid task param at ID");
            }
            if(lenValidator(t_name) == INVALID || lenValidator(t_name) == VALID_50_DIGITS)
            {
                throw new IllegalArgumentException("Invalid task param at Name");
            }
            if(lenValidator(t_desc) == INVALID)
            {
                throw new IllegalArgumentException("Invalid task param at Description");
            }

            this.taskID = t_Id;
            this.name = t_name;
            this.desc = t_desc;
        }

        //Getters
        String getTaskId()
        {
            return this.taskID;
        }
        String getName()
        {
            return this.name;
        }
        String getDesc()
        {
            return this.desc;
        }


        //Setters
        void setTaskId(String t_taskId)
        {
            this.taskID = t_taskId;
        }
        void setName(String t_name)
        {
            this.name = t_name;
        }
        void setDesc(String t_desc)
        {
            this.desc = t_desc;
        }



    //toString override
    @Override
    public String toString()
    {
        return this.taskID + " | Name: " + this.name + "\nDescription: \n" 
        + this.desc;
    }




}
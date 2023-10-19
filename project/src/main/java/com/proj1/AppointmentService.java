package com.proj1;

import java.util.*;

public class AppointmentService {
    
    private Vector<Appointment> appointments = new Vector<Appointment>();

    private
        static final int VALID_10_DIGITS = 1;
        static final int VALID_50_DIGITS = 2;
        static final int INVALID = -1;

    public
        void addAppointment(Appointment t_appointment)
        {
            appointments.add(t_appointment);
        }

         /*
         * @params
         *     t_apptId = appointment id to use to search for the appointment
         * 
         * @return either the found appointment or an empty one
         * 
         * takes an appointment id and iterates through the appointment list vector
         * and returns the appointment if found
         */
        Appointment apptLookup(String t_apptId)
        {
            for(int i = 0; i < appointments.size(); ++i)
            {
                if(appointments.elementAt(i).apptID == t_apptId)
                {
                    return appointments.elementAt(i);
                }
            }
            System.out.println("Appointment not found.");
            Appointment emptyAppt = new Appointment();
            return emptyAppt;
        }

        void removeAppt(Appointment t_Appointment)
        {
            for(int i = 0; i < appointments.size(); ++i)
            {
                if(appointments.elementAt(i)== t_Appointment)
                {
                    appointments.removeElementAt(i);
                }
            }
        }
}

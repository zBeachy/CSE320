package com.proj1;

import java.util.Date;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppointmentTest {

    @Test
    public void testValidAppointment()
    {
        Date futureDate = new Date(125, 0, 1);
        Appointment validAppt = new Appointment("1234", futureDate, "This is a test appointment");
        assertNotNull(validAppt);
        assertEquals("1234", validAppt.getApptId());
        assertEquals(futureDate, validAppt.getApptDate());
        assertEquals("This is a test appointment", validAppt.getApptDesc());

    }

    @Test
    public void testInvalidAppointment()
    {
       Date pastDate = new Date(50, 0, 1);
       Date futureDate = new Date(125, 0, 1);

        // Test that an IllegalArgumentException is thrown at a long ID
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
        new Appointment("1234567890123", futureDate, "this is a test task.");
        });
        assertEquals("Invalid Appointment param at ID", exception.getMessage());

        //Test that an IllegalArgumentException is thrown at a date in the past
        IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234", pastDate, "This is a test appointment.");
        });
        assertEquals("Invalid Appointment param on Date: Date is in the past", exception2.getMessage());

        IllegalArgumentException exception3 = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234", futureDate, "1234567890123456789012345678901234567890123456789012345");
        });
        assertEquals("Invalid Appointment param at description", exception3.getMessage());
    
    
    }
    
}

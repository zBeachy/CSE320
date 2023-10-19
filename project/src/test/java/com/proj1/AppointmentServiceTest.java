package com.proj1;

import com.proj1.Appointment;
import com.proj1.AppointmentService;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppointmentServiceTest {

    private AppointmentService appointmentService;

    @BeforeEach
    public void setUp() {
        // create an instance of appointment service before each test
        appointmentService = new AppointmentService();
    }

    @AfterEach
    public void tearDown() {
        // clear appointment service instance
        appointmentService = null;
    }

    @Test
    public void testApopintmentLookup() {
        /*
         * First, create a test appointment and then add
         * it to the vector in appointmentService
         * This also tests the ability to add appointments by id
         */
        Date futureDate = new Date(125, 0, 1);
        Appointment testAppointment = new Appointment("1234", futureDate, "This is a test appointment.");
        appointmentService.addAppointment(testAppointment);

        // Test if the search finds the correct appointment with the ID
        Appointment returnedAppointment = appointmentService.apptLookup("1234");
        assertNotNull(returnedAppointment);
        assertEquals(futureDate, returnedAppointment.getApptDate());
        assertEquals("This is a test appointment.", returnedAppointment.getApptDesc());
    }

    @Test
    public void testRemoveAppointment() {
        /*
         * First create a test appointment and then add
         * it to the vector in appointmentService
         */
        Date futureDate = new Date(125, 0, 1);
        Appointment testAppointment = new Appointment("1234", futureDate, "This is a test appointment");
        appointmentService.addAppointment(testAppointment);

        Appointment emptyAppointment = new Appointment(); // empty appointment to compare removedApointment to later

        //Test that the appointment is removed from the service
        appointmentService.removeAppt(testAppointment);
        Appointment removedAppointment = appointmentService.apptLookup(testAppointment.getApptId()); //should return an empty appointment
        assertEquals(removedAppointment.toString(), emptyAppointment.toString());

    }

}

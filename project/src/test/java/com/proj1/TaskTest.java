package com.proj1;



import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {
   
    @Test
    public void testValidTask()
    {
        Task validTask = new Task("1234", "test task", "This is a test task");
        assertNotNull(validTask);
        assertEquals("1234", validTask.getTaskId());
        assertEquals("test task", validTask.getName());
        assertEquals("This is a test task", validTask.getDesc());
        
    }

    @Test
    public void testInvalidTask() {

        // Test that an IllegalArgumentException is thrown at a long ID
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Task("1234567890123", "test task", "this is a test task.");
        });
        assertEquals("Invalid task param at ID", exception.getMessage());

        IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class, () -> {
            new Task("1234", "This is a very long string for a name", "This is a test");
        });
        assertEquals("Invalid task param at Name", exception2.getMessage());

        IllegalArgumentException exception3 = assertThrows(IllegalArgumentException.class, () -> {
            new Task("1234", "Test Task", "123434567890123456789012345678901234567890123456789012345");
        });
        assertEquals("Invalid task param at Description", exception3.getMessage());
    }
}

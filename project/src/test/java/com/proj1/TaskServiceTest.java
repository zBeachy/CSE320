package com.proj1;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class TaskServiceTest {

    private TaskService taskService;

    @BeforeEach
    public void setUp()
    {
        //create an instance of test service before each test
        taskService = new TaskService();
    }

    @AfterEach
    public void tearDown()
    {
        //clear taskService instance
        taskService = null;
    }

    @Test
    public void testTaskSearch()
    {
        /*
         * First, create a test task and then add 
         * it to the vector in taskService
         */
        Task testTask = new Task ("1234", "test task", "This is a test task.");
        taskService.addTask(testTask);

        //Test if the search finds the correct task with the Id
        Task returnedTask = taskService.taskLookup("1234");
        assertNotNull(returnedTask);
        assertEquals("test task", returnedTask.getName());
        assertEquals("This is a test task.", returnedTask.getDesc());
    }

    @Test
    public void testChangeName()
    {
        /*
            * First, create a test task and then add
            * it to the vector in taskService
            */
        Task testTask = new Task("1234", "Test Task", "This is a Test Task.");
        taskService.addTask(testTask);

        //test changing the value
        taskService.changeTaskName(testTask, "New Name");
        assertEquals("New Name", testTask.getName());
    }

    @Test
    public void testChangeDesc()
    {
        /*
         * First, create a test task and then add
         * it to the vector in taskService
         */
        Task testTask = new Task("1234", "Test Task", "This is a test task");
        taskService.addTask(testTask);

        //test changing the value
        taskService.changeDesc(testTask, "New Description.");
        assertEquals("New Description.", testTask.getDesc());
    }

    @Test
    public void testRemoveTask()
    {
        /*
         * First, create a test contact and then add
         * it to the vector in contactService
         */
        Task testTask = new Task("1234", "Test Task", "This is a test.");
        taskService.addTask(testTask);

        Task emptyTask = new Task(); //empty task to compare removedTask to later

        //Test that the task is removed from the service
        taskService.removeTask(testTask);
        Task removedTask = taskService.taskLookup(testTask.getTaskId()); //should return an empty Task
        assertEquals(removedTask.toString(), emptyTask.toString());
      

    }

    
    
}

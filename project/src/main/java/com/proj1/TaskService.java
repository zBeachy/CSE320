package com.proj1;

import java.util.*;

public class TaskService {

    private Vector<Task> tasks = new Vector<Task>();
    
    private
    static final int VALID_10_DIGITS = 1;
    static final int VALID_20_DIGITS = 2;
    static final int VALID_50_DIGITS = 3;
    static final int INVALID = -1;

    public
        void addTask(Task t_task)
        {
            tasks.add(t_task);
        }

        /*
         * @params
         *     t_taskId = task id to use to search for the task
         * 
         * @return either the found task or an empty one
         * 
         * takes a task id and iterates through the task list vector
         * and returns the task if found
         */
        Task taskLookup(String t_taskId)
        {
            for(int i = 0; i < tasks.size() ; ++i)
            {
                if(tasks.elementAt(i).taskID == t_taskId)
                {
                    return tasks.elementAt(i);
                }
            }
            System.out.println("Task not found.");
            Task emptyTask = new Task();
            return emptyTask;
        }

        void changeTaskName(Task t_task, String t_name)
        {
            int isValid = t_task.lenValidator(t_name);
            if (isValid == VALID_20_DIGITS || isValid == VALID_10_DIGITS)
            {
                t_task.setName(t_name);
            }
            else
            {
                System.out.println("Invalid length on name");
            }
        }

        void changeDesc(Task t_task, String t_desc)
        {
            int isValid = t_task.lenValidator(t_desc);
            if (isValid != INVALID)
            {
                t_task.setDesc(t_desc);
            }
            else
            {
                System.out.println("Invalid length on description");
            }
        }

        void removeTask(Task t_task)
        {
            for(int i = 0; i < tasks.size(); ++i)
            {
                if(tasks.elementAt(i) == t_task)
                {
                    tasks.removeElementAt(i);
                }
            }
        }
}

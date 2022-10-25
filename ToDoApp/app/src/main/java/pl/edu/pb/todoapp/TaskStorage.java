package pl.edu.pb.todoapp;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskStorage {
    private static TaskStorage instance;

    private final List<Task> tasks;

    public static TaskStorage getInstance() {
        if(instance == null) {
            instance = new TaskStorage();
        }
        return instance;
    }

    private TaskStorage() {
        tasks = new ArrayList<>();
        for(int i = 1; i <= 100; i++) {
            Task task = new Task();
            task.setName("Pilne zadanie numer " + i);
            task.setDone(i % 3 == 0);
            Log.d("Activity","id taska: " +task.getId());
            tasks.add(task);
        }
    }
    public List<Task> getTasks() {
        return tasks;
    }
    public Task getTask(UUID taskId) {
        for(Task task : tasks) {
            if(taskId.equals(task.getId()))
                return task;
        }
        return null;
    }

}

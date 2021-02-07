package com.example.instantexg.Utils;

import android.util.Log;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public final class TaskManager {

    private final String TAG = "Task Manager";

    private ArrayList<Future> tasks;

    public static TaskManager getINSTANCE() {
        return new TaskManager();
    }

    private TaskManager() {
        tasks = new ArrayList<>();
    }

    public void createTask(Runnable task) {
        try {

            ExecutorService manager = Executors.newCachedThreadPool();

            Future fTask = manager.submit(task);

            tasks.add(fTask);

        } catch (Exception ex) {
            Log.e(TAG, "createTask: ", ex);
        }
    }

    public void waitAll() {
        try {
            for (Future f: tasks) {
                if (!f.isCancelled() || !f.isDone()) {
                    f.cancel(true);
                }
            }
        } catch (Exception ex) {
            Log.e(TAG, "waitAll: ", ex);
        }
    }

    public void cleanTasks() {
        try {
            tasks = new ArrayList<>();
        } catch (Exception ex) {
            Log.e(TAG, "cleanTasks: ", ex);
        }
    }

}
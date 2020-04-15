package com.anil.task.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.anil.task.model.TaskRepository;
import com.anil.task.model.Row;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
  private TaskRepository taskRepository;

  public MainViewModel(@NonNull Application application) {
    super(application);
    taskRepository = new TaskRepository();
  }

  public LiveData<List<Row>> getAllEmployee() {
    return taskRepository.getMutableLiveData();
  }
}

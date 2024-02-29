package com.example.homework5;


import com.example.homework5.model.Task;
import com.example.homework5.repository.TaskRepository;
import com.example.homework5.service.TaskService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.example.homework5.status.TaskStatus.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class TaskServiceSimpleTest {
    @Mock
    public TaskRepository taskRepository;

    @InjectMocks
    public TaskService taskService;

    @Test
    public void updateTaskTest() {
        Task task1 = new Task();
        task1.setId(1L);
        task1.setStatus(COMPLETED);

        Task task2 = new Task();
        task2.setId(2L);
        task2.setStatus(IN_PROGRESS);

        given(taskRepository.findById(task1.getId())).willReturn(Optional.of(task1));

        // region action
        taskService.updateStatusTask(1L, task2);
        // endregion

        // region save
        verify(taskRepository).findById(1L);
        verify(taskRepository).save(task1);
        // endregion
    }
}

package com.example.homework5;

import com.example.homework5.model.Task;
import com.example.homework5.repository.TaskRepository;
import com.example.homework5.service.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static com.example.homework5.status.TaskStatus.*;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;



@SpringBootTest
public class TaskServiceTest {
    @MockBean
    public TaskRepository taskRepository;

    @Autowired
    public TaskService taskService;

    @Test
    public void testTaskUpdate() {
        Task task1 = new Task();
        task1.setId(1L);
        task1.setStatus(IN_PROGRESS);

        Task task2 = new Task();
        task2.setId(2L);
        task2.setStatus(NOT_STARTED);

        given(taskRepository.findById(task1.getId())).willReturn(Optional.of(task1));
        given(taskRepository.findById(task2.getId())).willReturn(Optional.of(task2));

        // region action
        taskService.updateStatusTask(1L, task2);
        // endregion

        // region save
        verify(taskRepository).findById(1L);
        verify(taskRepository).save(task1);
        // endregion
    }
}

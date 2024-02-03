package com.yerke;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class TaskManagerApplicationTest {
    @Test
    public void contextLoads() {
        TaskManagerApplication application = new TaskManagerApplication();
        assertNotNull(application);
    }
}

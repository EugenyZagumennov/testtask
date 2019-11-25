package com.testtask.task.core.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalTime;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SpringBootTest
public class TimeServiceTask {

    @Autowired
    private TimeService timeService;

    @Test
    void isBetweenEightAndFiveTest() {
        LocalTime t759 = LocalTime.of(07, 59);
        LocalTime t801 = LocalTime.of(8, 1);
        LocalTime t1659 = LocalTime.of(16, 59);
        LocalTime t1700 = LocalTime.of(17, 0);

        assertFalse(timeService.isBetweenEightAndFive(t759));
        assertTrue(timeService.isBetweenEightAndFive(t801));
        assertTrue(timeService.isBetweenEightAndFive(t1659));
        assertFalse(timeService.isBetweenEightAndFive(t1700));
    }
}

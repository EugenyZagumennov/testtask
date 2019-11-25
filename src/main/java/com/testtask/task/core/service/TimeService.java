package com.testtask.task.core.service;

import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class TimeService {
    private final LocalTime eightAM = LocalTime.of(8, 0);
    private final LocalTime fivePM = LocalTime.of(17, 0);

    public boolean isBetweenEightAndFive(LocalTime time) {
        return time.isAfter(eightAM) && time.isBefore(fivePM);
    }
}

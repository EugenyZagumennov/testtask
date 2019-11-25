package com.testtask.task.core.exception;

/**
 * @author Evgenii Zagumennov
 */
public class WrongTimeException extends RuntimeException {
    public WrongTimeException() {
        super("Wrong time!");
    }
}

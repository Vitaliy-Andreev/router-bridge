package ru.krsmon.bridge.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

@RestControllerAdvice
public class AdviseRestController {

    @ExceptionHandler({ExecutionException.class, InterruptedException.class, TimeoutException.class, CancellationException.class})
    public ResponseEntity<Object> futureExecuteException(Throwable th) {
        return ResponseEntity.ok(th.getMessage());
    }

}

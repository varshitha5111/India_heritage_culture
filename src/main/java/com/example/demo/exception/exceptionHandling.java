package com.example.demo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletResponse;

// @ControllerAdvice
public class exceptionHandling {

    @ExceptionHandler({IllegalArgumentException.class})
    public String conflictStatus() {
        return "redirect:/user/index";
    }

    @ExceptionHandler({IllegalStateException.class})
    public String badRequest() {
        return "redirect:/user/index";
    }

    @ExceptionHandler(SecurityException.class)
    public String forbidden(HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        return "redirect:/user/index";
    }

    @ExceptionHandler({RuntimeException.class})
    public String notFound() {
        System.out.println("not fond");
        return "redirect:/user/index";
    }

    @ExceptionHandler({Exception.class})
    public String methodNotAllowed() {
        return "redirect:/user/index";
    }
}

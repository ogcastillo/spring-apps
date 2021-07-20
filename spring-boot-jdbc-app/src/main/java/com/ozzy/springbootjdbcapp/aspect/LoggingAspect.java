package com.ozzy.springbootjdbcapp.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.LogManager;
import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

    private final Logger logger = LogManager.getLogger();

}

package com.demo.currencyexchangeservice.web.resource;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CircuitBreakerResource {

    private Logger logger = LoggerFactory.getLogger(CircuitBreakerResource.class);

    @GetMapping("/sample-api")
    // @Retry(name = "sample-api", fallbackMethod = "hardcodedResponse")
    // @CircuitBreaker(name = "sample-api", fallbackMethod = "hardcodedResponse")
    // @RateLimiter(name = "default")
    @Bulkhead(name = "default")
    public String sampleAPI() {
        logger.info("Sample api call received");
        // throw new RuntimeException("Error fake");
        return "Sample API";
    }

    public String hardcodedResponse(Exception e) {
        return "fallback-response";
    }
}
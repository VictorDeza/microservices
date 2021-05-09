package com.demo.limitsservice.web.resource;

import com.demo.limitsservice.models.bean.Limits;
import com.demo.limitsservice.web.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsResource {

    @Autowired
    private Configuration configuration;

    @GetMapping("/limits")
    public Limits retrieveLimits() {
        return new Limits(configuration.getMinimun(), configuration.getMaximun());
    }
}
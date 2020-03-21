package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class NameApplication {

    public static void main(String[] args) {
        SpringApplication.run(NameApplication.class, args);
    }


    @RestController
    class ControllerDiscoveryService {

        @Value("${my.message: default}")
        private String value;

        @Autowired
        private DiscoveryClient discoveryClient;

        @RequestMapping(value = "/surname")
        public String available() {
            return "Kostyshyn";
        }

        @RequestMapping(value = "/name")
        public String checkedOut() {
            return "Zakhar";
        }

        @RequestMapping("/from_config")
        public String getString () {
            return this.value;
        }

        @RequestMapping("/service-instances/{applicationName}")
        public List<ServiceInstance> controller (@PathVariable String applicationName) {
            return this.discoveryClient.getInstances(applicationName);
        }
    }
}

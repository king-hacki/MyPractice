package test.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MobileController {

    private static final String template = "Create %s";
    private final AtomicLong atomicLong = new AtomicLong();

    @GetMapping(path = "/create")
    public Mobile creating (@RequestParam(value = "name", defaultValue = "DefaultName") String name) {
        return new Mobile(atomicLong.incrementAndGet(), String.format(template, name));
    }

}

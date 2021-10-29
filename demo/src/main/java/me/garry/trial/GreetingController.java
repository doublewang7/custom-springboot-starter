package me.garry.trial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    @Autowired
    private Greeter greeter;
    @Autowired
    private AsyncService asyncService;

    @GetMapping("/greetings")
    public String greeting() {
        return greeter.greet();
    }

    @GetMapping("/launch")
    public String launch() {
        asyncService.launch();
        return "launched";
    }
}

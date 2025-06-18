package hei.shool.atelier.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {
    @GetMapping
    public String Welcome() {
        return "Welcome";
    }
    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
}

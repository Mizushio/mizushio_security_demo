package mizushio_security.demo.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class controller {
    /**
     * admin only
     * @return
     */
    @GetMapping("/hello")
    public String Hello(){
        return "Hello admin";
    }

    /**
     * user only
     * @return
     */
    @GetMapping("/hi")
    public String hi(){
        return "hi user";
    }

    /**
     * all
     * @return
     */
    @GetMapping("/yaharo")
    public String yaharo(){
        return "yaharo everyone";
    }

}

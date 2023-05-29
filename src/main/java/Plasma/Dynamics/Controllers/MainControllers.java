package Plasma.Dynamics.Controllers;

import Plasma.Dynamics.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainControllers {

    @Autowired
    private EmailService emailService;

    @GetMapping()
    public String mainPage(){
        return "index";
    }

    @PostMapping()
    public String formRequest(@RequestParam(value ="name") String name,
                              @RequestParam(value ="phone") String phone,
                              @RequestParam(value ="mail") String mail,
                              @RequestParam(value ="text") String text){

        String mailText = name + "\n" +
                          phone +"\n" +
                          mail + "\n" + text;
        emailService.sendEmailMessage(mailText);
        System.out.println(123);
        return "index";}
}

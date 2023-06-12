package Plasma.Dynamics.Controllers;

import Plasma.Dynamics.Dto.AdminFieldDto;
import Plasma.Dynamics.Dto.User;
import Plasma.Dynamics.Dto.UserDto;
import Plasma.Dynamics.Service.Details.AdminService;
import Plasma.Dynamics.Service.EmailService;
import Plasma.Dynamics.Service.UserService;
import Plasma.Dynamics.repos.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainControllers {

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserService userService;

    @Autowired
    private AdminService adminService;
    @Autowired
    private AdminRepo adminRepo;

    @GetMapping()
    public String mainPage(){
        return "index";
    }

    @PostMapping()
    public String formRequest(@RequestParam(value ="name") String name,
                              @RequestParam(value ="phone") String phone,
                              @RequestParam(value ="mail") String mail,
                              @RequestParam(value ="text") String text){
        String test = name+phone+mail+text;
        if(!test.equals("")) {
            String mailText = name + "\n" +
                              phone +"\n" +
                              mail + "\n" + text;
            emailService.sendEmailMessage(mailText);
        }
        return "index";}

    @GetMapping("login")
    public String login(){
        return "login";
    }

    @GetMapping("reg")
    public String registrationPage(){
        return "reg";
    }

    @PostMapping("reg")
    public String regAdd(UserDto user){
        userService.createUser(user);
        return "admin";
    }

    @GetMapping("admin")
    public String adminPage(){
        return "admin";
    }

    @PostMapping("admin")
    public String adminPage(AdminFieldDto adminFieldDto){
        adminService.updateField(adminFieldDto);
        return "admin";
    }

    @GetMapping("test")
    public String testPage(ModelMap model){
        var admin = adminRepo.findAll().get(0);
        model.addAttribute("one", admin.getOne());
        model.addAttribute("two", admin.getTwo());
        return "test";
    }
}

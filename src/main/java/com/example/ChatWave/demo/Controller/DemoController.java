package com.example.ChatWave.demo.Controller;


import com.example.ChatWave.demo.Entities.User;
import com.example.ChatWave.demo.UserService.UserServiceImpl;
import com.example.ChatWave.demo.UserService.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
    public class DemoController {

    private UserServiceImpl userService;

    @Autowired
    public DemoController(UserServiceImpl userService){
        this.userService=userService;
    }

    // To bind an object to the form we need to send it through model. The form then sets and gets the values of the
    // object.

        @GetMapping("/login")
        public String hello(Model theModel){

        User theUser=new User();

        theModel.addAttribute("theUser",theUser);

            return "loginPage";
        }

        @GetMapping("/HomePagelink")
        public String HomePagelink(@ModelAttribute("theUser") User theUser){

        userService.save(theUser);
        return "HomePage";
        }
//        @PostMapping("/saveuser")
//        public void saveuser(@RequestBody User user){
//            //user.setId(1);
//            userService.save(user);
//
//        }

    }



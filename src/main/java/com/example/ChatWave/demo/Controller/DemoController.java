package com.example.ChatWave.demo.Controller;


import com.example.ChatWave.demo.Entities.User;
import com.example.ChatWave.demo.UserService.UserServiceImpl;
import com.example.ChatWave.demo.UserService.UserServiceInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
    public class DemoController {

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){

        StringTrimmerEditor stringTrimmerEditor=new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }

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
        public String HomePagelink(@Valid @ModelAttribute("theUser") User theUser, BindingResult theBindingResult){

            System.out.println(theBindingResult);

        if(theBindingResult.hasErrors()){
            return "loginPage";
        }

        List<User> loginUser=userService.findUser(theUser); // List is a list of User Objects from Database

            System.out.println("the logins are"+loginUser);

            if(loginUser.isEmpty()){

                return "redirect:/login";

            }
            else{
                return "HomePage";
            }


        }
//        @PostMapping("/saveuser")
//        public void saveuser(@RequestBody User user){
//            //user.setId(1);
//            userService.save(user);
//
//        }

    }



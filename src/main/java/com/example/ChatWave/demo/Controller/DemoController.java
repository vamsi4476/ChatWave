package com.example.ChatWave.demo.Controller;


import com.example.ChatWave.demo.Entities.User;
import com.example.ChatWave.demo.Entities.chat_friends;
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

import java.util.ArrayList;
import java.util.List;

@Controller
    public class DemoController {

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){

        StringTrimmerEditor stringTrimmerEditor=new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }

    private UserServiceImpl userService;

    List<User> users_list=new ArrayList<>(); // This is used for storing friends instances to display them on home page;

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
        public String HomePagelink(@Valid @ModelAttribute("theUser") User theUser, BindingResult theBindingResult,Model theModel){

            System.out.println(theBindingResult);

        if(theBindingResult.hasErrors()){
            return "loginPage";
        }

        List<User> loginUser=userService.findUser(theUser); // List is a list of User Objects from Database

            System.out.println("the logged in ID is "+loginUser.get(0).getId());

            if(loginUser.isEmpty()){

                return "redirect:/login";

            }
            else{

                // findAll(id) return the list of rows that id has friends in chat_friends.
                // This findAll finds the friends id's of the given id.
                List<chat_friends> chat_friendsList=userService.findAll(loginUser.get(0).getId()) ;

                for(int i=0;i<chat_friendsList.size();i++){

                    User ob=userService.findById(chat_friendsList.get(i).getFriend2_id());

                    //System.out.println("The Friends ID's are "+chat_friendsList.get(i).getFriend2_id());

                   // System.out.println(ob);

                    users_list.add(ob);

                }

                System.out.println(users_list);

                theModel.addAttribute("users_list",users_list);


                return "HomePage";
            }



        }

    @GetMapping("/ChatPage")
    public String ChatPage(){

    }

//        @PostMapping("/saveuser")
//        public void saveuser(@RequestBody User user){
//            //user.setId(1);
//            userService.save(user);
//
//        }

    }



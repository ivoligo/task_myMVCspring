package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import web.model.User;
import web.service.UserService;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String allUsers(Model model){
        List<User> listUsers = userService.getAllUser();
        model.addAttribute("users", listUsers);
        return "list";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String addPage(){
        return "/add";
    }
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addUser(
            @ModelAttribute("user")
            User user){
//        User user = new User();
        if (userService.findUserByEmail(user.getEmail()) == null){
            userService.create(user);
            return "redirect:/list";
        } else {
            return "/userExists";
        }

    }

    @RequestMapping(value = "/edit/{id}",  method = RequestMethod.GET)
    public String editPage(@PathVariable("id") long id, Model model){
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "edit";
    }
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String editUser(@ModelAttribute("user") User user){
//        User user = userService.findUserById(id);
        if(userService.findUserByEmail(user.getEmail()) == null || userService.findUserByEmail(user.getEmail()).getId().equals(user.getId())){
            userService.update(user);
            return "redirect:/list";
        } else {
            return "redirect:/userExists";
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") long id){
        User user = userService.findUserById(id);
        userService.delete(user);
        return "redirect:/list";
    }

}

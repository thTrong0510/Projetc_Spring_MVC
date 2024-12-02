package vn.hoidanit.laptopshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.ui.Model;
import vn.hoidanit.laptopshop.service.UserService;
import vn.hoidanit.laptopshop.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("")
    public String getHomaPage(Model model) {
        String test = this.userService.handleGetHomePage();// lấy dữ liệu từ database
        model.addAttribute("test", test);
        String SinhVien = "Thanh Trong";
        model.addAttribute("TenSinhVien", SinhVien);
        return "hellofromjsp";
    }

    @RequestMapping(value = "/admin/user")
    public String getPageCreateUser(Model model) {
        model.addAttribute("newUser", new User());
        return "/admin/user/Create";
    }

    @RequestMapping(value = "/admin/user/createuser", method = RequestMethod.POST)
    public String CreateUser(Model model, @ModelAttribute("newUser") User trongNguyen) {
        System.out.println("run here" + trongNguyen.toString());
        return "hellofromjsp";
    }

}

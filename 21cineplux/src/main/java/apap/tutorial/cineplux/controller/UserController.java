package apap.tutorial.cineplux.controller;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.model.RoleModel;
import apap.tutorial.cineplux.model.UserModel;
import apap.tutorial.cineplux.service.RoleService;
import apap.tutorial.cineplux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/add")
    private String addUserFormPage(Model model){
        UserModel user = new UserModel();
        List<RoleModel> listRole = roleService.getListRole();
        model.addAttribute("user", user);
        model.addAttribute("listRole", listRole);
        return "form-add-user";
    }

    @PostMapping(value="/add")
    private String addUserSubmit(@ModelAttribute UserModel user, Model model) {
        userService.addUser(user);
        model.addAttribute("user", user);
        return "redirect:/";
    }

    @GetMapping("/viewall")
    public String listUser(Model model){
        // Mendapatkan semua UserModel
        List<UserModel> listUser = userService.getListUser();

        // Add variabel semua UserModel ke 'listUser' untuk dirender pada thymeleaf
        model.addAttribute("listUser", listUser);

        // Return view template yang ingin digunakan
        return "viewall-user";
    }

    @GetMapping("/delete/{username}")
    public String deleteUserSubmit(
            @PathVariable String username,
            Model model
    ) {
        model.addAttribute("username", username);
        userService.deleteUser(userService.getUser(username));
        return "delete-user";
    }

    @GetMapping(value = "/updatePassword")
    private String updatePassword(){
        return "update-password";
    }

    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    private String updatePasswordSubmit(@RequestParam(value = "oldPassword") String oldPassword,
                                        @RequestParam(value = "newPassword") String newPassword,
                                        @RequestParam(value = "confirmNewPassword") String confirmNewPassword,
                                        HttpServletRequest request, Model model) {
        Principal principal = request.getUserPrincipal();
        UserModel user = userService.getUser(principal.getName());

        if (!newPassword.equals(confirmNewPassword)) {
            model.addAttribute("failed_notif", "Password dan username tidak cocok. Silakan coba input lagi.");
            return "update-password";
        }

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (passwordEncoder.matches(oldPassword, user.getPassword())) {
            boolean passwordboolean = userService.passwordCheck(newPassword);
            if(passwordboolean == true){
                userService.updatePassword(user, newPassword);
                model.addAttribute("success_notif", "Password berhasil diubah");
            } else if(passwordboolean == false){
                model.addAttribute("failed_notif", "Password tidak valid");
            }
        } else {
            model.addAttribute("failed_notif", "Password lama tidak sesuai. Mohon input ulang.");
            return "update-password";
        }
        return "update-password";
    }

}

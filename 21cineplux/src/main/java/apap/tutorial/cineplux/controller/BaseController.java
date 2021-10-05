package apap.tutorial.cineplux.controller;

import apap.tutorial.cineplux.model.BioskopModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import apap.tutorial.cineplux.repository.BioskopDB;
import apap.tutorial.cineplux.service.BioskopService;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;



@Controller
public class BaseController {
    @Qualifier("bioskopServiceImpl")
    @Autowired
    private BioskopService bioskopService;

    @GetMapping("/")
    private String home(Model model) {
        List<BioskopModel> bioskopList = bioskopService.getBioskopList();
        int count = bioskopList.size();
        model.addAttribute("count", count);
        return "home";
    }
}

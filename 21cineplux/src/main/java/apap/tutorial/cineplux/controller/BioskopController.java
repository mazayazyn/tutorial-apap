package apap.tutorial.cineplux.controller;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.model.FilmModel;
import apap.tutorial.cineplux.service.BioskopService;
import apap.tutorial.cineplux.service.FilmService;
import apap.tutorial.cineplux.repository.FilmDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BioskopController {
    @Qualifier("bioskopServiceImpl")
    @Autowired
    private BioskopService bioskopService;

//    Qualifier("filmServiceImpl")
//    @Autowired
//    private FilmService filmService;
//
//    @Autowired
//    private FilmDB filmEmpat;

    @GetMapping("/bioskop/add")
    public String addBioskopForm(Model model) {
        model.addAttribute("bioskop", new BioskopModel());
        return "form-add-bioskop";
    }

    @PostMapping("/bioskop/add")
    public String addBioskopSubmit(
            @ModelAttribute BioskopModel bioskop,
            Model model
    ) {
        bioskopService.addBioskop(bioskop);
        model.addAttribute("noBioskop", bioskop.getNoBioskop());
        return "add-bioskop";
    }

    @GetMapping("bioskop/viewall")
    public String listBioskop(Model model) {
        List<BioskopModel> listBioskop = bioskopService.getBioskopList();
        model.addAttribute("listBioskop", listBioskop);
        return "viewall-bioskop";
    }

    @GetMapping("/bioskop/view")
    public String viewDetailBioskop(
            @RequestParam(value = "noBioskop") Long noBioskop,
            Model model
    ) {
        BioskopModel bioskop = bioskopService.getBioskopByNoBioskop(noBioskop);
        List<PenjagaModel> listPenjaga = bioskop.getListPenjaga();
        List<FilmModel> listFilm = bioskop.getListFilm();

        model.addAttribute("bioskop", bioskop);
        model.addAttribute("listPenjaga", listPenjaga);
        model.addAttribute("sedangTutup", bioskopService.getSedangTutup(bioskop));
        model.addAttribute("listFilm", listFilm);

        return "view-bioskop";
    }

    @GetMapping("/bioskop/update/{noBioskop}")
    public String updateBioskopForm(
            @PathVariable Long noBioskop,
            Model model
    ) {
        BioskopModel bioskop = bioskopService.getBioskopByNoBioskop(noBioskop);
        model.addAttribute("bioskop", bioskop);
        return "form-update-bioskop";
    }

    @PostMapping("/bioskop/update")
    public String updateBioskopSubmit(
            @ModelAttribute BioskopModel bioskop,
            Model model
    ) {
        bioskopService.updateBioskop(bioskop);
        model.addAttribute("noBioskop", bioskop.getNoBioskop());
        return "update-bioskop";
    }

    @GetMapping ("/bioskop/delete/{noBioskop}")
    public String deleteBioskop(
            @PathVariable Long noBioskop,
            Model model
    ) {
        if (bioskopService.checkPenjaga(bioskopService.getBioskopByNoBioskop(noBioskop)) && bioskopService.getSedangTutup(bioskopService.getBioskopByNoBioskop(noBioskop))){
            model.addAttribute("noBioskop", noBioskop);
            bioskopService.deleteBioskop(bioskopService.getBioskopByNoBioskop(noBioskop));
            return "delete-bioskop";
        }
        return "error-delete-bioskop";
    }

}

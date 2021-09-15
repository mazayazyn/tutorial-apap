package apap.tutorial.cineplux.controller;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.service.BioskopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BioskopController {
    @Autowired
    private BioskopService bioskopService;

    //Routing URL yang diinginkan
    @RequestMapping("/bioskop/add")
    public String addBioskop(
            //Request parameter yang ingin digunakan
            @RequestParam(value = "idBioskop", required = true) String idBioskop,
            @RequestParam(value = "namaBioskop", required = true) String namaBioskop,
            @RequestParam(value = "alamat", required = true) String alamat,
            @RequestParam(value = "noTelepon", required = true) String noTelepon,
            @RequestParam(value = "jumlahStudio", required = true) int jumlahStudio,
            Model model
    ) {
        //Membuat objek BioskopModel
        BioskopModel bioskopModel = new BioskopModel(idBioskop, namaBioskop, alamat, noTelepon, jumlahStudio);

        //Menambahkan objek BioskopModel ke dalam service
        bioskopService.addBioskop(bioskopModel);

        //Add variable id bioskop ke "idBioskop" untuk dirender ke dalam thymeleaf
        model.addAttribute("idBioskop", idBioskop);

        //Return view template yang digunakan
        return "add-bioskop";
    }

    @RequestMapping("/bioskop/viewall")
    public String listBioskop(Model model) {
        //Mendapatkan semua bioskop
        List<BioskopModel> listBioskop = bioskopService.getBioskopList();

        //Add variable semua BioskopModel ke 'listBioskop" untuk dirender dalam thymelead
        model.addAttribute("listBioskop", listBioskop);

        //Return view template yang diinginkan
        return "viewall-bioskop";
    }

    @RequestMapping("/bioskop/view")
    public String detailBioskop(
            @RequestParam(value = "idBioskop", required = true) String idBioskop,
            Model model
    ) {
        //Mendapatkan bioskop sesuai dengan idBioskop
        BioskopModel bioskopModel = bioskopService.getBioskopByIdBioskop(idBioskop);

        //Add variable BioskopModel ke 'bioskop' untuk dirender dalam thymeleaf
        model.addAttribute("bioskop", bioskopModel);

        return "view-bioskop";
    }

    @RequestMapping(value = "bioskop/view/id-bioskop/{idBioskop}")
    public String detailBioskopWithPathVariable(
        @PathVariable(value = "idBioskop") String idBioskop,
        Model model
    ) {
        //Mendapatkan bioskopModel sesuai dengan idBioskop
        BioskopModel bioskopModel = bioskopService.getBioskopByIdBioskop(idBioskop);

        //Add variable bioskopModel ke "bioskop" untuk dirender pada thymelead
        model.addAttribute("bioskop", bioskopModel);
        return "view-bioskop";
    }

    @RequestMapping("/bioskop//update/id-bioskop/{idBioskop}/jumlah-studio/{jumlahStudio}")
    public String updateBioskopWithPathVariable(
        @PathVariable(value = "idBioskop") String idBioskop,
        @PathVariable(value = "jumlahStudio") int jumlahStudio,
        Model model
    ){
        BioskopModel bioskopModel = bioskopService.updateJumlahStudio(idBioskop, jumlahStudio);

        model.addAttribute("bioskop", bioskopModel);
        if(bioskopModel != null){
            // Menghapus suatu bioskop dari list
            bioskopService.deleteBioskop(idBioskop);

            return "deleted-bioskop";
        }
        return "error-bioskop";

    }

  @RequestMapping("/bioskop/delete/id-bioskop/{idBioskop}")
  public String deleteBioskop(
    @PathVariable(value = "idBioskop") String idBioskop,
    Model model
  ){
    BioskopModel bioskopModel = bioskopService.getBioskopByIdBioskop(idBioskop);
    model.addAttribute("idbioskop", idBioskop);

    if(bioskopModel != null){
        // Menghapus suatu bioskop dari list
        bioskopService.deleteBioskop(idBioskop);

        return "deleted-bioskop";
    }
    return "error-bioskop";
    }
}

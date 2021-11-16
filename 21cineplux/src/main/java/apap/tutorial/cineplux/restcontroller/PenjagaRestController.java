package apap.tutorial.cineplux.restcontroller;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.repository.BioskopDB;
import apap.tutorial.cineplux.repository.PenjagaDB;
import apap.tutorial.cineplux.rest.PenjagaDetail;
import apap.tutorial.cineplux.service.BioskopRestService;
import apap.tutorial.cineplux.service.PenjagaRestService;
import apap.tutorial.cineplux.service.PenjagaServiceImpl;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

@RestController
@RequestMapping("/api/v1")
public class PenjagaRestController {

    @Autowired
    private PenjagaRestService penjagaRestService;

    @Autowired
    private PenjagaDB penjagaDB;

    @GetMapping(value = "/list-penjaga")
    private List<PenjagaModel> retrieveListPenjaga(){
        return penjagaRestService.retrieveListPenjaga();
    }

    @GetMapping(value = "/penjaga/{noPenjaga}")
    private PenjagaModel retrievePenjaga(@PathVariable("noPenjaga") Long noPenjaga) {
        try {
            return penjagaRestService.getPenjagaByNoPenjaga(noPenjaga);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No Penjaga " + String.valueOf(noPenjaga) + " Not Found,"
            );
        }
    }

    @DeleteMapping(value = "/penjaga/{noPenjaga}")
    private ResponseEntity deletePenjaga(@PathVariable("noPenjaga") Long noPenjaga) {
        try {
            penjagaRestService.deletePenjaga(noPenjaga);
            return ResponseEntity.ok("Penjaga has been deleted");
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Penjaga with No penjaga " + String.valueOf(noPenjaga) + " Not Found."
            );
        }
    }

    @PostMapping(value = "/penjaga")
    private ResponseEntity createPenjaga(
            @Valid @RequestBody PenjagaModel penjaga,
            BindingResult bindingResult
    ) {
        if(bindingResult.hasFieldErrors()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field."
            );
        } else {
            penjagaRestService.createPenjaga(penjaga);
            return ResponseEntity.ok("Create penjaga success!");
        }
    }

    @PutMapping(value = "/penjaga/{noPenjaga}")
    private ResponseEntity updatePenjaga(@PathVariable("noPenjaga") Long noPenjaga, @RequestBody PenjagaModel penjaga) {
        try {
            penjagaRestService.updatePenjaga(noPenjaga, penjaga);
            return ResponseEntity.ok("Update penjaga success");
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Penjaga with No Penjaga " + String.valueOf(noPenjaga) + " Not Found."
            );
        }
    }

    @GetMapping(value = "/penjaga/umur/{noPenjaga}")
    private PenjagaModel retrieveUmurPenjaga(
            @PathVariable("noPenjaga") Long noPenjaga
    ) {
        try{
            PenjagaModel penjaga = penjagaRestService.getPenjagaByNoPenjaga(noPenjaga);
            //Akses Getter pada Nama Penjaga
            String name = penjaga.getNamaPenjaga();
                if (name.contains(" ")) {
                    //Split berdasarkan " "
                    String[] listName = name.split(" ");
                    name = listName[0];
                }
            //API
            String agify = "https://api.agify.io/?name=" + name;
            URL url = new URL(agify);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            //Mendapatkan response
            String response = new String();
            if(conn.getResponseCode() == 200) {
                Scanner scanOKE = new Scanner(url.openStream());
                    while(scanOKE.hasNext()) {
                        response += scanOKE.nextLine();
                    }
                scanOKE.close();
            }
            JSONObject agifyJson = new JSONObject(response);
            String age1 = String.valueOf(agifyJson.get("age"));
            penjaga.setUmur(age1);
            //Simpan ke database
            penjagaDB.save(penjaga);

            return penjaga;
        }   catch (NoSuchElementException | IOException | JSONException e) {
            throw new ResponseStatusException(
                //Error Message
                HttpStatus.NOT_FOUND, "No Penjaga " + String.valueOf(noPenjaga) + " Not Found."
            );
        }
    }

    @GetMapping(value = "/penjaga/jenisKelamin/{jenisKelamin}")
    private List<PenjagaModel> returnListByJenisKelamin(
            @PathVariable("jenisKelamin") Integer jenisKelamin
    ){
        return penjagaRestService.getListPenjagaByJenisKelamin(jenisKelamin);
    }



}

//            penjaga.setUmur(age1);
//                    penjagaDB.save(penjaga);
//
//                    return penjaga;
//                    }catch (NoSuchElementException | IOException | JSONException e) {
//                    throw new ResponseStatusException(
//                    HttpStatus.NOT_FOUND, "No Penjaga " + String.valueOf(noPenjaga) + " Not Found."
//                    );

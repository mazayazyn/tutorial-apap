package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.repository.PenjagaDB;
import apap.tutorial.cineplux.rest.PenjagaDetail;
import apap.tutorial.cineplux.rest.Setting;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.io.IOException;
import java.time.LocalTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class PenjagaRestServiceImpl implements PenjagaRestService{

//    private final WebClient webClient;

    @Autowired
    private PenjagaDB penjagaDB;

    @Override
    public List<PenjagaModel> retrieveListPenjaga(){
        return penjagaDB.findAll();
    }

    @Override
    public PenjagaModel createPenjaga(PenjagaModel penjaga) {
        return penjagaDB.save(penjaga);
    }

    @Override
    public PenjagaModel getPenjagaByNoPenjaga(Long noPenjaga) {
        Optional<PenjagaModel> penjaga = penjagaDB.findByNoPenjaga(noPenjaga);

        if(penjaga.isPresent()){
            return penjaga.get();
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public void deletePenjaga(Long noPenjaga) {
        LocalTime now = LocalTime.now();
        PenjagaModel penjaga = getPenjagaByNoPenjaga(noPenjaga);
            penjagaDB.delete(penjaga);
    }

    @Override
    public PenjagaModel updatePenjaga(Long noPenjaga, PenjagaModel penjagaUpdate) {
        PenjagaModel penjaga = getPenjagaByNoPenjaga(noPenjaga);
        penjaga.setNamaPenjaga(penjagaUpdate.getNamaPenjaga());
        penjaga.setBioskop(penjagaUpdate.getBioskop());
        penjaga.setJenisKelamin(penjagaUpdate.getJenisKelamin());
        return penjagaDB.save(penjaga);
    }

}

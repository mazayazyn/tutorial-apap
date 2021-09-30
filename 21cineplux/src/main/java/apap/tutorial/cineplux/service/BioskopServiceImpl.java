package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.repository.BioskopDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BioskopServiceImpl implements BioskopService {

    @Autowired
    BioskopDB bioskopDB;

    @Override
    public void addBioskop(BioskopModel bioskop) {
        bioskopDB.save(bioskop);
    }

    @Override
    public void updateBioskop(BioskopModel bioskop) {
        bioskopDB.save(bioskop);
    }

    @Override
    public List<BioskopModel> getBioskopList() {
        return bioskopDB.findAll(Sort.by(Sort.Direction.ASC, "namaBioskop"));
    }

    @Override
    public void deleteBioskop(BioskopModel bioskop) {
        bioskopDB.delete(bioskop);
    }

    @Override
    public boolean checkPenjaga(BioskopModel bioskop) {
        if (bioskop.getListPenjaga().isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public BioskopModel getBioskopByNoBioskop(Long noBioskop) {
        Optional<BioskopModel> bioskop = bioskopDB.findByNoBioskop(noBioskop);
        if (bioskop.isPresent()) {
            return bioskop.get();
        }
        return null;
    }

    @Override
    public boolean getSedangTutup (BioskopModel bioskop){
        LocalTime time = LocalTime.now();
        LocalTime a1 = bioskop.getWaktuBuka();
        LocalTime a2 = bioskop.getWaktuTutup();

        int isOpen = time.compareTo(a1);
        int isClosed = time.compareTo(a2);

        return ((isOpen <= 0 || isClosed >= 0) ? true : false);
    }

}

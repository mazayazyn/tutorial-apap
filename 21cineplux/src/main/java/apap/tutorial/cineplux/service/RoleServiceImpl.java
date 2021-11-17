package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.RoleModel;
import apap.tutorial.cineplux.repository.RoleDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDb roleDb;

    @Override
    public List<RoleModel>getListRole() {
        return roleDb.findAll();
    }
}
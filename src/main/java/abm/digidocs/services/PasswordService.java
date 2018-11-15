package abm.digidocs.services;

import abm.digidocs.daos.CrudDao;
import abm.digidocs.models.PasswordModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasswordService implements CrudService<PasswordModel, String> {

    @Autowired
    private CrudDao<PasswordModel, String> passwordDao;

    @Override
    public void save(PasswordModel passwordModel) {
        passwordDao.add(passwordModel);
    }

    @Override
    public void update(PasswordModel passwordModel) {

    }

    @Override
    public void delete(String s) {

    }

    @Override
    public PasswordModel findOne(String s) {
        return null;
    }

    @Override
    public List<PasswordModel> findAll() {
        return passwordDao.findAll();
    }
}

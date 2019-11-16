package abm.digidocs.services;

import abm.digidocs.daos.CrudDao;
import abm.digidocs.formatters.Format;
import abm.digidocs.formatters.FormatterFactory;
import abm.digidocs.models.PasswordModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PasswordService implements CrudService<PasswordModel, String> {

    @Autowired
    private CrudDao<PasswordModel, String> passwordDao;

    @Autowired
    private FormatterFactory formatterFactory;

    @Override
    public void save(PasswordModel passwordModel) {
        passwordModel.encrypt();
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
        return null;
    }

    @Override
    public String findAll(Format format) {
        return formatterFactory.get(format).format(passwordDao.findAll().stream().map($ -> {
            $.decrypt();
            $.clearId();
            return $;
        }).collect(Collectors.toList()));
    }
}

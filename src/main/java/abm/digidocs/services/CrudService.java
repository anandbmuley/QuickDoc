package abm.digidocs.services;

import abm.digidocs.formatters.Format;

import java.util.List;

public interface CrudService<Model, Id> {

    void save(Model model);

    void update(Model model);

    void delete(Id id);

    Model findOne(Id id);

    List<Model> findAll();

    String findAll(Format format);

}

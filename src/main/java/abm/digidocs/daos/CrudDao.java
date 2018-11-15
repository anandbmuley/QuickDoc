package abm.digidocs.daos;

import java.util.List;

public interface CrudDao<Model,Id> {

    void add(Model model);

    List<Model> findAll();

}

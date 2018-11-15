package abm.digidocs.daos;

import abm.digidocs.models.NoteModel;

public interface NoteDao {

    void add(NoteModel model);

    NoteModel searchById(String id);

    void update(NoteModel model);

    void delete(String id);

}

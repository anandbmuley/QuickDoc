package abm.digidocs.daos;

import abm.digidocs.models.NoteModel;

import java.util.List;


public interface NoteDao {

    void add(NoteModel model);

    List<NoteModel> searchByTitle(String title);

    NoteModel searchById(String id);

    void update(NoteModel model);

    void delete(String id);

    List<NoteModel> searchByTag(String text);

}

package abm.digidocs.services;

import abm.digidocs.models.NoteModel;

import java.util.List;

public interface NoteService {

    void add(NoteModel noteModel);

    List<NoteModel> searchByTitle(String title);

    void update(NoteModel noteModel);

    NoteModel searchById(String id);

    void delete(String id);

    List<NoteModel> searchByTag(String text);
}

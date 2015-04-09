package abm.digidocs.services;

import abm.digidocs.daos.NoteDao;
import abm.digidocs.models.NoteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteDao noteDao;

    @Override
    public void add(NoteModel noteModel) {
        Date today = new Date();
        noteModel.setDate(today);
        noteDao.add(noteModel);
    }

    @Override
    public List<NoteModel> searchByTitle(String title) {
        return noteDao.searchByTitle(title);
    }

    @Override
    public void update(NoteModel noteModel) {
        noteDao.update(noteModel);
    }

    @Override
    public NoteModel searchById(String id) {
        return noteDao.searchById(id);
    }

    @Override
    public void delete(String id) {
        noteDao.delete(id);
    }

    @Override
    public List<NoteModel> searchByTag(String text) {
        return noteDao.searchByTag(text);
    }
}

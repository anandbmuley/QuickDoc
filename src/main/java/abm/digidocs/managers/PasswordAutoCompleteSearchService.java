package abm.digidocs.managers;


import abm.digidocs.daos.SearcheableDao;
import abm.digidocs.models.NoteJson;
import abm.digidocs.models.NoteModel;
import abm.digidocs.models.PasswordModel;
import abm.digidocs.models.SearchNoteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PasswordAutoCompleteSearchService extends SearchManager implements AutoCompleteSearchService<SearchNoteModel, NoteJson>, SearchService<PasswordModel, String> {

    @Autowired
    private SearcheableDao<PasswordModel, String> passwordSearchDao;

    @Override
    public List<NoteJson> search(SearchNoteModel searchNoteModel) {
        List<NoteJson> searchResults = Collections.emptyList();
        if (SearchNoteModel.SEARCH_BY.TAGS.getSearchBy().equals(
                searchNoteModel.getSearchBy())) {
            searchResults = convertToJson(passwordSearchDao.searchByTag(searchNoteModel.getTerm()));
        } else if (SearchNoteModel.SEARCH_BY.TITLE.getSearchBy().equals(searchNoteModel.getSearchBy())) {
            searchResults = convertToJson(passwordSearchDao.searchByTitle(searchNoteModel.getTerm()));
        }
        return searchResults;
    }

    @Override
    public List<PasswordModel> searchByTitle(String title) {
        return passwordSearchDao.searchByTitle(title);
    }
}

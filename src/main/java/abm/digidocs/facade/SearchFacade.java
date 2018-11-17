package abm.digidocs.facade;

import abm.digidocs.daos.SearcheableDao;
import abm.digidocs.managers.AutoCompleteSearchService;
import abm.digidocs.managers.SearchManager;
import abm.digidocs.managers.SearchService;
import abm.digidocs.models.NoteJson;
import abm.digidocs.models.SearchNoteModel;
import abm.digidocs.models.SearcheableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchFacade extends SearchManager implements AutoCompleteSearchService<SearchNoteModel, NoteJson>, SearchService<SearcheableModel, String> {

    @Autowired
    private List<AutoCompleteSearchService<SearchNoteModel, NoteJson>> searchServices;

    @Autowired
    private List<SearcheableDao> searchDaos;

    @Override
    public List<NoteJson> search(SearchNoteModel searchNoteModel) {
        List<NoteJson> allSearces = new ArrayList<>();
        for (AutoCompleteSearchService<SearchNoteModel, NoteJson> searchService : searchServices) {
            allSearces.addAll(searchService.search(searchNoteModel));
        }
        return allSearces;
    }

    @Override
    public List<SearcheableModel> searchByTitle(String title) {
        List<SearcheableModel> allSearches = new ArrayList<>();
        for (SearcheableDao searcheableDao : searchDaos) {
            allSearches.addAll(searcheableDao.searchByTitle(title));
        }
        return allSearches;
    }
}

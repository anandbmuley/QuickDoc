package abm.digidocs.managers;

import abm.digidocs.models.NoteJson;
import abm.digidocs.models.NoteModel;
import abm.digidocs.models.SearchNoteModel;
import abm.digidocs.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class SearchManager {

    @Autowired
    private NoteService noteService;

    public List<NoteJson> search(SearchNoteModel searchNoteModel) {
        List<NoteJson> searchResults = Collections.emptyList();
        if (SearchNoteModel.SEARCH_BY.TAGS.getSearchBy().equals(
                searchNoteModel.getSearchBy())) {
            searchResults = convertToJson(noteService.searchByTag(searchNoteModel.getTerm()));
        } else if (SearchNoteModel.SEARCH_BY.TITLE.getSearchBy().equals(searchNoteModel.getSearchBy())) {
            searchResults = convertToJson(noteService.searchByTitle(searchNoteModel.getTerm()));
        }
        return searchResults;
    }

    private List<NoteJson> convertToJson(List<NoteModel> notes) {
        List<NoteJson> noteJsons = new ArrayList<>();
        for (NoteModel noteModel : notes) {
            NoteJson noteJson = new NoteJson(noteModel.getTitle(), noteModel.getTitle(), noteModel.getTitle());
            noteJsons.add(noteJson);
        }
        return noteJsons;
    }
}

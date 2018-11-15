package abm.digidocs.controllers;

import abm.digidocs.managers.AutoCompleteSearchService;
import abm.digidocs.models.NoteJson;
import abm.digidocs.models.SearchNoteModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public abstract class AutoCompleteSearchController {

    private AutoCompleteSearchService<SearchNoteModel, NoteJson> noteAutoCompleteSearchService;

    public AutoCompleteSearchController(AutoCompleteSearchService<SearchNoteModel, NoteJson> noteAutoCompleteSearchService) {
        this.noteAutoCompleteSearchService = noteAutoCompleteSearchService;
    }

    @ResponseBody
    @RequestMapping("search")
    public List<NoteJson> searchNote(SearchNoteModel searchNoteModel) {
        return noteAutoCompleteSearchService.search(searchNoteModel);
    }

}

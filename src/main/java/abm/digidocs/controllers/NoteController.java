package abm.digidocs.controllers;

import abm.digidocs.managers.AutoCompleteSearchService;
import abm.digidocs.managers.SearchService;
import abm.digidocs.models.NoteJson;
import abm.digidocs.models.NoteModel;
import abm.digidocs.models.SearchNoteModel;
import abm.digidocs.services.NoteService;
import abm.digidocs.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("notes")
public class NoteController extends AutoCompleteSearchController {

    @Autowired
    private NoteService noteService;

    @Autowired
    private SearchService<NoteModel, String> searchService;

    @Autowired
    public NoteController(@Qualifier("noteAutoCompleteSearchService") AutoCompleteSearchService<SearchNoteModel, NoteJson> noteAutoCompleteSearchService) {
        super(noteAutoCompleteSearchService);
    }

    @RequestMapping("getdetails")
    public String getDetails(Model model, NoteModel noteModel) {
        NoteModel note = noteService.searchById(noteModel.getId());
        model.addAttribute("note", note);
        return Page.NOTE_DETAILS;
    }

    @RequestMapping("index")
    public String renderIndex() {
        return Page.INDEX;
    }

    @RequestMapping("add")
    public String renderAddNote() {
        return Page.ADD_NOTE;
    }

    @RequestMapping("savechanges")
    public String saveChanges(Model model, NoteModel noteModel) {
        noteService.update(noteModel);
        return getDetails(model, noteModel);
    }

    @RequestMapping("delete")
    public String deleteNote(NoteModel noteModel) {
        noteService.delete(noteModel.getId());
        return renderSearchNote();
    }

    @RequestMapping("addnew")
    public String addNote(NoteModel noteModel) {
        noteService.add(noteModel);
        return renderAddNote();
    }

    @RequestMapping("searchbytitle")
    public String renderSearchNote() {
        return Page.SEARCH_NOTE;
    }

    @RequestMapping("searchnote")
    public String searchNote(String title, Model model) {
        List<NoteModel> notes = searchService.searchByTitle(title);
        model.addAttribute("notes", notes);
        return renderSearchNote();
    }

}

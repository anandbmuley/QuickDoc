package abm.digidocs.controllers;

import abm.digidocs.managers.SearchManager;
import abm.digidocs.models.NoteJson;
import abm.digidocs.models.NoteModel;
import abm.digidocs.models.SearchNoteModel;
import abm.digidocs.services.NoteService;
import abm.digidocs.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @Autowired
    private SearchManager searchManager;

    @RequestMapping("getdetails")
    public String getDetails(Model model,NoteModel noteModel){
        System.out.println("Fetching details for : "+noteModel.getId());
        NoteModel note = noteService.searchById(noteModel.getId());
        System.out.println("Searched : "+note);
        model.addAttribute("note",note);
        return Page.NOTE_DETAILS;
    }

    @RequestMapping("index")
    public String renderIndex(){
        return Page.INDEX;
    }

    @RequestMapping("add")
    public String renderAddNote(){
        System.out.println("Rendering Add Note...");
        return Page.ADD_NOTE;
    }

    @RequestMapping("savechanges")
    public String saveChanges(Model model,NoteModel noteModel){
        noteService.update(noteModel);
        return getDetails(model,noteModel);
    }

    @RequestMapping("delete")
    public String deleteNote(NoteModel noteModel){
        noteService.delete(noteModel.getId());
        return renderSearchNote();
    }

    @RequestMapping("addnew")
    public String addNote(NoteModel noteModel){
        System.out.println("Adding Note : " + noteModel);
        noteService.add(noteModel);
        return renderAddNote();
    }

    @RequestMapping("searchbytitle")
    public String renderSearchNote(){
        return Page.SEARCH_NOTE;
    }

    @RequestMapping("searchnote")
    public String searchNote(String title,Model model){
        List<NoteModel> notes = noteService.searchByTitle(title);
        model.addAttribute("notes",notes);
        return renderSearchNote();
    }

    @ResponseBody
    @RequestMapping("search")
    public List<NoteJson> searchNote(SearchNoteModel searchNoteModel){
        return searchManager.search(searchNoteModel);
    }



}

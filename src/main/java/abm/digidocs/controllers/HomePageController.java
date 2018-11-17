package abm.digidocs.controllers;

import abm.digidocs.managers.AutoCompleteSearchService;
import abm.digidocs.managers.SearchService;
import abm.digidocs.models.NoteJson;
import abm.digidocs.models.SearchNoteModel;
import abm.digidocs.models.SearcheableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("home")
public class HomePageController extends AutoCompleteSearchController {

    @Autowired
    private SearchService<SearcheableModel, String> searchService;

    @Autowired
    public HomePageController(@Qualifier("searchFacade") AutoCompleteSearchService<SearchNoteModel, NoteJson> searchService) {
        super(searchService);
    }

    @RequestMapping
    public ModelAndView renderHome() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("HomePage");
        return mav;
    }

    @RequestMapping("search-all")
    public String searchAll(String title, RedirectAttributes redirectAttributes) {
        List<SearcheableModel> results = searchService.searchByTitle(title);
        redirectAttributes.addFlashAttribute("searchResults", results);
        return "redirect:/home";
    }

}

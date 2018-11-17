package abm.digidocs.controllers;

import abm.digidocs.managers.AutoCompleteSearchService;
import abm.digidocs.managers.SearchService;
import abm.digidocs.models.NoteJson;
import abm.digidocs.models.PasswordModel;
import abm.digidocs.models.SearchNoteModel;
import abm.digidocs.services.CrudService;
import abm.digidocs.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("passwords")
public class PasswordController extends AutoCompleteSearchController {

    @Autowired
    private CrudService<PasswordModel, String> passwordService;

    @Autowired
    private SearchService<PasswordModel, String> searchService;

    @Autowired
    public PasswordController(@Qualifier("passwordAutoCompleteSearchService") AutoCompleteSearchService<SearchNoteModel, NoteJson> passwordAutoCompleteSearchService) {
        super(passwordAutoCompleteSearchService);
    }

    @RequestMapping("home")
    public ModelAndView mainPage() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(Page.PASSWORDS_HOME);
//        mav.addObject("passwords", passwordService.findAll());
        return mav;
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ModelAndView createNew(PasswordModel passwordModel) {
        passwordService.save(passwordModel);
        ModelAndView mav = new ModelAndView();
        mav.addObject("message", "Password saved successfully !");
        mav.setViewName(Page.PASSWORDS_HOME);
        return mav;
    }

    @RequestMapping("searchpassword")
    public ModelAndView searchNote(String title, Model model) {
        List<PasswordModel> passwordModels = searchService.searchByTitle(title);
        ModelAndView mav = new ModelAndView();
        mav.setViewName(Page.PASSWORDS_HOME);
        mav.addObject("passwords", passwordModels);
        return mav;
    }


}

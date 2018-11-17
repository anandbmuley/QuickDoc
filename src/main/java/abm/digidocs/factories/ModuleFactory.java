package abm.digidocs.factories;

import abm.digidocs.models.SearcheableModel;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public abstract class ModuleFactory {

    public static ModelAndView getModuleToShow(List<SearcheableModel> searcheableModels){
       return null;
    }


}

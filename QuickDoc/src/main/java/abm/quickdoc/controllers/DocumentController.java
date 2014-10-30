package abm.quickdoc.controllers;

import abm.quickdoc.daos.DocumentDaoI;
import abm.quickdoc.models.DocumentModel;
import abm.quickdoc.utils.ViewName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by user on 29/10/14.
 */

@Controller
public class DocumentController {

    @Autowired
    private DocumentDaoI documentDaoI;

    @RequestMapping(value = "index")
    public String renderIndexPage() {
        return ViewName.PAGE_INDEX;
    }

    @RequestMapping("create")
    public String renderCreateDocument(){
        return ViewName.PAGE_CREATE;
    }

    @RequestMapping("save")
    public String saveDocument(DocumentModel document){
        documentDaoI.add(document);
        return renderCreateDocument();
    }

    @RequestMapping("search")
    public String search(String txt,Model model){
        DocumentModel document = documentDaoI.searchByName(txt);
        model.addAttribute("foundDoc",document);
        return ViewName.PAGE_MODIFY;
    }

    @RequestMapping("update")
    public String search(DocumentModel documentModel){
        documentDaoI.update(documentModel);
        return ViewName.PAGE_MODIFY;
    }

}

package abm.quickdoc.controllers;

import abm.quickdoc.daos.DocumentDaoI;
import abm.quickdoc.models.DocumentModel;
import abm.quickdoc.utils.ViewName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

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
    public String renderSearch(){
        return ViewName.PAGE_MODIFY;
    }

//    @RequestMapping("searchdoc")
//    public String searchDoc(String txt,Model model){
//        DocumentModel document = documentDaoI.searchByName(txt);
//        model.addAttribute("foundDoc",document);
//        return renderSearch();
//    }

    @RequestMapping("update")
    public String search(DocumentModel documentModel){
        documentDaoI.update(documentModel);
        return ViewName.PAGE_MODIFY;
    }

    @RequestMapping(value = "searchdoc", method = RequestMethod.GET)
    public @ResponseBody
    List<DocumentModel> searchDocument(String txt) {
        List<DocumentModel> docs = documentDaoI.searchByName(txt);
        return docs;
    }

}

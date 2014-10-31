package abm.quickdoc.daos;

import abm.quickdoc.models.DocumentModel;

import java.util.List;

/**
 * Created by user on 29/10/14.
 */
public interface DocumentDaoI {

    void add(DocumentModel documentModel);

    List<DocumentModel> searchByName(String name);

    void update(DocumentModel documentModel);

}

package abm.quickdoc.daos;

import abm.quickdoc.models.DocumentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

/**
 * Created by user on 29/10/14.
 */
@Repository
public class DocumentDaoImpl implements  DocumentDaoI {

    @Qualifier("mongoTemplate")
    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public void add(DocumentModel documentModel) {
        mongoOperations.save(documentModel);
    }

    @Override
    public DocumentModel searchByName(String name) {
        Query searchQuery = new Query(Criteria.where("name").is(name));
        DocumentModel searchedDoc = mongoOperations.findOne(searchQuery,DocumentModel.class);
        return searchedDoc;
    }

    @Override
    public void update(DocumentModel documentModel) {
        Query searchedQuery = new Query(Criteria.where("name").is(documentModel.getName()));
        mongoOperations.updateFirst(searchedQuery, Update.update("text",documentModel.getText()),DocumentModel.class);
    }
}

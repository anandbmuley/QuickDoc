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

import java.util.List;
import java.util.regex.Pattern;

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
    public List<DocumentModel> searchByName(String name) {
        Query searchQuery = new Query(Criteria.where("name").regex(Pattern.compile(name,Pattern.CASE_INSENSITIVE)));
        List<DocumentModel> searchedDocs = mongoOperations.find(searchQuery,DocumentModel.class);
        return searchedDocs;
    }

    @Override
    public void update(DocumentModel documentModel) {
        Query searchedQuery = new Query(Criteria.where("name").regex(Pattern.compile(documentModel.getName(), Pattern.CASE_INSENSITIVE)));
        mongoOperations.updateFirst(searchedQuery, Update.update("text",documentModel.getText()),DocumentModel.class);
    }
}

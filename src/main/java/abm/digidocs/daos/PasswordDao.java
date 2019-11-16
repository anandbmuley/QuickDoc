package abm.digidocs.daos;

import abm.digidocs.models.PasswordModel;
import abm.digidocs.utils.DBCollections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PasswordDao implements CrudDao<PasswordModel, String>, SearcheableDao<PasswordModel, String> {

    @Qualifier("mongoTemplate")
    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public void add(PasswordModel passwordModel) {
        mongoOperations.insert(passwordModel, DBCollections.PASSWORDS);
    }

    @Override
    public List<PasswordModel> findAll() {
        return mongoOperations.findAll(PasswordModel.class);
    }

    @Override
    public List<PasswordModel> searchByTitle(String title) {
        Query query = new Query(Criteria.where("title").regex(title, "i"));
        //return this.mongoOperations.find(query, NoteModel.class, DBCollections.NOTES);
        return mongoOperations.find(query, PasswordModel.class).stream().map($ -> {
            $.decrypt();
            return $;
        }).collect(Collectors.toList());
    }

    @Override
    public List<PasswordModel> searchByTag(String text) {
        Query query = new Query(Criteria.where("tags").regex(text, "i"));
        return mongoOperations.find(query, PasswordModel.class);
    }
}

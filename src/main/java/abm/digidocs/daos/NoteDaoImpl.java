package abm.digidocs.daos;

import abm.digidocs.models.NoteModel;
import abm.digidocs.utils.DBCollections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NoteDaoImpl implements NoteDao, SearcheableDao<NoteModel, String> {


    @Qualifier("mongoTemplate")
    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public void add(NoteModel noteModel) {
        mongoOperations.insert(noteModel, DBCollections.NOTES);
    }

    @Override
    public List<NoteModel> searchByTitle(String title) {
        Query query = new Query(Criteria.where("title").regex(title, "i"));
        return this.mongoOperations.find(query, NoteModel.class);
    }

    @Override
    public void delete(String id) {
        NoteModel noteModel = mongoOperations.findById(id, NoteModel.class);
        mongoOperations.remove(noteModel);
    }

    @Override
    public List<NoteModel> searchByTag(String text) {
        Query query = new Query(Criteria.where("tags").regex(text, "i"));
        return this.mongoOperations.find(query, NoteModel.class);
    }

    @Override
    public NoteModel searchById(String id) {
        return this.mongoOperations.findById(id, NoteModel.class);
    }

    @Override
    public void update(NoteModel noteModel) {
        mongoOperations.save(noteModel, DBCollections.NOTES);
    }

}

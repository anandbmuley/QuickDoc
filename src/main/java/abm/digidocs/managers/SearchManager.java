package abm.digidocs.managers;

import abm.digidocs.models.NoteJson;
import abm.digidocs.models.NoteModel;
import abm.digidocs.models.SearcheableModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public abstract class SearchManager<T extends SearcheableModel> {

    protected List<NoteJson> convertToJson(List<T> notes) {
        List<NoteJson> noteJsons = new ArrayList<>();
        for (T noteModel : notes) {
            NoteJson noteJson = new NoteJson(noteModel.getTitle(), noteModel.getTitle(), noteModel.getTitle());
            noteJsons.add(noteJson);
        }
        return noteJsons;
    }

}

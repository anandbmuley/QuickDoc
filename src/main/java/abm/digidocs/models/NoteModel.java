package abm.digidocs.models;


import abm.digidocs.utils.DBCollections;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = DBCollections.NOTES)
public class NoteModel extends SearcheableModel {

    @Id
    private String id;
    private String title;
    private String content;
    private String presenter;
    private Date date;
    private List<String> tags;

    public NoteModel() {

    }

    public NoteModel(String title, String content, String presenter, Date date) {
        this.title = title;
        this.content = content;
        this.presenter = presenter;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPresenter() {
        return presenter;
    }

    public void setPresenter(String presenter) {
        this.presenter = presenter;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "NoteModel{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", presenter='" + presenter + '\'' +
                ", date=" + date +
                ", tags=" + tags +
                '}';
    }
}

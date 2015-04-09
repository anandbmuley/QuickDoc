package abm.digidocs.models;

public class NoteJson {

    private  String id;
    private String value;
    private String label;

    public NoteJson() {
    }

    public NoteJson(String id, String value, String label) {
        this.id = id;
        this.value = value;
        this.label = label;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "NoteJson{" +
                "id='" + id + '\'' +
                ", value='" + value + '\'' +
                ", label='" + label + '\'' +
                '}';
    }
}

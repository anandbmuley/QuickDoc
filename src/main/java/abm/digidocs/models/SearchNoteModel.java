package abm.digidocs.models;


public class SearchNoteModel {

    public enum SEARCH_BY{
        TITLE("1"),TAGS("2");

        private String searchBy;

        SEARCH_BY(String searchBy){
            this.searchBy = searchBy;
        }

        public String getSearchBy() {
            return searchBy;
        }
    }

    private String searchBy;
    private String term;

    public SearchNoteModel() {
    }

    public SearchNoteModel(String term, String searchBy) {
        this.term = term;
        this.searchBy = searchBy;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getSearchBy() {
        return searchBy;
    }

    public void setSearchBy(String searchBy) {
        this.searchBy = searchBy;
    }

    @Override
    public String toString() {
        return "SearchNoteModel{" +
                "searchBy='" + searchBy + '\'' +
                ", term='" + term + '\'' +
                '}';
    }
}

package abm.digidocs.daos;

import java.util.List;

public interface SearcheableDao<SearcheableModel, SearchValue> {

    List<SearcheableModel> searchByTitle(SearchValue searchValue);

    List<SearcheableModel> searchByTag(String text);

}

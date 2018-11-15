package abm.digidocs.managers;

import java.util.List;

public interface SearchService<ModelToSearch, SearchValue> {

    List<ModelToSearch> searchByTitle(SearchValue searchValue);

}

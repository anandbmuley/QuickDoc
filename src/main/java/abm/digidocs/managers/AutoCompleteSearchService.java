package abm.digidocs.managers;

import java.util.List;

public interface AutoCompleteSearchService<SearchModel, ResponseModel> {

    List<ResponseModel> search(SearchModel searchModel);

}

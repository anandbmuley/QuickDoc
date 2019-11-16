package abm.digidocs.formatters;

import abm.digidocs.models.PasswordModel;

import java.util.List;

public interface PasswordFormatter {

    String format(List<PasswordModel> passwordModel);

}

package abm.digidocs.formatters;

import abm.digidocs.models.PasswordModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.util.List;

public class XmlFormatter implements PasswordFormatter {

    @Override
    public String format(List<PasswordModel> passwordModel) {
        CsvMapper csvMapper = new CsvMapper();
        CsvSchema csvSchema = csvMapper.schemaFor(PasswordModel.class);
        try {
            return csvMapper.writer(csvSchema.withUseHeader(true)).writeValueAsString(passwordModel);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}

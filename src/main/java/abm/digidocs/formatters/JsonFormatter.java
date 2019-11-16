package abm.digidocs.formatters;

import abm.digidocs.models.PasswordModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;

import java.util.List;

public class JsonFormatter implements PasswordFormatter {

    private ObjectMapper objectMapper;

    public JsonFormatter() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new Jdk8Module());
    }

    @Override
    public String format(List<PasswordModel> passwordModel) {
        try {
            return objectMapper.writeValueAsString(passwordModel);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}

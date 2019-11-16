package abm.digidocs.formatters;

import org.springframework.stereotype.Component;

@Component
public class FormatterFactory {

    public PasswordFormatter get(Format format) {
        PasswordFormatter passwordFormatter = null;
        switch (format) {
            case XML:
                passwordFormatter = new XmlFormatter();
                break;
            case JSON:
                passwordFormatter = new JsonFormatter();
                break;
        }
        return passwordFormatter;
    }

}

package abm.digidocs.controllers.rest;

import abm.digidocs.formatters.Format;
import abm.digidocs.services.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("passwords")
public class PasswordResource {

    private final PasswordService passwordService;

    @Autowired
    public PasswordResource(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @RequestMapping(value = "backup/{format}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void downloadBackup(@PathVariable("format") Format format, HttpServletResponse response) {
        try {
            setResponseContentHeaders(response, format);
            response.getWriter().print(passwordService.findAll(format));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setResponseContentHeaders(HttpServletResponse response, Format format) {
        switch (format) {
            case JSON:
                response.setHeader("Content-Type", "application/json; charset=utf-8");
                response.setHeader("Content-Disposition", "attachment; filename=backup.json");
                break;
            case XML:
                response.setHeader("Content-Type", "text/plain; charset=utf-8");
                response.setHeader("Content-Disposition", "attachment; filename=backup.csv");
                break;
        }

    }

}

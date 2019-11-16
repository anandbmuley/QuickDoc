package abm.digidocs.models;

import abm.digidocs.utils.DBCollections;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Base64;

import static abm.digidocs.facade.Module.PASSWORDS;

@Document(collection = DBCollections.PASSWORDS)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PasswordModel extends SearcheableModel {

    @Id
    private String id;
    private String title;
    private String username;
    private String password;
    private String additionalDetails;

    public PasswordModel() {
        super(PASSWORDS);
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdditionalDetails() {
        return additionalDetails;
    }

    public void setAdditionalDetails(String additionalDetails) {
        this.additionalDetails = additionalDetails;
    }

    public void encrypt() {
        password = Base64.getEncoder().encodeToString(password.getBytes());
    }

    public void decrypt() {
        password = new String(Base64.getDecoder().decode(password));
    }

    public void clearId() {
        id = null;
    }
}

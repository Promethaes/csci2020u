package lab04;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class PrimaryController {

    @FXML
    TextField user;
    @FXML
    PasswordField pass;
    @FXML
    TextField name;
    @FXML
    TextField email;
    @FXML
    TextField phone;
    @FXML
    DatePicker date;


    @FXML
    private void printInput() throws IOException {
        //App.setRoot("secondary");
        System.out.println(user.getText());
        System.out.println(pass.getText());
        System.out.println(name.getText());
        System.out.println(email.getText());
        System.out.println(phone.getText());
        System.out.println(date.getValue());
    }
}

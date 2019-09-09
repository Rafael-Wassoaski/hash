package HashLogin.HashLogin.Screens;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import HashLogin.HashLogin.Database.DB;
import HashLogin.HashLogin.Entidades.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CadastroController implements Initializable{
	
	
	
	@FXML
	private TextField nomeDeUsuario;
	@FXML
	private PasswordField senha;
	@FXML
	private Button cadastro;

	

	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		
		cadastro.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
				User user = new User(nomeDeUsuario.getText(), senha.getText().hashCode());
			
				DB.conn.addUser(user);
				DB.conn.updateDB();
		
				
				
				Stage stage =(Stage) cadastro.getScene().getWindow();
				stage.close();
				Parent root;
				try {
					root = FXMLLoader.load(getClass().getResource("TelaLogin.fxml"));
					stage = new Stage();
					Scene scene = new Scene(root);
					stage.setTitle("Login");
					stage.setScene(scene);
					
					
					stage.show();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
	}

}

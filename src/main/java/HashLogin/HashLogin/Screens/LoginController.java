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

public class LoginController implements Initializable{
	
	@FXML
	private TextField nomeDeUsuario;
	@FXML
	private PasswordField senha;
	@FXML
	private Button login;
	@FXML
	private Text alerta;
	

	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		login.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				User usuario = DB.conn.getUser(nomeDeUsuario.getText());
				
				
				if(usuario == null) {
					alerta.setText("Esse usuário não existe");
					alerta.setVisible(true);
				}else {
					if(usuario.getSenha() == senha.getText().hashCode()) {
						Stage stage = (Stage)login.getScene().getWindow();
						stage.close();
						try {
							
							Parent parent = FXMLLoader.load(getClass().getResource("LoginSucess.fxml"));
							Scene scene = new Scene(parent);
							stage = new Stage();
							stage.setTitle("Sucesso");
							stage.setScene(scene);
					
							stage.show();
							
							
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				
			}
		});
		
	}

}

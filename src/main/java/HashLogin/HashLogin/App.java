package HashLogin.HashLogin;

import com.sun.glass.ui.Application;

import HashLogin.HashLogin.Database.DB;
import HashLogin.HashLogin.Entidades.User;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class App extends javafx.application.Application{
    public static void main( String[] args )
    {
//       User user  = new User("Rafael", "12345");
//       
//       
//       DB.conn.addUser(user);
//       DB.conn.updateDB();
//       
//       System.out.println(DB.conn.getUser("Rafael").getNome());
//       	
//       DB.conn.close();
    	
    	launch(args);
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		Parent parent = FXMLLoader.load(getClass().getResource("Screens/TelaCadastro.fxml"));
		Scene scene = new Scene(parent);
		primaryStage.setScene(scene);
		
		primaryStage.setTitle("Trabalho Hash");
		primaryStage.show();
	
	
	
	}
}

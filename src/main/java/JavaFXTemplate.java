import java.util.HashMap;

import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;


public class JavaFXTemplate extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	
	HashMap<String, Scene> sceneMap; 
	private MenuBar menu;
	private Menu m1;
	private Button b1;
	private TextField t1, t2;
	
	//feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {
		// main menu selection
		primaryStage.setTitle("***Keno Lottery Game***");
		sceneMap = new HashMap<String,Scene>();
		sceneMap.put("mainMenu", createMenuScene(primaryStage));
		sceneMap.put("play", createPlayScene());
		sceneMap.put("rules", createRuleScene());
		
		//Scene scene = new Scene(borderPane, 700,700);
		 primaryStage.setScene(sceneMap.get("mainMenu"));
		 primaryStage.show();
		
		
		// TODO Auto-generated method stub
		/*primaryStage.setTitle("Welcome to JavaFX");
		
		 Rectangle rect = new Rectangle (100, 40, 100, 100);
	     rect.setArcHeight(50);
	     rect.setArcWidth(50);
	     rect.setFill(Color.VIOLET);

	     RotateTransition rt = new RotateTransition(Duration.millis(5000), rect);
	     rt.setByAngle(270);
	     rt.setCycleCount(4);
	     rt.setAutoReverse(true);
	     SequentialTransition seqTransition = new SequentialTransition (
	         new PauseTransition(Duration.millis(500)),
	         rt
	     );
	     seqTransition.play();
	     
	     FadeTransition ft = new FadeTransition(Duration.millis(5000), rect);
	     ft.setFromValue(1.0);
	     ft.setToValue(0.3);
	     ft.setCycleCount(4);
	     ft.setAutoReverse(true);

	     ft.play();
	     BorderPane root = new BorderPane();
	     root.setCenter(rect);
	     
	     Scene scene = new Scene(root, 700,700);
			primaryStage.setScene(scene);
			primaryStage.show();*/
		
				
		
	}
	
	public Scene createMenuScene(Stage primaryStage) {
		menu = new MenuBar(); //a menu bar takes menus as children
		m1 = new Menu("Menu"); 
		
		MenuItem iOne = new MenuItem("Play"); //menu items go inside a menu
		MenuItem iTwo = new MenuItem("Display Rules");
		MenuItem iThree = new MenuItem("Display Odds");
		MenuItem iFour = new MenuItem("Quit");
		//event handler for menu item
						
		iOne.setOnAction(e -> primaryStage.setScene(sceneMap.get("play")));
		m1.getItems().add(iOne); //add menu item to first menu
		iTwo.setOnAction(e-> primaryStage.setScene(sceneMap.get("rules")));
		m1.getItems().add(iTwo);
		//iThree.setOnAction(e->{close();});
		m1.getItems().add(iThree);
		iFour.setOnAction(e->{close();});
		m1.getItems().add(iFour);
				
		menu.getMenus().addAll(m1); //add two menus to the menu bar
		
		GridPane grid = new GridPane();
	    grid.setAlignment(Pos.CENTER);
	    grid.add(menu, 0, 0);
		
		
		HBox menuBox = new HBox(grid);
		
	    //color
	    BorderPane pane = new BorderPane();
		// centered menu pane
		VBox paneCenter = new VBox(menuBox);
		
		pane.setCenter(paneCenter);
		pane.setStyle("-fx-background-color: Grey;");
		
		return new Scene(pane,700,700);
	}
	
	public Scene createPlayScene() {
		BorderPane pane = new BorderPane();
		pane.setStyle("-fx-background-color: Black;");
		
		return new Scene(pane, 700, 700);
	}
	
	public Scene createRuleScene() {
		BorderPane pane = new BorderPane();
		t2 = new TextField();
		t2.setEditable(false);
		t2.setText(WelcomeMenu.getRules());		
		
		VBox paneCenter = new VBox(t2);
		
		pane.setCenter(paneCenter);
		pane.setStyle("-fx-background-color: Blue;");
		return new Scene(pane, 700, 700);
	}
	
	public Scene createOddScene() {
		return null;
	}
	
	private void close() {
		System.exit(-1);
	}

}

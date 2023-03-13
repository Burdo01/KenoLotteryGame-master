import java.util.HashMap;

import javax.swing.JFrame;

import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;


public class JavaFXTemplate extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	
	HashMap<String, Scene> sceneMap; 
	private MenuBar menu;
	private MenuButton mb;
	private Menu m1;
	private TilePane tp;
	private Label l1;
	private ScrollBar sb;
	private Button b1, b2;
	private TextField t1, t2;
	private TextArea textA;
	private ScrollPane sp;
	private Image pic;
	private ImageView v;
	static final int picHeight = 600;
	static final int picWidth = 680;
	
	//feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {
		// main menu selection
		primaryStage.setTitle("*****Keno Lottery Game*****");
		sceneMap = new HashMap<String,Scene>();
		sceneMap.put("mainMenu", createMenuScene(primaryStage));
		sceneMap.put("play", createPlayScene(primaryStage));
		sceneMap.put("rules", createRuleScene(primaryStage));
		sceneMap.put("odds", createOddScene(primaryStage));
		
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
		//menu = new MenuBar(); //a menu bar takes menus as children
	    //m1 = new Menu("Menu");
	    mb = new MenuButton("Menu");
		
		MenuItem iOne = new MenuItem("Play"); //menu items go inside a menu
		MenuItem iTwo = new MenuItem("Display Rules");
		MenuItem iThree = new MenuItem("Display Odds");
		MenuItem iFour = new MenuItem("Quit");
		
		//event handler for menu item			
		iOne.setOnAction(e -> primaryStage.setScene(sceneMap.get("play")));
		mb.getItems().add(iOne); //add menu item to first menu
		iTwo.setOnAction(e-> primaryStage.setScene(sceneMap.get("rules")));
		mb.getItems().add(iTwo);
		iThree.setOnAction(e->primaryStage.setScene(sceneMap.get("odds")));
		mb.getItems().add(iThree);
		iFour.setOnAction(e->{close();});
		mb.getItems().add(iFour);
		
		// create a label
        l1 = new Label();
		//menu.getMenus().addAll(m1); //add all menus to the menu bar
		tp = new TilePane(l1, mb); // adds menus to menu bar tilepane
		
		GridPane grid = new GridPane();
	    grid.setAlignment(Pos.CENTER);
	    grid.add(tp, 600, 600);
		
	    //color
	    BorderPane pane = new BorderPane();
		// centered menu pane
		VBox paneCenter = new VBox(grid);
		
		pane.setCenter(paneCenter);
		pane.setStyle("-fx-background-color: LightBlue;");
		
		return new Scene(pane,700,700);
	}
	
	public Scene createPlayScene(Stage primaryStage) {
		BorderPane pane = new BorderPane();
		pane.setStyle("-fx-background-color: Black;");
		
		return new Scene(pane, 700, 700);
	}
	
	public Scene createRuleScene(Stage primaryStage) {
		BorderPane pane = new BorderPane();
		
		textA = new TextArea();
		sp = new ScrollPane(textA);
		b1 = new Button("Back");
		//sb = new ScrollBar();
		//sb.setOrientation(Orientation.VERTICAL);
		//sp.setFitToWidth(true); 
		
		
		b1.setOnAction(e -> {primaryStage.setScene(sceneMap.get("mainMenu"));});
		HBox bbox = new HBox(b1);
			
		//textA.resize(500,500);
		
		textA.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
		textA.setText(WelcomeMenu.getRules());
		textA.setWrapText(true);
		textA.setEditable(false);
		textA.setVisible(true);
		
		VBox paneC = new VBox(bbox, textA);
		paneC.setAlignment(Pos.CENTER);
        paneC.setPadding(new Insets(10));

        // Set Hgrow for TextField
        VBox.setVgrow(textA, Priority.ALWAYS);
        pane.setCenter(paneC);
		pane.setStyle("-fx-background-color: Black;");
		return new Scene(pane, 700, 700);
	}
	
	public Scene createOddScene(Stage primaryStage) {
		BorderPane pane = new BorderPane();
		b1 = new Button("Back");
		
		b1.setOnAction(e -> primaryStage.setScene(sceneMap.get("mainMenu")));
		HBox bbox = new HBox(b1);
		/*textA = new TextArea();
		t1 = new TextField();
		sp = new ScrollPane(textA);
		textA.resize(400,400);
		textA.setEditable(false);
		textA.setVisible(true);
		*/
		Image pic = new Image("KenoOdds.jpg");
		ImageView v = new ImageView(pic);
		v.setFitHeight(picHeight);
		v.setFitWidth(picWidth);
		v.setPreserveRatio(true);
		
		b2 = new Button();
		//b2.setOnAction(returnButtons);
		b2.setGraphic(v);
		
		//textA.setText(WelcomeMenu.getOdds(odds)); //just an idea but need int value inserted 
		// into function that deals with game odds
		
		VBox paneC = new VBox(bbox, b2);
		paneC.setAlignment(Pos.CENTER);
        paneC.setPadding(new Insets(10));

        // Set Hgrow for TextField
        //VBox.setVgrow(textA, Priority.ALWAYS);
        pane.setCenter(paneC);
		pane.setStyle("-fx-background-color: Black;");
		return new Scene(pane, 700, 700);
	}
	
	private void close() {
		System.exit(-1);
	}

}

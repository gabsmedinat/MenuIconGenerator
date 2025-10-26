package application;
	
import java.util.ArrayList;
import java.util.Iterator;

import application.Icone.type;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.Background;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


public class Main extends Application {
	Icone ic = new Icone();
	
	Scene scene;
	GridPane root;
	
	// Liste du cöté gauche
	public ListView<type> lstViewMenus; 
	ObservableList<type> listeObservableGauche = FXCollections.observableArrayList(
			type.CART,
			type.DISK,
			type.FOLDER,
			type.HOME,
			type.IMAGE,
			type.RETURN,
			type.USER,
			type.CODE,
			type.AI
			);
	
	private ArrayList<String> listeIconesAjoutes = new ArrayList<String>();
	
	// Colonne du milieu
	VBox vBoxBoutons;
	Button btnAjouter;
	Button btnEnlever;
	
	//Icones du côté droite
	Icone icon;
	FlowPane panneauIcones;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			root = new GridPane();
			scene = new Scene(root,500,380);
			
			genererComposants();
			configurerComposants();
			assemblerComposants();
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Component - Edition Menu d'icones");
			primaryStage.sizeToScene();
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void genererComposants() {
		btnAjouter = new Button("Ajouter ->");
		btnEnlever = new Button("<- Enlever");
		
		vBoxBoutons = new VBox(10);
		
		panneauIcones = new FlowPane();
	}
	
	public void configurerComposants() {
		ColumnConstraints col1 = new ColumnConstraints(100,100,Double.MAX_VALUE);
		ColumnConstraints col2 = new ColumnConstraints(100);
		ColumnConstraints col3 = new ColumnConstraints(300);
				
		root.getColumnConstraints().addAll(col1,col2,col3);
		root.setPadding(new Insets(10.0));
		
		GridPane.setHalignment(btnAjouter, HPos.CENTER);
		
		

		
		lstViewMenus = new ListView<type>(listeObservableGauche); 
		lstViewMenus.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
		// Mise en forme VBox des boutons
		vBoxBoutons.setAlignment(Pos.CENTER);
		
		ArrayList<type> listeTemporaire = new ArrayList<type>(); // Elle contiendra l'ensemble de menus choisis
		
		panneauIcones.setHgap(10);
		panneauIcones.setVgap(10);
		panneauIcones.setPadding(new Insets(10));		
		panneauIcones.setBackground(Background.fill(Color.WHITE));
		
		// EVENEMENTS
		
		btnAjouter.setOnMouseClicked(event ->{ 
			listeTemporaire.addAll(lstViewMenus.getSelectionModel().getSelectedItems());
			
			if(listeTemporaire != null) {
				Iterator<type> itListeTemporaire = listeTemporaire.iterator();
				while(itListeTemporaire.hasNext()) {
					type tp = itListeTemporaire.next();
					Icone nvoIcone = new Icone(tp);
					System.out.println("Ajouté: "+nvoIcone.hashCode()); // VOYONS
					listeIconesAjoutes.add(nvoIcone.getName());                  /// LISTE AVEC ICONES
					VBox iconeGenere = nvoIcone.genererIcone();
					panneauIcones.getChildren().add(iconeGenere);
				}
				
				listeObservableGauche.removeAll(listeTemporaire);
				listeTemporaire.removeAll(listeTemporaire);
			}
		});
		
		btnEnlever.setOnMouseClicked(event ->{ 
			int idClique = ic.getClickedID();
			System.out.println("CLICK : " + idClique);
			ArrayList<String> clonListe = new ArrayList<String>();
			clonListe.addAll(listeIconesAjoutes);
			for(String i : clonListe) {
				
				if(i.hashCode() == idClique) {
//					System.out.println("Le bouton appuyé est: "+ i );
//					System.out.println("L'index est: " + listeIconesAjoutes.indexOf(i));
					panneauIcones.getChildren().remove(clonListe.indexOf(i));
					rajouterElements(i);
					listeIconesAjoutes.remove(i);
				}
			}
//			listeObservableGauche.add(type.)
//			System.out.println(listeIconesAjoutes);
			
		});
	
		 
		
	
	}
	
	public void rajouterElements(String element) {
		switch(element) {
		case "ACHAT":
			listeObservableGauche.add(type.CART);
			break;
		case "ENREGISTRER":
			listeObservableGauche.add(type.DISK);
			break;
		case "FOLDER":
			listeObservableGauche.add(type.FOLDER);
			break;
		case "HOME":
			listeObservableGauche.add(type.HOME);
			break;
		case "IMAGE":
			listeObservableGauche.add(type.IMAGE);
			break;
		case "RETOURNER":
			listeObservableGauche.add(type.RETURN);
			break;
		case "UTILISATEUR":
			listeObservableGauche.add(type.USER);
			break;
		case "DEVELOPPEUR":
			listeObservableGauche.add(type.CODE);
			break;
		case "AI":
			listeObservableGauche.add(type.AI);
			break;
		}
	}
	
	public void assemblerComposants() {
		vBoxBoutons.getChildren().addAll(btnAjouter,btnEnlever);
		
		//root.getChildren().addAll(lstViewMenus,vBoxBoutons,panneauIcones);
		root.add(lstViewMenus, 0, 0);
		root.add(vBoxBoutons, 1, 0);
		root.add(panneauIcones, 2, 0);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

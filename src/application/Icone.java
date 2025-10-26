package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.FocusModel;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Icone {
	private static int clickedID;
	
	enum type {
		HOME,
		FOLDER,
		CART,
		DISK,
		IMAGE,
		RETURN,
		USER,
		CODE,
		AI
		};	
		
		String txtIcone;
		Image imgIcone;
		ImageView imgViewIcone;
		Label lblTypeIcone;
		
		VBox icone;
	
		public Icone() {}
		
	
	public Icone(type tp) {
		
		switch(tp) {
		case HOME:
			imgIcone = new Image("HomeIcon_72px.png");
			txtIcone = "HOME";
			break;
		case FOLDER:
			imgIcone = new Image("FolderIcon_72px.png");
			txtIcone = "FOLDER";
			break;
		case CART:
			imgIcone = new Image("CartIcon_72px.png");
			txtIcone = "ACHAT";
			break;
		case DISK:
			imgIcone = new Image("DisketteIcon_72px.png");
			txtIcone = "ENREGISTRER";
			break;
		case IMAGE:
			imgIcone = new Image("ImageIcon_72px.png");
			txtIcone = "IMAGE";
			break;
		case RETURN:
			imgIcone = new Image("ReturnArrowIcon_72px.png");
			txtIcone = "RETOURNER";
			break;
		case USER:
			imgIcone = new Image("UserIcon_72px.png");
			txtIcone = "UTILISATEUR";
			break;
		case CODE:
			imgIcone = new Image("CodeIcon_72px.png");
			txtIcone = "DEVELOPPEUR";
			break;
		case AI:
			imgIcone = new Image("AIIcon_72px.png");
			txtIcone = "AI";
			break;
		}
		imgViewIcone = new ImageView(imgIcone);
		lblTypeIcone = new Label(txtIcone);
		lblTypeIcone.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 10.0));
		
	}

	
	public VBox genererIcone() {
		icone = new VBox(5);
		icone.setPadding(new Insets(5.0));
		
		icone.setFocusTraversable(true);
		icone.setBackground(Background.fill(Color.LIGHTSLATEGREY));
		icone.setBorder(Border.stroke(Color.BLACK));
		icone.getChildren().addAll(imgViewIcone, lblTypeIcone);
		icone.setAlignment(Pos.BOTTOM_CENTER);
		
		// EVENEMENT
		icone.setOnMouseClicked(event ->{
			icone.requestFocus();
			
			clickedID = this.hashCode();
		});
		return icone;
	}
	
	@Override
	public int hashCode() {
		return txtIcone.hashCode();
	}
	
	public int getClickedID() {
		return clickedID;
	};
	
	public String getName() {
		return txtIcone;
	}
	
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	}
}

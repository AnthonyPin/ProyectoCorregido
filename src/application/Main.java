package application;
	
import java.util.List;
import ListaChats.Listachats;
import Mensajes.Message;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;


public class Main extends Application {
	BorderStroke stroke1 = new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(2));
	VBox Login = new VBox();
	Font fuente =Font.font("Script MT Bold",FontWeight.BOLD, FontPosture.ITALIC,25); 
	
	Listachats names = new Listachats();
	
	public void start(Stage primaryStage) {
		Label etqloguin = new Label("Login");
		
		etqloguin.setTextFill(Color.WHITE);
		etqloguin.setFont(Font.font("Freestyle Script",FontWeight.BLACK,60));
		
		Label usuario = new Label("        User:");
		usuario.setFont(fuente);
		usuario.setTextFill(Color.WHITESMOKE);
		TextField ingresaUser = new TextField   ();
		
		
		Label contrasenia = new Label("Password:");
		contrasenia.setFont(fuente);
		contrasenia.setTextFill(Color.WHITE);
		PasswordField ingresacontra = new PasswordField();
		
		Label denegarOpermitir = new Label();
		
		Button btLoguin = new Button();
		btLoguin.setText("Iniciar Sesión");
		btLoguin.setTextFill(Color.BLUE);
		btLoguin.setFont(Font.font("Script MT Bold",FontWeight.BLACK,15));
		btLoguin.setBorder(new Border(stroke1));
		btLoguin.setStyle("-fx-background-color: turquoise");
		btLoguin.setMaxWidth(150);
		btLoguin.setMinHeight(30);
		//btaction.setOnAction(e-> );
		
		
		Pane panelDer = new Pane();
		panelDer.setPrefSize(977, 630);
		panelDer.setLayoutX(391);
		panelDer.setLayoutY(0);
		//Color celeste
		panelDer.setStyle("-fx-background-image:  url('https://images.unsplash.com/photo-1429892494097-cccc61109f58?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8Zm9uZG8lMjBkZSUyMHBhbnRhbGxhJTIwZGUlMjBsYSUyMGx1bmF8ZW58MHx8MHx8&w=1000&q=80'); -fx-background-repeat: "
				+ "no-repeat; -fx-background-size: 977 630; -fx-background-position: center left;");
		
		btLoguin.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (ingresaUser.getText().equals("Milena") && ingresacontra.getText().equals("23112002")) {
					denegarOpermitir.setText("Acceso permitido");
					denegarOpermitir.setTextFill(Color.GREEN);
					
					List<Message> result = names.getUser();
					
					VBox vbox = new VBox();
					vbox.setStyle("-fx-background-image:  url('https://color-hex.org/colors/4e8da6.png'); -fx-background-repeat: "
							+ "no-repeat; -fx-background-size: 400 1300; -fx-background-position: center center;");
					
					
					TextField buscar = new TextField();
					buscar.setPromptText("Buscar contacto...");
					
					
					for(Message us: result) {
						Image fotochats = new Image("https://electronicssoftware.net/wp-content/uploads/user.png");
						ImageView imagenx1 = new ImageView(fotochats);
						imagenx1.setFitHeight(50);
						imagenx1.setFitWidth(50);
						Label lbpara = new Label(us.getPara());
						Label lbfecha = new Label(us.getHora());
						Label lbcontent = new Label(us.getMens());
						
						lbpara.setFont(Font.font("Tunga", FontWeight.BLACK, 15));
						lbcontent.setFont(Font.font("Tunga", FontWeight.BLACK, 10));
						lbfecha.setFont(Font.font("Tunga", FontWeight.BLACK, 10));
							
						GridPane gripaneChatactivos = new GridPane();
						gripaneChatactivos.add(lbpara, 0, 0);
						gripaneChatactivos.add(lbcontent, 0, 1);
						gripaneChatactivos.add(lbfecha, 1, 1);

						gripaneChatactivos.setVgap(10);
						gripaneChatactivos.setHgap(10);
						
						HBox hboxChatActivos = new HBox(15,imagenx1,gripaneChatactivos);
						hboxChatActivos.setPadding(new Insets(10, 0, 0, 10));
					  
						vbox.getChildren().addAll(hboxChatActivos);
						
						//Parte de arriba de los chats
						Label chatseleccionado = new Label("Chat seleccionado");
						chatseleccionado.setPrefSize(977, 75);
						
						chatseleccionado.setTextFill(Color.WHITE);
						chatseleccionado.setFont(Font.font("Tunga",FontWeight.BLACK,25));
						//Color verde oscuro
						chatseleccionado.setStyle("-fx-background-image:  url('https://keramikos.com.ec/1670-home_default/porcelanato-ivory-gris-claro-60x60-rectificado.jpg'); -fx-background-repeat: "
								+ "no-repeat; -fx-background-size: 977 75; -fx-background-position: center center;");
						
						gripaneChatactivos.setId(us.getId()+"");
						
						gripaneChatactivos.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){

							@Override
							public void handle(MouseEvent event) {
								GridPane result =(GridPane) event.getSource();
								
								if (result.getId().equals("1")) {
									
									VBox cuadroMensajes = new VBox();
									cuadroMensajes.setPrefSize(780, 540);
									cuadroMensajes.setLayoutX(90);
									cuadroMensajes.setLayoutY(80);
									cuadroMensajes.setStyle("-fx-background-image:  url('https://i.pinimg.com/236x/bc/3b/b1/bc3bb1b40fd811f0635fffb679c4176c.jpg'); -fx-background-repeat: "
											+ "no-repeat; -fx-background-size: 391 800; -fx-background-position: center left;");
									
									Label mensaje = new Label();
									mensaje.setText("Holaa");
									mensaje.setStyle("-fx-background-image:  url('https://img.freepik.com/foto-gratis/fondo-estudio-fotografo-vacio-resumen-textura-fondo-belleza-azul-claro-oscuro-claro-gris-frio-pared-plana-degradado-blanco-nevado-piso_1258-54160.jpg?w=2000'); -fx-background-repeat: "
											+ "no-repeat; -fx-background-size: 391 700; -fx-background-position: center left;");
									mensaje.setPrefSize(1050, 0);
									mensaje.setTextFill(Color.BLACK);
									mensaje.setFont(Font.font("Arial",FontWeight.BLACK,15));
									
									Label mensaje2 = new Label();
									mensaje2.setText("¿Como estas?");
									mensaje2.setStyle("-fx-background-image:  url('https://img.freepik.com/foto-gratis/fondo-estudio-fotografo-vacio-resumen-textura-fondo-belleza-azul-claro-oscuro-claro-gris-frio-pared-plana-degradado-blanco-nevado-piso_1258-54160.jpg?w=2000'); -fx-background-repeat: "
											+ "no-repeat; -fx-background-size: 391 700; -fx-background-position: center left;");
									mensaje2.setPrefSize(1050, 0);
									mensaje2.setTextFill(Color.BLACK);
									mensaje2.setFont(Font.font("Arial",FontWeight.BLACK,15));
									
									cuadroMensajes.getChildren().addAll(mensaje, mensaje2);
									cuadroMensajes.setBorder(new Border(stroke1));
									cuadroMensajes.setStyle("-fx-background-image:  url('https://thumbs.dreamstime.com/b/fondo-del-cielo-color-en-colores-pastel-suave-de-tono-aire-contexto-fondos-hermosos-belleza-azul-brillante-limpio-clara-clima-nube-147591030.jpg'); -fx-background-repeat: "
											+ "no-repeat; -fx-background-size: 780 540; -fx-background-position: center center;");
									chatseleccionado.setText("Anthony");
									
									ImageView imagenCont1 = new ImageView(new Image("https://electronicssoftware.net/wp-content/uploads/user.png"));
									imagenCont1.setFitWidth(75);
									imagenCont1.setFitHeight(75);
									
									HBox contactoSelc = new HBox(25);
									contactoSelc.setStyle("-fx-background-image:  url('https://keramikos.com.ec/1670-home_default/porcelanato-ivory-gris-claro-60x60-rectificado.jpg'); -fx-background-repeat: "
											+ "no-repeat; -fx-background-size: 975 75; -fx-background-position: center center;");
									contactoSelc.getChildren().addAll(imagenCont1, chatseleccionado);
									
									//Cuadro para escribir mensajes
									TextField texto = new TextField();
									texto.setPrefSize(880, 20);
									texto.setPromptText("Escriba un mensaje...");
									
									VBox mensEnvi = new VBox();
									
									Button button = new Button("Enviar");
									
									button.setOnAction(new EventHandler<ActionEvent>() {

										@Override
										public void handle(ActionEvent arg0) {
											// TODO Auto-generated method stub
											
											Label mensajeEnviado = new Label(texto.getText());
											mensajeEnviado.setPrefSize(1050, 0);
											mensajeEnviado.setTextFill(Color.BLACK);
											mensajeEnviado.setFont(Font.font("Arial",FontWeight.BLACK,15));
			
											mensajeEnviado.setStyle("-fx-background-image:  url('https://i.pinimg.com/236x/bc/3b/b1/bc3bb1b40fd811f0635fffb679c4176c.jpg'); -fx-background-repeat: "
													+ "no-repeat; -fx-background-size: 391 700; -fx-background-position: center left;");
											
											mensEnvi.getChildren().addAll(mensajeEnviado);
											texto.clear();

											cuadroMensajes.getChildren().addAll(mensEnvi);
										}
									});
									
									//Boton para enviar
									HBox panelInfDer = new HBox(25, texto, button);
									panelInfDer.setPrefSize(977, 630);
									panelInfDer.setLayoutX(10);
									panelInfDer.setLayoutY(650);
									
									panelDer.getChildren().addAll(contactoSelc, cuadroMensajes, panelInfDer);
							}
								
								if (result.getId().equals("2")) {
									VBox cuadroMensajes = new VBox();
									cuadroMensajes.setPrefSize(780, 540);
									cuadroMensajes.setLayoutX(90);
									cuadroMensajes.setLayoutY(80);
									cuadroMensajes.setStyle("-fx-background-image:  url('https://i.pinimg.com/236x/bc/3b/b1/bc3bb1b40fd811f0635fffb679c4176c.jpg'); -fx-background-repeat: "
											+ "no-repeat; -fx-background-size: 391 800; -fx-background-position: center left;");
									
									Label mensaje = new Label();
									mensaje.setText("Holaaaaaa");
									mensaje.setStyle("-fx-background-image:  url('https://img.freepik.com/foto-gratis/fondo-estudio-fotografo-vacio-resumen-textura-fondo-belleza-azul-claro-oscuro-claro-gris-frio-pared-plana-degradado-blanco-nevado-piso_1258-54160.jpg?w=2000'); -fx-background-repeat: "
											+ "no-repeat; -fx-background-size: 391 700; -fx-background-position: center left;");
									mensaje.setPrefSize(1050, 0);
									mensaje.setTextFill(Color.BLACK);
									mensaje.setFont(Font.font("Arial",FontWeight.BLACK,15));
									
									Label mensaje2 = new Label();
									mensaje2.setText("¿Que hay?");
									mensaje2.setStyle("-fx-background-image:  url('https://img.freepik.com/foto-gratis/fondo-estudio-fotografo-vacio-resumen-textura-fondo-belleza-azul-claro-oscuro-claro-gris-frio-pared-plana-degradado-blanco-nevado-piso_1258-54160.jpg?w=2000'); -fx-background-repeat: "
											+ "no-repeat; -fx-background-size: 391 700; -fx-background-position: center left;");
									mensaje2.setPrefSize(1050, 0);
									mensaje2.setTextFill(Color.BLACK);
									mensaje2.setFont(Font.font("Arial",FontWeight.BLACK,15));
									
									cuadroMensajes.getChildren().addAll(mensaje, mensaje2);
									cuadroMensajes.setBorder(new Border(stroke1));
									cuadroMensajes.setStyle("-fx-background-image:  url('https://thumbs.dreamstime.com/b/fondo-del-cielo-color-en-colores-pastel-suave-de-tono-aire-contexto-fondos-hermosos-belleza-azul-brillante-limpio-clara-clima-nube-147591030.jpg'); -fx-background-repeat: "
											+ "no-repeat; -fx-background-size: 780 540; -fx-background-position: center center;");
									chatseleccionado.setText("Julissa");
									
									ImageView imagenCont1 = new ImageView(new Image("https://electronicssoftware.net/wp-content/uploads/user.png"));
									imagenCont1.setFitWidth(75);
									imagenCont1.setFitHeight(75);
									
									HBox contactoSelc = new HBox(25);
									contactoSelc.setStyle("-fx-background-image:  url('https://keramikos.com.ec/1670-home_default/porcelanato-ivory-gris-claro-60x60-rectificado.jpg'); -fx-background-repeat: "
											+ "no-repeat; -fx-background-size: 975 75; -fx-background-position: center center;");
									contactoSelc.getChildren().addAll(imagenCont1, chatseleccionado);
									
									//Cuadro para escribir mensajes
									TextField texto = new TextField();
									texto.setPrefSize(880, 20);
									texto.setPromptText("Escriba un mensaje...");
									
									VBox mensEnvi = new VBox();
									
									Button button = new Button("Enviar");
									
									button.setOnAction(new EventHandler<ActionEvent>() {

										@Override
										public void handle(ActionEvent arg0) {
											// TODO Auto-generated method stub
											
											Label mensajeEnviado = new Label(texto.getText());
											mensajeEnviado.setPrefSize(1050, 0);
											mensajeEnviado.setTextFill(Color.BLACK);
											mensajeEnviado.setFont(Font.font("Arial",FontWeight.BLACK,15));
			
											mensajeEnviado.setStyle("-fx-background-image:  url('https://i.pinimg.com/236x/bc/3b/b1/bc3bb1b40fd811f0635fffb679c4176c.jpg'); -fx-background-repeat: "
													+ "no-repeat; -fx-background-size: 391 700; -fx-background-position: center left;");
											
											mensEnvi.getChildren().addAll(mensajeEnviado);
											texto.clear();

											cuadroMensajes.getChildren().addAll(mensEnvi);
										}
									});
									
									//Boton para enviar
									HBox panelInfDer = new HBox(25, texto, button);
									panelInfDer.setPrefSize(977, 630);
									panelInfDer.setLayoutX(10);
									panelInfDer.setLayoutY(650);
									
									panelDer.getChildren().addAll(contactoSelc, cuadroMensajes, panelInfDer);
								}
																						
							if (result.getId().equals("3")) {
								VBox cuadroMensajes = new VBox();
								cuadroMensajes.setPrefSize(780, 540);
								cuadroMensajes.setLayoutX(90);
								cuadroMensajes.setLayoutY(80);
								cuadroMensajes.setStyle("-fx-background-image:  url('https://i.pinimg.com/236x/bc/3b/b1/bc3bb1b40fd811f0635fffb679c4176c.jpg'); -fx-background-repeat: "
										+ "no-repeat; -fx-background-size: 391 800; -fx-background-position: center left;");
								
								Label mensaje = new Label();
								mensaje.setText("Holaaaaaa");
								mensaje.setStyle("-fx-background-image:  url('https://img.freepik.com/foto-gratis/fondo-estudio-fotografo-vacio-resumen-textura-fondo-belleza-azul-claro-oscuro-claro-gris-frio-pared-plana-degradado-blanco-nevado-piso_1258-54160.jpg?w=2000'); -fx-background-repeat: "
										+ "no-repeat; -fx-background-size: 391 700; -fx-background-position: center left;");
								mensaje.setPrefSize(1050, 0);
								mensaje.setTextFill(Color.BLACK);
								mensaje.setFont(Font.font("Arial",FontWeight.BLACK,15));
								
								Label mensaje2 = new Label();
								mensaje2.setText("¿Me pudes hacer un gran favor?");
								mensaje2.setStyle("-fx-background-image:  url('https://img.freepik.com/foto-gratis/fondo-estudio-fotografo-vacio-resumen-textura-fondo-belleza-azul-claro-oscuro-claro-gris-frio-pared-plana-degradado-blanco-nevado-piso_1258-54160.jpg?w=2000'); -fx-background-repeat: "
										+ "no-repeat; -fx-background-size: 391 700; -fx-background-position: center left;");
								mensaje2.setPrefSize(1050, 0);
								mensaje2.setTextFill(Color.BLACK);
								mensaje2.setFont(Font.font("Arial",FontWeight.BLACK,15));
								
								cuadroMensajes.getChildren().addAll(mensaje, mensaje2);
								cuadroMensajes.setBorder(new Border(stroke1));
								cuadroMensajes.setStyle("-fx-background-image:  url('https://thumbs.dreamstime.com/b/fondo-del-cielo-color-en-colores-pastel-suave-de-tono-aire-contexto-fondos-hermosos-belleza-azul-brillante-limpio-clara-clima-nube-147591030.jpg'); -fx-background-repeat: "
										+ "no-repeat; -fx-background-size: 780 540; -fx-background-position: center center;");
								chatseleccionado.setText("Johanna");
								
								ImageView imagenCont1 = new ImageView(new Image("https://electronicssoftware.net/wp-content/uploads/user.png"));
								imagenCont1.setFitWidth(75);
								imagenCont1.setFitHeight(75);
								
								HBox contactoSelc = new HBox(25);
								contactoSelc.setStyle("-fx-background-image:  url('https://keramikos.com.ec/1670-home_default/porcelanato-ivory-gris-claro-60x60-rectificado.jpg'); -fx-background-repeat: "
										+ "no-repeat; -fx-background-size: 975 75; -fx-background-position: center center;");
								contactoSelc.getChildren().addAll(imagenCont1, chatseleccionado);
								
								//Cuadro para escribir mensajes
								TextField texto = new TextField();
								texto.setPrefSize(880, 20);
								texto.setPromptText("Escriba un mensaje...");
								
								VBox mensEnvi = new VBox();
								
								Button button = new Button("Enviar");
								
								button.setOnAction(new EventHandler<ActionEvent>() {

									@Override
									public void handle(ActionEvent arg0) {
																			
										Label mensajeEnviado = new Label(texto.getText());
										mensajeEnviado.setPrefSize(1050, 0);
										mensajeEnviado.setTextFill(Color.BLACK);
										mensajeEnviado.setFont(Font.font("Arial",FontWeight.BLACK,15));
		
										mensajeEnviado.setStyle("-fx-background-image:  url('https://i.pinimg.com/236x/bc/3b/b1/bc3bb1b40fd811f0635fffb679c4176c.jpg'); -fx-background-repeat: "
												+ "no-repeat; -fx-background-size: 391 700; -fx-background-position: center left;");
										
										mensEnvi.getChildren().addAll(mensajeEnviado);
										texto.clear();

										cuadroMensajes.getChildren().addAll(mensEnvi);
									}
								});
								
								//Boton para enviar
								HBox panelInfDer = new HBox(25, texto, button);
								panelInfDer.setPrefSize(977, 630);
								panelInfDer.setLayoutX(10);
								panelInfDer.setLayoutY(650);
								
								panelDer.getChildren().addAll(contactoSelc, cuadroMensajes, panelInfDer);
							}
							
							if (result.getId().equals("4")) {
								VBox cuadroMensajes = new VBox();
								cuadroMensajes.setPrefSize(780, 540);
								cuadroMensajes.setLayoutX(90);
								cuadroMensajes.setLayoutY(80);
								cuadroMensajes.setStyle("-fx-background-image:  url('https://i.pinimg.com/236x/bc/3b/b1/bc3bb1b40fd811f0635fffb679c4176c.jpg'); -fx-background-repeat: "
										+ "no-repeat; -fx-background-size: 391 800; -fx-background-position: center left;");
								
								Label mensaje = new Label();
								mensaje.setText("Hola amigo");
								mensaje.setStyle("-fx-background-image:  url('https://img.freepik.com/foto-gratis/fondo-estudio-fotografo-vacio-resumen-textura-fondo-belleza-azul-claro-oscuro-claro-gris-frio-pared-plana-degradado-blanco-nevado-piso_1258-54160.jpg?w=2000'); -fx-background-repeat: "
										+ "no-repeat; -fx-background-size: 391 700; -fx-background-position: center left;");
								mensaje.setPrefSize(1050, 0);
								mensaje.setTextFill(Color.BLACK);
								mensaje.setFont(Font.font("Arial",FontWeight.BLACK,15));
								
								Label mensaje2 = new Label();
								mensaje2.setText("¿Como has estado?");
								mensaje2.setStyle("-fx-background-image:  url('https://img.freepik.com/foto-gratis/fondo-estudio-fotografo-vacio-resumen-textura-fondo-belleza-azul-claro-oscuro-claro-gris-frio-pared-plana-degradado-blanco-nevado-piso_1258-54160.jpg?w=2000'); -fx-background-repeat: "
										+ "no-repeat; -fx-background-size: 391 700; -fx-background-position: center left;");
								mensaje2.setPrefSize(1050, 0);
								mensaje2.setTextFill(Color.BLACK);
								mensaje2.setFont(Font.font("Arial",FontWeight.BLACK,15));
								
								cuadroMensajes.getChildren().addAll(mensaje, mensaje2);
								cuadroMensajes.setBorder(new Border(stroke1));
								cuadroMensajes.setStyle("-fx-background-image:  url('https://thumbs.dreamstime.com/b/fondo-del-cielo-color-en-colores-pastel-suave-de-tono-aire-contexto-fondos-hermosos-belleza-azul-brillante-limpio-clara-clima-nube-147591030.jpg'); -fx-background-repeat: "
										+ "no-repeat; -fx-background-size: 780 540; -fx-background-position: center center;");
								chatseleccionado.setText("Jorge");
								
								ImageView imagenCont1 = new ImageView(new Image("https://electronicssoftware.net/wp-content/uploads/user.png"));
								imagenCont1.setFitWidth(75);
								imagenCont1.setFitHeight(75);
								
								HBox contactoSelc = new HBox(25);
								contactoSelc.setStyle("-fx-background-image:  url('https://keramikos.com.ec/1670-home_default/porcelanato-ivory-gris-claro-60x60-rectificado.jpg'); -fx-background-repeat: "
										+ "no-repeat; -fx-background-size: 975 75; -fx-background-position: center center;");
								contactoSelc.getChildren().addAll(imagenCont1, chatseleccionado);
								
								//Cuadro para escribir mensajes
								TextField texto = new TextField();
								texto.setPrefSize(880, 20);
								texto.setPromptText("Escriba un mensaje...");
								
								VBox mensEnvi = new VBox();
								
								Button button = new Button("Enviar");
								
								button.setOnAction(new EventHandler<ActionEvent>() {

									@Override
									public void handle(ActionEvent arg0) {
										// TODO Auto-generated method stub
										
										Label mensajeEnviado = new Label(texto.getText());
										mensajeEnviado.setPrefSize(1050, 0);
										mensajeEnviado.setTextFill(Color.BLACK);
										mensajeEnviado.setFont(Font.font("Arial",FontWeight.BLACK,15));
		
										mensajeEnviado.setStyle("-fx-background-image:  url('https://i.pinimg.com/236x/bc/3b/b1/bc3bb1b40fd811f0635fffb679c4176c.jpg'); -fx-background-repeat: "
												+ "no-repeat; -fx-background-size: 391 700; -fx-background-position: center left;");
										
										mensEnvi.getChildren().addAll(mensajeEnviado);
										texto.clear();

										cuadroMensajes.getChildren().addAll(mensEnvi);
									}
								});
								
								//Boton para enviar
								HBox panelInfDer = new HBox(25, texto, button);
								panelInfDer.setPrefSize(977, 630);
								panelInfDer.setLayoutX(10);
								panelInfDer.setLayoutY(650);
								
								panelDer.getChildren().addAll(contactoSelc, cuadroMensajes, panelInfDer);
							}
							
							if (result.getId().equals("5")) {
								VBox cuadroMensajes = new VBox();
								cuadroMensajes.setPrefSize(780, 540);
								cuadroMensajes.setLayoutX(90);
								cuadroMensajes.setLayoutY(80);
								cuadroMensajes.setStyle("-fx-background-image:  url('https://i.pinimg.com/236x/bc/3b/b1/bc3bb1b40fd811f0635fffb679c4176c.jpg'); -fx-background-repeat: "
										+ "no-repeat; -fx-background-size: 391 800; -fx-background-position: center left;");
								
								Label mensaje = new Label();
								mensaje.setText("heeey!!");
								mensaje.setStyle("-fx-background-image:  url('https://img.freepik.com/foto-gratis/fondo-estudio-fotografo-vacio-resumen-textura-fondo-belleza-azul-claro-oscuro-claro-gris-frio-pared-plana-degradado-blanco-nevado-piso_1258-54160.jpg?w=2000'); -fx-background-repeat: "
										+ "no-repeat; -fx-background-size: 391 700; -fx-background-position: center left;");
								mensaje.setPrefSize(1050, 0);
								mensaje.setTextFill(Color.BLACK);
								mensaje.setFont(Font.font("Arial",FontWeight.BLACK,15));
								
								Label mensaje2 = new Label();
								mensaje2.setText("Hola, buenos dias");
								mensaje2.setStyle("-fx-background-image:  url('https://img.freepik.com/foto-gratis/fondo-estudio-fotografo-vacio-resumen-textura-fondo-belleza-azul-claro-oscuro-claro-gris-frio-pared-plana-degradado-blanco-nevado-piso_1258-54160.jpg?w=2000'); -fx-background-repeat: "
										+ "no-repeat; -fx-background-size: 391 700; -fx-background-position: center left;");
								mensaje2.setPrefSize(1050, 0);
								mensaje2.setTextFill(Color.BLACK);
								mensaje2.setFont(Font.font("Arial",FontWeight.BLACK,15));
								
								cuadroMensajes.getChildren().addAll(mensaje, mensaje2);
								cuadroMensajes.setBorder(new Border(stroke1));
								cuadroMensajes.setStyle("-fx-background-image:  url('https://thumbs.dreamstime.com/b/fondo-del-cielo-color-en-colores-pastel-suave-de-tono-aire-contexto-fondos-hermosos-belleza-azul-brillante-limpio-clara-clima-nube-147591030.jpg'); -fx-background-repeat: "
										+ "no-repeat; -fx-background-size: 780 540; -fx-background-position: center center;");
								chatseleccionado.setText("Miguel");
								
								ImageView imagenCont1 = new ImageView(new Image("https://electronicssoftware.net/wp-content/uploads/user.png"));
								imagenCont1.setFitWidth(75);
								imagenCont1.setFitHeight(75);
								
								HBox contactoSelc = new HBox(25);
								contactoSelc.setStyle("-fx-background-image:  url('https://keramikos.com.ec/1670-home_default/porcelanato-ivory-gris-claro-60x60-rectificado.jpg'); -fx-background-repeat: "
										+ "no-repeat; -fx-background-size: 975 75; -fx-background-position: center center;");
								contactoSelc.getChildren().addAll(imagenCont1, chatseleccionado);
								
								//Cuadro para escribir mensajes
								TextField texto = new TextField();
								texto.setPrefSize(880, 20);
								texto.setPromptText("Escriba un mensaje...");
								
								VBox mensEnvi = new VBox();
								
								Button button = new Button("Enviar");
								
								button.setOnAction(new EventHandler<ActionEvent>() {

									@Override
									public void handle(ActionEvent arg0) {
										// TODO Auto-generated method stub
										
										Label mensajeEnviado = new Label(texto.getText());
										mensajeEnviado.setPrefSize(1050, 0);
										mensajeEnviado.setTextFill(Color.BLACK);
										mensajeEnviado.setFont(Font.font("Arial",FontWeight.BLACK,15));
		
										mensajeEnviado.setStyle("-fx-background-image:  url('https://i.pinimg.com/236x/bc/3b/b1/bc3bb1b40fd811f0635fffb679c4176c.jpg'); -fx-background-repeat: "
												+ "no-repeat; -fx-background-size: 391 700; -fx-background-position: center left;");
										
										mensEnvi.getChildren().addAll(mensajeEnviado);
										texto.clear();

										cuadroMensajes.getChildren().addAll(mensEnvi);
									}
								});
								
								//Boton para enviar
								HBox panelInfDer = new HBox(25, texto, button);
								panelInfDer.setPrefSize(977, 630);
								panelInfDer.setLayoutX(10);
								panelInfDer.setLayoutY(650);
								
								panelDer.getChildren().addAll(contactoSelc, cuadroMensajes, panelInfDer);
							}
							
							if (result.getId().equals("6")) {
								VBox cuadroMensajes = new VBox();
								cuadroMensajes.setPrefSize(780, 540);
								cuadroMensajes.setLayoutX(90);
								cuadroMensajes.setLayoutY(80);
								cuadroMensajes.setStyle("-fx-background-image:  url('https://i.pinimg.com/236x/bc/3b/b1/bc3bb1b40fd811f0635fffb679c4176c.jpg'); -fx-background-repeat: "
										+ "no-repeat; -fx-background-size: 391 800; -fx-background-position: center left;");
								
								Label mensaje = new Label();
								mensaje.setText("A los tiempos!!");
								mensaje.setStyle("-fx-background-image:  url('https://img.freepik.com/foto-gratis/fondo-estudio-fotografo-vacio-resumen-textura-fondo-belleza-azul-claro-oscuro-claro-gris-frio-pared-plana-degradado-blanco-nevado-piso_1258-54160.jpg?w=2000'); -fx-background-repeat: "
										+ "no-repeat; -fx-background-size: 391 700; -fx-background-position: center left;");
								mensaje.setPrefSize(1050, 0);
								mensaje.setTextFill(Color.BLACK);
								mensaje.setFont(Font.font("Arial",FontWeight.BLACK,15));
								
								Label mensaje2 = new Label();
								mensaje2.setText("Hola, como asi?");
								mensaje2.setStyle("-fx-background-image:  url('https://img.freepik.com/foto-gratis/fondo-estudio-fotografo-vacio-resumen-textura-fondo-belleza-azul-claro-oscuro-claro-gris-frio-pared-plana-degradado-blanco-nevado-piso_1258-54160.jpg?w=2000'); -fx-background-repeat: "
										+ "no-repeat; -fx-background-size: 391 700; -fx-background-position: center left;");
								mensaje2.setPrefSize(1050, 0);
								mensaje2.setTextFill(Color.BLACK);
								mensaje2.setFont(Font.font("Arial",FontWeight.BLACK,15));
								
								cuadroMensajes.getChildren().addAll(mensaje, mensaje2);
								cuadroMensajes.setBorder(new Border(stroke1));
								cuadroMensajes.setStyle("-fx-background-image:  url('https://thumbs.dreamstime.com/b/fondo-del-cielo-color-en-colores-pastel-suave-de-tono-aire-contexto-fondos-hermosos-belleza-azul-brillante-limpio-clara-clima-nube-147591030.jpg'); -fx-background-repeat: "
										+ "no-repeat; -fx-background-size: 780 540; -fx-background-position: center center;");
								chatseleccionado.setText("Vanessa");
								
								ImageView imagenCont1 = new ImageView(new Image("https://electronicssoftware.net/wp-content/uploads/user.png"));
								imagenCont1.setFitWidth(75);
								imagenCont1.setFitHeight(75);
								
								HBox contactoSelc = new HBox(25);
								contactoSelc.setStyle("-fx-background-image:  url('https://keramikos.com.ec/1670-home_default/porcelanato-ivory-gris-claro-60x60-rectificado.jpg'); -fx-background-repeat: "
										+ "no-repeat; -fx-background-size: 975 75; -fx-background-position: center center;");
								contactoSelc.getChildren().addAll(imagenCont1, chatseleccionado);
								
								//Cuadro para escribir mensajes
								TextField texto = new TextField();
								texto.setPrefSize(880, 20);
								texto.setPromptText("Escriba un mensaje...");
								
								VBox mensEnvi = new VBox();
								
								Button button = new Button("Enviar");
								
								button.setOnAction(new EventHandler<ActionEvent>() {

									@Override
									public void handle(ActionEvent arg0) {
										// TODO Auto-generated method stub
										
										Label mensajeEnviado = new Label(texto.getText());
										mensajeEnviado.setPrefSize(1050, 0);
										mensajeEnviado.setTextFill(Color.BLACK);
										mensajeEnviado.setFont(Font.font("Arial",FontWeight.BLACK,15));
		
										mensajeEnviado.setStyle("-fx-background-image:  url('https://i.pinimg.com/236x/bc/3b/b1/bc3bb1b40fd811f0635fffb679c4176c.jpg'); -fx-background-repeat: "
												+ "no-repeat; -fx-background-size: 391 700; -fx-background-position: center left;");
										
										mensEnvi.getChildren().addAll(mensajeEnviado);
										texto.clear();

										cuadroMensajes.getChildren().addAll(mensEnvi);
									}
								});
								
								//Boton para enviar
								HBox panelInfDer = new HBox(25, texto, button);
								panelInfDer.setPrefSize(977, 630);
								panelInfDer.setLayoutX(10);
								panelInfDer.setLayoutY(650);
								
								panelDer.getChildren().addAll(contactoSelc, cuadroMensajes, panelInfDer);
							}
						
						}
					});
					
					}
				
					ScrollPane scrollcontIzq = new ScrollPane();
					scrollcontIzq.setContent(vbox);
					scrollcontIzq.setFitToWidth(true);
					scrollcontIzq.setPrefWidth(400);
					scrollcontIzq.setPrefHeight(627);
					scrollcontIzq.setHbarPolicy(ScrollBarPolicy.NEVER);
					scrollcontIzq.setVbarPolicy(ScrollBarPolicy.ALWAYS);
					scrollcontIzq.setStyle("-fx-background-image:  url('https://color-hex.org/colors/402d22.png'); -fx-background-repeat: "
							+ "no-repeat; -fx-background-size: 391 700; -fx-background-position: center left;");
					
				
					
					
					VBox ladoIzquierdo = new VBox();
			        
			        HBox usuario = new HBox(20);
					ImageView imagenU = new ImageView(new Image("https://images.vexels.com/media/users/3/154663/isolated/preview/1040feae4f085a107b45bfa5fa927209-icono-de-contacto-de-conversacion-de-reunion.png"));
					imagenU.setFitWidth(60);
					imagenU.setFitHeight(50);
					Label lblusuario = new Label("Milena");
					lblusuario.setTextFill(Color.WHITE);
					lblusuario.setFont(Font.font("Tunga",FontWeight.BLACK,25));
					lblusuario.setLayoutY(200);
					usuario.getChildren().addAll(imagenU, lblusuario);
					VBox panelUsu = new VBox();
					panelUsu.getChildren().addAll(usuario);
					
					//Ventana principal
					var root = new Pane(ladoIzquierdo, panelDer);
					root.setPrefSize(1300, 600);
					
					usuario.setStyle("-fx-background-image:  url('https://www.htmlcsscolor.com/preview/gallery/F2CB05.png'); -fx-background-repeat: "
							+ "no-repeat; -fx-background-size: 450 100; -fx-background-position: center center;");
					ladoIzquierdo.getChildren().addAll(panelUsu, buscar, scrollcontIzq);
					
					Scene scene = new Scene(root, 1366, 700);
					primaryStage.getIcons().add(new Image("https://logodownload.org/wp-content/uploads/2017/11/discord-logo-5-1.png"));
					scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					primaryStage.setScene(scene);
					primaryStage.setTitle("Proyecto: Mensajería");
					primaryStage.show();
				}
				else {
					denegarOpermitir.setText("Contraseña incorrecta");
					denegarOpermitir.setTextFill(Color.RED);
				}
			}
		});

		ImageView imagen = new ImageView(new Image("https://images.vexels.com/media/users/3/204412/isolated/preview/4109687dc5e9008b3e3cc9c21dd30151-vista-superior-astronauta-de-color.png"));
		imagen.setFitWidth(100);
		imagen.setFitHeight(100);
		
		ImageView iconUser = new ImageView(new Image("https://www.google.com/search?q=apt+png&sxsrf=ALiCzsaOjmkx6O7Xy0VEBsjdiKlSj6nlTQ:1656822871584&source=lnms&tbm=isch&sa=X&ved=2ahUKEwjrq92V8tv4AhWJRjABHcfTDRcQ_AUoAXoECAEQAw&biw=1360&bih=657&dpr=1#imgrc=LpzCtAm0waglNM"));
		iconUser.setFitWidth(50);
		iconUser.setFitHeight(50);
		
		ImageView iconcontra = new ImageView(new Image("https://www.google.com/search?q=apt+png&sxsrf=ALiCzsaOjmkx6O7Xy0VEBsjdiKlSj6nlTQ:1656822871584&source=lnms&tbm=isch&sa=X&ved=2ahUKEwjrq92V8tv4AhWJRjABHcfTDRcQ_AUoAXoECAEQAw&biw=1360&bih=657&dpr=1#imgrc=LpzCtAm0waglNM"));
		iconcontra.setFitWidth(50);
		iconcontra.setFitHeight(50);
		
		HBox usuarios =new HBox();
		usuarios.getChildren().addAll(iconUser, usuario,ingresaUser);
		usuarios.setAlignment(Pos.BASELINE_CENTER);
		usuarios.setSpacing(6);
		
		HBox contrasenias = new HBox();
		contrasenias.getChildren().addAll(iconcontra,contrasenia,ingresacontra);
		contrasenias.setAlignment(Pos.BASELINE_CENTER);
		contrasenias.setSpacing(4);
		
		Login.setAlignment(Pos.CENTER);
		Login.setSpacing(20);
		Login.getChildren().addAll(imagen,etqloguin,usuarios,contrasenias,btLoguin,denegarOpermitir);
		Login.setStyle("-fx-background-image:  url('https://static.dw.com/image/62175131_303.jpg'); -fx-background-repeat: no-repeat; -fx-background-size: 500 500; -fx-background-position: center center;");
		
		Scene scene = new Scene(Login,450, 460);
		primaryStage.getIcons().add(new Image("data:image/png;base64,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"));
		primaryStage.setScene(scene);
		primaryStage.setTitle("User Login");
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}

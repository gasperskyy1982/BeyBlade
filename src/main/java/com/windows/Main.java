package com.windows;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

/**
 * Main application class.
 *
 * @author Gasperskyy Aleskey
 * @version 1.0
 */

public class Main extends Application {
	private static volatile boolean isGame;
	private boolean isSound = false;
	private String player1Name;
	private String player2Name;
	private Label player1NameLabel;
	private Label player2NameLabel;

	private ImageView fafnir = new ImageView("/images/fafnir.jpg");
	private ImageView horusood = new ImageView("/images/horusood.jpg");
	private ImageView sprizenRequiem = new ImageView("/images/sprizen_requiem.jpg");
	private ImageView voltraek = new ImageView("/images/voltraek_genesis.jpg");
	private ImageView wybron = new ImageView("/images/wybron.jpg");
	private ImageView xcalibur = new ImageView("/images/xcalibur.jpg");
	private ImageView zeitron = new ImageView("/images/zeitron.jpg");
	private ImageView blackGenius = new ImageView("/images/blackGenius.jpg");
	private ImageView luinor = new ImageView("/images/luinor.jpg");

	private ImageView fafnir2 = new ImageView("/images/fafnir.jpg");
	private ImageView horusood2 = new ImageView("/images/horusood.jpg");
	private ImageView sprizenRequiem2 = new ImageView("/images/sprizen_requiem.jpg");
	private ImageView voltraek2 = new ImageView("/images/voltraek_genesis.jpg");
	private ImageView wybron2 = new ImageView("/images/wybron.jpg");
	private ImageView xcalibur2 = new ImageView("/images/xcalibur.jpg");
	private ImageView zeitron2 = new ImageView("/images/zeitron.jpg");
	private ImageView blackGenius2 = new ImageView("/images/blackGenius.jpg");
	private ImageView luinor2 = new ImageView("/images/luinor.jpg");
	private transient Label balancePlayer1;
	private transient Label balancePlayer2;

	private Exchanger<Double> ex1 = new Exchanger<>();
	private BeyBlade bey1;
	private BeyBlade bey2;
	private Stage primaryStage;
	private GameField field;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		
		try {
			GridPane root = new GridPane();
			Button play = new Button("Play");
			root.setAlignment(Pos.TOP_LEFT);
			root.add(play, 2, 2);
			root.setPadding(new Insets(100, 100, 100, 50));
			Scene scene = new Scene(root, 600, 600);
			scene.getStylesheets().add(getClass().getResource("/css/mainPane.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			play.setOnAction((event) -> choosing());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void playSound() {

		Runnable snd = new Runnable() {

			@Override
			public void run() {
				Sound sound = new Sound();
				sound.playSound();
				isSound = true;
			}
		};

		Thread playSound = new Thread(snd);
		playSound.setDaemon(true);
		playSound.start();
	}

	public void choosing() {

		field = new GameField(300, 300);
		if (isSound == false)
			playSound();
		BorderPane root = new BorderPane();

		Label chooseTitle = new Label("Choose Your Player");
		chooseTitle.setId("choose");

		GridPane titlePane = new GridPane();
		titlePane.setAlignment(Pos.TOP_RIGHT);
		titlePane.getChildren().add(chooseTitle);
		titlePane.setPadding(new Insets(10, 10, 10, 0));

		Label player1 = new Label("Player 1");
		Label player2 = new Label("Player 2");
		
		if (player1Name == null) player1NameLabel = new Label("Name: ");
		else player1NameLabel.setText("Name: " + player1Name);
		if (player2Name == null) player2NameLabel = new Label("Name: ");
		else player2NameLabel.setText("Name: " + player2Name);
		
		TextField player1NameField = new TextField();
		TextField player2NameField = new TextField();
		Label player1Bey = new Label("Bey: ");
		Label player2Bey = new Label("Bey: ");

		TilePane player1Beys = new TilePane();

		Label fafnirLabel = new Label("Fafnir", fafnir);
		fafnirLabel.setText("");
		fafnirLabel.setOnMouseClicked((e) -> {
			player1Bey.setText("Bey: " + "Fafnir");
		});

		Label blackGeniusLabel = new Label("BlackGeniusr", blackGenius);
		blackGeniusLabel.setText("");
		blackGeniusLabel.setOnMouseClicked((e) -> {
			player1Bey.setText("Bey: " + "BlackGenius");
		});

		Label horusoodLabel = new Label("Horusood", horusood);
		horusoodLabel.setText("");
		horusoodLabel.setOnMouseClicked((e) -> {
			player1Bey.setText("Bey: " + "Horusood");
		});

		Label luinorLabel = new Label("luinor", luinor);
		luinorLabel.setText("");
		luinorLabel.setOnMouseClicked((e) -> {
			player1Bey.setText("Bey: " + "Luinor");
		});

		Label sprizenRequiemLabel = new Label("SprizenRequiem", sprizenRequiem);
		sprizenRequiemLabel.setText("");
		sprizenRequiemLabel.setOnMouseClicked((e) -> {
			player1Bey.setText("Bey: " + "SprizenRequiem");
		});

		Label voltraekLabel = new Label("Voltraek", voltraek);
		voltraekLabel.setText("");
		voltraekLabel.setOnMouseClicked((e) -> {
			player1Bey.setText("Bey: " + "Voltraek");
		});

		Label wybronLabel = new Label("Wybron", wybron);
		wybronLabel.setText("");
		wybronLabel.setOnMouseClicked((e) -> {
			player1Bey.setText("Bey: " + "Wybron");
		});

		Label xcaliburLabel = new Label("Xcalibur", xcalibur);
		xcaliburLabel.setText("");
		xcaliburLabel.setOnMouseClicked((e) -> {
			player1Bey.setText("Bey: " + "Xcalibur");
		});

		Label zeitronLabel = new Label("Zeitron", zeitron);
		zeitronLabel.setText("");
		zeitronLabel.setOnMouseClicked((e) -> {
			player1Bey.setText("Bey: " + "Zeitron");
		});

		player1Beys.getChildren().add(fafnirLabel);
		player1Beys.getChildren().add(blackGeniusLabel);
		player1Beys.getChildren().add(horusoodLabel);
		player1Beys.getChildren().add(luinorLabel);
		player1Beys.getChildren().add(sprizenRequiemLabel);
		player1Beys.getChildren().add(voltraekLabel);
		player1Beys.getChildren().add(wybronLabel);
		player1Beys.getChildren().add(xcaliburLabel);
		player1Beys.getChildren().add(zeitronLabel);

		TilePane player2Beys = new TilePane();

		Label fafnirLabel2 = new Label("Fafnir", fafnir2);
		fafnirLabel2.setText("");
		fafnirLabel2.setOnMouseClicked((e) -> {
			player2Bey.setText("Bey: " + "Fafnir");
		});

		Label blackGeniusLabel2 = new Label("BlackGenius", blackGenius2);
		blackGeniusLabel2.setText("");
		blackGeniusLabel2.setOnMouseClicked((e) -> {
			player2Bey.setText("Bey: " + "BlackGenius");
		});

		Label horusoodLabel2 = new Label("Horusood", horusood2);
		horusoodLabel2.setText("");
		horusoodLabel2.setOnMouseClicked((e) -> {
			player2Bey.setText("Bey: " + "Horusood");
		});

		Label luinorLabel2 = new Label("luinor", luinor2);
		luinorLabel2.setText("");
		luinorLabel2.setOnMouseClicked((e) -> {
			player2Bey.setText("Bey: " + "Luinor");
		});

		Label sprizenRequiemLabel2 = new Label("SprizenRequiem", sprizenRequiem2);
		sprizenRequiemLabel2.setText("");
		sprizenRequiemLabel2.setOnMouseClicked((e) -> {
			player2Bey.setText("Bey: " + "SprizenRequiem");
		});

		Label voltraekLabel2 = new Label("Voltraek", voltraek2);
		voltraekLabel2.setText("");
		voltraekLabel2.setOnMouseClicked((e) -> {
			player2Bey.setText("Bey: " + "Voltraek");
		});

		Label wybronLabel2 = new Label("Wybron", wybron2);
		wybronLabel2.setText("");
		wybronLabel2.setOnMouseClicked((e) -> {
			player2Bey.setText("Bey: " + "Wybron");
		});

		Label xcaliburLabel2 = new Label("Xcalibur", xcalibur2);
		xcaliburLabel2.setText("");
		xcaliburLabel2.setOnMouseClicked((e) -> {
			player2Bey.setText("Bey: " + "Xcalibur");
		});

		Label zeitronLabel2 = new Label("Zeitron", zeitron2);
		zeitronLabel2.setText("");
		zeitronLabel2.setOnMouseClicked((e) -> {
			player2Bey.setText("Bey: " + "Zeitron");
		});

		player2Beys.getChildren().add(fafnirLabel2);
		player2Beys.getChildren().add(blackGeniusLabel2);
		player2Beys.getChildren().add(horusoodLabel2);
		player2Beys.getChildren().add(luinorLabel2);
		player2Beys.getChildren().add(sprizenRequiemLabel2);
		player2Beys.getChildren().add(voltraekLabel2);
		player2Beys.getChildren().add(wybronLabel2);
		player2Beys.getChildren().add(xcaliburLabel2);
		player2Beys.getChildren().add(zeitronLabel2);

		Button setPlayer1Name = new Button("Set Name");
		setPlayer1Name.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				player1Name = player1NameField.getText();
				System.out.println(player1Name);
				player1NameLabel.setText("Name: " + player1Name);
			}
		});

		Button setPlayer2Name = new Button("Set Name");
		setPlayer2Name.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				player2Name = player2NameField.getText();
				System.out.println(player2Name);
				player2NameLabel.setText("Name: " + player2Name);
			}
		});

		Button setPlayer1Bey = new Button("Set Bey");
		setPlayer1Bey.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				switch (player1Bey.getText()) {

				case "Bey: Fafnir": {
					bey1 = new Fafnir(field, ex1);
					break;
				}

				case "Bey: BlackGenius": {
					bey1 = new BlackGenius(field, ex1);
					break;
				}
				case "Bey: Horusood": {
					bey1 = new Horusood(field, ex1);
					break;
				}

				case "Bey: Luinor": {
					bey1 = new Luinor(field, ex1);
					break;
				}
				case "Bey: SprizenRequiem": {
					bey1 = new SprizenRequiem(field, ex1);
					break;
				}
				case "Bey: Voltraek": {
					bey1 = new Voltraek(field, ex1);
					break;
				}
				case "Bey: Wybron": {
					bey1 = new Wybron(field, ex1);
					break;
				}
				case "Bey: Xcalibur": {
					bey1 = new Xcalibur(field, ex1);
					break;
				}
				case "Bey: Zeitron": {
					bey1 = new Zeitron(field, ex1);
					break;
				}

				default:
					break;
				}
			}
		});

		Button setPlayer2Bey = new Button("Set Bey");

		setPlayer2Bey.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (bey1 != null) {
					switch (player2Bey.getText()) {

					case "Bey: Fafnir": {
						bey2 = new Fafnir(field, ex1);
						break;
					}

					case "Bey: BlackGenius": {
						bey2 = new BlackGenius(field, ex1);
						break;
					}
					case "Bey: Horusood": {
						bey2 = new Horusood(field, ex1);
						break;
					}
					case "Bey: Luinor": {
						bey2 = new Luinor(field, ex1);
						break;
					}
					case "Bey: SprizenRequiem": {
						bey2 = new SprizenRequiem(field, ex1);
						break;
					}
					case "Bey: Voltraek": {
						bey2 = new Voltraek(field, ex1);
						break;
					}
					case "Bey: Wybron": {
						bey2 = new Wybron(field, ex1);
						break;
					}
					case "Bey: Xcalibur": {
						bey2 = new Xcalibur(field, ex1);
						break;
					}
					case "Bey: Zeitron": {
						bey2 = new Zeitron(field, ex1);
						break;
					}

					default:
						break;
					}
				}
			}
		});

		GridPane players = new GridPane();
		players.setGridLinesVisible(false);

		players.add(player1, 0, 0);
		players.add(player2, 1, 0);
		players.add(player1NameLabel, 0, 1);
		players.add(player2NameLabel, 1, 1);
		players.add(player1NameField, 0, 2);
		players.add(player2NameField, 1, 2);
		players.add(setPlayer1Name, 0, 3);
		players.add(setPlayer2Name, 1, 3);
		players.add(player1Bey, 0, 4);
		players.add(player2Bey, 1, 4);
		players.add(player1Beys, 0, 5);
		players.add(player2Beys, 1, 5);
		players.add(setPlayer1Bey, 0, 6);
		players.add(setPlayer2Bey, 1, 6);

		ColumnConstraints columnconstraints = new ColumnConstraints();
		columnconstraints.setPrefWidth(300);
		ColumnConstraints columnconstraints1 = new ColumnConstraints();
		columnconstraints1.setPrefWidth(300);
		players.getColumnConstraints().addAll(columnconstraints, columnconstraints1);

		HBox startBox = new HBox();
		Button start = new Button("Start");
		start.setOnAction((event) -> {
			if (bey1 != null && bey2 != null)
				game();
		});

		startBox.setAlignment(Pos.CENTER);
		startBox.getChildren().add(start);

		root.setTop(titlePane);
		root.setCenter(players);
		root.setBottom(startBox);

		Scene scene = new Scene(root, 600, 600);
		scene.getStylesheets().add(getClass().getResource("/css/choosing.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void game() {

		GridPane root = new GridPane();
		root.setAlignment(Pos.TOP_CENTER);
				
		GridPane names = new GridPane();
		names.setPrefSize(600, 150);
		Label bey1Label = new Label();
		bey1Label.setId("bey1Label");
		bey1Label.setText(bey1.getName());
		Label bey2Label = new Label();
		bey2Label.setId("bey2Label");
		bey2Label.setText(bey2.getName());
		Button go = new Button("Go!");
		go.setId("go");

		balancePlayer1 = new Label();
		balancePlayer1.setId("balancePlayer1");
		balancePlayer1.setText("Balance: " + bey1.getBalance());
		balancePlayer2 = new Label();
		balancePlayer2.setId("balancePlayer2");
		balancePlayer2.setText("Balance: " + bey2.getBalance());
		names.setAlignment(Pos.CENTER);
		names.add(bey1Label, 0, 0);
		names.add(go, 1, 0);
		names.add(bey2Label, 2, 0);
		names.add(balancePlayer1, 0, 1);
		names.add(balancePlayer2, 2, 1);

		ColumnConstraints columnConstrains = new ColumnConstraints();
		columnConstrains.setPrefWidth(200);
		ColumnConstraints columnConstrains1 = new ColumnConstraints();
		columnConstrains1.setPrefWidth(200);
		ColumnConstraints columnConstrains2 = new ColumnConstraints();
		columnConstrains2.setPrefWidth(200);
		names.getColumnConstraints().addAll(columnConstrains, columnConstrains1, columnConstrains2);

		GridPane fieldPane = new GridPane();

		BorderPane fields = new BorderPane();
		fieldPane.setGridLinesVisible(true);
		fields.setId("fields");
		fields.getChildren().add(bey1.getBeySmallImage());
		fields.getChildren().add(bey2.getBeySmallImage());
		fields.setPadding(new Insets(110, 150, 150, 150));
		fields.setPrefSize(field.getFieldSizeX() + 50, field.getFieldSizeY() + 50);

		Label player1 = new Label();
		player1.setId("player1Label");
		player1.setText(player1Name);
		Label player2 = new Label();
		player2.setId("player2Label");
		player2.setText(player2Name);

		ColumnConstraints columnConstrains3 = new ColumnConstraints();
		columnConstrains3.setPrefWidth(125);
		ColumnConstraints columnConstrains4 = new ColumnConstraints();
		columnConstrains4.setPrefWidth(350);
		ColumnConstraints columnConstrains5 = new ColumnConstraints();
		columnConstrains5.setPrefWidth(125);
		fieldPane.getColumnConstraints().addAll(columnConstrains3, columnConstrains4, columnConstrains5);

		fieldPane.add(player1, 0, 0);
		fieldPane.add(fields, 1, 0);
		fieldPane.add(player2, 2, 0);

		root.add(names, 0, 0);
		root.add(fieldPane, 0, 1);

		bey1.setStartBey();
		bey2.setStartBey();

		go.setOnAction((event) -> {
			if (isGame == false) {
				isGame = true;
				bey1FinalRun();
				bey2FinalRun();
			}
		});

		Scene scene = new Scene(root, 600, 600);
		scene.getStylesheets().add(getClass().getResource("/css/game.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void bey1FinalRun() {

		Runnable bey1FinRun = new Runnable() {
			@Override
			public void run() {
				bey1Run();
			}
		};

		Thread bey1Thr = new Thread(bey1FinRun);
		bey1Thr.start();
	}

	public void bey1Run() {

		while (isGame) {
			while (!(Math.abs(field.getBey1placeX() - field.getBey2placeX()) <= 40
					&& Math.abs(field.getBey1placeY() - field.getBey2placeY()) <= 40)
					&& bey1.getBalance() > 0 && isGame == true) {

				Platform.runLater(new Runnable() {

					@Override
					public void run() {

						turnBey1();
						bey1.setBey();
						bey1.loseBalanceStep();
						balancePlayer1.setText("Balance: " + bey1.getBalance());
						System.out.println("Bey 1 Balance: " + bey1.getBalance());

						try {
							TimeUnit.MILLISECONDS.sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

						System.out.println("Field Bey1 Placex: " + field.getBey1placeX());
						System.out.println("Field Bey1 Placey: " + field.getBey1placeY());

						if (bey1.getBalance() <= 0 || bey2.getBalance() <= 0) {
							isGame = false;
							System.out.println("Bey 1 - END");
							results();

						} else {
							bey1.setNextMove();
							bey1.setPreviousPositionX(bey1.getCurrentPositionX());
							bey1.setPreviousPositionY(bey1.getCurrentPositionY());
							System.out.println("Bey1 NextMove " + bey1.getNextMove());
							bey1.setMove(bey1.getNextMove());
						}
					}
				});

				try {
					TimeUnit.MILLISECONDS.sleep(30);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			bey1AfterStrike();

			try {
				TimeUnit.MILLISECONDS.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public void bey1AfterStrike() {

		System.out.println("BANG");
		Double strike1 = bey1.getStrikePower();

		System.out.println("Bey 1 STRIKE: " + strike1);
		System.out.println("Bey 1 Balance: " + bey1.getBalance());

		try {
			bey1.loseBalanceStrike(ex1.exchange(strike1));
			System.out.println("Bey 1 Balance AFTER: " + bey1.getBalance());

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				bey1.setMoveAfterBang(bey1.getNextMove());
				bey1.setBey();
				balancePlayer1.setText("Balance: " + bey1.getBalance());

				try {
					TimeUnit.MILLISECONDS.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				if (bey1.getBalance() <= 0 || bey2.getBalance() <= 0) {
					isGame = false;
					System.out.println("Bey 1 - END");
					results();

				}

				
				bey1.setPreviousPositionX(bey1.getCurrentPositionX());
				bey1.setPreviousPositionY(bey1.getCurrentPositionY());
				System.out.println("Bey1 current posX : " + bey1.getCurrentPositionX());
				System.out.println("Bey1 current posY : " + bey1.getCurrentPositionY());
				System.out.println("Bey1 previos posX : " + bey1.getPreviousPositionX());
				System.out.println("Bey1 previos posY: " + bey1.getPreviousPositionY());
				System.out.println("Field Bey1 Placex AfterStrike: " + field.getBey1placeX());
				System.out.println("Field Bey1 Placey AfterStrike: " + field.getBey1placeY());

			}
		});

	}

	public void bey2FinalRun() {

		Runnable bey2FinRun = new Runnable() {

			@Override
			public void run() {
				bey2Run();
			}
		};

		Thread bey2Thr = new Thread(bey2FinRun);
		bey2Thr.start();

	}

	public void bey2Run() {

		while (isGame) {

			while (!(Math.abs(field.getBey1placeX() - field.getBey2placeX()) <= 40
					&& Math.abs(field.getBey1placeY() - field.getBey2placeY()) <= 40) 
					&& bey2.getBalance() > 0 && isGame == true) {

				Platform.runLater(new Runnable() {

					@Override
					public void run() {

						turnBey2();

						bey2.setBey();
						bey2.loseBalanceStep();
						balancePlayer2.setText("Balance: " + bey2.getBalance());
						System.out.println("Bey 2 Balance: " + bey2.getBalance());

						try {
							TimeUnit.MILLISECONDS.sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

						System.out.println("Field Bey2 Placex: " + field.getBey2placeX());
						System.out.println("Field Bey2 Placey: " + field.getBey2placeY());

						if (bey1.getBalance() <= 0 || bey2.getBalance() <= 0) {
							isGame = false;
							System.out.println("Bey 2 - END");
							results();
						} else {
							bey2.setNextMove();
							bey2.setPreviousPositionX(bey2.getCurrentPositionX());
							bey2.setPreviousPositionY(bey2.getCurrentPositionY());
							bey2.setMove(bey2.getNextMove());
						}
					}
				});

				try {
					TimeUnit.MILLISECONDS.sleep(30);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			bey2AfterStrike();

			try {
				TimeUnit.MILLISECONDS.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void bey2AfterStrike() {

		System.out.println("BANG");
		Double strike2 = bey2.getStrikePower();

		System.out.println("Bey 2 STRIKE: " + strike2);
		System.out.println("Bey 2 Balance: " + bey2.getBalance());

		try {
			bey2.loseBalanceStrike(ex1.exchange(strike2));
			System.out.println("Bey 2 Balance AFTER: " + bey2.getBalance());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Platform.runLater(new Runnable() {
			@Override
			public void run() {

				bey2.setMoveAfterBang(bey2.getNextMove());
				bey2.setBey();
				balancePlayer2.setText("Balance: " + bey2.getBalance());

				try {
					TimeUnit.MILLISECONDS.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				if (bey1.getBalance() <= 0 || bey2.getBalance() <= 0) {
					isGame = false;
					System.out.println("Bey 2 - END");
					results();
				}

				bey2.setPreviousPositionX(bey2.getCurrentPositionX());
				bey2.setPreviousPositionY(bey2.getCurrentPositionY());
				System.out.println("Bey2 current posX : " + bey2.getCurrentPositionX());
				System.out.println("Bey2 current posY : " + bey2.getCurrentPositionY());
				System.out.println("Bey2 previos posX : " + bey2.getPreviousPositionX());
				System.out.println("Bey2 previos posY: " + bey2.getPreviousPositionY());
				System.out.println("Field Bey2 Placex AfterStrike: " + field.getBey2placeX());
				System.out.println("Field Bey2 Placey AfterStrike: " + field.getBey2placeY());

			}
		});

	}

	public void turnBey1() {
		Runnable trn = new Runnable() {
			@Override
			public void run() {
				bey1.turnBey();
			}
		};
		Thread turnBey1 = new Thread(trn);
		turnBey1.setDaemon(true);
		turnBey1.start();
	}

	public void turnBey2() {
		Runnable trn = new Runnable() {
			@Override
			public void run() {
				bey2.turnBey();
			}
		};
		Thread turnBey2 = new Thread(trn);
		turnBey2.setDaemon(true);
		turnBey2.start();
	}


	public void results() {

		BorderPane root = new BorderPane();

		Label winNameLabel = new Label();
		winNameLabel.setId("winNameLabel");
		Label winBeyLabel = new Label();
		winBeyLabel.setId("winBeyLabel");

		if (bey1.getBalance() > bey2.getBalance()) {
			winNameLabel.setText(player1Name);
			winBeyLabel.setText(bey1.getName());
		} else {
			winNameLabel.setText(player2Name);
			winBeyLabel.setText(bey2.getName());
		}

		VBox winner = new VBox();
		winner.setPadding(new Insets(10, 10, 10, 10));
		winner.setAlignment(Pos.TOP_CENTER);
		winner.getChildren().add(winNameLabel);

		if (bey1.getBalance() > bey2.getBalance()) {
			winner.getChildren().add(bey1.getBeyBigImage());
		} else {
			winner.getChildren().add(bey2.getBeyBigImage());
		}

		winner.getChildren().add(winBeyLabel);

		Button again = new Button("Try Again");
		again.setId("again");
		Button exit = new Button("EXIT");
		exit.setId("exit");
		again.setOnAction((event) -> {

			bey1 = null;
			bey2 = null;
			field = null;
			choosing();
		});
		exit.setOnAction((e) -> primaryStage.close());

		GridPane choice = new GridPane();
		choice.setAlignment(Pos.CENTER);
		choice.add(again, 0, 0);
		choice.add(exit, 1, 0);

		root.setTop(winner);
		root.setBottom(choice);

		Scene scene = new Scene(root, 600, 600);
		scene.getStylesheets().add(getClass().getResource("/css/results.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);

	}
}

package view;

import javax.jms.JMSException;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import controller.Consumer;
import controller.Producer;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import model.FieldTile;
import model.Model;
import javax.jms.Message;

import view.Controller;

public class Controller {

	private Rectangle rec = new Rectangle(10, 10, Color.RED);

	@FXML
	private GridPane gridPane;

	Producer producer;
	Consumer consumer;
	model.Message alert = new model.Message();
	static boolean myTurn;
	FieldTile lastFt = null;
	boolean whitePlayer;
	public static Model model;

	public static FieldTile[][] tablica = new FieldTile[15][15];

	@FXML
	public void initialize() {
		whitePlayer = Main.getPlayer();
		myTurn = false;
		try {
			if (whitePlayer)
				producer = new Producer("localhost:4848/jms", "producer");
			else
				producer = new Producer("localhost:4848/jms", "consumer");
		} catch (JMSException e) {
			alert.setup("Problem while trying to connect to server.");
		}

		try {
			if (whitePlayer)
				consumer = new Consumer("localhost:4848/jms", "consumer");
			else
				consumer = new Consumer("localhost:4848/jms", "producer");
		} catch (JMSException e) {
			alert.setup("Problem while trying to connect to server.");
		}

		consumer.getJMSConsumer().setMessageListener(new AsynchConsumer());
		if (whitePlayer) {
			myTurn = true;
		}

		for (int i = 0; i < 15; i++)
			for (int j = 0; j < 15; j++) {
				FieldTile ft = new FieldTile(i, j);
				ft.setOnMouseClicked(e -> Click(ft));
				tablica[i][j] = ft;
				gridPane.add(ft, i, j);
			}

		model = new Model(whitePlayer);
	}

	public void setMyTurn() {
		myTurn = true;
		Platform.runLater(() -> {
			drawRec(lastFt.getCol(), lastFt.getRow());
		});
	}

	public void Click(FieldTile ft) {
		if (myTurn) {
			if (lastFt != null) {
				removeRec();
			}
			myTurn = false;

			String text = String.valueOf(ft.getCol());
			text += ";";
			text += String.valueOf(ft.getRow());
			producer.sendQueueMessage(text);
			lastFt = tablica[ft.getCol()][ft.getRow()];
			model.turn(ft);
		}

	}

	public void endOfGame() {
		producer.finalize();
		consumer.finalize();
	}

	public void drawRec(int col, int row) {
		gridPane.add(rec, col, row);
		rec.setTranslateX(22);
	}

	public void drawWhite(int col, int row) {
		Circle circle = new Circle(27);
		circle.setFill(Color.rgb(252, 252, 252));
		gridPane.add(circle, col, row);
	}

	public void drawBlack(int col, int row) {
		Circle circle = new Circle(27);
		circle.setFill(Color.rgb(0, 0, 0));
		gridPane.add(circle, col, row);
	}

	public void removeRec() {
		gridPane.getChildren().remove(rec);
	}

	public class AsynchConsumer implements MessageListener {
		@Override
		public void onMessage(Message message) {
			if (message instanceof TextMessage)
				try {
					Controller.model.updateBoard(((TextMessage) message).getText());
					setMyTurn();

				} catch (JMSException e) {
					e.printStackTrace();
				}
		}
	}

}

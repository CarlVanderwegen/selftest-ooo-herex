package view.panels;

import controller.SelftestController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import model.SelftestFacade;

public class MessagePane extends GridPane implements MyObserver {
	private Button testButton;
	private SelftestController subject;
	
	public MessagePane (SelftestController controller, String error){
		this.subject = controller;
		subject.registerObserver(this);
		subject.notifyObserver();
	    setBorder(new Border(new BorderStroke(Color.BLACK, 
	            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

		this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);
        
		testButton = new Button("Evaluate");
		testButton.setOnAction(new EventHandler<ActionEvent>() { //TODO remove or generalize
			
			@Override
			public void handle(ActionEvent event) {
				controller.setQuestionableView(null);


			}
		});

		add(testButton, 0,1,1,1);
		setHalignment(testButton, HPos.CENTER);
	}

	@Override
	public void update(SelftestFacade facade) {

	}
}

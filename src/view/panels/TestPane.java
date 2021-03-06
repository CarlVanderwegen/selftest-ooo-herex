package view.panels;

import java.util.ArrayList;
import java.util.List;

import controller.SelftestController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import model.SelftestFacade;

public class TestPane extends GridPane implements MyObserver{
	private Label questionField;
	private Button submitButton;
	private ToggleGroup statementGroup;
	private SelftestController subject;
	private SelftestFacade facade;

	public TestPane (SelftestController controller, String error){
		this.subject = controller;
		subject.registerObserver(this);
		subject.notifyObserver();

		this.setPrefHeight(300);
		this.setPrefWidth(750);

		this.setPadding(new Insets(5, 5, 5, 5));
		this.setVgap(5);
		this.setHgap(5);

		questionField = new Label();
		add(questionField, 0, 0, 1, 1);

		statementGroup = new ToggleGroup();

		submitButton = new Button("Submit");
	}


	public void setProcessAnswerAction(EventHandler<ActionEvent> processAnswerAction) {
		submitButton.setOnAction(processAnswerAction);
	}

	public List<String> getSelectedStatements() {
		List<String> selected = new ArrayList<String>();
		if(statementGroup.getSelectedToggle()!=null){
			selected.add(statementGroup.getSelectedToggle().getUserData().toString());
		}
		return selected;
	}

	@Override
	public void update(SelftestFacade facade) {
		this.facade = facade;
	}
}
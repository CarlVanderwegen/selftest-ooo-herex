package view.panels;

import controller.SelftestController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import model.category.CategoryType;
import model.category.MainCategory;

import java.util.ArrayList;

public class QuestionDetailPane extends GridPane {
	private Button btnOK, btnCancel;
	private TextArea statementsArea;
	private TextField questionField, statementField, feedbackField;
	private Button btnAdd, btnRemove;
	private ComboBox categoryField;

	public QuestionDetailPane(SelftestController controller, String error) {





		this.setPrefHeight(300);
		this.setPrefWidth(320);
		
		this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);

		Label errors = new Label(error);
		this.add(errors, 1, 12);
        
		add(new Label("Question: "), 0, 0, 1, 1);
		questionField = new TextField();
		add(questionField, 1, 0, 2, 1);
		
		add(new Label("Statement: "), 0, 1, 1, 1);
		statementField = new TextField();
		add(statementField, 1, 1, 2, 1);

		add(new Label("Statements: "), 0, 2, 1, 1);
		statementsArea = new TextArea();
		statementsArea.setPrefRowCount(5);
//		statementsArea.setEditable(false);
		add(statementsArea, 1, 2, 2, 5);

//		Pane addRemove = new HBox();
//		btnAdd = new Button("add");
//		btnAdd.setOnAction(new AddStatementListener());
//		addRemove.getChildren().add(btnAdd);
//
//		btnRemove = new Button("remove");
//		btnRemove.setOnAction(new RemoveStatementListener());
//		addRemove.getChildren().add(btnRemove);
//		add(addRemove, 1, 8, 2, 1);

		add(new Label("Category: "), 0, 9, 1, 1);
		categoryField = new ComboBox();
		// --------------------------------------------------
		categoryField.setEditable(false);
		ArrayList<String> cats = new ArrayList<>();
		for (CategoryType cat:controller.facade.getCatlist()) {
			if (cat instanceof MainCategory){
				categoryField.getItems().add(cat.getNaam());
				cats.add(cat.getNaam());
			}
		}
		categoryField.getItems().setAll(cats);
		categoryField.setValue(cats.get(0));
		//----------------------------------------------------
		add(categoryField, 1, 9, 2, 1);

		add(new Label("Feedback: "), 0, 10, 1, 1);
		feedbackField = new TextField();
		add(feedbackField, 1, 10, 2, 1);

		btnCancel = new Button("Cancel");
		btnCancel.setText("Cancel");
		add(btnCancel, 0, 11, 1, 1);

		btnCancel.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				controller.mainPane();
			}
		});

		btnOK = new Button("Save");
		btnOK.isDefaultButton();
		btnOK.setText("Save");
		add(btnOK, 1, 11, 2, 1);


		btnOK.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				System.out.println(	"category: " 		+ categoryField.getValue().toString() +
									" / question: " 		+ questionField.getText() +
									" / correct: " 	+ statementField.getText() +
									" / description: " 	+ statementsArea.getText() +
									" / feedback: " 	+ feedbackField.getText());

				try {
					controller.facade.addVraag(categoryField.getValue().toString(),questionField.getText(),statementField.getText(), statementsArea.getText(), feedbackField.getText());
				}catch (Exception e){
					controller.setQuestionDetailPane(e.getMessage());
					return;
				}
				controller.mainPane();
			}
		});

	}

	public void setSaveAction(EventHandler<ActionEvent> saveAction) {
		btnOK.setOnAction(saveAction);
	}

	public void setCancelAction(EventHandler<ActionEvent> cancelAction) {
		btnCancel.setOnAction(cancelAction);
	}

	class AddStatementListener implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
		}
	}

	class RemoveStatementListener implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
		}
	}



}

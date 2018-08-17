package view.panels;

import controller.SelftestController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import model.category.CategoryType;
import model.category.MainCategory;

import java.util.ArrayList;

public class CategoryDetailPane extends GridPane {
	private Button btnOK, btnCancel;
	private TextField titleField, descriptionField;
	private ComboBox categoryField;
	private SelftestController controller;


	public CategoryDetailPane(SelftestController controller, String error) {
		this.controller = controller;

		this.setPrefHeight(150);
		this.setPrefWidth(300);
		
		this.setPadding(new Insets(5, 5, 5, 5));
		this.setVgap(5);
		this.setHgap(5);

		Label errors = new Label(error);
		this.add(errors, 1, 4);

		this.add(new Label("Title:"), 0, 0, 1, 1);
		titleField = new TextField();
		this.add(titleField, 1, 0, 1, 1);

		this.add(new Label("Description:"), 0, 1, 1, 1);
		descriptionField = new TextField();
		this.add(descriptionField, 1, 1, 1, 1);

		this.add(new Label("Main Category:"), 0, 2, 1, 1);
		categoryField = new ComboBox<>();
		// --------------------------------------------------
		categoryField.setEditable(false);
		ArrayList<String> cats = new ArrayList<>();
		categoryField.getItems().add("");
		cats.add("");
		for (CategoryType cat:controller.facade.getCatlist().getCatlist()) {
			if (cat instanceof MainCategory){
				categoryField.getItems().add(cat.getNaam());
				cats.add(cat.getNaam());
			}
		}
		categoryField.getItems().setAll(cats);
		categoryField.setValue(cats.get(0));
		//----------------------------------------------------
		this.add(categoryField, 1, 2, 1, 1);

		btnCancel = new Button("Cancel");
		this.add(btnCancel, 0, 3, 1, 1);


		btnOK = new Button("Save");
		btnOK.isDefaultButton();
		this.add(btnOK, 1, 3, 1, 1);



		btnOK.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				System.out.println(	"maincatcat: " 		+ categoryField.getValue().toString() +
									" / name: " 		+ titleField.getText() +
									" / description: " 	+ descriptionField.getText());
				try {
					controller.facade.addCategory(	titleField.getText(),
													descriptionField.getText(),
													categoryField.getValue().toString());
				}catch (Exception e){
					controller.addCategoryView(e.getMessage());
					return;
				}
				controller.mainPane();
			}
		});

		btnCancel.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
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
}

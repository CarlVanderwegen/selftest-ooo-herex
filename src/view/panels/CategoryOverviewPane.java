package view.panels;

import controller.MyObservable;
import controller.SelftestController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import model.SelftestFacade;
import model.category.CategoryList;
import model.category.CategoryType;
import model.vraag.VraagType;


public class CategoryOverviewPane extends GridPane implements MyObserver {
	private TableView table;
	private Button btnNew;
	private ObservableList<CategoryType> categoryTypes;
	private SelftestController subject;

	@Override
	public void update(CategoryList catlist) {
			this.categoryTypes = FXCollections.observableArrayList(catlist.getCatlist());
	}
	
	public CategoryOverviewPane(SelftestController selftestController) {
		this.subject = selftestController;
		subject.registerObserver(this);
		subject.notifyObserver();

		for (CategoryType catt:categoryTypes) {
			System.out.println(catt.getNaam());
		}
		System.out.println();

		this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);
        
		this.add(new Label("Categories:"), 0, 0, 1, 1);
		
		table = new TableView<>();
		table.setPrefWidth(REMAINING);
        TableColumn nameCol = new TableColumn("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<CategoryType, String>("naam"));

        TableColumn descriptionCol = new TableColumn("Description");
        descriptionCol.setCellValueFactory(new PropertyValueFactory<CategoryType, String>("description"));

        table.setItems(this.categoryTypes);


        table.getColumns().addAll(nameCol,descriptionCol);


		this.add(table, 0, 1, 2, 6);
		
		btnNew = new Button("New");
		this.add(btnNew, 0, 11, 1, 1);
	}
	


	public void setNewAction(EventHandler<ActionEvent> newAction) {
		btnNew.setOnAction(newAction);
	}
	
	public void setEditAction(EventHandler<MouseEvent> editAction) {
		table.setOnMouseClicked(editAction);
	}


}

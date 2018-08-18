package view.panels;

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
import model.category.CategoryType;
import model.vraag.VraagType;

public class QuestionOverviewPane extends GridPane implements MyObserver {
	private TableView table;
	private Button btnNew;
	private ObservableList<RowData> vragen = FXCollections.observableArrayList();
	private SelftestController subject;
	
	public QuestionOverviewPane(SelftestController selftestController) {

		this.subject = selftestController;
		subject.registerObserver(this);
		subject.notifyObserver();


		table = new TableView<>();
		table.setPrefWidth(REMAINING);
        TableColumn nameCol = new TableColumn<>("Question");
		TableColumn descriptionCol = new TableColumn<>("Category");

        nameCol.setCellValueFactory(new PropertyValueFactory<>("vraag"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory("category"));

		table.getColumns().addAll(nameCol,descriptionCol);

		table.setItems(this.vragen);
		btnNew = new Button("New");

		this.setPadding(new Insets(5, 5, 5, 5));
		this.setVgap(5);
		this.setHgap(5);
		this.add(new Label("Questions:"), 0, 0, 1, 1);
		this.add(table, 0, 1, 2, 6);
		this.add(btnNew, 0, 11, 1, 1);
	}

	@Override
	public void update(SelftestFacade facade) {
		for (CategoryType cat: facade.getCatlist().getCatlist()) {
			for (VraagType vraag:cat.getVragen().getVraaagLijst()) {
				vragen.add(new RowData(cat.getNaam(), vraag.getNaam()));
				System.out.println("added");
			}
		}
	}
	
	public void setNewAction(EventHandler<ActionEvent> newAction) {
		btnNew.setOnAction(newAction);
	}
	
	public void setEditAction(EventHandler<MouseEvent> editAction) {
		table.setOnMouseClicked(editAction);
	}


	public class RowData {
		public String category, vraag;
		public RowData(String category, String vraag) {
			this.category = category;
			this.vraag = vraag;
		}
		public String getCategory(){ return category; }
		public String getVraag(){ return vraag; }
	}



}

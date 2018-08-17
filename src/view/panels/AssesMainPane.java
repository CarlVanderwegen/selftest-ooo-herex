package view.panels;

import controller.SelftestController;
import javafx.geometry.Pos;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;


public class AssesMainPane extends BorderPane {

    TabPane tabPane;
    FlowPane messageBox;

    private MessagePane messagePane;


	public AssesMainPane(SelftestController controller){

	    this.tabPane = new TabPane();
        this.messagePane = new MessagePane();

	    this.messageBox = new FlowPane(messagePane);
	    this.messageBox.setAlignment(Pos.CENTER);

        Tab testTab = new Tab("Test", messageBox);
        Tab categoriesTab = new Tab("Categories", new CategoryOverviewPane(controller));
        Tab questionsTab = new Tab("Questions", new QuestionOverviewPane(controller));

        this.tabPane.getTabs().addAll(testTab, categoriesTab,questionsTab);
	    this.setCenter(tabPane);
	}
}

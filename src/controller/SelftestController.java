package controller;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.SelftestFacade;
import model.category.CategoryList;
import view.panels.*;
import java.util.ArrayList;

public class SelftestController implements MyObservable {

    private Group root;
    private Scene scene;
    private Stage stage;
    private TestPane testPane;
    public SelftestFacade facade;
    private BorderPane borderPane;
    private MessagePane messagePane;
    private ArrayList<MyObserver> observers;
    private QuestionDetailPane questionDetailPane;
    private CategoryDetailPane categoryDetailPane;


    public SelftestController(Stage stage) {
        observers = new ArrayList<MyObserver>();

        facade = new SelftestFacade();
        this.stage = stage;

//        questionDetailPane = new QuestionDetailPane(this);
//        categoryDetailPane = new CategoryDetailPane(this);
//
//        testPane = new TestPane(this, null);
        mainPane();

    }

    public void mainPane(){

        borderPane= new AssesMainPane(this);
        root = new Group();
        scene = new Scene(root, 750, 400);
        root.getChildren().add(borderPane);
        borderPane.prefHeightProperty().bind(scene.heightProperty());
        borderPane.prefWidthProperty().bind(scene.widthProperty());

        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();

    }

    public void addCategoryView(String error){

        categoryDetailPane = new CategoryDetailPane(this, error);
        Group base = new Group();
        scene = new Scene(base, 300, 150);
        base.getChildren().add(categoryDetailPane);
        borderPane.prefHeightProperty().bind(scene.heightProperty());
        borderPane.prefWidthProperty().bind(scene.widthProperty());

        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();

    }

    public void setQuestionDetailPane(String error){
        questionDetailPane = new QuestionDetailPane(this, error);
        Group base = new Group();
        scene = new Scene(base, 320, 300);
        base.getChildren().add(questionDetailPane);
        borderPane.prefHeightProperty().bind(scene.heightProperty());
        borderPane.prefWidthProperty().bind(scene.widthProperty());

        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }
    public void setQuestionableView(String error){
        testPane = new TestPane(this, error);
        Group base = new Group();
        scene = new Scene(base, 750, 300);
        base.getChildren().add(testPane);
        borderPane.prefHeightProperty().bind(scene.heightProperty());
        borderPane.prefWidthProperty().bind(scene.widthProperty());

        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();

    }


    public void start(){
        stage.show();
    }


// observer code
    @Override
    public void registerObserver(MyObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(MyObserver observer) {
        if (observers.indexOf(observer)>=0)
            observers.remove(observers.indexOf(observer));
    }

    @Override
    public void notifyObserver() {
        for (MyObserver observer:observers) {
            observer.update(facade);
        }
    }
// rest









}

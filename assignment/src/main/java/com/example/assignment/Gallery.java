package com.example.assignment;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Gallery extends Application {
    private final String[] imageFileNames = {"Albania.png", "Portugal.png", "Qatar.png", "Russia.png", "Rwanda.png", "San Marino.png", "Saudi Arabia.png"};
    private final ImageView[] imageViews = new ImageView[7];

    @Override
    public void start(Stage primaryStage) {
        VBox vbox = new VBox();
        vbox.setSpacing(10); // Spacing between buttons and thumbnails

        for (int i = 0; i < imageFileNames.length; i++) {
            ImageView thumbnail = createThumbnail(imageFileNames[i]);
            imageViews[i] = thumbnail;

            Button button = new Button(imageFileNames[i]);
            int finalI = i;
            button.setOnAction(e -> toAction(finalI));

            HBox entry = new HBox(button, thumbnail);
            entry.setSpacing(10); // Spacing between button and thumbnail in each entry
            vbox.getChildren().add(entry);
        }

        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Image Viewer");
        primaryStage.show();
    }

    private ImageView createThumbnail(String imageName) {
        Image image = new Image(getClass().getResourceAsStream(imageName));
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);
        return imageView;
    }

    private void toAction(int index) {
        Stage stage = new Stage();

        // Create an HBox to hold the enlarged image
        HBox hbox = new HBox();
        ImageView imageView = new ImageView(imageViews[index].getImage());
        imageView.setFitWidth(500);
        imageView.setFitHeight(500);
        hbox.getChildren().add(imageView);

        Scene scene = new Scene(hbox);
        stage.setScene(scene);
        stage.setTitle(imageFileNames[index]);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Anton on 10.05.2018.
 */
public class Spect {

    public void work() throws FileNotFoundException {
        File f=new File("1.jpg");
        File f2=new File("2.jpg");
        FileInputStream input = new FileInputStream("1.jpg");
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);

        FileInputStream input3 = new FileInputStream("2.jpg");
        Image image3 = new Image(input3);
        ImageView imageView3 = new ImageView(image3);
        imageView3.setLayoutX(350);
        imageView3.setLayoutY(0);

        Button button  = new Button("Ok");
        button.setLayoutX(400);
        button.setLayoutY(500);
        Pane pane = new Pane();
        pane.getChildren().addAll(imageView,button, imageView3);
        Scene scene = new Scene(pane,800,600);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

        File output=new File("ready.jpg");

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                BufferedImage img= null;
                BufferedImage img2 =null;
                try {
                    img = ImageIO.read(f);
                    img2 = ImageIO.read(f2);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                for(int i=1;i<img.getWidth()-1;i++)
                    for(int j=1;j<img.getHeight()-1;j++)
                    {

                        Color cl1 = new Color(img.getRGB(i,j));
                        Color cl2 = new Color(img2.getRGB(i,j));

                        int red = cl1.getRed();
                        int green = cl2.getGreen();
                        int blue = cl2.getBlue();



                        Color rgb = new Color(red,green,blue);
                        img.setRGB(i,j,rgb.getRGB());

                        
                    }
                try {
                    ImageIO.write(img,"jpg",output);
                    FileInputStream input1 = new FileInputStream("ready.jpg");
                    Image image1 = new Image(input1);
                    ImageView imageView1 = new ImageView(image1);
                    imageView1.setLayoutX(0);
                    imageView1.setLayoutY(400);
                    pane.getChildren().addAll(imageView1);


                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

    }

}

package GameOfUr;

import javax.swing.*;
import java.lang.reflect.Array; 


class GUI{

    private JFrame frame;

    Tile [] tiles;
    

    GUI(Tile[] tiles){
        
        this.frame = new JFrame("Royal Game of Ur");
        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE); 
        frame.setVisible(true);

        this.tiles = tiles;
    }

}
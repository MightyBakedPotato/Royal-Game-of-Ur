package GameOfUr;

import javax.swing.*;

class GUI{

    private JFrame frame;
    

    GUI(){
        
        this.frame = new JFrame("Royal Game of Ur");
        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE); 
        frame.setVisible(true);
    }

}
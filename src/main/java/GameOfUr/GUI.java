package GameOfUr;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import GameOfUr.BoardStatus;
import GameOfUr.BoardStatus.TileState;

class GUI{

    private JFrame frame;
    //private Container content;
    private TileLabel[][] labelArray;
    private Board model = new Board();

    class TileLabel extends JLabel{

        private TileState _status;

        private void setStyle(){
            setBorder(new LineBorder(Color.BLACK));
            setPreferredSize(new Dimension(40, 40));
            setHorizontalAlignment(SwingConstants.CENTER);
            setVerticalAlignment(SwingConstants.CENTER);
        }

        TileLabel(String text){
            setText(text);
            setStyle();
        }

        TileLabel(){
            setStyle();
            //setText("a");
        }

        public void setState ( TileState status )
        {      
            _status = status;

            switch(status){

            case START:
                break;

            case END:
                break;

            case EMPTY:
                break;

            case WHITE_PIECE: 
                this.setText("1");
                this.setForeground(Color.RED);
                break;

            case BLACK_PIECE: 
                this.setText("1");
                this.setForeground(Color.BLACK);
                break;

            default:
                System.out.println("uhoh, something wrong with the setState switch");
            }
        }
    }

    private void labelArray(){

        this.labelArray = new TileLabel[3][8];

        GridBagConstraints c = new GridBagConstraints();

        for (int i = 0; i < labelArray.length; i++) {
            for (int j = 0; j < labelArray[i].length; j++) {
                labelArray[i][j] = new TileLabel();
                c.gridx = j;
                c.gridy = i;
                frame.getContentPane().add(labelArray[i][j], c);
                }
            }
    }    

    GUI(){
        
        this.frame = new JFrame("Royal Game of Ur");
        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE); 
        frame.setVisible(true);

        Container content = frame.getContentPane();

        content.setLayout( new GridBagLayout());

        labelArray();

        updateView();

        /*
        {
            TileLabel startLabel_white = new TileLabel();
            c.gridx = 4;
            c.gridy = 0;
            content.add(startLabel_white, c);

            TileLabel label1_white = new TileLabel();        
            c.gridx = 3;
            content.add(label1_white, c);

            TileLabel label2_white = new TileLabel();        
            c.gridx = 2;
            content.add(label2_white, c);

            TileLabel label3_white = new TileLabel();
            c.gridx = 1;
            content.add(label3_white, c);
            
            TileLabel label4_white = new TileLabel();
            c.gridx = 0;
            content.add(label4_white, c);
                ///
            TileLabel startLabel_black = new TileLabel();
            c.gridy = 2;
            c.gridx = 4;
            content.add(startLabel_black, c);
            
            TileLabel label1_black = new TileLabel();
            c.gridx = 3;
            content.add(label1_black, c);
            
            TileLabel label2_black = new TileLabel();
            c.gridx = 2;
            content.add(label2_black, c);
            
            TileLabel label3_black = new TileLabel();
            c.gridx = 1;
            content.add(label3_black, c);
            
            TileLabel label4_black = new TileLabel();
            c.gridx = 0;
            content.add(label4_black, c);
                ///
            TileLabel midLabel5 = new TileLabel(); 
            c.gridy = 1;
            c.gridx = 0;
            content.add(midLabel5, c);       
            
            TileLabel midLabel6 = new TileLabel();
            c.gridx = 1;
            content.add(midLabel6, c);
            
            TileLabel midLabel7 = new TileLabel();
            c.gridx = 2;
            content.add(midLabel7, c);
     
            TileLabel midLabel8 = new TileLabel();
            c.gridx = 3;
            content.add(midLabel8, c);
           
            TileLabel midLabel9 = new TileLabel();
            c.gridx = 4;
            content.add(midLabel9, c);
        
            TileLabel midLabel10 = new TileLabel();
            c.gridx = 5;
            content.add(midLabel10, c);

            TileLabel midLabel11 = new TileLabel();
            c.gridx = 6;
            content.add(midLabel11, c);

            TileLabel midLabel12 = new TileLabel();
            c.gridx = 7;
            content.add(midLabel12, c);
                ///    
            TileLabel label13_white = new TileLabel();
            c.gridy = 0;
            c.gridx = 7;
            content.add(label13_white, c);
           
            TileLabel label14_white = new TileLabel();
            c.gridx = 6;
            content.add(label14_white, c);
           
            TileLabel endLabel_white = new TileLabel();
            c.gridx = 5;
            content.add(endLabel_white, c);
                ///    
            TileLabel label13_black = new TileLabel();
            c.gridy = 2;
            c.gridx = 7;
            content.add(label13_black, c);
            
            TileLabel label14_black = new TileLabel();
            c.gridx = 6;
            content.add(label14_black, c);
            
            TileLabel endLabel_black = new TileLabel();
            c.gridx = 5;
            content.add(endLabel_black, c);}
        */
                
    }

    public void updateView ()
    {
        BoardStatus status = model.getBoardStatus();

        for (int i = 0; i < labelArray.length; i++) {
            for (int j = 0; j < labelArray[i].length; j++) {
                this.labelArray[i][j].setState(status.tilesGrid[i][j]);
                }
            }

    }
}
package GameOfUr;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import org.apache.commons.lang3.ArrayUtils;
import GameOfUr.BoardStatus;
import GameOfUr.BoardStatus.TileState;

class GUI implements MouseListener{

    private JFrame frame;
    //private Container content;
    private TileLabel[][] labelArray;
    private Board _model;

    public void setModel(Board model){
        _model = model;
        updateView();
    }

    class TileLabel extends JLabel{

        private TileState state;

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

        public void setState ( TileState state ){      
            this.state = state;
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
                labelArray[i][j].addMouseListener(this);
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
                
    }

    public void updateView (){
        BoardStatus status = new BoardStatus();

        status = _model.getStatus();

        for (int i = 0; i < labelArray.length; i++) {
            for (int j = 0; j < labelArray[i].length; j++) {
                labelArray[i][j].setState(status.tilesGrid[i][j]);

                switch(labelArray[i][j].state){

                    case START:
                    if(i == 0 && j == labelArray[0].length - 4){
                        labelArray[i][j].setText(String.valueOf(status.whiteStartGPsCount));
                        labelArray[i][j].setForeground(Color.RED);
                    }else if(i == 2 && j == labelArray[0].length - 4){
                        labelArray[i][j].setText(String.valueOf(status.blackStartGPsCount));
                        labelArray[i][j].setForeground(Color.BLACK);
                    }
                    break;

                    case END:
                    if(i == 0 && j == labelArray[0].length - 3){
                        labelArray[i][j].setText(String.valueOf(status.whiteEndGPsCount));
                        labelArray[i][j].setForeground(Color.RED);
                    }else if(i == 2 && j == labelArray[0].length -3){
                        labelArray[i][j].setText(String.valueOf(status.blackEndGPsCount));
                        labelArray[i][j].setForeground(Color.BLACK);
                    }
                    break;

                    case EMPTY:
                        labelArray[i][j].setText("");
                    break;

                    case WHITE_PIECE: 
                    labelArray[i][j].setText("1");
                    labelArray[i][j].setForeground(Color.RED);
                    break;

                    case BLACK_PIECE: 
                    labelArray[i][j].setText("1");
                    labelArray[i][j].setForeground(Color.BLACK);
                    break;

                    default:
                    System.out.println("uhoh, something wrong with the setState switch");

                }                  

            }
        }
            
    }

    public void mouseClicked(MouseEvent e) {
        Object src = e.getSource();
        int x = -1;
        int y = -1;

        for (int i = 0 ; i < labelArray.length; i++){
            for(int j = 0 ; j < labelArray[i].length; j++){
                if (labelArray[i][j] == src){
                    y = i;
                    x = j;                        
                }
            }
        }

        if( x == -1 || y == -1){
            System.out.println("couldn't find the TileLabel you clicked");
            return;
        }

        _model.moveGP(y, x);

    }

    public void mousePressed(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}

    private int getGPsIndexfromTileCoords(int coordsX, int coordsY){
        int index = -1;

        if(coordsX == 0 || coordsX == 2){
                switch(coordsY){
                case 0 :
                    index = 4;
                    break;
                case 1 :
                    index = 3;
                    break;
                case 2 :
                    index = 2;
                    break;
                case 3 :
                    index = 1;
                    break;
                case 4 :
                    index = 0;
                    break;
                case 5 :
                    index = 15;
                    break;
                case 6 :
                    index = 14;
                    break;
                case 7 :
                    index = 13;
                    break;
                }
            }else if(coordsX == 1){
                switch(coordsY){
                case 0 :
                    index = 5;
                    break;
                case 1 :
                    index = 6;
                    break;
                case 2 :
                    index = 7;
                    break;
                case 3 :
                    index = 8;
                    break;
                case 4 :
                    index = 9;
                    break;
                case 5 :
                    index = 10;
                    break;
                case 6 :
                    index = 11;
                    break;
                case 7 :
                    index = 12;
                    break;
                }
            }

        return index;
                
        }

}
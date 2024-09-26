package GameOfUr;

import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import org.apache.commons.lang3.ArrayUtils;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import GameOfUr.BoardStatus;
import GameOfUr.BoardStatus.TileState;

class GUI implements MouseListener, ActionListener{

    private JFrame frame;
    //private Container content;
    private TilePane[][] tileArray;
    private Board _model;
    private JLabel playerLabel;
    private JLabel diceLabel;
    private JButton skipButton;

    ImageIcon flowerTile = new ImageIcon(getClass().getResource("/flowerTile.png"));
    ImageIcon eyeTile = new ImageIcon(getClass().getResource("/eyeTile.png"));
    ImageIcon squareTile = new ImageIcon(getClass().getResource("/squaresTile.png"));
    ImageIcon zebraTile = new ImageIcon(getClass().getResource("/zebraTile.png"));
    ImageIcon dotsTile = new ImageIcon(getClass().getResource("/dotsTile.png"));

    ImageIcon whiteGPIcon = new ImageIcon(getClass().getResource("/whiteGP.png"));
    ImageIcon blackGPIcon = new ImageIcon(getClass().getResource("/blackGP.png"));


    public void setModel(Board model){
        _model = model;
        updateView();
    }

    class TilePane extends JLayeredPane{

        private TileState state;
        private Dimension tileDimension = new Dimension(80,80);

        TilePane(){
            setPreferredSize(tileDimension);            
            /*
            this.gamePieceLabel = new JLabel();
            gamePieceLabel.setBounds(0,0,80,80);
            gamePieceLabel.setHorizontalAlignment(SwingConstants.CENTER);
            gamePieceLabel.setVerticalAlignment(SwingConstants.CENTER);
            
            this.add(gamePieceLabel,0);
            */
        }

        public void setBackgroundImg(ImageIcon tileIcon){
            JLabel backgroundImgLabel = new JLabel(tileIcon);
            backgroundImgLabel.setBounds(0,0,80,80);
            this.add(backgroundImgLabel, JLayeredPane.DEFAULT_LAYER);
        }

        public void setGPIcon(ImageIcon gpIcon){
            JLabel gamePieceLabel = new JLabel(gpIcon);
            gamePieceLabel.setBounds(0,0,80,80);
            this.add(gamePieceLabel, JLayeredPane.PALETTE_LAYER);
        }

        public void setGPIcon(){
            Component[] compArray = this.getComponentsInLayer(JLayeredPane.PALETTE_LAYER);

            if ( compArray.length != 0){
                this.remove(compArray[0]);
                this.repaint();
            }
        }

        public void setStackedGPIcons(int numberofGPs, ImageIcon gpIcon){

        int y = 5;

            for(int i = 0; i <numberofGPs; i ++){
                JLabel gamePieceLabel = new JLabel(gpIcon);
                gamePieceLabel.setBounds(SwingConstants.CENTER, y, gpIcon.getIconWidth(), gpIcon.getIconHeight());
                y = +10;
                this.add(gamePieceLabel,0,i);
            }
        }

        public void setState ( TileState state ){      
            this.state = state;
            }
    }

    private void tileArray(){

        this.tileArray = new TilePane[3][8];

        GridBagConstraints c = new GridBagConstraints();

        for (int i = 0; i < tileArray.length; i++) {
            for (int j = 0; j < tileArray[i].length; j++) {
                tileArray[i][j] = new TilePane();
                c.gridx = j;
                c.gridy = i;
                c.insets = new Insets(2,2,2,2);
                tileArray[i][j].addMouseListener(this);
                frame.getContentPane().add(tileArray[i][j], c);
                }
            }

        tileArray[0][3].setBackgroundImg(eyeTile);
        tileArray[0][2].setBackgroundImg(dotsTile);
        tileArray[0][1].setBackgroundImg(eyeTile);
        tileArray[0][0].setBackgroundImg(flowerTile);
        tileArray[2][3].setBackgroundImg(eyeTile);
        tileArray[2][2].setBackgroundImg(dotsTile);
        tileArray[2][1].setBackgroundImg(eyeTile);
        tileArray[2][0].setBackgroundImg(flowerTile);
        tileArray[1][0].setBackgroundImg(squareTile);
        tileArray[1][1].setBackgroundImg(dotsTile);
        tileArray[1][2].setBackgroundImg(zebraTile);
        tileArray[1][3].setBackgroundImg(flowerTile);
        tileArray[1][4].setBackgroundImg(dotsTile);
        tileArray[1][5].setBackgroundImg(zebraTile);
        tileArray[1][6].setBackgroundImg(eyeTile);
        tileArray[1][7].setBackgroundImg(dotsTile);
        tileArray[0][6].setBackgroundImg(flowerTile);
        tileArray[0][7].setBackgroundImg(zebraTile);
        tileArray[2][6].setBackgroundImg(flowerTile);
        tileArray[2][7].setBackgroundImg(zebraTile);
    }    

    GUI(){
        
        this.frame = new JFrame("Royal Game of Ur");
        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE); 
        frame.setVisible(true);

        Container content = frame.getContentPane();

        content.setLayout( new GridBagLayout());

        tileArray();

        playerLabel = new JLabel();

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridwidth = 4;
        c.gridy = 3;

        content.add(playerLabel,c);

        diceLabel = new JLabel();

        c.gridx = GridBagConstraints.RELATIVE;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.gridy = 3;

        content.add(diceLabel,c);

        skipButton = new JButton("skip turn");
        skipButton.addActionListener(this);// to do: turn it into a lambda expression

        c.gridx = 0;
        c.gridwidth = 8;
        c.gridy = 4;

        content.add(skipButton,c);
        
    }

    public void updateView (){
        BoardStatus status = new BoardStatus();

        status = _model.getStatus();

        playerLabel.setText("current player: " + status.playerString);
        diceLabel.setText("dice roll: " + status.diceRoll);

        for (int i = 0; i < tileArray.length; i++) {
            for (int j = 0; j < tileArray[i].length; j++) {
                tileArray[i][j].setState(status.tilesGrid[i][j]);

                switch(tileArray[i][j].state){

                    case START:
                    if(i == 0 && j == tileArray[0].length - 4){
                        tileArray[i][j].setStackedGPIcons(status.whiteStartGPsCount, whiteGPIcon);
                    }else if(i == 2 && j == tileArray[0].length - 4){
                        tileArray[i][j].setStackedGPIcons(status.blackStartGPsCount, blackGPIcon);
                    }
                    break;

                    case END:
                    if(i == 0 && j == tileArray[0].length - 3){
                        tileArray[i][j].setStackedGPIcons(status.whiteEndGPsCount, whiteGPIcon);
                    }else if(i == 2 && j == tileArray[0].length -3){
                        tileArray[i][j].setStackedGPIcons(status.blackEndGPsCount, blackGPIcon);
                    }
                    break;

                    case EMPTY:
                    tileArray[i][j].setGPIcon(null);
                    break;

                    case WHITE_PIECE: 
                    tileArray[i][j].setGPIcon(whiteGPIcon);
                    break;

                    case BLACK_PIECE: 
                    tileArray[i][j].setGPIcon(blackGPIcon);
                    break;

                    default:
                    System.out.println("uhoh, something wrong with the setState switch");

                }                  

            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == skipButton){
            _model.endTurn();
            updateView();
        }
    }

    public void mouseClicked(MouseEvent e) {
        Object src = e.getSource();
        int x = -1;
        int y = -1;

        for (int i = 0 ; i < tileArray.length; i++){
            for(int j = 0 ; j < tileArray[i].length; j++){
                if (tileArray[i][j] == src){
                    y = i;
                    x = j;                        
                }
            }
        }

        if( x == -1 || y == -1){
            System.out.println("couldn't find the TilePanel you clicked");
            return;
        }

        _model.moveGP(y, x);
    }

    public void mousePressed(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}

}
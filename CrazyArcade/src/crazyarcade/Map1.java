package crazyarcade;

import javax.swing.*;
import java.awt.*;


public class Map1 extends JFrame {
   
   public static final int SCREEN_WIDTH = 614;
   public static final int SCREEN_HEIGHT = 550;

    private Image background;
    private Image brick;
    private Image brickA;

    //캐릭터 생성
    public static Person person1; 
    public static Person person2;
    
    public Map1(Point location) {
        setTitle("Map1");
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // JPanel을 추가하여 이미지를 그릴 수 있도록 함
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                screenDraw(g);
            }
        };
        add(panel);

        background = new ImageIcon(getClass().getResource("/image/mapbg2.png")).getImage();
        brick = new ImageIcon(getClass().getResource("/image/box3.png")).getImage();
        brickA = new ImageIcon(getClass().getResource("/image/box2.png")).getImage();
       
        // 창을 waitroom의 위치에 설정
        setLocation(location);
        setVisible(true);
        
        addKeyListener(new KeyListener(1)); // Map1에서
        
        // 캐릭터 생성자 호출 및 초기화
        person1 = new Person();
        person1.Bazzi(); // Bazzi 이미지로 초기화
        
        person1.setPosition(200,400);
        person1.setDirection("left");
        person1.setState(person1.getLeft());
        
        
        person2 = new Person();
        person2.Woonie(); // Woonie 이미지로 초기화
        
        person2.setPosition(400,200);
        person2.setDirection("right");
        person2.setState(person2.getright());
        
    }

    public void screenDraw(Graphics g) {
        g.drawImage(background, 0, 0, null);
        
        //하트 안에 
        int[][] inbrick = {
                {200, 190}, {160, 150}, {400, 150},
                {320, 190}, {360, 190},
                {360, 230},
                {200, 270}, {360, 310}, {320, 310},
                {240, 310}, {200, 310}
        };
        for (int[] coord : inbrick ){
            int x = coord[0];
            int y = coord[1];
            g.drawImage(brick, x, y, null);
        }
       
        //하트
        int[][] brickCoordinates = {
                {160, 80}, {200, 80}, {240, 80},
                {120, 110},
                {80, 140}, {80, 170}, {80, 200}, {80, 230},
                {120, 270}, {160, 310}, {200, 350}, {240, 390}, {280, 390}, {320, 390},
                {360, 350}, {400, 310}, {440, 270},
                {280, 110},
                {320, 80}, {360, 80}, {400, 80},
                {440, 110},
                {480, 140}, {480, 170}, {480, 200}, {480, 230}
        };
        for (int[] coordA : brickCoordinates) {
            int x = coordA[0];
            int y = coordA[1];
            g.drawImage(brickA, x, y, null);
        }
        
        
        
        
        //왼,오른에 쭉!
        for (int y = 0; y <= 500; y += 40) {
            g.drawImage(brick, 0, y, null);
        }
        
        for (int y = 0; y <= 500; y += 40) {
            g.drawImage(brick, 557, y, null);
        }
        
        g.drawImage(person1.getState(), person1.getPos_X(), person1.getPos_Y() , null);
        g.drawImage(person2.getState(), person2.getPos_X(), person2.getPos_Y() , null);
       
        this.repaint();
    }

   
    
}
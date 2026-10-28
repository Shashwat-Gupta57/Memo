import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class p extends JPanel{
    Dimension sc = Toolkit.getDefaultToolkit().getScreenSize();
    main m = new main();
    p(){
        sc.height-=60;
        setSize(sc);
        setBackground(new Color(61,61,61));
        setLayout(null);
    }
    public void paint(Graphics g1){
        super.paint(g1);
        g1.setColor(new Color(61,61,61));
        g1.fillOval(sc.width/2-120, sc.height/2-120, 240, 240);
        g1.setColor(Color.white);
        g1.setFont(new Font("arial",Font.BOLD,90));
        if(!m.started){
            g1.setFont(new Font("arial",Font.BOLD,40));
            g1.drawString("HI "+m.hi,sc.width/2-40,sc.height/2-75);
            g1.setFont(new Font("arial",Font.BOLD,64));
            g1.drawString("Start!",sc.width/2-85,sc.height/2+20);
        }else{
            if(m.score-1 < 10){
                if(m.score-1 < 0){
                    g1.drawString("0",sc.width/2-25,sc.height/2+25);
                }else{
                    g1.drawString(""+(m.score-1),sc.width/2-25,sc.height/2+25);
                }
            }else if(m.score-1 < 100){
                g1.drawString(""+(m.score-1),sc.width/2-45,sc.height/2+25);
            }else if(m.score-1 < 1000){
                g1.drawString(""+(m.score-1),sc.width/2-75,sc.height/2+25);
            }
        }
        repaint();
    }
}
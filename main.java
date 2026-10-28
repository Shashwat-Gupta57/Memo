import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.nio.file.*;
import java.io.*;

public class main{
    static JButton r,g,b,y,start;
    static Dimension sc = Toolkit.getDefaultToolkit().getScreenSize();
    static byte[] seq = new byte[999];
    static short chance = 0,score = 0,hi = 0;
    static boolean gameOver = false,started,outputting,red = false,green = false,blue = false,yellow = false;
    static p pa = new p();
    static Thread cr;
    public static void main(String args[]) throws  InterruptedException, java.io.IOException {
        new Thread(() -> {
            for(int i = 0;i < 999;i++){
                seq[i] = (byte)(1 + (int)(Math.random()*4));
            }
        }).start();
        JFrame f = new JFrame("Memo By Shashwat Gupta");
        f.setSize(sc);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setIconImage((new ImageIcon(System.getProperty("user.dir")+"//res//icon.png")).getImage());
        Container c = f.getContentPane();
        c.setBackground(new Color(61,61,61));
        c.add(pa);
        sc.height -= 60;
        hi = Short.parseShort(Files.lines(Paths.get(System.getProperty("user.dir")+"\\res\\saves.txt")).findFirst().orElse(String.valueOf(0)));
        r = new JButton();
        r.setSize(sc.width/2-10,sc.height/2-10);
        r.setLocation(0,0);
        r.setBackground(new Color(237, 109, 100));
        r.setBorderPainted(false);
        r.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(seq[chance] == 1 && !outputting && !gameOver && started){
                    chance++;
                    if(chance == score){
                        chance = 0;
                        new Thread(() ->{
                            outputting = true;
                            try{
                                Thread.sleep(700);
                            }catch (InterruptedException ie){
                                ie.printStackTrace();
                            }
                            output();
                        }).start();
                    }
                }else if(!outputting && !gameOver){
                    gameOver = true;
                    started = false;
                    r.setBackground(Color.red);
                    chance = 0;
                }
            }
        });
        g = new JButton();
        g.setSize(sc.width/2-10,sc.height/2-10);
        g.setLocation(sc.width/2+10,0);
        g.setBackground(new Color(111, 194, 118));
        g.setBorderPainted(false);
        g.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(seq[chance] == 2 && !outputting && !gameOver&& started){
                    chance++;
                    if(chance == score){
                        chance = 0;
                        new Thread(() ->{
                            outputting = true;
                            try{
                                Thread.sleep(700);
                            }catch (InterruptedException ie){
                                ie.printStackTrace();
                            }
                            output();
                        }).start();
                    }
                }else if(!outputting && !gameOver){
                    gameOver = true;
                    started = false;
                    g.setBackground(Color.red);
                    chance = 0;
                }
            }
        });
        b = new JButton();
        b.setSize(sc.width/2-10,sc.height/2-10);
        b.setLocation(0,sc.height/2+10);
        b.setBackground(new Color(56, 104, 235));
        b.setBorderPainted(false);
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(seq[chance] == 3 && !outputting && !gameOver && started){
                    chance++;
                    if(chance == score){
                        chance = 0;
                        new Thread(() ->{
                            outputting = true;
                            try{
                                Thread.sleep(700);
                            }catch (InterruptedException ie){
                                ie.printStackTrace();
                            }
                            output();
                        }).start();
                    }
                }else if(!outputting && !gameOver){
                    gameOver = true;
                    started = false;
                    b.setBackground(Color.red);
                    chance = 0;
                }
            }
        });
        y = new JButton();
        y.setSize(sc.width/2-10,sc.height/2-10);
        y.setLocation(sc.width/2+10,sc.height/2+10);
        y.setBackground(new Color(247, 239, 0));
        y.setBorderPainted(false);
        y.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(seq[chance] > 3 && !outputting && !gameOver && started){
                    chance++;
                    if(chance == score){
                        chance = 0;
                        new Thread(() ->{
                            outputting = true;
                            try{
                                Thread.sleep(700);
                            }catch (InterruptedException ie){
                                ie.printStackTrace();
                            }
                            output();
                        }).start();
                    }
                }else if(!outputting && !gameOver){
                    gameOver = true;
                    started = false;
                    y.setBackground(Color.red);
                    chance = 0;
                }
            }
        });
        start = new JButton();
        start.setText("");
        start.setSize(170,170);
        start.setLocation(sc.width/2-85,sc.height/2-85);
        start.setBackground(new Color(61,61,61));
        start.setFocusable(false);
        start.setBorderPainted(false);
        start.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(!started){
                    try{
                        Thread.sleep(200);
                    }catch (InterruptedException ie){
                        ie.printStackTrace();
                    }
                    started = true;
                    gameOver= false;
                    score = 0;
                    new Thread(() -> {
                    for(int i = 0;i < 999;i++){
                        seq[i] = (byte)(1 + (int)(Math.random()*4));
                    }
                    }).start();
                    cr.interrupt();
                    r.setBackground(new Color(237, 109, 100));
                    g.setBackground(new Color(111,194,118));
                    b.setBackground(new Color(56,104,235));
                    y.setBackground(new Color(247,239,0));
                    output();
                }
            }
        });
        cr = new Thread(() -> {
            while(!started){
                r.setBackground(new Color(245, 143, 130));
                try{
                    Thread.sleep(500);
                }catch (InterruptedException ie){
                    ie.printStackTrace();
                }
                r.setBackground(new Color(237,109,100));
                try{
                        Thread.sleep(50);
                    }catch (InterruptedException ie){
                        ie.printStackTrace();
                    }
                g.setBackground(new Color(139, 196, 144));
                try{
                    Thread.sleep(500);
                }catch (InterruptedException ie){
                    ie.printStackTrace();
                }
                g.setBackground(new Color(111,194,118));
                try{
                    Thread.sleep(50);
                }catch (InterruptedException ie){
                    ie.printStackTrace();
                }
                y.setBackground(new Color(255, 252, 166));
                try{
                    Thread.sleep(500);
                }catch (InterruptedException ie){
                    ie.printStackTrace();
                }
                y.setBackground(new Color(247,239,0));
                try{
                    Thread.sleep(50);
                }catch (InterruptedException ie){
                    ie.printStackTrace();
                }
                b.setBackground(new Color(89, 128, 235));
                try{
                    Thread.sleep(500);
                }catch (InterruptedException ie){
                    ie.printStackTrace();
                }
                b.setBackground(new Color(56,104,235));
                try{
                    Thread.sleep(50);
                }catch (InterruptedException ie){
                    ie.printStackTrace();
                }
                try{
                    Thread.sleep(500);
                }catch (InterruptedException ie){
                    ie.printStackTrace();
                }
            }
        });
        cr.start();
        pa.add(start);
        pa.add(r);
        pa.add(g);
        pa.add(b);
        pa.add(y);
        f.setVisible(true);
    }
    public static void output(){
        outputting = true;
        if(hi < score){
            hi = score;
            try{
                Files.write(Paths.get(System.getProperty("user.dir")+"\\res\\saves.txt"),String.valueOf(hi).getBytes());
            }catch (IOException ioe){
                ioe.printStackTrace();
            }
        }
        score++;
        new Thread(() -> {
        for(int i = 0;i < score;i++){
            if(seq[i] == 1){
                r.setBackground(new Color(245, 143, 130));
                try{
                    Thread.sleep(500);
                }catch (InterruptedException ie){
                    ie.printStackTrace();
                }
                r.setBackground(new Color(237, 109, 100));
            }else if(seq[i] == 2){
                g.setBackground(new Color(139, 196, 144));
                try{
                    Thread.sleep(500);
                }catch (InterruptedException ie){
                    ie.printStackTrace();
                }
                g.setBackground(new Color(111,194,118));
            }else if(seq[i] == 3){
                b.setBackground(new Color(89, 128, 235));
                try{
                    Thread.sleep(500);
                }catch (InterruptedException ie){
                    ie.printStackTrace();
                }
                b.setBackground(new Color(56, 104, 235));
            }else{
                y.setBackground(new Color(255, 252, 166));
                try{
                    Thread.sleep(500);
                }catch (InterruptedException ie){
                    ie.printStackTrace();
                }
                y.setBackground(new Color(247, 239, 0));
            }
            try{
                Thread.sleep(100);
            }catch (InterruptedException ie){
                ie.printStackTrace();
            }
        }
        }).start();
        outputting = false;
        pa.repaint();
    }
}
import com.sun.org.apache.bcel.internal.generic.L2D;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.time.format.TextStyle;
import java.util.*;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class Visualization {

    public static void main(String[] args) {


        int i;
        String[] state;
        int[] initialState = new int[9];
        Scanner input = new Scanner(System.in);

        System.out.println("---------------");
        System.out.println("8-puzzle solver");
        System.out.println("---------------");

        do {
            System.out.print("\nInitial state: ");
            state = input.nextLine().split("");
        } while (state.length != 9);

        for (i = 0; i < state.length; i++) {
            initialState[i] = Integer.parseInt(state[i]);
        }

        Color[] colorstate = new Color[9];
        colorstate[0] = Color.white ;
        colorstate[1] = new Color(255, 28, 28);
        colorstate[2] = new Color(32, 232, 42);
        colorstate[3] = new Color(255, 138, 28);
        colorstate[4] = new Color(64, 64, 179);
        colorstate[5] = new Color(146, 36, 214);
        colorstate[6] = new Color(255, 240, 36);
        colorstate[7] = new Color(255, 28, 28);
        colorstate[8] = new Color(32, 232, 42);



        JFrame frame = new JFrame("8-puzzle Visualization");

        frame.setSize(780, 660);
        frame.setVisible(true);
        frame.setLocation(500, 150);

        JPanel panel = new JPanel();

        frame.add(panel);
        panel.setBackground(Color.white);
        panel.setLayout(null);

        JLabel Header = new JLabel("8-puzzle solver", 0);
        Header.setLocation(175, 50);
        Header.setSize(400, 100);
        Header.setFont(new Font("Ariel", Font.BOLD, 40));

        LineBorder blackB = new LineBorder(Color.black,4,false);


        JPanel borderpanel = new JPanel();
        borderpanel.setBackground(new Color(0,0,0,0));
        borderpanel.setLayout(null);
        borderpanel.setBorder(blackB);
        borderpanel.setSize(248 ,248);
        borderpanel.setLocation(255,195);
        panel.add(borderpanel);



        LineBorder round = new LineBorder(Color.black,1,true);

        panel.add(Header);

        JLabel L1 = new JLabel(" ", 0);
        L1.setLocation(260, 200);
        L1.setBorder(round);
        L1.setSize(78, 78);
        L1.setFont(new Font("Ariel", Font.BOLD, 45));
        L1.setBackground(colorstate[initialState[0]]);
        L1.setOpaque(true);

        JLabel L2 = new JLabel(" ", 0);
        L2.setLocation(340, 200);
        L2.setBorder(round);
        L2.setSize(78, 78);
        L2.setFont(new Font("Ariel", Font.BOLD, 45));
        L2.setBackground(colorstate[initialState[1]]);
        L2.setOpaque(true);

        JLabel L3 = new JLabel(" ", 0);
        L3.setLocation(420, 200);
        L3.setBorder(round);
        L3.setSize(78, 78);
        L3.setFont(new Font("Ariel", Font.BOLD, 45));
        L3.setBackground(colorstate[initialState[2]]);
        L3.setOpaque(true);

        JLabel L4 = new JLabel(" ", 0);
        L4.setLocation(260, 280);
        L4.setBorder(round);
        L4.setSize(78, 78);
        L4.setFont(new Font("Ariel", Font.BOLD, 45));
        L4.setBackground(colorstate[initialState[3]]);
        L4.setOpaque(true);

        JLabel L5 = new JLabel(" ", 0);
        L5.setLocation(340, 280);
        L5.setBorder(round);
        L5.setSize(78, 78);
        L5.setFont(new Font("Ariel", Font.BOLD, 45));
        L5.setBackground(colorstate[initialState[4]]);
        L5.setOpaque(true);

        JLabel L6 = new JLabel(" ", 0);
        L6.setLocation(420, 280);
        L6.setBorder(round);
        L6.setSize(78, 78);
        L6.setFont(new Font("Ariel", Font.BOLD, 45));
        L6.setBackground(colorstate[initialState[5]]);
        L6.setOpaque(true);

        JLabel L7 = new JLabel(" ", 0);
        L7.setLocation(260, 360);
        L7.setBorder(round);
        L7.setSize(78, 78);
        L7.setFont(new Font("Ariel", Font.BOLD, 45));
        L7.setBackground(colorstate[initialState[6]]);
        L7.setOpaque(true);

        JLabel L8 = new JLabel(" ", 0);
        L8.setLocation(340, 360);
        L8.setBorder(round);
        L8.setSize(78, 78);
        L8.setFont(new Font("Ariel", Font.BOLD, 45));
        L8.setBackground(colorstate[initialState[7]]);
        L8.setOpaque(true);

        JLabel L9 = new JLabel(" ", 0);
        L9.setLocation(420, 360);
        L9.setBorder(round);
        L9.setSize(78, 78);
        L9.setFont(new Font("Ariel", Font.BOLD, 45));
        L9.setBackground(colorstate[initialState[8]]);
        L9.setOpaque(true);


        panel.add(L1);
        panel.add(L2);
        panel.add(L3);
        panel.add(L4);
        panel.add(L5);
        panel.add(L6);
        panel.add(L7);
        panel.add(L8);
        panel.add(L9);


            if (initialState[0] == 0)
            {
                L1.setText(" ");
            }
            else
            {
                L1.setText(String.valueOf(initialState[0]));
            }
        if (initialState[1] == 0)
        {
            L2.setText(" ");
        }
        else
        {
            L2.setText(String.valueOf(initialState[1]));
        }
        if (initialState[2] == 0)
        {
            L3.setText(" ");
        }
        else
        {
            L3.setText(String.valueOf(initialState[2]));
        }
        if (initialState[3] == 0)
        {
            L4.setText(" ");
        }
        else
        {
            L4.setText(String.valueOf(initialState[3]));
        }
        if (initialState[4] == 0)
        {
            L5.setText(" ");
        }
        else
        {
            L5.setText(String.valueOf(initialState[4]));
        }
        if (initialState[5] == 0)
        {
            L6.setText(" ");
        }
        else
        {
            L6.setText(String.valueOf(initialState[5]));
        }
        if (initialState[6] == 0)
        {
            L7.setText(" ");
        }
        else
        {
            L7.setText(String.valueOf(initialState[6]));
        }
        if (initialState[7] == 0)
        {
            L8.setText(" ");
        }
        else
        {
            L8.setText(String.valueOf(initialState[7]));
        }
        if (initialState[8] == 0)
        {
            L9.setText(" ");
        }
        else
        {
            L9.setText(String.valueOf(initialState[8]));
        }



        JToggleButton BFSbutton = new JToggleButton();
        BFSbutton.setLocation(140,500);
        BFSbutton.setSelected(false);
        BFSbutton.setSize(100,40);
        BFSbutton.setText("BFS");
        BFSbutton.setContentAreaFilled(false);
        BFSbutton.setFocusPainted(false);

        JToggleButton DFSbutton = new JToggleButton();
        DFSbutton.setLocation(270,500);
        DFSbutton.setSelected(false);
        DFSbutton.setSize(100,40);
        DFSbutton.setText("DFS");
        DFSbutton.setContentAreaFilled(false);
        DFSbutton.setFocusPainted(false);

        JToggleButton Astarbutton1 = new JToggleButton();
        Astarbutton1.setLocation(400,500);
        Astarbutton1.setSelected(false);
        Astarbutton1.setSize(100,40);
        Astarbutton1.setText("A*/MANH");
        Astarbutton1.setContentAreaFilled(false);
        Astarbutton1.setFocusPainted(false);

        JToggleButton Astarbutton2 = new JToggleButton();
        Astarbutton2.setLocation(530,500);
        Astarbutton2.setSelected(false);
        Astarbutton2.setSize(100,40);
        Astarbutton2.setText("A*/ECLU");
        Astarbutton2.setContentAreaFilled(false);
        Astarbutton2.setFocusPainted(false);

        panel.add(BFSbutton);
        panel.add(DFSbutton);
        panel.add(Astarbutton1);
        panel.add(Astarbutton2);


        BFSbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BFSClass bfs = new BFSClass();
                Stack<String> path = bfs.BFSPath(initialState);

                BFSbutton.setEnabled(false);
                DFSbutton.setEnabled(false);
                Astarbutton1.setEnabled(false);
                Astarbutton2.setEnabled(false);


                javax.swing.Timer timer = new javax.swing.Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        char[] state ;
                        int [] temp = new int[9] ;
                        int count ;

                        if (!path.empty()) {
                            count = 0;
                            state = path.pop().toCharArray();
                            for (int i = 0; i < state.length; i++)
                                if (state[i] <= '8' && state[i] >= '0') {
                                    temp[count] = state[i] - '0';
                                    count++;
                                }

                            if (count != 0) {
                                if (temp[0] == 0) {
                                    L1.setText(" ");
                                } else {
                                    L1.setText(String.valueOf(temp[0]));
                                }
                                if (temp[1] == 0) {
                                    L2.setText(" ");
                                } else {
                                    L2.setText(String.valueOf(temp[1]));
                                }
                                if (temp[2] == 0) {
                                    L3.setText(" ");
                                } else {
                                    L3.setText(String.valueOf(temp[2]));
                                }
                                if (temp[3] == 0) {
                                    L4.setText(" ");
                                } else {
                                    L4.setText(String.valueOf(temp[3]));
                                }
                                if (temp[4] == 0) {
                                    L5.setText(" ");
                                } else {
                                    L5.setText(String.valueOf(temp[4]));
                                }
                                if (temp[5] == 0) {
                                    L6.setText(" ");
                                } else {
                                    L6.setText(String.valueOf(temp[5]));
                                }
                                if (temp[6] == 0) {
                                    L7.setText(" ");
                                } else {
                                    L7.setText(String.valueOf(temp[6]));
                                }
                                if (temp[7] == 0) {
                                    L8.setText(" ");
                                } else {
                                    L8.setText(String.valueOf(temp[7]));
                                }
                                if (temp[8] == 0) {
                                    L9.setText(" ");
                                } else {
                                    L9.setText(String.valueOf(temp[8]));
                                }

                                L1.setBackground(colorstate[temp[0]]);
                                L2.setBackground(colorstate[temp[1]]);
                                L3.setBackground(colorstate[temp[2]]);
                                L4.setBackground(colorstate[temp[3]]);
                                L5.setBackground(colorstate[temp[4]]);
                                L6.setBackground(colorstate[temp[5]]);
                                L7.setBackground(colorstate[temp[6]]);
                                L8.setBackground(colorstate[temp[7]]);
                                L9.setBackground(colorstate[temp[8]]);

                                panel.revalidate();
                                panel.repaint();


                            }
                        }
                    }
                });

                timer.setRepeats(true);
                timer.start();

            }
        });


        DFSbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DFSClass dfs = new DFSClass();
                Stack<String> path = dfs.DFSPath(initialState);

                BFSbutton.setEnabled(false);
                DFSbutton.setEnabled(false);
                Astarbutton1.setEnabled(false);
                Astarbutton2.setEnabled(false);


                javax.swing.Timer timer = new javax.swing.Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        char[] state ;
                        int [] temp = new int[9] ;
                        int count ;

                        if (!path.empty()) {
                            count = 0;
                            state = path.pop().toCharArray();
                            for (int i = 0; i < state.length; i++)
                                if (state[i] <= '8' && state[i] >= '0') {
                                    temp[count] = state[i] - '0';
                                    count++;
                                }

                            if (count != 0) {
                                if (temp[0] == 0) {
                                    L1.setText(" ");
                                } else {
                                    L1.setText(String.valueOf(temp[0]));
                                }
                                if (temp[1] == 0) {
                                    L2.setText(" ");
                                } else {
                                    L2.setText(String.valueOf(temp[1]));
                                }
                                if (temp[2] == 0) {
                                    L3.setText(" ");
                                } else {
                                    L3.setText(String.valueOf(temp[2]));
                                }
                                if (temp[3] == 0) {
                                    L4.setText(" ");
                                } else {
                                    L4.setText(String.valueOf(temp[3]));
                                }
                                if (temp[4] == 0) {
                                    L5.setText(" ");
                                } else {
                                    L5.setText(String.valueOf(temp[4]));
                                }
                                if (temp[5] == 0) {
                                    L6.setText(" ");
                                } else {
                                    L6.setText(String.valueOf(temp[5]));
                                }
                                if (temp[6] == 0) {
                                    L7.setText(" ");
                                } else {
                                    L7.setText(String.valueOf(temp[6]));
                                }
                                if (temp[7] == 0) {
                                    L8.setText(" ");
                                } else {
                                    L8.setText(String.valueOf(temp[7]));
                                }
                                if (temp[8] == 0) {
                                    L9.setText(" ");
                                } else {
                                    L9.setText(String.valueOf(temp[8]));
                                }

                                L1.setBackground(colorstate[temp[0]]);
                                L2.setBackground(colorstate[temp[1]]);
                                L3.setBackground(colorstate[temp[2]]);
                                L4.setBackground(colorstate[temp[3]]);
                                L5.setBackground(colorstate[temp[4]]);
                                L6.setBackground(colorstate[temp[5]]);
                                L7.setBackground(colorstate[temp[6]]);
                                L8.setBackground(colorstate[temp[7]]);
                                L9.setBackground(colorstate[temp[8]]);

                                panel.revalidate();
                                panel.repaint();


                            }
                        }
                    }
                });

                timer.setRepeats(true);
                timer.start();

            }
        });

    }
}

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class Analyst {
JFrame fereastra = new JFrame();
JPanel panouButoane = new JPanel();
JPanel panouFrumos = new JPanel();
JButton fileChooser = new JButton("Open file");



Color magicblue = new Color(138, 205, 255);
Color grey = new Color(165, 165, 165);

int latime=360;
int inaltime=540;

Analyst()
{
    fereastra.setVisible(true);
    fereastra.setSize(latime, inaltime);
    fereastra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    fereastra.setResizable(false);
    fereastra.setLayout(new BorderLayout());

    panouButoane.setBackground(magicblue);
    panouButoane.setPreferredSize(new Dimension(130, inaltime));
    fereastra.add(panouButoane, BorderLayout.WEST);

    panouFrumos.setBackground(Color.black);
    fereastra.add(panouFrumos);

    fileChooser.setForeground(Color.black);
    fileChooser.setBackground(Color.white);
    fileChooser.setBorder(new LineBorder(grey));
    fileChooser.setHorizontalAlignment(SwingConstants.CENTER);
    fileChooser.setVerticalAlignment(SwingConstants.CENTER);
    fileChooser.setPreferredSize(new Dimension(100, 30));
    fileChooser.setFont(new Font("Calibri", Font.PLAIN, 18));
    fileChooser.setFocusable(false);
    panouButoane.add(fileChooser);

    fileChooser.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            JFileChooser choose = new JFileChooser();
            int rezultat = choose.showOpenDialog(null);
            if (rezultat == JFileChooser.APPROVE_OPTION){
                File fisier = choose.getSelectedFile();
                try{
                    Scanner scanner = new Scanner(fisier);
                    String tipSerie = scanner.next();
                    switch (tipSerie) {
                        case "DistributionSeries":
                            double[][] tabel = new double[100][2];
                            int i = 0;
                            int randuri = 0;
                            while (scanner.hasNext()) {
                                int n = scanner.nextInt();
                                double x = scanner.nextDouble();
                                tabel[i][0] = n;
                                tabel[i][1] = x;
                                randuri++;
                                i++;
                                System.out.println(n);
                                System.out.println(x);
                            }
                            double suma = 0;
                            for(i=0; i<randuri; i++){
                                suma += tabel[i][1];

                            }
                            double media = suma/randuri;

                            double max = -1;
                            double mod;
                            for(i=0; i<randuri; i++){
                            if (max < tabel[i][0]){
                                max = tabel[i][0];
                                mod = tabel[i][1];
                                }
                            }

                            int[] FCC = new int[randuri];
                            FCC[0] = (int)tabel[0][0];
                            for(i=1; i<randuri; i++){
                               FCC[i] = FCC[i-1] + (int)tabel[i][0];
                                
                            }
                            
                            double locQ1 = 1/4*(FCC[randuri-1]+1);
                            double locQ2 = 1/2*(FCC[randuri-1]+1);
                            double locQ3 = 3/4*(FCC[randuri-1]+1);

                            if (locQ1 < FCC[0]){
                                double Q1 = tabel[0][1];

                            }
                                else{
                                    for(i=1; i<randuri; i++){
                                        if(locQ1 < FCC[i] && locQ1 > FCC[i-1]){
                                            double Q1 = tabel[i][1];
                                        }
                                       
                                    }

                                }

                                if (locQ2 < FCC[0]){
                                    double Q2 = tabel[0][1];
                                    double mediana = Q2;
    
                                }
                                    else{
                                        for(i=1; i<randuri; i++){
                                            if(locQ2 < FCC[i] && locQ2 > FCC[i-1]){
                                                double Q2 = tabel[i][1];
                                                double mediana = Q2;
                                            }
                                            
                                        }
    
                                    }

                                    if (locQ3 < FCC[0]){
                                        double Q3 = tabel[0][1];
        
                                    }
                                        else{
                                            for(i=1; i<randuri; i++){
                                                if(locQ3 < FCC[i] && locQ3 > FCC[i-1]){
                                                    double Q3 = tabel[i][1];
                                                }
                                                
                                            }
        
                                        }
                            
                            break;
                        case "IntervalSeries":

                            break;

                        default:
                            break;
                    }
                }
                catch(Exception err){
                    err.printStackTrace();
                }
            }
        }
    });
}
}

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
                            }
                            scanner.close();

                            DistributionSeriesStatistics statistica = new DistributionSeriesStatistics(tabel, randuri);
                            double medie = statistica.getMean();
                            double mod = statistica.getMod();
                            double mediana = statistica.getMedian();
                            double Q1 = statistica.getQ1();
                            double Q2 = statistica.getQ2();
                            double Q3 = statistica.getQ3();

                            System.out.println("media " + medie);
                            System.out.println("mod " + mod);
                            System.out.println("mediana " + mediana);
                            System.out.println("Q1 " + Q1);
                            System.out.println("Q2 " + Q2);
                            System.out.println("Q3 " + Q3);

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

double Media(double[][] tabel, int randuri){
    double suma = 0;
    double n = 0;
    for(int i = 0;i<randuri;i++){
        suma += tabel[i][1] * tabel[i][0];
        n += tabel[i][0];
    }
    return suma/n;
}
double Mod(double[][] tabel, int randuri){
    double max = -1;
    double mod = -1;
    for(int i = 0;i<randuri;i++){
        if(tabel[i][0] > max){
            max = tabel[i][0];
            mod = tabel[i][1];
        }
    }
    return mod;
  }
void UmplereFCC(double[][] tabel,int[] FCC, int randuri){
    FCC[0] = (int)tabel[0][0];
    for(int i = 1; i < randuri;i ++){
        FCC[i] = FCC[i-1] + (int)tabel[i][0];
    }
}
double Quartil(double[][] tabel, int[] FCC, int randuri, double locQ){
    double Q = -1;
    if (locQ < FCC[0]){
        Q = tabel[0][1];
    }
    else{
        for(int i=1; i<randuri; i++){
            if(locQ < FCC[i] && locQ > FCC[i-1]){
                Q = tabel[i][1];
            } 
        }
    }
    return Q;
}
public class DistributionSeriesStatistics{

    double medie;
    double mod;
    double Q1;
    double Q2;
    double Q3;

    public DistributionSeriesStatistics(double[][] tabel, int randuri){
        medie = Media(tabel, randuri);
    mod = Mod(tabel, randuri);

    int[] FCC = new int[randuri];
    UmplereFCC(tabel, FCC, randuri);
                            
    double locQ1 = 1.0/4*(FCC[randuri-1]+1);
    double locQ2 = 1.0/2*(FCC[randuri-1]+1);
    double locQ3 = 3.0/4*(FCC[randuri-1]+1);

    Q1 = Quartil(tabel, FCC, randuri, locQ1);
    Q2 = Quartil(tabel, FCC, randuri, locQ2);
    Q3 = Quartil(tabel, FCC, randuri, locQ3);
    }

    public double getMean(){
        return medie;
    }
    public double getMod(){
        return mod;
    }
    public double getMedian(){
        return Q2;
    }
    public double getQ1(){
        return Q1;
    }
    public double getQ2(){
        return Q2;
    }
    public double getQ3(){
        return Q3;
    }
}

}

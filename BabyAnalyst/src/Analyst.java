import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

//Loc de parcare cursor
//
//
//
//
//        
//
//
////////////////////////

import javax.swing.*;
import javax.swing.border.LineBorder;

public class Analyst {
JFrame fereastra = new JFrame();
JPanel panouButoane = new JPanel();
JPanel panouFrumos = new JPanel();
JPanel panouOpenFile = new JPanel();
JPanel panouOperatori = new JPanel();
JPanel panouRezultate = new JPanel();
JPanel panouTheme = new JPanel();
JButton fileChooser = new JButton("Open file");
JButton changeTheme = new JButton("Change theme");
JButton formule = new JButton("Formule");

Color magicblue = new Color(138, 205, 255);
Color grey = new Color(165, 165, 165);

String[] butoane = {"Mean", "Mod", "Median", "Q1", "Q2", "Q3" };

int latime=540;
int inaltime=540;

Analyst()
{
    fereastra.setVisible(true);
    fereastra.setSize(latime, inaltime);
    fereastra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    fereastra.setResizable(false);
    fereastra.setLayout(new BorderLayout());

    panouButoane.setPreferredSize(new Dimension(130, inaltime));
    panouButoane.setLayout(new BorderLayout());
    fereastra.add(panouButoane, BorderLayout.WEST);

    panouOpenFile.setBackground(grey);
    panouOpenFile.setPreferredSize(new Dimension(130, 100));
    panouOpenFile.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 15));
    panouButoane.add(panouOpenFile, BorderLayout.NORTH);

    panouOperatori.setBackground(Color.white);
    panouOperatori.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 25));
    panouButoane.add(panouOperatori);

    changeTheme.setBackground(Color.white);
    changeTheme.setForeground(Color.black);
    changeTheme.setFocusable(false);
    changeTheme.setBorder(new LineBorder(grey));
    changeTheme.setHorizontalAlignment(SwingConstants.CENTER);
    changeTheme.setVerticalAlignment(SwingConstants.CENTER);
    changeTheme.setFont(new Font("Impact", Font.PLAIN, 10));
    changeTheme.setPreferredSize(new Dimension(80, 20));
    panouTheme.add(changeTheme);

    panouTheme.setSize(new Dimension(130, 150));
    panouTheme.setBackground(ClassicTheme.navyblue);
    panouButoane.add(panouTheme, BorderLayout.SOUTH);
    
    panouRezultate.setSize(new Dimension(130, inaltime));
    panouRezultate.setBackground(GirlyTheme.lavenderpurple);
    panouFrumos.add(panouRezultate, BorderLayout.WEST);

    panouFrumos.setBackground(Color.black);
    panouFrumos.setLayout( new BorderLayout());
    fereastra.add(panouFrumos);

    fileChooser.setForeground(Color.black);
    fileChooser.setBackground(Color.white);
    fileChooser.setBorder(new LineBorder(grey));
    fileChooser.setHorizontalAlignment(SwingConstants.CENTER);
    fileChooser.setVerticalAlignment(SwingConstants.CENTER);
    fileChooser.setPreferredSize(new Dimension(100, 30));
    fileChooser.setFont(new Font("Impact", Font.PLAIN, 18));
    fileChooser.setFocusable(false);
    panouOpenFile.add(fileChooser);

    formule.setBackground(Color.white);
    formule.setForeground(Color.black);
    formule.setBorder(new LineBorder(grey));
    formule.setHorizontalAlignment(SwingConstants.CENTER);
    formule.setVerticalAlignment(SwingConstants.CENTER);
    formule.setPreferredSize(new Dimension(60, 20));
    formule.setFont(new Font("Impact", Font.PLAIN, 10));
    formule.setFocusable(false);
    panouOpenFile.add(formule);

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
                            double[][] tabelDS = new double[100][2];

                            int i = 0;
                            int randuriDS = 0;

                            while (scanner.hasNext()) {
                                int n = scanner.nextInt();
                                double x = scanner.nextDouble();
                                tabelDS[i][0] = n;
                                tabelDS[i][1] = x;
                                randuriDS++;
                                i++;
                            }
                            scanner.close();

                            DistributionSeriesStatistics statisticaDS = new DistributionSeriesStatistics(tabelDS, randuriDS);
                            double medieDS = statisticaDS.getMean();
                            double modDS = statisticaDS.getMod();
                            double medianaDS = statisticaDS.getMedian();
                            double Q1DS = statisticaDS.getQ1();
                            double Q2DS = statisticaDS.getQ2();
                            double Q3DS = statisticaDS.getQ3();

                            System.out.println("media " + medieDS);
                            System.out.println("mod " + modDS);
                            System.out.println("mediana " + medianaDS);
                            System.out.println("Q1 " + Q1DS);
                            System.out.println("Q2 " + Q2DS);
                            System.out.println("Q3 " + Q3DS);

                            break;
                        case "IntervalSeries":
                            double[][] tabelIS = new double[100][3];

                            int j = 0;
                            int randuriIS = 0;

                            while (scanner.hasNext()) {
                                int n = scanner.nextInt();
                                double limInf = scanner.nextDouble();
                                double limSup = scanner.nextDouble();
                                tabelIS[j][0] = n;
                                tabelIS[j][1] = limInf;
                                tabelIS[j][2] = limSup;
                                randuriIS++;
                                j++;
                            }
                            scanner.close();

                            IntervalSeriesStatistics statisticaIS = new IntervalSeriesStatistics(tabelIS, randuriIS);
                            double medieIS = statisticaIS.getMean();
                            double modIS = statisticaIS.getMod();
                            double medianaIS = statisticaIS.getMedian();
                            double Q1IS = statisticaIS.getQ1();
                            double Q2IS = statisticaIS.getQ2();
                            double Q3IS = statisticaIS.getQ3();

                            System.out.println("media " + medieIS);
                            System.out.println("mod " + modIS);
                            System.out.println("mediana " + medianaIS);
                            System.out.println("Q1 " + Q1IS);
                            System.out.println("Q2 " + Q2IS);
                            System.out.println("Q3 " + Q3IS);

                            break;

                        default:
                            break;
                    }

                    int poz = 0;
                    for(int i = 0; i < butoane.length; i++){
                        JButton buton = new JButton(butoane[i]);
                        
                        buton.setFocusable(false);
                        buton.setPreferredSize(new Dimension(100, 30));
                        buton.setHorizontalAlignment(SwingConstants.CENTER);
                        buton.setVerticalAlignment(SwingConstants.CENTER);
                        buton.setFont(new Font("Impact", Font.PLAIN, 18));
                        buton.setForeground(Color.black);
                        buton.setBackground(Color.white);
                        buton.setBorder(new LineBorder(grey));

                        // GridBagConstraints gbc = new GridBagConstraints();
                        // gbc.gridy = poz;
                        // poz +=2;


                        panouOperatori.add(buton);
                        
                    }

                    panouButoane.revalidate();
                    panouButoane.repaint();
                    
                }
                catch(Exception err){
                    err.printStackTrace();
                }
            }
        }
    });
}

double MediaDS(double[][] tabel, int randuri){
    double suma = 0;
    double n = 0;
    for(int i = 0;i<randuri;i++){
        suma += tabel[i][1] * tabel[i][0];
        n += tabel[i][0];
    }
    return suma/n;
}
double ModDS(double[][] tabel, int randuri){
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
double QuartilDS(double[][] tabel, int[] FCC, int randuri, double locQ){
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
        medie = MediaDS(tabel, randuri);
        mod = ModDS(tabel, randuri);

        int[] FCC = new int[randuri];
        UmplereFCC(tabel, FCC, randuri);
                            
        double locQ1 = 1.0/4*(FCC[randuri-1]+1);
        double locQ2 = 1.0/2*(FCC[randuri-1]+1);
        double locQ3 = 3.0/4*(FCC[randuri-1]+1);

        Q1 = QuartilDS(tabel, FCC, randuri, locQ1);
        Q2 = QuartilDS(tabel, FCC, randuri, locQ2);
        Q3 = QuartilDS(tabel, FCC, randuri, locQ3);
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

double MediaIS(double[][] tabel, int randuri){
    double suma = 0;
    double MI;
    double n = 0;
    for(int i = 0; i < randuri; i++){
        MI = (tabel[i][1] + tabel[i][2])/2;
        suma += MI * tabel[i][0];
        n += tabel[i][0];
    }
    return suma/n;
}

double ModIS(double[][] tabel, int randuri){
    int poz = 1;
    double max = -1;
    for(int i = 0; i< randuri; i++){
        if(tabel[i][0] > max){
            max = tabel[i][0];
            poz = i;
        }
    }

    double D1 = tabel[poz][0] - tabel[poz-1][0];
    double D2 = tabel[poz][0] - tabel[poz + 2][0];
    double lungime = tabel[poz][2] - tabel[poz][1];
    double mod = tabel[poz][1] + lungime*D1/(D1 + D2);

    return mod;
}

double QuartilIS(double[][] tabel, int[] FCC, int randuri, double locQ){
    double n = -1;
    double lungime = 0;
    double limInf = 0;
    int poz = 0;
    
    if (locQ < FCC[0]){
        n = tabel[0][0];
        lungime = tabel[0][2] - tabel[0][1];

        return tabel[0][1] + lungime*locQ/n;
    }
    else{
        for(int i=1; i<randuri; i++){
            if(locQ < FCC[i] && locQ > FCC[i-1]){
                n = tabel[i][0];
                lungime = tabel[0][2] - tabel[0][1];
                limInf = tabel[0][1];
                poz = i;
            } 
        }
    }

    return limInf + lungime*(locQ - FCC[poz-1])/n;

}

public class IntervalSeriesStatistics{
    double medie;
    double mod;
    double Q1;
    double Q2;
    double Q3;

    public IntervalSeriesStatistics(double[][] tabel, int randuri){
        medie = MediaIS(tabel, randuri);
        mod = ModIS(tabel, randuri);

        int[] FCC = new int[randuri];
        UmplereFCC(tabel, FCC, randuri);

        double locQ1 = 1.0/4*(FCC[randuri-1]+1);
        double locQ2 = 1.0/2*(FCC[randuri-1]+1);
        double locQ3 = 3.0/4*(FCC[randuri-1]+1);

        Q1 = QuartilIS(tabel, FCC, randuri, locQ1);
        Q2 = QuartilIS(tabel, FCC, randuri, locQ2);
        Q3 = QuartilIS(tabel, FCC, randuri, locQ3);
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

public class ClassicTheme{
    static Color sharkgrey = new Color(68, 69 ,66);  //backgroundul din spatele butoanelor
    static Color blue = new Color(63, 72, 204); // chenarul pt medie, mod, mediana
    static Color navyblue = new Color(11, 47, 133); //interioul pt medie, mod, mediana
    static Color greyblue = new Color(46, 47, 71); // pt butoanele de la Q
    static Color silverblue = new Color(112, 146, 190); // culoare scris Q
}

public class GirlyTheme{
    static Color lavenderpurple = new Color(229, 156, 255); //background din spatele butoanelor
    static Color peonypink = new Color(255, 65, 153); // chenar pt medie, mod, mediana si interior la Q
    static Color powderpink = new Color(255, 174, 201); // interioul pt medie, mod, mediana
    static Color wildpink = new Color(186, 47, 112); // chenar pt Q   
}


    
}


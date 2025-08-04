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
    JPanel sus = new JPanel();
    JPanel mijloc = new JPanel();
    JButton fileChooser = new JButton("Open file");
    JButton changeTheme = new JButton("Change theme");
    JButton formule = new JButton("Formule");
    JLabel medieLabel = new JLabel();
    JLabel modLabel = new JLabel();
    JLabel medianaLabel = new JLabel();
    JLabel Q1Label = new JLabel();
    JLabel Q2Label = new JLabel();
    JLabel Q3Label = new JLabel();
    ImagineClassicTheme imgClassicTheme = new ImagineClassicTheme();
    ImagineGirlyTheme imgGirlyTheme = new ImagineGirlyTheme();

    String theme = "classic";

    // ImageIcon icon = new
    // ImageIcon(getClass().getResource("/src/poze/statisticaFundal.png"));
    // JLabel labelImagine = new JLabel(icon);

    Color magicblue = new Color(138, 205, 255);
    Color grey = new Color(165, 165, 165);

    String[] butoane = { "Mean", "Mode", "Median", "Q1", "Q2", "Q3" };

    String[] primele3 = { "Mean", "Mode", "Median" };

    int latime = 540;
    int inaltime = 540;

    Analyst() {
        fereastra.setVisible(true);
        fereastra.setSize(latime, inaltime);
        fereastra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fereastra.setResizable(false);
        fereastra.setLayout(new BorderLayout());

        panouButoane.setPreferredSize(new Dimension(130, 540));
        // panouButoane.setBorder(new LineBorder(Color.black, 7));
        panouButoane.setLayout(new BorderLayout());
        fereastra.add(panouButoane, BorderLayout.WEST);

        panouOpenFile.setBackground(ClassicTheme.sharkgrey);
        panouOpenFile.setPreferredSize(new Dimension(130, 100));
        panouOpenFile.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 15));
        panouButoane.add(panouOpenFile, BorderLayout.NORTH);

        panouOperatori.setBackground(ClassicTheme.sharkgrey);
        panouOperatori.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 25));
        panouButoane.add(panouOperatori);

        changeTheme.setBackground(Color.white);
        changeTheme.setForeground(ClassicTheme.silverblue);
        changeTheme.setFocusable(false);
        changeTheme.setBorder(new LineBorder(ClassicTheme.silverblue));
        changeTheme.setHorizontalAlignment(SwingConstants.CENTER);
        changeTheme.setVerticalAlignment(SwingConstants.CENTER);
        changeTheme.setFont(new Font("Impact", Font.PLAIN, 10));
        changeTheme.setPreferredSize(new Dimension(80, 20));
        panouTheme.add(changeTheme);

        panouTheme.setBackground(ClassicTheme.sharkgrey);
        panouButoane.add(panouTheme, BorderLayout.SOUTH);

        panouRezultate.setSize(new Dimension(110, inaltime));
        panouRezultate.setLayout(new BorderLayout());
        // panouRezultate.setBorder(new LineBorder(Color.black, 7));
        panouFrumos.add(panouRezultate, BorderLayout.WEST);
        // panouFrumos.add(labelImagine);

        sus.setPreferredSize(new Dimension(130, 100));
        sus.setBackground(ClassicTheme.sharkgrey);
        panouRezultate.add(sus, BorderLayout.NORTH);

        mijloc.setBackground(ClassicTheme.sharkgrey);
        mijloc.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 25));
        panouRezultate.add(mijloc);

        medieLabel.setPreferredSize(new Dimension(75, 30));
        medieLabel.setFont(new Font("Impact", Font.PLAIN, 18));
        medieLabel.setForeground(Color.black);

        modLabel.setPreferredSize(new Dimension(75, 30));
        modLabel.setFont(new Font("Impact", Font.PLAIN, 18));
        modLabel.setForeground(Color.black);

        medianaLabel.setPreferredSize(new Dimension(75, 30));
        medianaLabel.setFont(new Font("Impact", Font.PLAIN, 18));
        medianaLabel.setForeground(Color.black);

        Q1Label.setPreferredSize(new Dimension(75, 30));
        Q1Label.setFont(new Font("Impact", Font.PLAIN, 18));
        Q1Label.setForeground(Color.black);

        Q2Label.setPreferredSize(new Dimension(75, 30));
        Q2Label.setFont(new Font("Impact", Font.PLAIN, 18));
        Q2Label.setForeground(Color.black);

        Q3Label.setPreferredSize(new Dimension(75, 30));
        Q3Label.setFont(new Font("Impact", Font.PLAIN, 18));
        Q3Label.setForeground(Color.black);

        mijloc.add(medieLabel);
        mijloc.add(modLabel);
        mijloc.add(medianaLabel);
        mijloc.add(Q1Label);
        mijloc.add(Q2Label);
        mijloc.add(Q3Label);

        panouFrumos.setLayout(new BorderLayout());
        panouFrumos.add(imgClassicTheme, BorderLayout.CENTER);

        fereastra.add(panouFrumos);

        fileChooser.setForeground(ClassicTheme.blue);
        fileChooser.setBackground(Color.white);
        fileChooser.setBorder(new LineBorder(ClassicTheme.silverblue));
        fileChooser.setHorizontalAlignment(SwingConstants.CENTER);
        fileChooser.setVerticalAlignment(SwingConstants.CENTER);
        fileChooser.setPreferredSize(new Dimension(100, 30));
        fileChooser.setFont(new Font("Impact", Font.PLAIN, 18));
        fileChooser.setFocusable(false);
        panouOpenFile.add(fileChooser);

        formule.setBackground(Color.white);
        formule.setForeground(ClassicTheme.silverblue);
        formule.setBorder(new LineBorder(ClassicTheme.silverblue));
        formule.setHorizontalAlignment(SwingConstants.CENTER);
        formule.setVerticalAlignment(SwingConstants.CENTER);
        formule.setPreferredSize(new Dimension(60, 20));
        formule.setFont(new Font("Impact", Font.PLAIN, 10));
        formule.setFocusable(false);
        panouOpenFile.add(formule);

        fileChooser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser choose = new JFileChooser();
                int rezultat = choose.showOpenDialog(null);
                if (rezultat == JFileChooser.APPROVE_OPTION) {
                    File fisier = choose.getSelectedFile();
                    try {
                        Scanner scanner = new Scanner(fisier);
                        String tipSerie = scanner.next();

                        double medie = 0;
                        double mod = 0;
                        double mediana = 0;
                        double Q1 = 0;
                        double Q2 = 0;
                        double Q3 = 0;

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

                                DistributionSeriesStatistics statisticaDS = new DistributionSeriesStatistics(tabelDS,
                                        randuriDS);
                                medie = statisticaDS.getMean();
                                mod = statisticaDS.getMod();
                                mediana = statisticaDS.getMedian();
                                Q1 = statisticaDS.getQ1();
                                Q2 = statisticaDS.getQ2();
                                Q3 = statisticaDS.getQ3();

                                System.out.println("media " + medie);
                                System.out.println("mod " + mod);
                                System.out.println("mediana " + mediana);
                                System.out.println("Q1 " + Q1);
                                System.out.println("Q2 " + Q2);
                                System.out.println("Q3 " + Q3);

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

                                    System.out.println(n);
                                    System.out.println(limInf);
                                    System.out.println(limSup);
                                    randuriIS++;
                                    j++;
                                }
                                scanner.close();

                                IntervalSeriesStatistics statisticaIS = new IntervalSeriesStatistics(tabelIS,
                                        randuriIS);
                                medie = statisticaIS.getMean();
                                mod = statisticaIS.getMod();
                                mediana = statisticaIS.getMedian();
                                Q1 = statisticaIS.getQ1();
                                Q2 = statisticaIS.getQ2();
                                Q3 = statisticaIS.getQ3();

                                // System.out.println("media " + medie);
                                // System.out.println("mod " + mod);
                                // System.out.println("mediana " + mediana);
                                // System.out.println("Q1 " + Q1);
                                // System.out.println("Q2 " + Q2);
                                // System.out.println("Q3 " + Q3);

                                break;

                            default:
                                break;
                        }

                        panouOperatori.removeAll();

                        medieLabel.setText("");
                        modLabel.setText("");
                        medianaLabel.setText("");
                        Q1Label.setText("");
                        Q2Label.setText("");
                        Q3Label.setText("");

                        butoaneOperanziClassicTheme(medie, mediana, mod, Q1, Q2, Q3);

                        panouButoane.revalidate();
                        panouButoane.repaint();

                    } catch (Exception err) {
                        err.printStackTrace();
                    }
                }
            }
        });

        changeTheme.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switch (theme) {
                    case "classic":
                        theme = "girly";
                        panouOperatori.setBackground(GirlyTheme.lavenderpurple);
                        panouOpenFile.setBackground(GirlyTheme.lavenderpurple);
                        panouTheme.setBackground(GirlyTheme.lavenderpurple);

                        sus.setBackground(GirlyTheme.lavenderpurple);
                        mijloc.setBackground(GirlyTheme.lavenderpurple);

                        fileChooser.setForeground(Color.black);
                        fileChooser.setBackground(Color.white);
                        fileChooser.setBorder(new LineBorder(Color.black));
                        fileChooser.setFont(new Font("Elephant", Font.PLAIN, 18));

                        formule.setBackground(Color.white);
                        formule.setForeground(GirlyTheme.peonypink);
                        formule.setBorder(new LineBorder(GirlyTheme.peonypink));
                        formule.setFont(new Font("Elephant", Font.PLAIN, 10));

                        changeTheme.setBackground(Color.white);
                        changeTheme.setForeground(GirlyTheme.peonypink);
                        changeTheme.setBorder(new LineBorder(GirlyTheme.peonypink));
                        changeTheme.setFont(new Font("Elephant", Font.PLAIN, 10));

                        panouFrumos.remove(imgClassicTheme);
                        panouFrumos.add(imgGirlyTheme);
                        panouFrumos.revalidate();
                        panouFrumos.repaint();
                        break;

                    case "girly":
                        theme = "classic";
                        panouOperatori.setBackground(ClassicTheme.sharkgrey);
                        panouOpenFile.setBackground(ClassicTheme.sharkgrey);
                        panouTheme.setBackground(ClassicTheme.sharkgrey);

                        sus.setBackground(ClassicTheme.sharkgrey);
                        mijloc.setBackground(ClassicTheme.sharkgrey);

                        fileChooser.setForeground(ClassicTheme.blue);
                        fileChooser.setBackground(Color.white);
                        fileChooser.setBorder(new LineBorder(ClassicTheme.silverblue));
                        fileChooser.setFont(new Font("Impact", Font.PLAIN, 18));

                        formule.setBackground(Color.white);
                        formule.setForeground(ClassicTheme.silverblue);
                        formule.setBorder(new LineBorder(ClassicTheme.silverblue));
                        formule.setFont(new Font("Impact", Font.PLAIN, 10));

                        changeTheme.setBackground(Color.white);
                        changeTheme.setForeground(ClassicTheme.silverblue);
                        changeTheme.setBorder(new LineBorder(ClassicTheme.silverblue));
                        changeTheme.setFont(new Font("Impact", Font.PLAIN, 10));

                        panouFrumos.remove(imgGirlyTheme);
                        panouFrumos.add(imgClassicTheme);
                        panouFrumos.revalidate();
                        panouFrumos.repaint();
                        break;

                    default:
                        break;
                }
            }
        });
    }

    double MediaDS(double[][] tabel, int randuri) {
        double suma = 0;
        double n = 0;
        for (int i = 0; i < randuri; i++) {
            suma += tabel[i][1] * tabel[i][0];
            n += tabel[i][0];
        }
        return suma / n;
    }

    double ModDS(double[][] tabel, int randuri) {
        double max = -1;
        double mod = -1;
        for (int i = 0; i < randuri; i++) {
            if (tabel[i][0] > max) {
                max = tabel[i][0];
                mod = tabel[i][1];
            }
        }
        return mod;
    }

    void UmplereFCC(double[][] tabel, int[] FCC, int randuri) {
        FCC[0] = (int) tabel[0][0];
        for (int i = 1; i < randuri; i++) {
            FCC[i] = FCC[i - 1] + (int) tabel[i][0];
        }
    }

    double QuartilDS(double[][] tabel, int[] FCC, int randuri, double locQ) {
        double Q = -1;
        if (locQ < FCC[0]) {
            Q = tabel[0][1];
        } else {
            for (int i = 1; i < randuri; i++) {
                if (locQ < FCC[i] && locQ > FCC[i - 1]) {
                    Q = tabel[i][1];
                }
            }
        }
        return Q;
    }

    public class DistributionSeriesStatistics {

        double medie;
        double mod;
        double Q1;
        double Q2;
        double Q3;

        public DistributionSeriesStatistics(double[][] tabel, int randuri) {
            medie = MediaDS(tabel, randuri);
            mod = ModDS(tabel, randuri);

            int[] FCC = new int[randuri];
            UmplereFCC(tabel, FCC, randuri);

            double locQ1 = 1.0 / 4 * (FCC[randuri - 1] + 1);
            double locQ2 = 1.0 / 2 * (FCC[randuri - 1] + 1);
            double locQ3 = 3.0 / 4 * (FCC[randuri - 1] + 1);

            Q1 = QuartilDS(tabel, FCC, randuri, locQ1);
            Q2 = QuartilDS(tabel, FCC, randuri, locQ2);
            Q3 = QuartilDS(tabel, FCC, randuri, locQ3);
        }

        public double getMean() {
            return medie;
        }

        public double getMod() {
            return mod;
        }

        public double getMedian() {
            return Q2;
        }

        public double getQ1() {
            return Q1;
        }

        public double getQ2() {
            return Q2;
        }

        public double getQ3() {
            return Q3;
        }
    }

    double MediaIS(double[][] tabel, int randuri) {
        double suma = 0;
        double MI;
        double n = 0;
        for (int i = 0; i < randuri; i++) {
            MI = (tabel[i][1] + tabel[i][2]) / 2;
            suma += MI * tabel[i][0];
            n += tabel[i][0];
        }
        return suma / n;
    }

    double ModIS(double[][] tabel, int randuri) {
        int poz = 1;
        double max = -1;
        for (int i = 0; i < randuri; i++) {
            if (tabel[i][0] > max) {
                max = tabel[i][0];
                poz = i;
            }
        }

        double D1 = tabel[poz][0] - tabel[poz - 1][0];
        double D2 = tabel[poz][0] - tabel[poz + 1][0];
        double lungime = tabel[poz][2] - tabel[poz][1];
        double mod = tabel[poz][1] + lungime * D1 / (D1 + D2);

        return mod;
    }

    double QuartilIS(double[][] tabel, int[] FCC, int randuri, double locQ) {
        double n = -1;
        double lungime = 0;
        double limInf = 0;
        int poz = 0;

        if (locQ < FCC[0]) {
            n = tabel[0][0];
            limInf = tabel[0][1];
            lungime = tabel[0][2] - tabel[0][1];

            return limInf + lungime * locQ / n;
        } else {
            for (int i = 1; i < randuri; i++) {
                if (locQ < FCC[i] && locQ > FCC[i - 1]) {
                    n = tabel[i][0];
                    lungime = tabel[i][2] - tabel[i][1];
                    limInf = tabel[i][1];
                    poz = i;
                }
            }
        }

        return limInf + lungime * (locQ - FCC[poz - 1]) / n;

    }

    public class IntervalSeriesStatistics {
        double medie;
        double mod;
        double Q1;
        double Q2;
        double Q3;

        public IntervalSeriesStatistics(double[][] tabel, int randuri) {
            medie = MediaIS(tabel, randuri);
            mod = ModIS(tabel, randuri);

            int[] FCC = new int[randuri];
            UmplereFCC(tabel, FCC, randuri);

            double locQ1 = 1.0 / 4 * (FCC[randuri - 1] + 1);
            double locQ2 = 1.0 / 2 * (FCC[randuri - 1] + 1);
            double locQ3 = 3.0 / 4 * (FCC[randuri - 1] + 1);

            Q1 = QuartilIS(tabel, FCC, randuri, locQ1);
            Q2 = QuartilIS(tabel, FCC, randuri, locQ2);
            Q3 = QuartilIS(tabel, FCC, randuri, locQ3);
        }

        public double getMean() {
            return medie;
        }

        public double getMod() {
            return mod;
        }

        public double getMedian() {
            return Q2;
        }

        public double getQ1() {
            return Q1;
        }

        public double getQ2() {
            return Q2;
        }

        public double getQ3() {
            return Q3;
        }
    }

    public class ClassicTheme {
        static Color sharkgrey = new Color(68, 69, 66); // backgroundul din spatele butoanelor
        static Color blue = new Color(63, 72, 204); // chenarul pt medie, mod, mediana
        static Color navyblue = new Color(11, 47, 133); // interioul pt medie, mod, mediana
        static Color greyblue = new Color(46, 47, 71); // pt butoanele de la Q
        static Color silverblue = new Color(112, 146, 190); // culoare scris Q
    }

    public class GirlyTheme {
        static Color lavenderpurple = new Color(229, 156, 255); // background din spatele butoanelor
        static Color peonypink = new Color(255, 65, 153); // si interiorchenar pt medie, mod, mediana la Q
        static Color powderpink = new Color(255, 174, 201); // interioul pt medie, mod, mediana
        static Color wildpink = new Color(186, 47, 112); // chenar pt Q
    }

    String scoateVirgula(double valoare) {
        if (valoare % 1 == 0) {
            return Integer.toString((int) valoare);
        } else {
            return Double.toString(valoare);
        }
    }

    void butoaneOperanziClassicTheme(double medie, double mediana, double mod, double Q1, double Q2, double Q3){
        for (int i = 0; i < butoane.length; i++) {
            JButton buton = new JButton(butoane[i]);

            buton.setFocusable(false);
            buton.setPreferredSize(new Dimension(100, 30));
            buton.setHorizontalAlignment(SwingConstants.CENTER);
            buton.setVerticalAlignment(SwingConstants.CENTER);
            buton.setFont(new Font("Impact", Font.PLAIN, 18));

            if (Arrays.asList(primele3).contains(butoane[i])) {
                buton.setBorder(new LineBorder(ClassicTheme.blue, 3));
                buton.setBackground(ClassicTheme.navyblue);
                buton.setForeground(Color.white);
            } else {
                buton.setBorder(new LineBorder(Color.white, 3));
                buton.setBackground(ClassicTheme.greyblue);
                buton.setForeground(ClassicTheme.silverblue);
            }

            panouOperatori.add(buton);

            final double medieFinal = medie;
            final double medianaFinal = mediana;
            final double modFinal = mod;
            final double Q1Final = Q1;
            final double Q2Final = Q2;
            final double Q3Final = Q3;

            buton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JButton buton = (JButton) e.getSource();
                    String simbol = buton.getText();

                    switch (simbol) {
                        case "Mean":
                            medieLabel.setText(scoateVirgula(medieFinal));
                            break;

                        case "Median":
                            medianaLabel.setText(scoateVirgula(medianaFinal));
                            break;

                        case "Mode":
                            modLabel.setText(scoateVirgula(modFinal));
                            break;

                        case "Q1":
                            Q1Label.setText(scoateVirgula(Q1Final));
                            break;

                        case "Q2":
                            Q2Label.setText(scoateVirgula(Q2Final));
                            break;

                        case "Q3":
                            Q3Label.setText(scoateVirgula(Q3Final));
                            break;

                        default:
                            break;
                    }
                }
            });
        }
    }

}

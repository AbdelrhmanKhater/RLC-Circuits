/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circuittask;
import java.net.URL;
import java.awt.Color;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author KhAtEr
 */
public class mainClass extends JFrame implements ActionListener,ItemListener{
    private  double q=0,y=0,VM=0,W=12000,V=0,I=0,R=0,L=0,C=0,Seta=0,Taw=0,Taw1=0,K=0,step=0,t=0,max=0,F=0,W0=0,Wd=0,Alfa=0,Fy=0,cond=0,Z=0,A1=0,A2=0,first=0,second=0;
    private byte choice=0;
    String arrs[]=new String[] {"None","RL","RC","RLC"};
    Panel main=new Panel();
    Panel p1=new Panel();
    Panel p2=new Panel();
    Panel p3=new Panel();
    Panel p4=new Panel();
    Panel p5=new Panel();
    Font font=new Font("Serif",Font.BOLD,15);
    Color c1=new Color(0,128,255);
    Color c2=new Color(255,255,255);
    Color c3=new Color(160,160,160);
    JComboBox combo=new JComboBox();
    Component com=new Component(){
           @Override
           public void paint(Graphics g){
               for(int i=0;i<=300;i+=30){
                   g.drawLine(0, i, 600, i);
               }
               for(int i=0;i<=600;i+=100){
                   g.drawLine(i, 0, i, 600);
               }
               g.setColor(Color.MAGENTA);
               if(choice==1){
               for( q=0,t=0;q<600;t+=step,q+=0.5){
                   y=(VM/(Math.sqrt(Math.pow(R, 2)+Math.pow(W*L, 2))))*(Math.sin(Math.toRadians(W*t+Seta-Math.atan(Math.toRadians((W*L)/R)))))+(Math.exp(Math.toRadians(-t/Taw))*K);
                   g.drawLine((int)q, 150-(int)(F*y), (int)q, 150-(int)(F*y));
               }}
               else if(choice==2){
                   for( q=0,t=0;q<600;t+=step,q+=0.5){
                   y=(VM/(Math.sqrt(Math.pow(R, 2)+Math.pow(1/(W*C), 2))))*(Math.sin(Math.toRadians(W*t+Seta+Math.atan(Math.toRadians(1/(W*C*R))))))+(Math.exp(Math.toRadians(-t/Taw))*K);
                   g.drawLine((int)q, 150-(int)(F*y), (int)q, 150-(int)(F*y));
               }
               }
               else if(choice==3){
                   if(cond==0){
                   for(q=0,t=0;q<600;t+=step,q+=1){
                   y=((VM/Z)*(Math.sin(Math.toRadians(W*t+Seta-Fy))))+(A1*(Math.exp(Math.toRadians(Taw*t))))+(A2*(Math.exp(Math.toRadians(Taw1*t))));
                   g.drawLine((int)q, 150-(int)(F*y), (int)q, 150-(int)(F*y));
                       }
                   }else if(cond==1){
                   for(q=0,t=0;q<600;t+=step,q+=0.5){
                   y=((VM/Z)*Math.sin(Math.toRadians(W*t+Seta-Fy)))+A1*t*Math.exp(Math.toRadians(-Alfa*t))+A2*Math.exp(Math.toRadians(-Alfa*t));
                   g.drawLine((int)q, 150-(int)(F*y), (int)q, 150-(int)(F*y));
                   }}else{
                    for(q=0,t=0;q<600;t+=step,q+=0.5){
                   y=((VM/Z)*Math.sin(Math.toRadians(W*t+Seta-Fy)))+Math.exp(Math.toRadians(-Alfa*t))*((A1*Math.cos(Math.toRadians(Wd*t)))+(A2*Math.sin(Math.toRadians(Wd*t))));
                   g.drawLine((int)q, 150-(int)(F*y), (int)q, 150-(int)(F*y));}
                   }
               }
           }
           
       };
    JButton BtnShow=new JButton("SHOW");
    JLabel [] labs=new JLabel[32];
    JTextField textf=new JTextField();
    JTextField texts[][]=new JTextField[4][2];
    BoxLayout box1=new BoxLayout(p1,BoxLayout.Y_AXIS);
    URL img1=mainClass.class.getResource("rl.gif");
    ImageIcon icon1=new ImageIcon(img1);
    URL img2= mainClass.class.getResource("PowerRC.jpg");
    ImageIcon icon2=new ImageIcon(img2);
    URL img3=mainClass.class.getResource("images.png");
    ImageIcon icon3=new ImageIcon(img3);
    URL img4=mainClass.class.getResource("def.png");
    ImageIcon icon4=new ImageIcon(img4);
    @Override
    public void setTitle(String title) {
        super.setTitle(title); //To change body of generated methods, choose Tools | Templates.
    }
    
    mainClass(){
        setupGUI();
    }
    
 
        public void rangeD(double x){
            labs[11].setText(""+0);
            for(int i=12,y=200;i<17;i++,y+=200){
                labs[i].setText(""+x*y);
            }
        }
        public void rangeD2(double x){
          double y=x/5;
            for(int i=21;i>16;y+=x/5,i--){
                labs[i].setText(y+"");
            }
            y=x/5;
            for(int i=26;i>21;i--,y+=x/5){
                labs[i].setText(-y+"");
            }
        }
    public void setupGUI(){
        labs[0]=new JLabel("R");
        labs[1]=new JLabel("L");
        labs[2]=new JLabel("C");
        labs[3]=new JLabel("I0");
        labs[4]=new JLabel();
        labs[5]=new JLabel("       seta");
        labs[6]=new JLabel("        Abdelrhman Ahmed Khater");
        labs[7]=new JLabel("        Sobhi Elshaat Elknafany");
        labs[8]=new JLabel("        Mohamed Gnana");
        labs[9]=new JLabel("تحت اشراف د/عصام الدين رشاد   ");
        labs[10]=new JLabel();
        labs[27]=new JLabel("VM");
        labs[28]=new JLabel("V0");
        labs[29]=new JLabel();
        labs[30]=new JLabel();
        labs[31]=new JLabel();
        for(int j=0,n=125;j<3;n+=50,j++){
            texts[j][0]=new JTextField();
            texts[j][1]=new JTextField();
            texts[j][0].setBounds(30, n, 40, 20);
            texts[j][1].setBounds(80, n, 40, 20);
        }
        texts[3][0]=new JTextField();
        texts[3][0].setBounds(30,275,90,20);
        labs[0].setBounds(30, 100, 40, 20);
        labs[1].setBounds(80,100,40,20);
        labs[2].setBounds(30,150,40,20);
        labs[3].setBounds(80,150,40,20);
        labs[4].setBounds(30,350,150,30);
        labs[5].setBounds(30,250,90,20);
        labs[27].setBounds(30,200,40,20);;
        labs[28].setBounds(80,200,40,20);
        labs[29].setBounds(30,380,150,20);
        labs[30].setBounds(30,400,150,20);
        labs[31].setBounds(30,420,150,20);
        labs[4].setVisible(false);
        labs[29].setVisible(false);
        labs[30].setVisible(false);
        labs[31].setVisible(false);
        labs[9].setFont(font);
        com.setBounds(0, 0, 610, 301);
        labs[10].setBounds(270, 320, 500, 190);
        labs[10].setIcon(icon4);
        BtnShow.setBounds(30,300,90,20);
        main.setLayout(null);
        p1.setLayout(box1);
        p3.setLayout(null);
        p4.setLayout(null);
        p5.setLayout(null);
        p3.setBackground(c1);
        labs[6].setForeground(c2);
        labs[7].setForeground(c2);
        labs[8].setForeground(c2);
        p1.setBounds(10,446,200,50);
        p2.setBounds(10,520,600,30);
        p5.setBounds(10,10, 602, 301);
        p5.setBackground(c2);
        p2.setBackground(c3);
        p1.setBackground(Color.BLACK);
         for(int i=11,j=0;i<17;i++,j+=100){
            labs[i]=new JLabel("");
            labs[i].setBounds(j, 145, 100, 20);
            p5.add(labs[i]);
        }
         for(int i=17,j=-5;i<22;i++,j+=30){
             labs[i]=new JLabel("");
             labs[i].setBounds(0,j,50,20);
             p5.add(labs[i]);
         }
         for(int i=22,j=285;i<27;i++,j-=30){
             labs[i]=new JLabel("");
             labs[i].setBounds(0, j,53, 20);
             p5.add(labs[i]);
         }
        p5.add(com);
        p1.add(labs[6]);
        p1.add(labs[7]);
        p1.add(labs[8]);
        p2.add(labs[9]);
        p3.add(p5);
        p3.add(p1);
        p3.add(labs[10]);
        p3.add(p2);
        p4.setBackground(c1);
        BtnShow.setBackground(c3);
        BtnShow.addActionListener(this);
        for(int l=0;l<6;l++){
           p4.add(labs[l]);
           p4.add(texts[l/2][l%2]);
       }
        p4.add(texts[3][0]);
        for(int u=0;u<4;u++){
        combo.addItem(arrs[u]);
        }
        combo.setBounds(30,60,90,30);
        combo.setBackground(c2);
        combo.addItemListener(this);
        p4.add(combo);
        p4.add(BtnShow);
        p4.add(labs[27]);
        p4.add(labs[28]);
        p4.add(labs[29]);
        p4.add(labs[30]);
        p4.add(labs[31]);
        p3.setBounds(0,0, 620,600);
        p4.setBounds(621,0,200,600);
        main.setBackground(c1);
        main.add(p3);
        main.add(p4);
        add(main);
        setBounds(100, 100, 800, 600);
        setVisible(true);
        setTitle("ACcircuit");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        labs[4].setVisible(false);
        labs[29].setVisible(false);
        labs[30].setVisible(false);
        labs[31].setVisible(false);
        try{
        Object s=e.getSource();
        if(s==BtnShow){
            if(choice !=0){
            R=Double.parseDouble(texts[0][0].getText());
            Seta=Double.parseDouble(texts[3][0].getText());
            VM=Double.parseDouble(texts[2][0].getText());
                    if(choice==1){
                        W=12000;
                        L=Double.parseDouble(texts[0][1].getText());
                        I=Double.parseDouble(texts[1][1].getText());
                        K=I-Math.sin(Math.toRadians(Seta-Math.atan(Math.toRadians((W*L)/R))));
                        max=(VM/(Math.sqrt(Math.pow(R, 2)+Math.pow(W*L, 2))))+Math.abs(K);
                        Taw=L/R;
                        step=Taw;
                        F=150/max;
                        rangeD(Taw);
                        rangeD2(max);
                        com.repaint();
                    }else if(choice==2){
                        W=1000;
                        C=Double.parseDouble(texts[1][0].getText());
                        V=Double.parseDouble(texts[2][1].getText());
                        K=V-Math.sin(Math.toRadians(Seta+Math.atan(Math.toRadians(1/(W*C*R)))));
                        max=(VM/(Math.sqrt(Math.pow(R, 2)+Math.pow(1/(W*C), 2))))+Math.abs(K);
                        Taw=R*C;
                        step=Taw;
                        F=150/max;
                        rangeD2(max);
                        rangeD(Taw);
                        com.repaint();
                    }else {
                         L=Double.parseDouble(texts[0][1].getText());
                         C=Double.parseDouble(texts[1][0].getText());
                         I=Double.parseDouble(texts[1][1].getText());
                         V=Double.parseDouble(texts[2][1].getText());
                         W=12000;
                         Alfa=R/(2*L);
                         Fy=Math.atan(Math.toRadians((W*L-(1/(W*C))))/(R));
                         Z=Math.sqrt(R*R+Math.pow(W*L-(1/(W*C)),2));
                         W0=1/(Math.sqrt(L*C));
                         if(Alfa>W0){
                              cond=0;
                              W=7000;
                              Taw=-Alfa+Math.sqrt((Alfa*Alfa)-(W0*W0));
                              Taw1=-Alfa-Math.sqrt((Alfa*Alfa)-(W0*W0));
                              first=(V/L)-((VM/Z)*W*Math.cos(Math.toRadians(Seta-Fy)))-I+((VM/Z)*Math.sin(Math.toRadians(Seta-Fy)));
                              second=((Taw1/Taw)-1);
                              A2=first/second;
                              A1=I-((VM/Z)*Math.sin(Math.toRadians(Seta-Fy)))-A2;
                              max=Math.abs(A1)+Math.abs(A2)+(VM/Z);
                              step=(-1/Taw)/2;
                              F=150/max;
                              rangeD2(max);
                              rangeD((-1/Taw)/4);
                              com.repaint();
                              labs[4].setText("W0 = "+W0);
                              labs[29].setText("Alfa = "+Alfa);
                              labs[30].setText("Over damping");
                              labs[4].setVisible(true);
                              labs[29].setVisible(true);
                              labs[30].setVisible(true);
                         }else if(Alfa==W0){
                             cond=1;
                             W=314;
                             A2=I-((VM/Z)*Math.sin(Math.toRadians(Seta-Fy)));
                             A1=(Alfa*A2)-((VM/Z)*W*Math.cos(Math.toRadians(Seta-Fy)))+(V/L);
                             max=25*(1/Alfa)*Math.abs(A1)+Math.abs(A2)+(VM/Z);
                             step=(1/Alfa);
                             F=150/max;
                             rangeD2(max);
                             rangeD((1/Alfa));
                             com.repaint();
                             labs[30].setText("Critical damping");
                             labs[30].setVisible(true);
                         }else{
                             cond=2;
                             Wd=Math.sqrt((W0*W0)-(Alfa*Alfa));
                             A1=I-((VM/Z)*Math.sin(Math.toRadians(Seta-Fy)));
                             A2=((V/L)+(Alfa*A1)-((VM/Z)*W*Math.cos(Math.toRadians(Seta-Fy))))/Wd;
                             max=Math.abs(A1)+Math.abs(A2)+(VM/Z);
                             step=1/Alfa;
                             F=150/max;
                             rangeD2(max);
                             rangeD(1/Alfa);
                             com.repaint();
                             labs[30].setText("Under damping");
                             labs[31].setText("Wd = "+Wd);
                             labs[30].setVisible(true);
                             labs[31].setVisible(true);
                         }
                             labs[4].setText("W0 = "+W0);
                             labs[29].setText("Alfa = "+Alfa);
                             labs[4].setVisible(true);
                             labs[29].setVisible(true);
                    }
        }else{
            JOptionPane.showMessageDialog(null, "Please insert type of circuit");
        }}}
        catch(Exception b){
            JOptionPane.showMessageDialog(null, "Error "+b.getMessage());
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        choice=(byte)combo.getSelectedIndex();
        labs[4].setVisible(false);
        labs[29].setVisible(false);
        labs[30].setVisible(false);
        labs[31].setVisible(false);
        switch(choice){
            case 0:
                labs[10].setIcon(icon4);
                break;
            case 1:
                labs[10].setIcon(icon1);
                break;
            case 2:
                labs[10].setIcon(icon2);
                break;
            default:
                labs[10].setIcon(icon3);
        }
        
    }
   static mainClass a=new mainClass();
}


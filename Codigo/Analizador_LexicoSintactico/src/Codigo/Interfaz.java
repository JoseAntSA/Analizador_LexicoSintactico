/*
- SÁNCHEZ ALANIS JOSÉ ANTONIO
*/

package Codigo;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;
import java.util.logging.*;
import java_cup.runtime.Symbol;

public class Interfaz extends JFrame{
	
    //Atributos
    private JPanel pnl1;
    private JLabel etqArc, etqTi1, etqTi2, etqSep, etqSep2, etqSep3;
    private JLabel etqIcono, etqPro1, etqPro2, etqMat1, etqMat2;
    private JLabel etqEsc1, etqEsc2, etqEqu1, etqEqu2, etqEqu3, etqEqu4, etqEqu5, etqNot;
    private JTextField txtArc;
    private JButton btnAnalizar;
    private ImageIcon img1, img2, img3, img4, img5, img6; 
    private TextPrompt txtTempArc;
    private JTextArea area1, area2;
    private JScrollPane barraNav1;

    public Interfaz(){
            setTitle("Analizador Lexico-Sintactico");
            setSize(1050,690);
            setResizable(false);
            setLocationRelativeTo(null);
            initComponents();
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
    }//constructor
    
    public void initComponents(){
        
         //----------------------------------------- CODIGO COLORES-FUENTES
        Color colorFondo = new Color(62,68,82);
        Color colorLetra = new Color(217,168,0);
        Color colorArea = new Color(205,205,205);
        Font letraRes = new Font( "Arial", 0, 14 );
        Font letraTxt = new Font( "Arial", 1, 14 );
        Font letraTxt2 = new Font( "Arial", 2, 14 );
        Font letraTit1 = new Font( "Arial Black", 0, 26 );
        Font letraTit2 = new Font( "Arial Black", 0, 20 );
        
        //----------------------------------------- CODIGO IMAGENES
        img1 = new ImageIcon(this.getClass().getResource("/Codigo/Imagenes/btnAnalizar.png"));
        img2 = new ImageIcon(this.getClass().getResource("/Codigo/Imagenes/btnAnalizar2.png"));
        img3 = new ImageIcon(this.getClass().getResource("/Codigo/Imagenes/Icono.png"));
        img4 = new ImageIcon(this.getClass().getResource("/Codigo/Imagenes/Icono2.png"));
        img5 = new ImageIcon(this.getClass().getResource("/Codigo/Imagenes/Icono3.png"));
        img6 = new ImageIcon();
        
        //----------------------------------------- CODIGO PANELES
        pnl1 = new JPanel();
        this.getContentPane().add(pnl1);
        pnl1.setBackground(colorFondo);
        pnl1.setLayout(null);
        
        //----------------------------------------- CODIGO ETIQUETAS
        etqTi1 = new JLabel("Python");
	etqTi1.setBounds(320,30,100,35);
        etqTi1.setOpaque(true);
        etqTi1.setBackground(colorFondo);
        etqTi1.setForeground(colorLetra);
        etqTi1.setFont( letraTit1 );
        pnl1.add(etqTi1);
        
        etqTi2 = new JLabel("Analizador Lexico-Sintactico");
	etqTi2.setBounds(320,60,340,30);
        etqTi2.setOpaque(true);
        etqTi2.setBackground(colorFondo);
        etqTi2.setForeground(Color.WHITE);
        etqTi2.setFont( letraTit2 );
        pnl1.add(etqTi2);
        
        etqSep = new JLabel();
	etqSep.setBounds(320,95,675,4);
        etqSep.setBorder(BorderFactory.createLineBorder(colorLetra));
        etqSep.setOpaque(true);
        etqSep.setBackground(colorLetra);
        pnl1.add(etqSep);
    
        etqArc = new JLabel("ARCHIVO");
	etqArc.setBounds(320,130,75,20);
        etqArc.setOpaque(true);
        etqArc.setBackground(colorFondo);
        etqArc.setForeground(Color.WHITE);
        etqArc.setFont( letraTxt );
        pnl1.add(etqArc);

        etqSep2 = new JLabel();
	etqSep2.setBounds(320,175,450,2);
        etqSep2.setBorder(BorderFactory.createLineBorder(colorLetra));
        etqSep2.setOpaque(true);
        etqSep2.setBackground(colorLetra);
        pnl1.add(etqSep2);
        
        etqIcono = new JLabel();
	etqIcono.setBounds(80,40,160,160);
        etqIcono.setIcon( imgEscala(img3, etqIcono) ); 
        pnl1.add(etqIcono);
        
        etqPro1 = new JLabel("PROFESOR");
	etqPro1.setBounds(55,277,85,20);
        etqPro1.setOpaque(true);
        etqPro1.setBackground(colorFondo);
        etqPro1.setForeground(Color.WHITE);
        etqPro1.setFont( letraTxt );
        pnl1.add(etqPro1);

        etqPro2 = new JLabel("Ing. Alejandro Quintero García");
	etqPro2.setBounds(55,297,250,20);
        etqPro2.setOpaque(true);
        etqPro2.setBackground(colorFondo);
        etqPro2.setForeground(colorLetra);
        etqPro2.setFont( letraTxt );
        pnl1.add(etqPro2);

        
        etqMat1 = new JLabel("U. ACADEMICA");
	etqMat1.setBounds(55,345,130,20);
        etqMat1.setOpaque(true);
        etqMat1.setBackground(colorFondo);
        etqMat1.setForeground(Color.WHITE);
        etqMat1.setFont( letraTxt );
        pnl1.add(etqMat1);
        
        etqMat2 = new JLabel("Compiladores");
	etqMat2.setBounds(55,365,130,20);
        etqMat2.setOpaque(true);
        etqMat2.setBackground(colorFondo);
        etqMat2.setForeground(colorLetra);
        etqMat2.setFont( letraTxt );
        pnl1.add(etqMat2);
        
        etqEqu1 = new JLabel("ELABORADO POR");
	etqEqu1.setBounds(55,412,140,20);
        etqEqu1.setOpaque(true);
        etqEqu1.setBackground(colorFondo);
        etqEqu1.setForeground(Color.WHITE);
        etqEqu1.setFont( letraTxt );
        pnl1.add(etqEqu1);
        
        etqEqu2 = new JLabel("Sánchez Alanis José Antonio");
	etqEqu2.setBounds(55,432,250,20); //usar  num*85/8
        etqEqu2.setOpaque(true);
        etqEqu2.setBackground(colorFondo);
        etqEqu2.setForeground(colorLetra);
        etqEqu2.setFont( letraTxt );
        pnl1.add(etqEqu2);
        
        etqEsc1 = new JLabel("UNIVERSIDAD");
	etqEsc1.setBounds(55,479,120,20);
        etqEsc1.setOpaque(true);
        etqEsc1.setBackground(colorFondo);
        etqEsc1.setForeground(Color.WHITE);
        etqEsc1.setFont( letraTxt );
        pnl1.add(etqEsc1);
        
        etqEsc2 = new JLabel("CU UAEM Zumpango");
	etqEsc2.setBounds(55,499,170,20);
        etqEsc2.setOpaque(true);
        etqEsc2.setBackground(colorFondo);
        etqEsc2.setForeground(colorLetra);
        etqEsc2.setFont( letraTxt );
        pnl1.add(etqEsc2);
        
        etqNot = new JLabel( "", SwingConstants.CENTER);
	etqNot.setBounds(320,185,450,20);
        etqNot.setBorder(BorderFactory.createLineBorder(colorFondo));
        etqNot.setOpaque(true);
        etqNot.setBackground(colorFondo);
        etqNot.setForeground(colorArea);
        etqNot.setFont( letraTxt2 );
        pnl1.add(etqNot);
        
        etqSep3 = new JLabel();
	etqSep3.setBounds(320,225,675,4);
        etqSep3.setBorder(BorderFactory.createLineBorder(colorLetra));
        etqSep3.setOpaque(true);
        etqSep3.setBackground(colorLetra);
        pnl1.add(etqSep3);
        
        //----------------------------------------- CODIGO CAJAS TEXTO
        txtArc = new JTextField();
        txtArc.setBounds(320,150,450,20);
        txtArc.setBorder(BorderFactory.createLineBorder(colorFondo));
        txtArc.setForeground(colorLetra);
        txtArc.setBackground(colorFondo);
        txtArc.setFont( letraTxt );
        txtTempArc = new TextPrompt("Ejemplo: C:/Documents/Newsletters/Summer2018.py", txtArc);
    	txtTempArc.changeStyle(Font.ITALIC);
    	txtTempArc.setForeground(colorLetra);
        pnl1.add(txtArc);
        
        //----------------------------------------- CODIGO BOTON BUSCAR
        btnAnalizar = new JButton();
        btnAnalizar.setBounds(800,135,200,46);
        btnAnalizar.setBackground(colorFondo);
        btnAnalizar.setBorder(BorderFactory.createLineBorder(colorFondo));
        btnAnalizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        
        btnAnalizar.setIcon( imgEscala(img1, btnAnalizar) );        
        btnAnalizar.setPressedIcon( imgEscala(img2, btnAnalizar) );
        btnAnalizar.setRolloverIcon( imgEscala(img1, btnAnalizar) );
        btnAnalizar.setContentAreaFilled(false);
        
        EventoBoton evtBtn = new EventoBoton();
        btnAnalizar.addActionListener(evtBtn);
        
        pnl1.add(btnAnalizar);
        
        //----------------------------------------- CODIGO CAJAS AREATEXTO
        area1 = new JTextArea ();
        area1.setLineWrap(false);
        area1.setWrapStyleWord(true);
        area1.setBackground(colorArea);
        area1.setBorder(BorderFactory.createLineBorder(colorArea));
        area1.setEditable(false);
        barraNav1 = new JScrollPane(area1);
        barraNav1.setBounds(320,240,675,300);
        pnl1.add(barraNav1);
        
        area2 = new JTextArea ();
        area2.setBounds(320,560,675,55);
        area2.setLineWrap(false);
        area2.setWrapStyleWord(true);
        area2.setBackground(colorArea);
        area2.setFont( letraRes );
        area2.setBorder(BorderFactory.createLineBorder(colorArea));
        area2.setEditable(false);
        pnl1.add(area2);
    }	
    
    public ImageIcon imgEscala(ImageIcon img, javax.swing.JComponent comp){
        return new ImageIcon(img.getImage().getScaledInstance( comp.getWidth(), comp.getHeight(), Image.SCALE_SMOOTH ));
    }
    public ImageIcon imgEscalaCuad(ImageIcon img, javax.swing.JComponent comp){
        return new ImageIcon(img.getImage().getScaledInstance( comp.getHeight(), comp.getHeight(), Image.SCALE_SMOOTH ));
    }
    
    //--------------------------------------------- CODIGO EVENTO BOTON REGRESAR
 	public class EventoBoton implements ActionListener{

            public void actionPerformed(ActionEvent ev){

                if("".equals(txtArc.getText())){
                    etqNot.setText("No se recibido una direccion");
                    etqNot.setIcon( imgEscalaCuad(img5, etqNot) );
                    area1.setText("");
                    area2.setText("");
                }
                else{
                    File arch = new File(txtArc.getText().replaceAll("\\s*$",""));
                    String nombre = arch.getName();
                    if(!arch.exists()){
                        etqNot.setText("Direccion de archivo no valida.");
                        etqNot.setIcon( imgEscalaCuad(img4, etqNot) );
                        area1.setText("");
                        area2.setText("");
                    }
                    else{
                        if(!nombre.endsWith(".py")){
                            etqNot.setText(nombre + " no es un archivo Python de extension .py");
                            etqNot.setIcon( imgEscalaCuad(img4, etqNot) );
                            area1.setText("");
                            area2.setText("");
                            }
                        else{              
                            etqNot.setText("");
                            etqNot.setIcon(img6);
                            try {
                                FileReader archivo = new FileReader(arch);
                                BufferedReader lector = new BufferedReader(archivo);
                               
                                Lexer lexer = new Lexer(lector);
                                String resultado = "\n\tLinea\t\tToken\t\t\tLexema\n";
                                resultado += "     ----------------------------------------------------------------------------";
                                resultado += "--------------------------------------------------------------------------------\n";
                                while (true) {
                                    Tokens tokens = lexer.yylex();
                                    if (tokens == null) {
                                        resultado += "     ----------------------------------------------------------------------------";
                                        resultado += "--------------------------------------------------------------------------------\n";
                                        resultado += "\tFINAL DEL ARCHIVO\n";
                                        area1.setText(resultado);
                                        lector.close();
                                        break;
                                    }
                                    switch (tokens) {
                                        case ERROR:
                                            resultado += "\tLinea " + lexer.linea + "\t\t"+ tokens + "\t\t\t'" + lexer.lexeme + "' Simbolo no definido\n";
                                            break;
                                        case OPER_ARITMETICO:
                                        case OPER_RELACIONAL:
                                        case OPER_ASIGNACION:
                                        case IDENTIFICADOR:
                                            resultado += "\tLinea " + lexer.linea + "\t\t" + tokens + "\t\t'" + lexer.lexeme + "'\n";
                                            break;
                                        case OPER_LOGICO:
                                        case OPER_BOOL:
                                        case NUM_ENTERO:
                                        case OPERADOR:
                                        case RESERVADA:
                                        case VARIABLE:
                                        case TABULACION:
                                        case STRING:
                                        case NUM_IMAG:
                                        case NUM_FLOAT:
                                            resultado += "\tLinea " + lexer.linea + "\t\t" + tokens + "\t\t\t'" + lexer.lexeme + "'\n";
                                            break;
                                        case SALTO_LINEA:    
                                            resultado += "\tLinea " + lexer.linea + "\t\t" + tokens + "\t\t\t'\\n'\n";
                                            break;
                                        default:
                                            resultado += "\tLinea " + lexer.linea + "\t\t" + "Token: " + tokens + "\n";
                                            break;
                                    }
                                }
                            }catch (FileNotFoundException ex) {
                                Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
                            }catch (IOException ex) {
                                Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                            String cad="";
                            try{
                                cad = new String(Files.readAllBytes(arch.toPath()));
                            }catch (FileNotFoundException ex) {
                                Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
                            }catch (IOException ex) {
                                Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                            Sintax s = new Sintax(new Codigo.LexerCup(new StringReader(cad)));
        
                            try {
                                s.parse();
                                area2.setText("\n     Analisis realizado correctamente");
                                area2.setForeground(new Color(25, 111, 61));
                            } catch (Exception ex) {
                                Symbol sym = s.getS();
                                area2.setText("\n     SyntaxError:  Linea: " + (sym.right + 1) + ",  Texto: \"  " + sym.value + "  \"\n");
                                area2.setForeground(Color.RED);
                            }
                            return;
                        }
                    }
                }
            }//evento
	}//clase interna
    
}//main

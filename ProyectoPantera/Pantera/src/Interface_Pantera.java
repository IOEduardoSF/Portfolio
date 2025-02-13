import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Interface_Pantera extends JFrame {
    private JButton fileButton;
    private JButton anaButton;
    private JButton clearButton;
    private JButton resultsButton;
    private JTextArea fileArea;
    private JTextArea resultArea;
    private JPanel panelMain;

    public Interface_Pantera() {
        setContentPane(panelMain);
        setTitle("Lenguaje Pantera");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setVisible(true);

        /*Accion al presionar el boton de Seleccionar Archivos*/
        fileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser(new File("./Code_Examples"));
                chooser.showOpenDialog(null);
                File file = chooser.getSelectedFile();
                try {
                    FileReader reader = new FileReader(file);
                    BufferedReader br = new BufferedReader(reader);
                    fileArea.read(br, null);
                    br.close();
                    fileArea.requestFocus();

                } catch (Exception exception) {
                    System.err.println("error" + exception);
                }
            }
        });


        /*Accion al presionar el boton de Analizar Texto*/
        anaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser(new File("./Code_Examples"));
                chooser.showOpenDialog(null);
                File file2 = chooser.getSelectedFile();
                String dest = "Code_Examples/resultados.pantera";

                try{
                    CharStream cs = CharStreams.fromFileName(file2.getAbsolutePath());
                    PanteraLexer Lexer = new PanteraLexer(cs);
                    CommonTokenStream token = new CommonTokenStream(Lexer);
                    PanteraParser parser = new PanteraParser(token);
                    ParseTree tree = parser.program();
                    MyVisitor visitor = new MyVisitor();

                    FileWriter writer = new FileWriter(dest);

                    for (int i = 0; i < tree.getChildCount(); i++){
                        String data = String.valueOf(visitor.visit(tree.getChild(i)));
                        writer.write(data + "\n");
                    }
                    writer.close();
                    JOptionPane.showMessageDialog(Interface_Pantera.this,"Análisis completo");


                }catch (Exception exception){
                    System.err.println(exception);
                }

            }
        });

        /*Accion al presionar el boton de Limpiar*/
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileArea.setText("");
                resultArea.setText("");
            }
        });

        resultsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser(new File("./Code_Examples"));
                chooser.showOpenDialog(null);
                File file = chooser.getSelectedFile();
                try {
                    FileReader reader = new FileReader(file);
                    BufferedReader br = new BufferedReader(reader);
                    resultArea.read(br, null);
                    br.close();
                    resultArea.requestFocus();

                } catch (Exception exception) {
                    System.err.println("error" + exception);
                }
            }
        });
















    }
}

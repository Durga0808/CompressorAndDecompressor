package GUI;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import Compress_Decompress.Compressor;
import Compress_Decompress.Decompressor;
public class Appframe extends JFrame implements ActionListener {
    JButton compressButton;
    JButton decompressButton;

    Appframe(){
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        compressButton=new JButton("Select File to Compress");
        compressButton.setBounds(30, 100, 200, 40);
        compressButton.setBackground(Color.LIGHT_GRAY);
        compressButton.addActionListener( this);

        decompressButton=new JButton("Select File to Decompress");
        decompressButton.setBounds(300, 100, 200, 40);
        decompressButton.setBackground(Color.GREEN);
        decompressButton.addActionListener(this);

        this.add(compressButton);
        this.add(decompressButton);
        this.setSize(600, 500);
        this.getContentPane().setBackground(Color.RED);
        this.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==compressButton){
            JFileChooser filechooser=new JFileChooser();
            int responce=filechooser.showSaveDialog(null);
            if(responce==JFileChooser.APPROVE_OPTION){
                File file=new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try {
                    Compressor.method(file);
                } catch (Exception ee) {

                    JOptionPane.showMessageDialog(null,e.toString());
                }
            }

        }


        if(e.getSource()==decompressButton){
            JFileChooser filechooser=new JFileChooser();
            int responce=filechooser.showSaveDialog(null);
            if(responce==JFileChooser.APPROVE_OPTION){
                File file=new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try {
                    Decompressor.method(file);
                } catch (Exception ee) {

                    JOptionPane.showMessageDialog(null,e.toString());
                }
            }
        }
    }
}

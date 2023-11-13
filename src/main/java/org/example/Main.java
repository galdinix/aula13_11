package org.example;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Exemplo cores");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);

        JLabel label = new JLabel();
        frame.add(label);

        JPanel panel = new JPanel();
        frame.add(panel);
        frame.setLayout(new FlowLayout());
        final JPanel contentPanel = (JPanel)frame.getContentPane();
        frame.setVisible(true);
        try{
            while(true) {
                String path = "https://testeinfnet.000webhostapp.com/conteudo.txt";
                Document doc = Jsoup.connect(path).get();
                System.out.println(doc);
                String corSelecionada = doc.toString();
                System.out.println(corSelecionada);

                if(corSelecionada.indexOf("2") !=-1){
                    contentPanel.setBackground(Color.red);

                }
                else if(corSelecionada.indexOf("1") != -1){
                    contentPanel.setBackground(Color.yellow);

                }
                else if(corSelecionada.indexOf("0") !=-1){
                    contentPanel.setBackground(Color.GREEN);

                }
                Thread.sleep(2000);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatConnect {
    private JFrame frame;
    private JTextField loginField;
    private JTextField ipAddressField;
    private JTextField portField;
    private JButton connectButton;
    private JPanel topPanel;
    private JPanel fullPanel;
    private JLabel userName;
    private JLabel pass;
    private JLabel ip;
    private LogFile logFile;
    private ChatClientApp chatClientApp;


    public ChatConnect() {
        logFile = new LogFile();
        frame = new JFrame("Chat Client");
        fullPanel = new JPanel(new GridLayout(2, 1, 1,50));
        frame.add(fullPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 400);


        topPanel = new JPanel(new GridLayout(6, 1, 1,10));
        userName = new JLabel("Your Username:");
        loginField = new JTextField();
        pass = new JLabel("Password:");
        ipAddressField = new JTextField();
        ip = new JLabel("Port:");
        portField = new JTextField();
        connectButton = new JButton("Connect");
        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chatClientApp = new ChatClientApp();
                for (String st: logFile.readLog()) {
                    chatClientApp.setChatArea(st);
                }
               frame.setVisible(false);
            }
        });
        topPanel.add(userName);
        topPanel.add(loginField);
        topPanel.add(pass);
        topPanel.add(ipAddressField);
        topPanel.add(ip);
        topPanel.add(portField);

        fullPanel.add(topPanel );
        fullPanel.add(connectButton);

        frame.setVisible(true);

    }
}

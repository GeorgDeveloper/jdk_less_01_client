import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ChatClientApp {
    private JFrame frame;
    private JTextArea chatArea;
    private JTextField messageField;
    private JButton sendButton;
    private  JPanel chatPanel;
    private JPanel bottomPanel;
    private final Calendar calendar = new GregorianCalendar();
    SimpleDateFormat  dateTimeFormatter;
    private LogFile logFile = new LogFile();

    public void setChatArea(String chatText) {
        chatArea.append(chatText);
    }

    public ChatClientApp() {
        frame = new JFrame("Chat Client");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        chatPanel = new JPanel(new BorderLayout());
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatPanel.add(new JScrollPane(chatArea), BorderLayout.CENTER);

        bottomPanel = new JPanel(new BorderLayout());
        messageField = new JTextField();
        messageField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chatArea.append(dateTimeFormatter.format(calendar.getTime()) + ": " + messageField.getText() + "\n");
                logFile.writeLog(chatArea.getText());
            }
        });
        sendButton = new JButton("Send");
        dateTimeFormatter =new SimpleDateFormat("yy/MM/dd hh:mm:ss");
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chatArea.append(dateTimeFormatter.format(calendar.getTime()) + ": " + messageField.getText() + "\n");
                logFile.writeLog(chatArea.getText());
            }
        });
        bottomPanel.add(messageField, BorderLayout.CENTER);
        bottomPanel.add(sendButton, BorderLayout.EAST);


        frame.add(chatPanel, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

}

package by.bsuir.aiprp.client;

import by.bsuir.aiprp.ws.MyAwesomeWebService;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ServiceClient extends JFrame implements ActionListener {
    private static List<Object> fileNames;
    private static int previousLine = 0;
    private static final TextArea txa = new TextArea();

    public ServiceClient() {
        super("my window");
        JPanel contents = new JPanel();
        final JList<Object> files = new JList<>(getFileNames());
        files.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        files.addListSelectionListener(new listSelectionListener());
        txa.setBounds(20, 50, 300, 300);
        contents.add(new JScrollPane(files));
        contents.add(txa);
        setContentPane(contents);
        setSize(600, 300);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    static class listSelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            if (e.getValueIsAdjusting()) {
                if (e.getFirstIndex() == previousLine) {
                    previousLine = e.getLastIndex();
                } else {
                    previousLine = e.getFirstIndex();
                }
                String text = getFileText((String) fileNames.get(previousLine));
                txa.setText(text);
            }
        }
    }

    public static void main(String[] args) {
        new ServiceClient();
    }

    public static Object[] getFileNames() {
        fileNames = new ArrayList<>();
        try {
            URL url = new URL("http://localhost:8080/wss/hello?wsdl");
            QName qname = new QName("http://ws.aiprp.bsuir.by/", "WebServiceImplService");
            Service service = Service.create(url, qname);
            MyAwesomeWebService hello = service.getPort(MyAwesomeWebService.class);
            fileNames.addAll(Arrays.asList(hello.getFiles()));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return fileNames.toArray();
    }

    public static String getFileText(String fileName) {
        String text = "";
        try {
            URL url = new URL("http://localhost:1986/wss/hello?wsdl");
            QName qname = new QName("http://ws.aiprp.bsuir.by/", "WebServiceImplService");
            Service service = Service.create(url, qname);
            MyAwesomeWebService hello = service.getPort(MyAwesomeWebService.class);
            text = hello.getText(fileName);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return text;
    }
}

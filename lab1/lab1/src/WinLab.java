import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.URL;
import java.net.URI;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class WinLab extends Frame implements ActionListener {
    private final Button exitBtn = new Button("Exit");
    private final Button searchBtn = new Button("Search");
    private final TextArea textArea = new TextArea();

    public WinLab() {
        super("my window");
        setLayout(null);
        setBackground(new Color(191,213,226));
        setSize(1024, 768);
        add(exitBtn);
        add(searchBtn);
        add(textArea);
        exitBtn.setBounds(400,700,200,30);
        exitBtn.setBackground(new Color(178,171,191));
        exitBtn.setForeground(new Color(0,0,0));
        exitBtn.addActionListener(this);
        searchBtn.setBounds(110,700,200,30);
        searchBtn.setBackground(new Color(178,171,191));
        searchBtn.setForeground(new Color(0,0,0));
        searchBtn.addActionListener(this);
        textArea.setBounds(20, 50, 800, 600);

        this.show();
        this.setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == exitBtn) {
            System.exit(0);
        } else if (actionEvent.getSource() == searchBtn) {
            String[] keywords = textArea.getText().split(",");
            for (String keyword : keywords) {
                System.out.println(keyword);
            }
            File f = new File("D:\\СПО и АИПР\\АиПРП\\lab1\\lab1\\resources\\files");
            ArrayList<File> files = new ArrayList<>(Arrays.asList(Objects.requireNonNull(f.listFiles())));

            textArea.setText("");
            int maxCountOfKeys = 0;
            File openedFile = null;
            for (File elem : files) {

                int countOfKeys = searchCount(elem, keywords);
                if (maxCountOfKeys < countOfKeys) {
                    maxCountOfKeys = countOfKeys;
                    openedFile = elem;
                }
                textArea.append("\n" + elem + "  :" + countOfKeys);
            }
            if (openedFile != null) {
                // try {
                //     Desktop.getDesktop().open(openedFile);
                // } catch (IOException e) {
                //     e.printStackTrace();
                // }
                oprnBrowser(openedFile.toURI());
            }
        }
    }
    private void oprnBrowser(URI  args) {
        String url = args.toString();

        String browser = "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe";

        ProcessBuilder pb = new ProcessBuilder(browser, url);
        
        Process p;
        try {
            p = pb.start();
            p.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public static int searchCount(File curFile, String[] keywords) {
        int count = 0;
        int i;
        try {
            URL url = new URL("file:/" + curFile);

            URLConnection connection = url.openConnection();
            BufferedInputStream inputStream = new BufferedInputStream(connection.getInputStream());
            StringBuilder builder = new StringBuilder(); //file content in byte array
            while ((i = inputStream.read()) != -1) {
                builder.append((char) i);
            }
            inputStream.close();
            String htmlContent = (builder.toString()).toLowerCase();
            System.out.println("New url content is: " + htmlContent);
            do {
                for (String keyword : keywords) {
                    if (htmlContent.contains(keyword.trim().toLowerCase())) {
                        int position = htmlContent.indexOf(keyword.trim().toLowerCase());
                        htmlContent = htmlContent.substring(position + keyword.length());
                        count++;
                    }
                }

            } while (htmlContent.contains(keywords[0].trim().toLowerCase()));
        } catch (Exception malformedInputException) {
            System.out.println("error " + malformedInputException.getMessage());
            return -1;
        }
        return count;
    }


    public static void main(String[] args) {

        new WinLab();
        
    }

}
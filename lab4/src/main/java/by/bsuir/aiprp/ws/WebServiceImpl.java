package by.bsuir.aiprp.ws;

import javax.jws.WebService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebService(endpointInterface = "by.bsuir.aiprp.ws.MyAwesomeWebService")
public class WebServiceImpl implements MyAwesomeWebService {
    @Override
    public Object[] getFiles() {
        List<String> files = new ArrayList<>();
        try {
            File f = new File("./src/main/resources");
            for (File file : f.listFiles()) {
                files.add(file.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return files.toArray();
    }

    @Override
    public String getText(String fileName) {
        String line;
        StringBuilder lines = new StringBuilder();
        File inputFile = new File("./src/main/resources/" + fileName);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile))) {
            while ((line = bufferedReader.readLine()) != null) {
                lines.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines.toString();
    }
}

package by.bsuir.aiprp.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface MyAwesomeWebService {
    @WebMethod
    Object[] getFiles();

    @WebMethod
    String getText(String fileName);
}
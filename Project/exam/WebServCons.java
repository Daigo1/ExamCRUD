package exam;
 
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;
 
class CalculadoraClient {
 
  public static void main(String args[]) throws Exception {
    URL url = new URL("http://127.0.0.1:3306/exam?wsdl");
    QName qname = new QName("http://exam/","ExameServerImplService");
    Service ws = Service.create(url, qname);
    ExameServer Exame = ws.getPort(ExameServer.class);
  }
}
package exam;
 
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
 
@WebService
@SOAPBinding(style = Style.RPC)
public interface ExameServer {
  @WebMethod int registerExam(String exame, String candidato, Date data);
  @WebMethod int updateExamDetails(String exame, String candidato, Date data, String candidatonovo);
  @WebMethod int deleteExamDetails(String candidato)
}
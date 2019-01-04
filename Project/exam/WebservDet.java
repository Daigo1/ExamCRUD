package exam;
 
import java.util.Date;
import javax.jws.WebService;
 
@WebService(endpointInterface = "exam.ExameServer")
public class ExamServerImpl implements ExameServer {

    public int registerExam(String exame, String candidato, Date data) throws Exception {
    int i = 0;
    try {
      String sql = "INSERT INTO STRUTS2CRUD VALUES (?,?,?)";
      PreparedStatement ps = getConnection().prepareStatement(sql);
      ps.setString(1, exame);
      ps.setString(2, candidato);
      ps.setDate(3, data);
      i = ps.executeUpdate();
      return i;
    } catch (Exception e) {
      e.printStackTrace();
      return i;
    } finally {
      if (getConnection() != null) {
        getConnection().close();
      }
    }
  }


  public int updateExamDetails(String exame, String candidato, Date data, String candidatonovo)
      throws SQLException, Exception {
    getConnection().setAutoCommit(false);
    int i = 0;
    try {
      String sql = "UPDATE EXAMES SET EXAME=?,CANDIDATO=?,DATA=? WHERE CANDIDATO=?";
      PreparedStatement ps = getConnection().prepareStatement(sql);
      ps.setString(1, exame);
      ps.setString(2, candidato);
      ps.setString(3, data);
      ps.setString(5, candidatonovo);
      i = ps.executeUpdate();
      return i;
    } catch (Exception e) {
      e.printStackTrace();
      getConnection().rollback();
      return 0;
    } finally {
      if (getConnection() != null) {
        getConnection().close();
      }
    }
  }

     
    public int deleteExamDetails(String candidato) throws SQLException, Exception {
    getConnection().setAutoCommit(false);
    int i = 0;
    try {
      String sql = "DELETE FROM EXAMES WHERE CANDIDATO=?";
      PreparedStatement ps = getConnection().prepareStatement(sql);
      ps.setString(1, candidato);
      i = ps.executeUpdate();
      return i;
    } catch (Exception e) {
      e.printStackTrace();
      getConnection().rollback();
      return 0;
    } finally {
      if (getConnection() != null) {
        getConnection().close();
      }
    }
  }
 
}
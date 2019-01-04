package org.exame.acoes;

import java.sql.ResultSet;
import java.util.Date;
import org.exame.dao.Admin;

import com.opensymphony.xwork2.ActionSupport;

public class UpdateAction extends ActionSupport {

	private static final long serialVersionUID = -687991492884005033L;
	private String exame = "", candidato = "", candidatonovo = "";
	private Date data;
	private String msg = "";
	ResultSet rs = null;
	Admin dao = new Admin();
	String submitType;

	@Override
	public String execute() throws Exception {
		try {
			if (submitType.equals("updatedata")) {
				rs = dao.fetchUserDetails(uemail.trim());
				if (rs != null) {
					while (rs.next()) {
						exame = rs.getString("EXAME");
						candidato = rs.getString("CANDIDATO");
						data = rs.getDate("DATA");
					}
				}
			} else {
				int i = dao.updateUserDetails(exame, candidato, data, candidatonovo);
				if (i > 0) {
					msg = "Record Updated Successfuly";
				} else {
					msg = "error";
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "UPDATE";
	}

	public String getExame() {
		return exame;
	}

	public void setExame(String exame) {
		this.exame = exame;
	}

	public Date getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getCandidato() {
		return candidato;
	}

	public void setCandidato (String candidato) {
		this.candidato = candidato;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCandidatonovo() {
		return candidatonovo;
	}

	public void setCandidatonovo(String candidatonovo) {
		this.candidatonovo = candidatonovo;
	}

	public String getSubmitType() {
		return submitType;
	}

	public void setSubmitType(String submitType) {
		this.submitType = submitType;
	}
}
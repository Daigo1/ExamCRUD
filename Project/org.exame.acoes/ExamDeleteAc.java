package org.exame.acoes;

import org.exame.dao.Admin;

import com.opensymphony.xwork2.ActionSupport;

public class DeleteAction extends ActionSupport {

	private static final long serialVersionUID = -146601914103585418L;
	String candidato, msg;
	Admin dao = new Admin();

	@Override
	public String execute() throws Exception {
		try {
			int isDeleted = dao.deleteUserDetails(candidato);
			if (isDeleted > 0) {
				msg = "Record deleted successfully";
			} else {
				msg = "Some error";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "DELETE";
	}

	public String getCandidato() {
		return candidato;
	}

	public void setCandidato(String candidato) {
		this.candidato = candidato;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
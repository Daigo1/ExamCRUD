package org.exame.acoes;

import org.exame.dao.Admin;
import java.util.Date;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {

	private static final long serialVersionUID = 9125277018717732648L;
	private String exame, candidato;
	private Date data;
	private String msg = "";
	Admin admin = null;
	int ctr = 0;

	@Override
	public String execute() throws Exception {
		admin = new Admin();

		try {
			ctr = admin.registerUser(exame, candidato, data);
			if (ctr > 0) {
				msg = "Registration Successfull";
			} else {
				msg = "Some error";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "REGISTER";
	}

	public String getExame() {
		return exame;
	}

	public void setExame(String exame) {
		this.exame = exame;
	}

	public String getCandidato() {
		return candidato;
	}

	public void setCandidato(String candidato) {
		this.candidato = candidato;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}


	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCtr() {
		return ctr;
	}

	public void setCtr(int ctr) {
		this.ctr = ctr;
	}
}

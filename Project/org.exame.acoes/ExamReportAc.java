package org.exame.acoes;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.exame.bean.EmpBean;
import org.exame.dao.Admin;
import java.util.Date;
import com.opensymphony.xwork2.ActionSupport;

public class ReportAction extends ActionSupport {

	private static final long serialVersionUID = -1235651048341475205L;
	ResultSet rs = null;
	EmpBean bean = null;
	List<EmpBean> beanList = null;
	Admin admin = new Admin();
	private boolean noData = false;

	@Override
	public String execute() throws Exception {
		try {
			beanList = new ArrayList<EmpBean>();
			rs = admin.report();
			int i = 0;
			if (rs != null) {
				while (rs.next()) {
					i++;
					bean = new EmpBean();
					bean.setSrNo(i);
					bean.setExame(rs.getString("EXAME"));
					bean.setCandidato(rs.getString("CANDIDATO"));
					bean.setData(rs.getDate("DATA"));
					beanList.add(bean);
				}
			}
			if (i == 0) {
				noData = false;
			} else {
				noData = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "REPORT";
	}

	public boolean isNoData() {
		return noData;
	}

	public void setNoData(boolean noData) {
		this.noData = noData;
	}

	public List<EmpBean> getBeanList() {
		return beanList;
	}

	public void setBeanList(List<EmpBean> beanList) {
		this.beanList = beanList;
	}
}
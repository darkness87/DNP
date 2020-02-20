package com.dnp.home.vo.mybatis.support;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.apache.ibatis.type.JdbcType;

import com.dnp.home.util.DNPDate;

public class DateToStringTypeHandler implements org.apache.ibatis.type.TypeHandler<String> {
	@Override
	public void setParameter(PreparedStatement ps, int i, String parameter,
			JdbcType jdbcType) throws SQLException {
	}

	@Override
	public String getResult(ResultSet rs, String columnName)
			throws SQLException {
		Timestamp ts = rs.getTimestamp(columnName);
		return timestampToString(ts);
	}

	@Override
	public String getResult(ResultSet rs, int columnIndex) throws SQLException {
		Timestamp ts = rs.getTimestamp(columnIndex);
		return timestampToString(ts);
	}

	@Override
	public String getResult(CallableStatement cs, int columnIndex) throws SQLException {
		Timestamp ts = cs.getTimestamp(columnIndex);
		return timestampToString(ts);
	}

	private String timestampToString(Timestamp ts) {
		if (ts != null) {
			DNPDate hdDate = new DNPDate(ts.getTime());
			return hdDate.toString(DNPDate.DATE_TYPE + DNPDate.TIME_TYPE + DNPDate.SECOND_TYPE, DNPDate.SYSTEM, " ");
		} else {
			return "";
		}
	}
}

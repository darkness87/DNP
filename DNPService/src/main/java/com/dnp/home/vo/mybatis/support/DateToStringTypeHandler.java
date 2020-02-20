package com.dnp.home.vo.mybatis.support;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.apache.ibatis.type.JdbcType;

import com.dnp.home.util.AMIDate;

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
			AMIDate hdDate = new AMIDate(ts.getTime());
			return hdDate.toString(AMIDate.DATE_TYPE + AMIDate.TIME_TYPE + AMIDate.SECOND_TYPE, AMIDate.SYSTEM, " ");
		} else {
			return "";
		}
	}
}

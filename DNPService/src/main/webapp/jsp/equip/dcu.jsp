<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../include/include.jsp"%>
<form class="search-form">
	<div class="search-input">
		<label><fmt:message key="ami.equipment.management.areacode"/></label>
		<div class="form-input input-select">
			<select id="areaCode" name="areaCode">
				<option value=""><fmt:message key="ami.common.select"/></option>
			</select> <i class="icon icon-select-arrow"></i>
		</div>
		<label><fmt:message key="ami.equipment.management.apartname"/></label>
		<div class="form-input input-select">
			<select id="apartName" name="apartName">
				<option value=""><fmt:message key="ami.common.select"/></option>
			</select> <i class="icon icon-select-arrow"></i>
		</div>
		<label><fmt:message key="ami.equipment.management.dcuid"/></label>
		<div class="form-input">
			<input id="dcuId" type="text" name="dcuId" />
		</div>
	</div>
	<div class="search-input">
		<label><fmt:message key="ami.equipment.management.wan.code"/></label>
		<div class="form-input input-select">
			<select id="mainNetwork" name="mainNetwork">
				<option value=""><fmt:message key="ami.common.select"/></option>
			</select> <i class="icon icon-select-arrow"></i>
		</div>
		<label><fmt:message key="ami.equipment.management.comm.code"/></label>
		<div class="form-input input-select">
			<select id="incomingNetwork" name="incomingNetwork">
				<option value=""><fmt:message key="ami.common.select"/></option>
			</select> <i class="icon icon-select-arrow"></i>
		</div>
		<label><fmt:message key="ami.equipment.management.disability"/></label>
		<div class="form-input input-select">
			<select id="disability" name="disability">
				<option value="default"><fmt:message key="ami.common.select"/></option>
				<option value=""><fmt:message key="ami.equipment.management.dcu.disconnect"/></option>
				<option value=""><fmt:message key="ami.equipment.management.connection.refused"/></option>
				<option value=""><fmt:message key="ami.equipment.management.modem.error"/></option>
				<option value=""><fmt:message key="ami.equipment.management.meter.error"/></option>
			</select><i class="icon icon-select-arrow"></i>
		</div>
	</div>
	<div class="search-btn">
		<button type="submit" class="btn-search"><fmt:message key="ami.equipment.management.search"/></button>
	</div>
</form>
<!-- /form-search -->
<table class="table table-list">
	<colgroup>
		<col style="width: 7%">
		<col>
		<col style="width: 8.6%">
		<col style="width: 14.4%">
		<col style="width: 14.4%">
		<col style="width: 10.4%">
		<col style="width: 10.4%">
		<col style="width: 10.4%">
		<col style="width: 10.4%">
	</colgroup>
	<thead>
		<tr>
			<th><fmt:message key="ami.equipment.management.area"/></th>
			<th><fmt:message key="ami.equipment.management.complexname"/></th>
			<th><fmt:message key="ami.equipment.management.dongname"/></th>
			<th><fmt:message key="ami.equipment.management.dcuid"/></th>
			<th><fmt:message key="ami.equipment.management.ip"/></th>
			<th><fmt:message key="ami.equipment.management.firmware"/></th>
			<th><fmt:message key="ami.equipment.management.wan.code"/></th>
			<th><fmt:message key="ami.equipment.management.comm.code"/></th>
			<th><fmt:message key="ami.equipment.management.meter"/></th>
		</tr>
	</thead>
	<tbody>
		<tr id="tableBody">
		</tr>
	</tbody>
</table>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../include/include.jsp"%>
<div class="search-form">
	<div class="search-input">
		<label><fmt:message key="ami.equipment.management.areacode"/></label>
		<div class="form-input input-select">
			<select id="areaCode" name="areaCode">
				<option value="default"><fmt:message key="ami.common.select"/></option>
			</select>
			<i class="icon icon-select-arrow"></i>
		</div>
		<label><fmt:message key="ami.equipment.management.apartname"/></label>
		<div class="form-input input-select">
			<select id="apartName" name="apartName">
				<option value="default"><fmt:message key="ami.common.select"/></option>
			</select>
			<i class="icon icon-select-arrow"></i>
		</div>
		<label><fmt:message key="ami.equipment.management.dongname"/></label>
		<div class="form-input">
			<input id="dongName" type="text" name="dongName" />
		</div>
	</div>
	<div class="search-input">
		<label><fmt:message key="ami.equipment.management.dcuid"/></label>
		<div class="form-input">
			<input id="dcuId" type="text" name="dcuId" />
		</div>
		<label><fmt:message key="ami.equipment.management.meter.id"/></label>
		<div class="form-input input-select">
			<select id="meterId" name="meterId">
				<option value="default"><fmt:message key="ami.common.select"/></option>
				<option value="">20.101.235.100 20.101.235.100</option>
			</select> <i class="icon icon-select-arrow"></i>
		</div>
		<label><fmt:message key="ami.equipment.management.isdelete"/></label>
		<div class="form-input input-select">
			<select id="isDelete" name="isDelete">
				<option value="default"><fmt:message key="ami.common.select"/></option>
			</select> <i class="icon icon-select-arrow"></i>
		</div>
	</div>
	<div class="search-btn">
		<button type="submit" class="btn-search"><fmt:message key="ami.equipment.management.search"/></button>
	</div>
</div>
<!-- /form-search -->

<!-- .table-list 는 tr 더블 클릭 이벤트 인식을 위한 class, style없음 -->
<table class="table table-list">
	<colgroup>
		<col style="width: 7%">
		<col>
		<col style="width: 8.6%">
		<col style="width: 14.4%">
		<col style="width: 14.4%">
		<col style="width: 10.4%">
		<col style="width: 10.4%">
	</colgroup>
	<thead>
		<tr>
			<th><fmt:message key="ami.equipment.management.area"/></th>
			<th><fmt:message key="ami.equipment.management.complexname"/></th>
			<th><fmt:message key="ami.equipment.management.dongname"/></th>
			<th><fmt:message key="ami.equipment.management.ho"/></th>
			<th><fmt:message key="ami.equipment.management.dcuid"/></th>
			<th><fmt:message key="ami.equipment.management.meter.id"/></th>
			<th><fmt:message key="ami.equipment.management.metering.date"/></th>
			<th><fmt:message key="ami.equipment.management.isdelete"/></th>
		</tr>
	</thead>
	<tbody>
		<tr class="alert-error">
			<td>강남</td>
			<td>거여 1단지</td>
			<td>102동</td>
			<td>101호</td>
			<td class="text-alert">NS09_0102A <i class="icon icon-alert"></i>
				<div class="alert-info">DCU 접속불가</div>
			</td>
			<td>06190009992</td>
			<td>1</td>
			<td></td>
		</tr>
	</tbody>
</table>
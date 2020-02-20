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
			<input id="dongName" type="text" name="" />
		</div>
	</div>
	<div class="search-input">
		<label><fmt:message key="ami.equipment.management.dcuid"/></label>
		<div class="form-input">
			<input id="dcuId" type="text" name="dcuId" />
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
		<col style="width: 10.4%">
	</colgroup>
	<thead>
		<tr>
			<th><fmt:message key="ami.equipment.management.computer.number"/></th>
			<th><fmt:message key="ami.equipment.management.transformer.class"/></th>
			<th><fmt:message key="ami.equipment.management.a.phase.volume"/></th>
			<th><fmt:message key="ami.equipment.management.b.phase.volume"/></th>
			<th><fmt:message key="ami.equipment.management.c.phase.volume"/></th>
			<th><fmt:message key="ami.equipment.management.threshold"/></th>
			<th><fmt:message key="ami.equipment.management.meaure.cycle"/></th>
			<th><fmt:message key="ami.equipment.management.tdu.integer"/></th>
			<th><fmt:message key="ami.equipment.management.istrap"/></th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>1974X842</td>
			<td>3상</td>
			<td>100</td>
			<td>100</td>
			<td>100</td>
			<td>110</td>
			<td>15</td>
			<td>233</td>
			<td>N</td>
		</tr>
	</tbody>
</table>
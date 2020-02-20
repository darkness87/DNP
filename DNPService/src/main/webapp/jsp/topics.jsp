<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="./include/include.jsp"%>
<li id="TEMPLATE_pageNumber">
	<a></a>
</li>
<div id="TEMPLATE_modifyPopup" class="modal">
	<div class="modal-title">
		<span>강남 거여 1단지 101동</span>
		<button class="btn-close" type="button" onclick="javascript:PAGE_CONTROLLER.closePopupPage();"></button>
	</div>

	<div class="modal-content">
		<div class="meter-title clearfix">
			<div class="float-left">
				<input type="text" class="meter-id" value="NS09_0101A" />
			</div>
			<div class="float-right">
				<!-- 활성화 시 active class 추가, 예시 : <a href="" class="btn-default btn-delete active" id="btnMeterDelete">Meter삭제</a>  -->
				<a href="" class="btn-default btn-delete active" id="btnMeterDelete">
					<fmt:message key="ami.popup.meter.delete"/>
				</a>
			</div>
		</div>
		<!-- /meter-title -->
		<div class="meter-info clearfix">
			<div class="float-left">
				<table class="table-meter">
					<tbody>
						<tr>
							<th><fmt:message key="ami.popup.ip.address"/></th>
							<td><input type="text" name="" value="20.131.235.100" disabled/></td>
						</tr>
						<tr>
							<th><fmt:message key="ami.popup.firmware.version"/></th>
							<!-- 비활성화 스타일 적용 :  class="disabled" 또는 input 의 attribute disabled 추가 -->
							<td><input type="text" name="" value="2.3" disabled /></td>
						</tr>
						<tr>
							<th><fmt:message key="ami.popup.wan.code"/></th>
							<td><input type="text" name="" value="LTE" disabled /></td>
						</tr>
						<tr>
							<th><fmt:message key="ami.popup.comm.code"/></th>
							<td><input type="text" name="" value="HS-PLC" disabled /></td>
						</tr>
						<tr>
							<th><fmt:message key="ami.popup.meter.count"/></th>
							<td><input type="text" name="" value="110" disabled /></td>
						</tr>
						<tr>
							<th><fmt:message key="ami.popup.tmark"/></th>
							<td><input type="text" name="" value="0x000000" readonly="readonly" disabled /></td>
						</tr>
						<tr>
							<th><fmt:message key="ami.popup.master.mod.a"/></th>
							<td><input type="text" name="" value="00:00:AC:5E:8C:01:99:7C" disabled /></td>
						</tr>
						<tr>
							<th><fmt:message key="ami.popup.snmp.ro"/></th>
							<td><input type="text" name="" value="kepsnmpro" /></td>
						</tr>
						<tr>
							<th><fmt:message key="ami.popup.snmp.rw"/></th>
							<td><input type="text" name="" value="kepsnmprw" /></td>
						</tr>
					</tbody>
				</table>
			</div>
			<!-- /float-left -->
			<div class="float-right">
				<table class="table-meter table-meter-list">
					<thead>
						<tr>
							<!-- 체크박스 스타일 input-checkbox -->
							<!-- 19.07.24 수정 data-target 에는 전체 선택 시 선택이 될 checkbox 가 있는  영역을 지정해주세요. 예시 ) .table-meter-list , #target_id  //-->
							<th class="td_checkbox">
								<label class="input-checkbox">
									<input type="checkbox" class="checkbox-all" onclick="fnCheckboxAll(this)" />
									<i class="icon-checkbox"></i>
								</label>
							</th>
							<!-- /19.07.24 수정  //-->
							<th><fmt:message key="ami.popup.meter.id"/></th>
							<th><fmt:message key="ami.popup.metering.date"/></th>
						</tr>
					</thead>
					<tbody>
						<tr class="checked">
							<td class="td_checkbox">
								<label class="input-checkbox">
									<input type="checkbox" onclick="fnBtnMeterDelete()" checked />
									<i class="icon-checkbox"></i>
								</label>
							</td>
							<td>06190010031</td>
							<td>19</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<!-- /meter-info -->
		<div class="meter-menu">
			<!-- 활설화 (색) class 에 active 추가 예시 : <a href="" class="btn-default active">시각설정</a>  -->
			<button type="button" class="btn-default"><fmt:message key="ami.popup.information.setting"/></button>
			<a href="" class="btn-default active"><fmt:message key="ami.popup.time.setting"/></a>
			<a href="" class="btn-default"><fmt:message key="ami.popup.time.error.limit"/></a>
			<a href="" class="btn-default"><fmt:message key="ami.popup.time.confirm.cycle"/></a>
			<a href="" class="btn-default"><fmt:message key="ami.popup.security.item"/></a>
		</div>
		<!-- /meter-menu -->
	</div>
	<!-- / .modal-content -->
</div>
<div id="TEMPLATE_readPopup" class="modal modal-sm">
	<div class="modal-title">
		강남 거여 1단지 101동
		<button class="btn-close" type="button" onclick="javascript:PAGE_CONTROLLER.closePopupPage(false);"></button>
	</div>

	<div class="modal-content">
		<div class="meter-title clearfix">
			<div class="float-left">
				<input type="text" class="meter-id" value="NS09_0101A" />
			</div>
			<div class="float-right">
				<!-- 활성화 시 active class 추가, 예시 : <a href="" class="btn-default btn-delete active" id="btnMeterDelete">Meter삭제</a>  -->
				<a href="" class="btn-default btn-delete active" id="btnMeterDelete"><fmt:message key="ami.popup.meter.delete"/></a>
			</div>
		</div>
		<!-- /meter-title -->
		<div class="meter-info clearfix">
			<div>
				<table class="table-meter">
					<tbody>
						<tr>
							<th><fmt:message key="ami.popup.dcuid"/></th>
							<td><input type="text" name="" value="NS09_0101A" disabled /></td>
						</tr>
						<tr>
							<th><fmt:message key="ami.popup.meter.id"/></th>
							<td><input type="text" name="" value="06190010031" disabled /></td>
						</tr>
						<tr>
							<th><fmt:message key="ami.popup.modem.mac"/></th>
							<td><input type="text" name=""
								value="00:00:AC:5E:8C:A0:39:04" disabled /></td>
						</tr>
						<tr>
							<th><fmt:message key="ami.popup.device.name"/></th>
							<td><input type="text" name="" value="WZT 161201A   21"
								disabled /></td>
						</tr>
						<tr>
							<th><fmt:message key="ami.popup.metering.date"/></th>
							<td><input type="text" name="" value="10" /></td>
						</tr>
						<tr>
							<th><fmt:message key="ami.popup.meter.time"/></th>
							<td><input type="text" name="" value="2019-05-09 11:00:55" /></td>
						</tr>
						<tr>
							<th><fmt:message key="ami.popup.lp.cycle"/></th>
							<td><input type="text" name="" value="15" /></td>
						</tr>
						<tr>
							<th><fmt:message key="ami.popup.snmp.ro"/></th>
							<td><input type="text" name="" value="kepsnmpro" /></td>
						</tr>
						<tr>
							<th><fmt:message key="ami.popup.snmp.rw"/></th>
							<td><input type="text" name="" value="kepsnmprw" /></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<!-- /meter-info -->
		<div class=" meter-menu">
			<!-- 활설화 (색) class 에 active 추가 예시 : <a href="" class="btn-default active">시각설정</a>  -->
			<button type="submit" class="btn-default"><fmt:message key="ami.popup.time.setting"/></button>
			<a href="" class="btn-default active"><fmt:message key="ami.popup.metering.date"/></a>
			<a href="" class="btn-default"><fmt:message key="ami.popup.lp.cycle"/></a>
			<a href="" class="btn-default"><fmt:message key="ami.popup.auto.metering"/></a>
		</div>
		<!-- /meter-menu -->
	</div>
	<!-- / .modal-content -->
</div>
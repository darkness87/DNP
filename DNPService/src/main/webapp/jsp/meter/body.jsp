<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../include/include.jsp"%>
<div id="navigator" class="location">
<%-- 	<fmt:message key="ami.menu.home"/> > <fmt:message key="ami.menu.equipment.management"/> > <fmt:message key="ami.menu.equipment.management.dcu"/> --%>
</div>
<!-- contents -->
<div class="contents">
	<div class="page-title">
		<h3><fmt:message key="ami.menu.equipment.management.dcu"/></h3>

		<ul id="subMenu" class="tab-menu">
			<li id="equipmentDcu">
				<a onclick="javascript:showSubMenuPage('equipmentDcu');"><fmt:message key="ami.menu.equipment.management.dcu"/></a>
			</li>
			<li id="equipmentDcu">
				<a onclick="javascript:showSubMenuPage('equipmentMeter');"><fmt:message key="ami.menu.equipment.management.meter"/></a>
			</li>
			<li id="equipmentDcu">
				<a onclick="javascript:showSubMenuPage('equipmentTransformer');"><fmt:message key="ami.menu.equipment.management.trasformer"/></a>
			</li>
			<li id="equipmentDcu">
				<a onclick="javascript:showSubMenuPage('equipmentHierarchy');"><fmt:message key="ami.menu.equipment.management.hierarchy"/></a>
			</li>
		</ul>
	</div>
	<!-- /page-title -->

	<form class="search-form">
		<div class="search-input">
			<label><fmt:message key="ami.equipment.management.areacode"/></label>
			<div class="form-input input-select">
				<select name="">
					<option value=""><fmt:message key="ami.common.select"/></option>
				</select> <i class="icon icon-select-arrow"></i>
			</div>
			<label><fmt:message key="ami.equipment.management.apartname"/></label>
			<div class="form-input input-select">
				<select name="">
					<option value=""><fmt:message key="ami.common.select"/></option>
				</select> <i class="icon icon-select-arrow"></i>
			</div>
			<label><fmt:message key="ami.equipment.management.dcuid"/></label>
			<div class="form-input">
				<input type="text" name="" />
			</div>
		</div>
		<div class="search-input">
			<label><fmt:message key="ami.equipment.management.wan.code"/></label>
			<div class="form-input input-select">
				<select name="">
					<option value=""><fmt:message key="ami.common.select"/></option>
				</select> <i class="icon icon-select-arrow"></i>
			</div>
			<label><fmt:message key="ami.equipment.management.comm.code"/></label>
			<div class="form-input input-select">
				<select name="">
					<option value=""><fmt:message key="ami.common.select"/></option>
					<option value="">20.101.235.100 20.101.235.100</option>
				</select> <i class="icon icon-select-arrow"></i>
			</div>
			<label><fmt:message key="ami.equipment.management.disability"/></label>
			<div class="form-input input-select">
				<select name="">
					<option value=""><fmt:message key="ami.common.select"/></option>
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

	<!-- .table-list 는 tr 더블 클릭 이벤트 인식을 위한 class, style없음 -->
	<div id="contentsBody">
		<%-- <%@include file="./dcu.jsp"%> --%>
	</div>

	<nav class="pagination_nav">
		<ul class="pagination">
			<li id="firstPage" class="paginate_first" style="display:none;"><a><span><fmt:message key="ami.common.prev.10"/></span></a></li>
			<li id="prevPage" class="paginate_prev" style="display:none;"><a><span><fmt:message key="ami.common.prev"/></span></a></li>
		</ul>
		<ul id="pagenation" class="pagination" style="display:none;">
		</ul>
		<ul class="pagination">
			<li id="nextPage" class="paginate_next" style="display:none;"><a><span><fmt:message key="ami.common.next"/></span></a></li>
			<li id="lastPage" class="paginate_last" style="display:none;"><a><span><fmt:message key="ami.common.next.10"/></span></a></li>
		</ul>
	</nav>
	<!-- / .pagination -->

	<!-- 팝업창 javascript  $('.modal_wrapper').show();  -->
	<div class="modal_wrapper">
		<div class="modal">
			<div class="modal-title">
				<span>강남 거여 1단지 101동</span>
				<button class="btn-close" type="button" onclick="fnModalClose();"></button>
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
						<table class="table-meter"><fmt:message key="ami"/>
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
									<th><fmt:message key="ami.popup.meter.date"/></th>
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
		<!-- / .modal -->
	</div>
	<!-- / .modal_wrapper -->
</div>
<!-- /contents -->
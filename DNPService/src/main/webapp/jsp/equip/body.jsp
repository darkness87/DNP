<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../include/include.jsp"%>
<div id="navigator" class="location">
<%-- 	<fmt:message key="ami.menu.home"/> > <fmt:message key="ami.menu.equipment.management"/> > <fmt:message key="ami.menu.equipment.management.dcu"/> --%>
</div>
<!-- contents -->
<div class="contents">
	<div class="page-title">
		<h3 id="subTitle"><fmt:message key="ami.menu.equipment.management.dcu"/></h3>

		<ul id="subMenu" class="tab-menu">
			<li id="equipmentDcu">
				<a onclick="javascript:showSubMenuPage('equipmentDcu');"><fmt:message key="ami.menu.equipment.management.dcu"/></a>
			</li>
			<li id="equipmentMeter">
				<a onclick="javascript:showSubMenuPage('equipmentMeter');"><fmt:message key="ami.menu.equipment.management.meter"/></a>
			</li>
			<li id="equipmentTransformer">
				<a onclick="javascript:showSubMenuPage('equipmentTransformer');"><fmt:message key="ami.menu.equipment.management.trasformer"/></a>
			</li>
			<li id="equipmentHierarchy">
				<a onclick="javascript:showSubMenuPage('equipmentHierarchy');"><fmt:message key="ami.menu.equipment.management.hierarchy"/></a>
			</li>
		</ul>
	</div>
	<!-- /page-title -->

	<!-- .table-list 는 tr 더블 클릭 이벤트 인식을 위한 class, style없음 -->
	<div id="contentsBody">
		<%-- <%@include file="./dcu.jsp"%> --%>
	</div>

	<nav id="pageBody" class="pagination_nav">
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
</div>
<!-- /contents -->
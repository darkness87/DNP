<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="./include/include.jsp"%>
<!-- contents -->
<div class="contents">
	<div class="dashboard clearfix">
		<div class="panel panel-realtime">
			<div class="panel-title">
				<fmt:message key="ami.dashboard.realtime.power"/>
			</div>
			<div class="panel-body">
				<div class="addon">
					<small><fmt:message key="ami.common.power.unit"/></small>
				</div>
				<div class="graph-value">
					<span class="bg-text">00</span>3,943.<small>56</small>
				</div>
				<!-- 그래프영역 -->
				<div class="graph-area">
					그래프 영역
				</div>
			</div>
			<div class="panel-footer">
				<div class="clearfix">
					<div class="float-left text-date">
						<fmt:message key="ami.dashboard.yesterday"/>
					</div>
					<div class="float-right text-data">
						<strong>5,980.23</strong>
						<small><fmt:message key="ami.common.power.unit"/></small>
					</div>
				</div>
			</div>
		</div>
		<!-- /panel-realtime --->
		<div class="panel panel-today">
			<div class="panel-title">
				<fmt:message key="ami.dashboard.today.power"/>
				<ul class="tab-menu">
					<li class="active">
						<a href="">
							<fmt:message key="ami.dashboard.day"/>
						</a>
					</li>
					<li>
						<a href="">
							<fmt:message key="ami.dashboard.month"/>
						</a>
					</li>
					<li>
						<a href="">
							<fmt:message key="ami.dashboard.year"/>
						</a>
					</li>
				</ul>
			</div>
			<div class="panel-body">
				<div class="addon">
					<small><fmt:message key="ami.common.power.unit"/></small>
				</div>
				<div class="graph-value">
					<span class="bg-text">0</span>12,016.<small>27</small>
				</div>
				<!-- /graph-value //-->
				<div class="graph-area">
					<!-- 그래프영역 -->
					그래프 영역
				</div>
			</div>
			<!-- /panel-body --->
			<div class="panel-footer">
				<div class="clearfix ">
					<div class="float-left text-date">
						<fmt:message key="ami.dashboard.yesterday"/>
					</div>
					<div class="float-right text-data">
						<strong>5,980.23</strong>
						<small><fmt:message key="ami.common.power.unit"/></small>
					</div>
				</div><!-- /clearfix --->
			</div>
			<!-- /panel-footer --->
		</div>
		<!-- /panel-today --->
		<div class="panel panel-install">
			<div class="panel-title">
				<fmt:message key="ami.dashboard.install.status"/>
			</div>
			<div class="panel-body">
				<ul class="tab-menu ">
					<li class="active">
						<a href=""><fmt:message key="ami.dashboard.dcu.install.status"/></a>
					</li>
					<li>
						<a href=""><fmt:message key="ami.dashboard.apt.install.status"/></a>
					</li>
				</ul>
				<div class="install-map">
					<dl class="map-info map-si map-seoul">
						<dt><fmt:message key="ami.area.seoul"/></dt>
						<dd>20</dd>
					</dl>
					<dl class="map-info map-do map-gyeonggi">
						<dt><fmt:message key="ami.area.gyeonggi"/></dt>
						<dd>17</dd>
					</dl>
					<dl class="map-info map-si map-incheon">
						<dt><fmt:message key="ami.area.incheon"/></dt>
						<dd>8</dd>
					</dl>
					<dl class="map-info map-do map-gangwon">
						<dt><fmt:message key="ami.area.gangwon"/></dt>
						<dd>8</dd>
					</dl>
					<dl class="map-info map-do map-chungbuk">
						<dt><fmt:message key="ami.area.chungbuk"/></dt>
						<dd>17</dd>
					</dl>
					<dl class="map-info map-do map-chungnam">
						<dt><fmt:message key="ami.area.chungnam"/></dt>
						<dd>17</dd>
					</dl>
					<dl class="map-info map-si map-daejeon">
						<dt><fmt:message key="ami.area.daejeon"/></dt>
						<dd>17</dd>
					</dl>
					<dl class="map-info map-do map-gyeongbuk">
						<dt><fmt:message key="ami.area.gyeongbuk"/></dt>
						<dd>17</dd>
					</dl>
					<dl class="map-info map-si map-daegu">
						<dt><fmt:message key="ami.area.daegu"/></dt>
						<dd>17</dd>
					</dl>
					<dl class="map-info map-do map-gyeongnam">
						<dt><fmt:message key="ami.area.gyeongnam"/></dt>
						<dd>17</dd>
					</dl>
					<dl class="map-info map-si map-busan">
						<dt><fmt:message key="ami.area.busan"/></dt>
						<dd>17</dd>
					</dl>
					<dl class="map-info map-do map-jeolbuk">
						<dt><fmt:message key="ami.area.jeolbuk"/></dt>
						<dd>17</dd>
					</dl>
					<dl class="map-info map-do map-jeolnam">
						<dt><fmt:message key="ami.area.jeolnam"/></dt>
						<dd>17</dd>
					</dl>
					<dl class="map-info map-si map-gwangju">
						<dt><fmt:message key="ami.area.gwangju"/></dt>
						<dd>17</dd>
					</dl>
					<dl class="map-info map-do map-jeju">
						<dt><fmt:message key="ami.area.jeju"/></dt>
						<dd>17</dd>
					</dl>
				</div>
			</div>
		</div>
		<!-- /panel-install --->
		<div class="panel panel-check">
			<div class="panel-title">
				<fmt:message key="ami.dashboard.meter.status"/>
			</div>
			<div class="panel-body">
				<div class="graph-area">
					그래프 영역
				</div>
			</div>
			
		</div>
		<!-- /panel-check --->
		<div class="panel panel-lp">
			<div class="panel-title">
				<fmt:message key="ami.dashboard.lp.status"/>
				<ul class="tab-menu clearfix">
					<li class="active">
						<a href=""><fmt:message key="ami.dashboard.day"/></a>
					</li>
					<li>
						<a href=""><fmt:message key="ami.dashboard.month"/></a>
					</li>
					<li>
						<a href=""><fmt:message key="ami.dashboard.year"/></a>
					</li>
				</ul>
			</div>
			<div class="panel-body">
				<div class="graph-area">
					그래프 영역
				</div>
			</div>
			<!-- /panel-body --->
			<div class="panel-footer ">
				<div class="clearfix ">
					<div class="float-left text-date">
						<fmt:message key="ami.dashboard.lp.today.success.rate"/>
					</div>
					<div class="float-right text-data">
						<strong>99.4</strong> <small>%</small>
					</div>
				</div>
				<!-- /clearfix --->
				<div class="clearfix ">
					<div class="float-left text-date">
						<fmt:message key="ami.dashboard.lp.monthavg.success.rate"/>
					</div>
					<div class="float-right text-data">
						<strong>99.1</strong> <small>%</small>
					</div>
				</div>
				<!-- /clearfix --->
			</div>
		</div>
		<!-- /panel-lp --->
	</div>
</div>
<!-- /contents -->
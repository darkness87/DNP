<%@ page language="java" contentType="application/javascript; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../../jsp/include/include.jsp"%>
<fmt:setBundle basename="com.cnu.amisystem.viewmessages" />
/**
// 아래의 5가지 리소스 파일은 line수와 value값을 동일하게 맞춰준다.						//
// 1. src/main/resources/com/hs/square/viewmessages_en.properties	//
// 2. src/main/resources/com/hs/square/viewmessages_ko.properties	//
// 3. src/main/resources/com/hs/square/viewmessages_ja.properties	//
// 4. src/main/resources/com/hs/square/viewmessages.properties		//
// 5. src/main/webapp/js/res/res_string.js							//
// 사용법은 src/main/webapp/js/res/res_controller.js 참조				//
*/
var RES_STRING = {
	// 제품기본
	ami_product_name						: "<fmt:message key="ami.product.name"/>",
	ami_product_version						: "<fmt:message key="ami.product.version"/>",
	ami_product_company						: "<fmt:message key="ami.product.company"/>",
	ami_product_company_address				: "<fmt:message key="ami.product.company.address"/>",
	ami_product_factory_address				: "<fmt:message key="ami.product.factory.address"/>",
	ami_product_copyright					: "<fmt:message key="ami.product.copyright"/>",

	// 공통
	ami_common_name_respect					: "<fmt:message key="ami.common.name.respect"/>",
	ami_common_join							: "<fmt:message key="ami.common.join"/>",
	ami_common_login						: "<fmt:message key="ami.common.login"/>",
	ami_common_logout						: "<fmt:message key="ami.common.logout"/>",
	ami_common_ok							: "<fmt:message key="ami.common.ok"/>",
	ami_common_power_unit					: "<fmt:message key="ami.common.power.unit"/>",
	ami_common_select						: "<fmt:message key="ami.common.select"/>",
	ami_common_prev_10						: "<fmt:message key="ami.common.prev.10"/>",
	ami_common_prev							: "<fmt:message key="ami.common.prev"/>",
	ami_common_next							: "<fmt:message key="ami.common.next"/>",
	ami_common_next_10						: "<fmt:message key="ami.common.next.10"/>",
	ami_common_id							: "<fmt:message key="ami.common.id"/>",
	ami_common_password						: "<fmt:message key="ami.common.password"/>",
	ami_common_password_check				: "<fmt:message key="ami.common.password.check"/>",
	ami_common_name							: "<fmt:message key="ami.common.name"/>",

	// 메뉴
	ami_menu_home							: "<fmt:message key="ami.menu.home"/>",
	// 설비관리
	ami_menu_equipment_management			: "<fmt:message key="ami.menu.equipment.management"/>",
	ami_menu_equipment_management_dcu		: "<fmt:message key="ami.menu.equipment.management.dcu"/>",
	ami_menu_equipment_management_meter		: "<fmt:message key="ami.menu.equipment.management.meter"/>",
	ami_menu_equipment_management_trasformer: "<fmt:message key="ami.menu.equipment.management.trasformer"/>",
	ami_menu_equipment_management_hierarchy	: "<fmt:message key="ami.menu.equipment.management.hierarchy"/>",
	// 검침조회
	ami_menu_meter_reading					: "<fmt:message key="ami.menu.meter.reading"/>",
	ami_menu_meter_reading_current_fixed_meter_reading	: "<fmt:message key="ami.menu.meter.reading.current.fixed.meter.reading"/>",
	ami_menu_meter_reading_current_maximum_demand		: "<fmt:message key="ami.menu.meter.reading.current.maximum.demand"/>",
	// 장애관리
	ami_menu_fault_management				: "<fmt:message key="ami.menu.fault.management"/>",
	ami_menu_fault_management_power_outage_restoration	: "<fmt:message key="ami.menu.fault.management.power.outage.restoration"/>",
	ami_menu_fault_management_meter_fluct_establish		: "<fmt:message key="ami.menu.fault.management.meter.fluct.establish"/>",
	// TOU
	ami_menu_tou							: "<fmt:message key="ami.menu.tou"/>",

	// 지명
	ami_area_seoul							: "<fmt:message key="ami.area.seoul"/>",
	ami_area_gyeonggi						: "<fmt:message key="ami.area.gyeonggi"/>",
	ami_area_incheon						: "<fmt:message key="ami.area.incheon"/>",
	ami_area_gangwon						: "<fmt:message key="ami.area.gangwon"/>",
	ami_area_chungbuk						: "<fmt:message key="ami.area.chungbuk"/>",
	ami_area_chungnam						: "<fmt:message key="ami.area.chungnam"/>",
	ami_area_daejeon						: "<fmt:message key="ami.area.daejeon"/>",
	ami_area_gyeongbuk						: "<fmt:message key="ami.area.gyeongbuk"/>",
	ami_area_gyeongnam						: "<fmt:message key="ami.area.gyeongnam"/>",
	ami_area_daegu							: "<fmt:message key="ami.area.daegu"/>",
	ami_area_busan							: "<fmt:message key="ami.area.busan"/>",
	ami_area_jeolbuk						: "<fmt:message key="ami.area.jeolbuk"/>",
	ami_area_jeolnam						: "<fmt:message key="ami.area.jeolnam"/>",
	ami_area_gwangju						: "<fmt:message key="ami.area.gwangju"/>",
	ami_area_jeju							: "<fmt:message key="ami.area.jeju"/>",
	ami_area_ulsan							: "<fmt:message key="ami.area.ulsan"/>",
	ami_area_ulleung						: "<fmt:message key="ami.area.ulleung"/>",
	ami_area_dokdo							: "<fmt:message key="ami.area.dokdo"/>",

	// 대쉬보드
	ami_dashboard_year						: "<fmt:message key="ami.dashboard.year"/>",
	ami_dashboard_month						: "<fmt:message key="ami.dashboard.month"/>",
	ami_dashboard_day						: "<fmt:message key="ami.dashboard.day"/>",
	ami_dashboard_graph_area				: "<fmt:message key="ami.dashboard.graph.area"/>",
	ami_dashboard_yesterday					: "<fmt:message key="ami.dashboard.yesterday"/>",
	ami_dashboard_realtime_power			: "<fmt:message key="ami.dashboard.realtime.power"/>",
	ami_dashboard_today_power				: "<fmt:message key="ami.dashboard.today.power"/>",
	ami_dashboard_meter_status				: "<fmt:message key="ami.dashboard.meter.status"/>",
	ami_dashboard_lp_status					: "<fmt:message key="ami.dashboard.lp.status"/>",
	ami_dashboard_lp_today_success_rate		: "<fmt:message key="ami.dashboard.lp.today.success.rate"/>",
	ami_dashboard_lp_monthavg_success_rate	: "<fmt:message key="ami.dashboard.lp.monthavg.success.rate"/>",
	ami_dashboard_install_status			: "<fmt:message key="ami.dashboard.install.status"/>",
	ami_dashboard_dcu_install_status		: "<fmt:message key="ami.dashboard.dcu.install.status"/>",
	ami_dashboard_apt_install_status		: "<fmt:message key="ami.dashboard.apt.install.status"/>",

	// 설비관리
	ami_equipment_management_areacode		: "<fmt:message key="ami.equipment.management.areacode"/>",
	ami_equipment_management_apartname		: "<fmt:message key="ami.equipment.management.apartname"/>",
	ami_equipment_management_dcuid			: "<fmt:message key="ami.equipment.management.dcuid"/>",
	ami_equipment_management_wan_code		: "<fmt:message key="ami.equipment.management.wan.code"/>",
	ami_equipment_management_comm_code		: "<fmt:message key="ami.equipment.management.comm.code"/>",
	ami_equipment_management_disability		: "<fmt:message key="ami.equipment.management.disability"/>",
	ami_equipment_management_dcu_disconnect	: "<fmt:message key="ami.equipment.management.dcu.disconnect"/>",
	ami_equipment_management_connection_refused	: "<fmt:message key="ami.equipment.management.connection.refused"/>",
	ami_equipment_management_modem_error	: "<fmt:message key="ami.equipment.management.modem.error"/>",
	ami_equipment_management_meter_error	: "<fmt:message key="ami.equipment.management.meter.error"/>",
	ami_equipment_management_search			: "<fmt:message key="ami.equipment.management.search"/>",
	ami_equipment_management_area			: "<fmt:message key="ami.equipment.management.area"/>",
	ami_equipment_management_complexname	: "<fmt:message key="ami.equipment.management.complexname"/>",
	ami_equipment_management_dongname		: "<fmt:message key="ami.equipment.management.dongname"/>",
	ami_equipment_management_ho				: "<fmt:message key="ami.equipment.management.ho"/>",
	ami_equipment_management_ip				: "<fmt:message key="ami.equipment.management.ip"/>",
	ami_equipment_management_firmware		: "<fmt:message key="ami.equipment.management.firmware"/>",
	ami_equipment_management_meter			: "<fmt:message key="ami.equipment.management.meter"/>",
	ami_equipment_management_meter_id		: "<fmt:message key="ami.equipment.management.meter.id"/>",
	ami_equipment_management_isdelete		: "<fmt:message key="ami.equipment.management.isdelete"/>",
	ami_equipment_management_metering_date	: "<fmt:message key="ami.equipment.management.metering.date"/>",
	ami_equipment_management_computer_number: "<fmt:message key="ami.equipment.management.computer.number"/>",
	ami_equipment_management_transformer_class	: "<fmt:message key="ami.equipment.management.transformer.class"/>",
	ami_equipment_management_a_phase_volume	: "<fmt:message key="ami.equipment.management.a.phase.volume"/>",
	ami_equipment_management_b_phase_volume	: "<fmt:message key="ami.equipment.management.b.phase.volume"/>",
	ami_equipment_management_c_phase_volume	: "<fmt:message key="ami.equipment.management.c.phase.volume"/>",
	ami_equipment_management_threshold		: "<fmt:message key="ami.equipment.management.threshold"/>",
	ami_equipment_management_meaure_cycle	: "<fmt:message key="ami.equipment.management.meaure.cycle"/>",
	ami_equipment_management_tdu_integer	: "<fmt:message key="ami.equipment.management.tdu.integer"/>",
	ami_equipment_management_istrap			: "<fmt:message key="ami.equipment.management.istrap"/>",

	// 팝업창
	ami_popup_meter_delete					: "<fmt:message key="ami.popup.meter.delete"/>",
	ami_popup_ip_address					: "<fmt:message key="ami.popup.ip.address"/>",
	ami_popup_firmware_version				: "<fmt:message key="ami.popup.firmware.version"/>",
	ami_popup_wan_code						: "<fmt:message key="ami.popup.wan.code"/>",
	ami_popup_comm_code						: "<fmt:message key="ami.popup.comm.code"/>",
	ami_popup_meter_count					: "<fmt:message key="ami.popup.meter.count"/>",
	ami_popup_tmark							: "<fmt:message key="ami.popup.tmark"/>",
	ami_popup_master_mod_a					: "<fmt:message key="ami.popup.master.mod.a"/>",
	ami_popup_snmp_ro						: "<fmt:message key="ami.popup.snmp.ro"/>",
	ami_popup_snmp_rw						: "<fmt:message key="ami.popup.snmp.rw"/>",
	ami_popup_meter_id						: "<fmt:message key="ami.popup.meter.id"/>",
	ami_popup_meter_date					: "<fmt:message key="ami.popup.meter.date"/>",
	ami_popup_information_setting			: "<fmt:message key="ami.popup.information.setting"/>",
	ami_popup_time_setting					: "<fmt:message key="ami.popup.time.setting"/>",
	ami_popup_time_error_limit				: "<fmt:message key="ami.popup.time.error.limit"/>",
	ami_popup_time_confirm_cycle			: "<fmt:message key="ami.popup.time.confirm.cycle"/>",
	ami_popup_security_item					: "<fmt:message key="ami.popup.security.item"/>",
	ami_popup_dcuid							: "<fmt:message key="ami.popup.dcuid"/>",
	ami_popup_modem_mac						: "<fmt:message key="ami.popup.modem.mac"/>",
	ami_popup_device_name					: "<fmt:message key="ami.popup.device.name"/>",
	ami_popup_meter_time					: "<fmt:message key="ami.popup.meter.time"/>",
	ami_popup_lp_cycle						: "<fmt:message key="ami.popup.lp.cycle"/>",
	ami_popup_auto_metering					: "<fmt:message key="ami.popup.auto.metering"/>",

	// Message
	ami_msg_forgot_login_information		: "<fmt:message key="ami.msg.forgot.login.information"/>",

	// Code Number Message
	ami_code_message_0						: "<fmt:message key="ami.code.message.0"/>",
	ami_code_message_9999					: "<fmt:message key="ami.code.message.9999"/>",
	ami_code_message_20						: "<fmt:message key="ami.code.message.20"/>",
	ami_code_message_31						: "<fmt:message key="ami.code.message.31"/>",
	ami_code_message_32						: "<fmt:message key="ami.code.message.32"/>",
	ami_code_message_101					: "<fmt:message key="ami.code.message.101"/>",
	ami_code_message_102					: "<fmt:message key="ami.code.message.102"/>",
	ami_code_message_103					: "<fmt:message key="ami.code.message.103"/>",
	ami_code_message_104					: "<fmt:message key="ami.code.message.104"/>",
	ami_code_message_105					: "<fmt:message key="ami.code.message.105"/>",
	ami_code_message_106					: "<fmt:message key="ami.code.message.106"/>",
	ami_code_message_107					: "<fmt:message key="ami.code.message.107"/>",
	ami_code_message_200					: "<fmt:message key="ami.code.message.200"/>",
	ami_code_message_201					: "<fmt:message key="ami.code.message.201"/>",
	ami_code_message_300					: "<fmt:message key="ami.code.message.300"/>",
	ami_code_message_301					: "<fmt:message key="ami.code.message.301"/>",
	ami_code_message_302					: "<fmt:message key="ami.code.message.302"/>",
	ami_code_message_303					: "<fmt:message key="ami.code.message.303"/>",
	ami_code_message_304					: "<fmt:message key="ami.code.message.304"/>",
	ami_code_message_305					: "<fmt:message key="ami.code.message.305"/>",
	ami_code_message_1401					: "<fmt:message key="ami.code.message.1401"/>",
	ami_code_message_1402					: "<fmt:message key="ami.code.message.1402"/>",
	ami_code_message_1403					: "<fmt:message key="ami.code.message.1403"/>",
	ami_code_message_1404					: "<fmt:message key="ami.code.message.1404"/>",
	ami_code_message_error_403				: "<fmt:message key="ami.code.message.error.403"/>",
	ami_code_message_error_404				: "<fmt:message key="ami.code.message.error.404"/>"
};
package com.dnp.home.vo;

public class MeterVO extends ResponseDataVO {
	private static final long serialVersionUID = 1L;

	private String dcuId;			// DID
	private String meterId;			// METER_ID
	private String macAddr;			// MAC_ADDR : 계량기 접속 모뎀 맥 어드레스
	private String deviceName;		// DEVICE_NAME : COSEM 계기 식별자
	private int activePowerConst;	// ACON : 전력량계 유효전력량 계기정수, 실제 정수 * 1000을 저장한다.
	private int reActivePowerConst;	// RCON : 전력량계 무효전력량 계기정수, 실제 정수 * 1000을 저장한다.
	private int meterReadingDay;	// MRD : 정기검침일
	private int dcuTime;			// ITIME : DCU 시각
	private int meterTime;			// MTIME : 전력량계 시각
	private int lpPeriod;			// LP_PERIOD : LP 주기 (1~60분)
	private int apparentPowerConst;	// PCON : 전력량계 피상전력량 계기정수(G-type/Ea-type계기), 실제 정수 * 1000을 저장한다.
	private String netMetering;		// NET_METERING : 양방향 계량 수행 여부(G-type/Ea-type계기), 0x00: 단방향 계량, 0x01: 양방향 계량
	private String isDelete;		// IS_DELETE : 검침대상 전력량계 삭제 여부
	private String registDate;		// WDATE : 등록일자
	private String modifyDate;		// UDATE : 수정일자

	// not in DB
	

	public int getActivePowerConst() {
		return activePowerConst;
	}

	public void setActivePowerConst(int activePowerConst) {
		this.activePowerConst = activePowerConst;
	}

	public String getDcuId() {
		return dcuId;
	}

	public void setDcuId(String dcuId) {
		this.dcuId = dcuId;
	}

	public String getMeterId() {
		return meterId;
	}

	public void setMeterId(String meterId) {
		this.meterId = meterId;
	}

	public String getMacAddr() {
		return macAddr;
	}

	public void setMacAddr(String macAddr) {
		this.macAddr = macAddr;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public int getReActivePowerConst() {
		return reActivePowerConst;
	}

	public void setReActivePowerConst(int reActivePowerConst) {
		this.reActivePowerConst = reActivePowerConst;
	}

	public int getMeterReadingDay() {
		return meterReadingDay;
	}

	public void setMeterReadingDay(int meterReadingDay) {
		this.meterReadingDay = meterReadingDay;
	}

	public int getDcuTime() {
		return dcuTime;
	}

	public void setDcuTime(int dcuTime) {
		this.dcuTime = dcuTime;
	}

	public int getMeterTime() {
		return meterTime;
	}

	public void setMeterTime(int meterTime) {
		this.meterTime = meterTime;
	}

	public int getLpPeriod() {
		return lpPeriod;
	}

	public void setLpPeriod(int lpPeriod) {
		this.lpPeriod = lpPeriod;
	}

	public int getApparentPowerConst() {
		return apparentPowerConst;
	}

	public void setApparentPowerConst(int apparentPowerConst) {
		this.apparentPowerConst = apparentPowerConst;
	}

	public String getNetMetering() {
		return netMetering;
	}

	public void setNetMetering(String netMetering) {
		this.netMetering = netMetering;
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

	public String getRegistDate() {
		return registDate;
	}

	public void setRegistDate(String registDate) {
		this.registDate = registDate;
	}

	public String getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
}
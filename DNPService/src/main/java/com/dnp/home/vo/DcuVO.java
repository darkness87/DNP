package com.dnp.home.vo;

public class DcuVO extends ResponseDataVO {
	private static final long serialVersionUID = 1L;

	private String dcuId;		// DID
	private int regionSeq;		// REGION_SEQ
	private String fepIp;		// FEP_IP
	private int fepPort;		// FEP_PORT
	private String ducIp;		// DCU_IP
	private int dcuPort;		// DCU_PORT
	private String macA;		// MAC_A : 마스터 모뎀 A 맥어드레스
	private String macB;		// MAC_B : 마스터 모뎀 B 맥어드레스
	private String macC;		// MAC_C : 마스터 모뎀 C 맥어드레스
	private long dcuTime;		// ITIME DCU 현재 시각
	private String dcuVersion;	// FWV : DCU Firmware 버전 (0x10 : ver1.0, 0x11 : ver1.1)
private String wanCode;		// WAN_CODE : 간선망 분류 코드 (1:HFC, 2:OPTICAL, 3:LTE)
private String commCode;	// COMM_CODE : 인입망 통신기술 분류코드 (1:HS-PLC, 2:HPGP, 3:WI-SUN, 4:ZIGBEE)
	private int trapCode;			// T_MARK : DCU에서 검침FEP으로 보내는 Trap 또는 자율보고 정보관리 금지 항목값 설정 (Default : 0x00000000, 모두 허용)
	private int meterCycle;			// SM_P : 표준형 계기 현재 검침 수집 주기 조정 (Default : 0x0F, 15분)
	private int meterLPCycle;		// SMLP_P : 표준형 계기 LP 수집 주기 조정 (Default : 0x0F, 15분)
	private int eMeterLPCycle;		// EMLP_P : E-TYPE 계기 LP 수집 주기 조정 (Default : 0x3C, 60분)
	private int gMeterLPCycle;		// GMLP_P : G-TYPE 계기 LP 수집 주기 조정 (Default : 0x0F, 15분)
	private int eaMeterLPCycle;		// EAMLP_P : Ea-TYPE 계기 LP 수집 주기 조정 (Default : 0x0F, 15분)
	private int gMeterAvgVACycle;	// GM_AVE_VA_P : G-TYPE 계기 평균 전압/전류 수집 주기 조정 (Default : 0x3C, 60분)
	private int gMeterInstVACycle;	// GM_INST_VA_P : G-TYPE 계기 순시 전압/전류 수집 주기 조정 (Default : 0x3C, 60분)
	private int eaMeterAvgVACycle;	// EAM_AVE_VA_P : G-TYPE 계기 평균 전압/전류 수집 주기 조정 (Default : 0x3C, 60분)
	private int eaMeterInstVACycle;	// EAM_INST_VA_P : G-TYPE 계기 순시 전압/전류 수집 주기 조정 (Default : 0x3C, 60분)
	private String versionBuildCode;// F_BUILD : Firmware 관리번호, Firmware 빌드연번 혹은 빌드일자(연월일 BCD표현)
	private int packetLength;		// P_LENGTH : 검침FEP-DCU간 프로토콜 패킷 길이(bytes), 초기값 0x00의 경우, 통신망 혹은 DCU OS 기기 기본 MTU 설정치에서 TCP/IP 헤더길이를 뺀 길이 적용
	private int timeOut;			// TIME_OUT : DCU-FEP간 프로토콜상 Time out 시간, 초기값 : 3초
	private int trapInterval;		// TRAP_INTERVAL : DCU-FEP간 Trap 전송 실패시 재전송 Interval (단위 : 분), 초기값 : 15분
	private int eMeterTimeErrorLimit;	// E_MTIME_ERROR_LIMIT : DCU와 E-type 전력량계간 시간오차 한계(Default 0x02, 2분)
	private int gMeterTimeErrorLimit;	// G_MTIME_ERROR_LIMIT : DCU와 G-type 전력량계간 시간오차 한계(Default 0x01, 1분)
	private int eaMeterTimeErrorLimit;	// EA_MTIME_ERROR_LIMIT : DCU와 Ea-type 전력량계간 시간오차 한계(Default 0x01, 1분)
	private int eMeterTimeCycle;	// EM_TIME_P : E-type 전력량계 시간확인 주기 (Default 0x3C, 60분)
	private int gMeterTimeCycle;	// GM_TIME_P : G-type 전력량계 시간확인 주기 (Default 0x0F, 15분)
	private int eaMeterTimeCycle;	// EAM_TIME_P : Ea-type 전력량계 시간확인 주기 (Default 0x0F, 15분)
private String cpuReset;		// CPU_RESET : cpu자동 reset 0x01:비활성화, 0x02:일 1회 실행, 0x02:월 1회 실행
	private String pinId;		// PNID : 콘솔 무선 모듈의 PNID
	private String authCodeRO;		// ACODE_RO : 인증권한 코드 (READ ONLY)
	private String authCodeRW;		// ACODE_RW : 인증권한 코드 (READ/WRITE)
	private String snmpPasswordRO;	// SNMP_PW_RO : SNMP COMMUNITY VALUE (READ ONLY)
	private String snmpPasswordRW;	// SNMP_PW_RW : SNMP COMMUNITY VALUE (READ/WRITE)
	private int registDate;			// WDATE : 등록 시각

	// not in DB
	private int meterCount;		// METER_COUNT 해당 DCU로 부터 속해 있는 계량기 개수
	private String area1;		// 지역1
	private String area2;		// 지역2
	private String area3;		// 지역3

	public String getAuthCodeRO() {
		return authCodeRO;
	}

	public void setAuthCodeRO(String authCodeRO) {
		this.authCodeRO = authCodeRO;
	}

	public String getDcuId() {
		return dcuId;
	}

	public void setDcuId(String dcuId) {
		this.dcuId = dcuId;
	}

	public int getRegionSeq() {
		return regionSeq;
	}

	public void setRegionSeq(int regionSeq) {
		this.regionSeq = regionSeq;
	}

	public String getFepIp() {
		return fepIp;
	}

	public void setFepIp(String fepIp) {
		this.fepIp = fepIp;
	}

	public int getFepPort() {
		return fepPort;
	}

	public void setFepPort(int fepPort) {
		this.fepPort = fepPort;
	}

	public String getDucIp() {
		return ducIp;
	}

	public void setDucIp(String ducIp) {
		this.ducIp = ducIp;
	}

	public int getDcuPort() {
		return dcuPort;
	}

	public void setDcuPort(int dcuPort) {
		this.dcuPort = dcuPort;
	}

	public String getMacA() {
		return macA;
	}

	public void setMacA(String macA) {
		this.macA = macA;
	}

	public String getMacB() {
		return macB;
	}

	public void setMacB(String macB) {
		this.macB = macB;
	}

	public String getMacC() {
		return macC;
	}

	public void setMacC(String macC) {
		this.macC = macC;
	}

	public long getDcuTime() {
		return dcuTime;
	}

	public void setDcuTime(long dcuTime) {
		this.dcuTime = dcuTime;
	}

	public String getDcuVersion() {
		return dcuVersion;
	}

	public void setDcuVersion(String dcuVersion) {
		this.dcuVersion = dcuVersion;
	}

	public String getWanCode() {
		return wanCode;
	}

	public void setWanCode(String wanCode) {
		this.wanCode = wanCode;
	}

	public String getCommCode() {
		return commCode;
	}

	public void setCommCode(String commCode) {
		this.commCode = commCode;
	}

	public int getTrapCode() {
		return trapCode;
	}

	public void setTrapCode(int trapCode) {
		this.trapCode = trapCode;
	}

	public int getMeterCycle() {
		return meterCycle;
	}

	public void setMeterCycle(int meterCycle) {
		this.meterCycle = meterCycle;
	}

	public int getMeterLPCycle() {
		return meterLPCycle;
	}

	public void setMeterLPCycle(int meterLPCycle) {
		this.meterLPCycle = meterLPCycle;
	}

	public int geteMeterLPCycle() {
		return eMeterLPCycle;
	}

	public void seteMeterLPCycle(int eMeterLPCycle) {
		this.eMeterLPCycle = eMeterLPCycle;
	}

	public int getgMeterLPCycle() {
		return gMeterLPCycle;
	}

	public void setgMeterLPCycle(int gMeterLPCycle) {
		this.gMeterLPCycle = gMeterLPCycle;
	}

	public int getEaMeterLPCycle() {
		return eaMeterLPCycle;
	}

	public void setEaMeterLPCycle(int eaMeterLPCycle) {
		this.eaMeterLPCycle = eaMeterLPCycle;
	}

	public int getgMeterAvgVACycle() {
		return gMeterAvgVACycle;
	}

	public void setgMeterAvgVACycle(int gMeterAvgVACycle) {
		this.gMeterAvgVACycle = gMeterAvgVACycle;
	}

	public int getgMeterInstVACycle() {
		return gMeterInstVACycle;
	}

	public void setgMeterInstVACycle(int gMeterInstVACycle) {
		this.gMeterInstVACycle = gMeterInstVACycle;
	}

	public int getEaMeterAvgVACycle() {
		return eaMeterAvgVACycle;
	}

	public void setEaMeterAvgVACycle(int eaMeterAvgVACycle) {
		this.eaMeterAvgVACycle = eaMeterAvgVACycle;
	}

	public int getEaMeterInstVACycle() {
		return eaMeterInstVACycle;
	}

	public void setEaMeterInstVACycle(int eaMeterInstVACycle) {
		this.eaMeterInstVACycle = eaMeterInstVACycle;
	}

	public String getVersionBuildCode() {
		return versionBuildCode;
	}

	public void setVersionBuildCode(String versionBuildCode) {
		this.versionBuildCode = versionBuildCode;
	}

	public int getPacketLength() {
		return packetLength;
	}

	public void setPacketLength(int packetLength) {
		this.packetLength = packetLength;
	}

	public int getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(int timeOut) {
		this.timeOut = timeOut;
	}

	public int getTrapInterval() {
		return trapInterval;
	}

	public void setTrapInterval(int trapInterval) {
		this.trapInterval = trapInterval;
	}

	public int geteMeterTimeErrorLimit() {
		return eMeterTimeErrorLimit;
	}

	public void seteMeterTimeErrorLimit(int eMeterTimeErrorLimit) {
		this.eMeterTimeErrorLimit = eMeterTimeErrorLimit;
	}

	public int getgMeterTimeErrorLimit() {
		return gMeterTimeErrorLimit;
	}

	public void setgMeterTimeErrorLimit(int gMeterTimeErrorLimit) {
		this.gMeterTimeErrorLimit = gMeterTimeErrorLimit;
	}

	public int getEaMeterTimeErrorLimit() {
		return eaMeterTimeErrorLimit;
	}

	public void setEaMeterTimeErrorLimit(int eaMeterTimeErrorLimit) {
		this.eaMeterTimeErrorLimit = eaMeterTimeErrorLimit;
	}

	public int geteMeterTimeCycle() {
		return eMeterTimeCycle;
	}

	public void seteMeterTimeCycle(int eMeterTimeCycle) {
		this.eMeterTimeCycle = eMeterTimeCycle;
	}

	public int getgMeterTimeCycle() {
		return gMeterTimeCycle;
	}

	public void setgMeterTimeCycle(int gMeterTimeCycle) {
		this.gMeterTimeCycle = gMeterTimeCycle;
	}

	public int getEaMeterTimeCycle() {
		return eaMeterTimeCycle;
	}

	public void setEaMeterTimeCycle(int eaMeterTimeCycle) {
		this.eaMeterTimeCycle = eaMeterTimeCycle;
	}

	public String getCpuReset() {
		return cpuReset;
	}

	public void setCpuReset(String cpuReset) {
		this.cpuReset = cpuReset;
	}

	public String getPinId() {
		return pinId;
	}

	public void setPinId(String pinId) {
		this.pinId = pinId;
	}

	public String getAuthCodeRW() {
		return authCodeRW;
	}

	public void setAuthCodeRW(String authCodeRW) {
		this.authCodeRW = authCodeRW;
	}

	public String getSnmpPasswordRO() {
		return snmpPasswordRO;
	}

	public void setSnmpPasswordRO(String snmpPasswordRO) {
		this.snmpPasswordRO = snmpPasswordRO;
	}

	public String getSnmpPasswordRW() {
		return snmpPasswordRW;
	}

	public void setSnmpPasswordRW(String snmpPasswordRW) {
		this.snmpPasswordRW = snmpPasswordRW;
	}

	public int getRegistDate() {
		return registDate;
	}

	public void setRegistDate(int registDate) {
		this.registDate = registDate;
	}

	public int getMeterCount() {
		return meterCount;
	}

	public void setMeterCount(int meterCount) {
		this.meterCount = meterCount;
	}

	public String getArea1() {
		return area1;
	}

	public void setArea1(String area1) {
		this.area1 = area1;
	}

	public String getArea2() {
		return area2;
	}

	public void setArea2(String area2) {
		this.area2 = area2;
	}

	public String getArea3() {
		return area3;
	}

	public void setArea3(String area3) {
		this.area3 = area3;
	}
}
package com.dnp.home.vo;

public class TransformerVO extends ResponseDataVO {
	private static final long serialVersionUID = 1L;

	private String dcuId;			// DID
	private String transformerId;	// TID : 변압기 전산화 번호
	private int transformerVolumeA;	// KVA_A : A상 변압기 용량
	private int transformerVolumeB;	// KVA_B : B상 변압기 용량
	private int transformerVolumeC;	// KVA_C : C상 변압기 용량
	private int undervoltLowerLimit;// OUTAGEVOL : 변압기 정전발생여부 판단을 위한 저전압 하한치
private String transformerDivision;	// NUMPHASE : 변압기 단상/3상 구분 - 1:단상 1BANK (R/N), 2:단상 2BANK(R/S/N), 3:3상 변압기 (R/S/T/N)
	private int period;				// PERIOD : 측정주기(분)
	private int TDU;				// CONSTANT : TDU(변압기 부하감시장치) 정수

	// not in DB
	

	public String getDcuId() {
		return dcuId;
	}

	public void setDcuId(String dcuId) {
		this.dcuId = dcuId;
	}

	public String getTransformerId() {
		return transformerId;
	}

	public void setTransformerId(String transformerId) {
		this.transformerId = transformerId;
	}

	public int getTransformerVolumeA() {
		return transformerVolumeA;
	}

	public void setTransformerVolumeA(int transformerVolumeA) {
		this.transformerVolumeA = transformerVolumeA;
	}

	public int getTransformerVolumeB() {
		return transformerVolumeB;
	}

	public void setTransformerVolumeB(int transformerVolumeB) {
		this.transformerVolumeB = transformerVolumeB;
	}

	public int getTransformerVolumeC() {
		return transformerVolumeC;
	}

	public void setTransformerVolumeC(int transformerVolumeC) {
		this.transformerVolumeC = transformerVolumeC;
	}

	public int getUndervoltLowerLimit() {
		return undervoltLowerLimit;
	}

	public void setUndervoltLowerLimit(int undervoltLowerLimit) {
		this.undervoltLowerLimit = undervoltLowerLimit;
	}

	public String getTransformerDivision() {
		return transformerDivision;
	}

	public void setTransformerDivision(String transformerDivision) {
		this.transformerDivision = transformerDivision;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public int getTDU() {
		return TDU;
	}

	public void setTDU(int tDU) {
		TDU = tDU;
	}
}
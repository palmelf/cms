package com.shishuo.cms.constant;

import javax.lang.model.type.TypeMirror;

/**
 * 交易结果
 */

public enum TransResultEnum implements TypeMappping {


	TRANS_RESULT_SUCCESS((short) 1, "成功"), TRANS_RESULT_FAIL((short) 2, "失败");

	short value;
	String desc;

	TransResultEnum(short value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public short getValue() {
		return value;
	}

	public String getDesc() {
		return desc;
	}

}

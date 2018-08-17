package com.usst.load.utils;

import java.math.BigDecimal;
import java.util.Objects;

public class DecimalUtil {
	private static final int DEF_DIV_SCALE = 2;
	private static final BigDecimal DEF_V = new BigDecimal("0");
	private static final int ROUND_MODE = 4;

	public DecimalUtil() {
	}

	public static BigDecimal add(BigDecimal v1, BigDecimal v2) {
		return calculate(v1, v2, DecimalUtil.Operator.ADD);
	}

	public static BigDecimal sub(BigDecimal v1, BigDecimal v2) {
		return calculate(v1, v2, DecimalUtil.Operator.SUB);
	}

	public static BigDecimal mul(BigDecimal v1, BigDecimal v2) {
		return calculate(v1, v2, DecimalUtil.Operator.MUL);
	}

	public static BigDecimal div(BigDecimal v1, BigDecimal v2) {
		return calculate(v1, v2, DecimalUtil.Operator.DIV);
	}

	public static BigDecimal div(BigDecimal v1, BigDecimal v2, int scale) {
		if (scale >= 0 && v2.intValue() != 0) {
			return v1.divide(v2, scale, 4);
		} else {
			return v1.divide(v2, DEF_DIV_SCALE,4);
		}
	}

	public static boolean eq(BigDecimal v1, BigDecimal v2) {
		return compare(v1, v2, DecimalUtil.Operator.EQ);
	}

	public static boolean neq(BigDecimal v1, BigDecimal v2) {
		return compare(v1, v2, DecimalUtil.Operator.NEQ);
	}

	public static boolean gt(BigDecimal v1, BigDecimal v2) {
		return compare(v1, v2, DecimalUtil.Operator.GT);
	}

	public static boolean egt(BigDecimal v1, BigDecimal v2) {
		return compare(v1, v2, DecimalUtil.Operator.EGT);
	}

	public static boolean lt(BigDecimal v1, BigDecimal v2) {
		return compare(v1, v2, DecimalUtil.Operator.LT);
	}

	public static boolean elt(BigDecimal v1, BigDecimal v2) {
		return compare(v1, v2, DecimalUtil.Operator.ELT);
	}

	public static boolean isBetween(BigDecimal data, BigDecimal min, BigDecimal max) {
		data = getScaleValue(data);
		min = getScaleValue(min);
		max = getScaleValue(max);
		return data.compareTo(min) >= 0 && data.compareTo(max) <= 0;
	}

	public static BigDecimal getScaleValue(BigDecimal o) {
		BigDecimal n = Objects.isNull(o) ? DEF_V : o;
		return n.setScale(2, 4);
	}

	private static BigDecimal calculate(BigDecimal v1, BigDecimal v2, DecimalUtil.Operator operator) {
		BigDecimal b1 = getScaleValue(v1);
		BigDecimal b2 = getScaleValue(v2);
		switch (operator) {
			case ADD:
				return b1.add(b2);
			case SUB:
				return b1.subtract(b2);
			case MUL:
				return b1.multiply(b2);
			case DIV:
				return div(b1, b2, 2);
			default:
				return null;
		}
	}

	private static boolean compare(BigDecimal v1, BigDecimal v2, DecimalUtil.Operator operator) {
		BigDecimal b1 = getScaleValue(v1);
		BigDecimal b2 = getScaleValue(v2);
		int result = b1.compareTo(b2);
		switch (operator) {
			case EQ:
				return result == 0;
			case NEQ:
				return result != 0;
			case GT:
				return result == 1;
			case EGT:
				return result >= 0;
			case LT:
				return result == -1;
			case ELT:
				return result <= 0;
			default:
				return false;
		}
	}

	static enum Operator {
		ADD,
		SUB,
		MUL,
		DIV,
		EQ,
		NEQ,
		GT,
		EGT,
		LT,
		ELT;

		private Operator() {
		}
	}
}

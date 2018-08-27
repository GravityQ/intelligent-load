package com.usst.load.enums;

import com.usst.load.model.Goods;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author junlin.qi on 2018/8/26
 */

public enum TrunEnum {
	XY(0) {
		@Override
		public Goods turn(Goods goods) {
			//水平旋转,即交换长宽
			Integer mid = goods.getLength();
			goods.setLength(goods.getWidth());
			goods.setWidth(mid);
			goods.setTruned(this.getCode());
			return goods;
		}
	}, XZ(1) {
		@Override
		public Goods turn(Goods goods) {
			//长高旋转
			Integer mid = goods.getLength();
			goods.setLength(goods.getHigh());
			goods.setHigh(mid);
			goods.setTruned(this.getCode());
			return goods;
		}
	}, XZY(2) {
		@Override
		public Goods turn(Goods goods) {
			//长高旋转再水平旋转
			XY.turn(XZ.turn(goods));
			goods.setTruned(this.getCode());
			return goods;
		}
	}, YZ(3) {
		@Override
		public Goods turn(Goods goods) {
			//宽高旋转
			Integer mid = goods.getWidth();
			goods.setWidth(goods.getHigh());
			goods.setHigh(mid);
			goods.setTruned(this.getCode());
			return goods;
		}
	}, YZX(4) {
		@Override
		public Goods turn(Goods goods) {
			//宽高旋转再水平旋转
			XY.turn(YZ.turn(goods));
			return goods;
		}
	};
	private Integer code;

	TrunEnum(Integer code) {
		this.code = code;
	}

	private static Map<Integer, TrunEnum> enumMap = Arrays.stream(TrunEnum.values()).collect(Collectors.toMap(TrunEnum::getCode, Function.identity()));

	public static TrunEnum getByCode(Integer code) {
		return enumMap.get(code);
	}

	public Integer getCode() {
		return code;
	}

	public abstract Goods turn(Goods goods);
}

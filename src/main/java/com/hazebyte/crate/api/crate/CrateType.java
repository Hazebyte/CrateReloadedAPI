package com.hazebyte.crate.api.crate;

import com.google.common.collect.Maps;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public enum CrateType {
	SUPPLY(0),
	MYSTERY(1),
	KEY(2),
	MENU(3);

	private final int id;
	private static CrateType[] byId = new CrateType[4];
	private static Map<String, CrateType> BY_NAME = Maps.newHashMap();
	CrateType(final int id) {
		this.id = id;
	}

	CrateType(final int id, AnimationType... animationType) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public static CrateType getType(final int id) {
		if( id < byId.length && id >= 0) {
			return byId[id];
		}
		return null;
	}

	public static CrateType getType(final String name) {
		return BY_NAME.get(name);
	}

	static {
		for (CrateType type : values()) {
			if (byId.length > type.id) {
				byId[type.id] = type;
			} else {
				byId = Arrays.copyOfRange(byId, 0, type.id + 2);
				byId[type.id] = type;
			}
			BY_NAME.put(type.name(), type);
		}
	}

}

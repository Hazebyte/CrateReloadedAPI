package com.hazebyte.crate.api.crate;

import com.google.common.collect.Maps;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Contain states that determine the interactions a crate takes.
 */
public enum CrateType {
	/**
	 * Type of crate that item is specifically a chest. This crate may only be activated or
	 * opened in-game by placing the chest onto a ground surface. The winning rewards are
	 * placed into the chest inventory.<br>
	 *
	 * This type does not support any gui animations at the moment.
	 */
	SUPPLY(0),
	/**
	 * Type of crate that can be opened at any time. It may be activated at anytime or anywhere
	 * by performing a left or right click.
	 *
	 * This type supports all animations.
	 *
	 * Notes: https://github.com/Hazebyte/CrateReloadedAPI/issues/16
	 */
	MYSTERY(1),
	/**
	 * Type of crate which specifically uses a key. A preset location must be present for users
	 * to interact with.
	 *
	 * This type supports all animations.
	 */
	KEY(2),
	/**
	 * @deprecated
	 */
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

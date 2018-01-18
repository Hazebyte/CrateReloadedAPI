package com.hazebyte.crate.api.crate.reward;

public enum Tag {
	COMMAND("cmd"),
	ITEM("item"),
	CHANCE("chance"),
	DISPLAY("display"),
	PERMISSION("onetime"),
	MESSAGE("onopen"),
	BROADCAST("broadcast"),
	BROADCAST_INLINE("inbroadcast"),
	PREVENT_DUPLICATE("unique");
	
	private final String tag;
	Tag(String tag) {
		this.tag = tag;
	}

	public String getName() {
		return tag;
	}
	
	public static Tag getTagFromValue(String str) {
		for(Tag current: Tag.values()) {
			if(str.toLowerCase().equalsIgnoreCase(current.getName())) {
				return current;
			}
		}
		return null;
	}
	
	public static boolean contains(String str) {
		for(Tag current: Tag.values()) {
			if(str.toLowerCase().contains(current.toString() + ":(")) {
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		return tag;
	}
}

package com.hazebyte.crate.api.crate.reward;

/**
 * States that determine the attributes of a {@link Reward}
 */
public enum Tag {
    /**
     * Represents a command.
     */
	COMMAND("cmd"),
    /**
     * Represents an item.
     */
	ITEM("item"),
    /**
     * Represents a chance value.
     */
	CHANCE("chance"),
    /**
     * Represents an display item.
     */
	DISPLAY("display"),
    /**
     * Represents a permission.
     */
	PERMISSION("permission"),
    /**
     * Represents an opening message.
     */
	MESSAGE("msg"),
    /**
     * Represents a broadcast message.
     */
	BROADCAST("broadcast"),
    /**
     * Represents an concatenated broadcast message.
     */
	BROADCAST_INLINE("append"),
    /**
     * Represents a unique reward.
     */
	PREVENT_DUPLICATE("unique"),
    /**
     * Represents a persistent reward.
     */
	ALWAYS("always"),

	// Legacy
	LEGACY_PERM("onetime"),
	LEGACY_MESSAGE("onopen"),
	LEGACY_PREVENT_DUPLICATE("noduplicate");
	
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

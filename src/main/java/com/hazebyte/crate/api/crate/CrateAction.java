package com.hazebyte.crate.api.crate;

/**
 * Contain states which represent an action.
 */
public enum CrateAction {
    /**
     * State when a player left clicks and previews a crate.
     */
    PREVIEW,
    /**
     * State when a player right clicks and opens a crate.
     */
    OPEN,
    /**
     * unused
     */
    RIGHT_CLICK,
    /**
     * unused
     */
    LEFT_CLICK;

    CrateAction() {}
}

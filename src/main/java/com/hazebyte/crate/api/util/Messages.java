package com.hazebyte.crate.api.util;

public interface Messages {

	String INVALID_CHANCE = "The following is not a number: ";
	String FEATURE_NOT_ENABLED = "The following feature is not enabled";
	String PREVIEWFEATURE_NOT_ENABLED = FEATURE_NOT_ENABLED + ": PREVIEW";
	String MESSAGE_NOT_FOUND = "Message not found: ";
	String REFRESHED = "%prefix%%green%Refreshed!";
	String RELOADED = "%prefix%%green%Reload Complete!";

	String NO_REWARDS = "%prefix%%red%Unable to find any rewards.";
	String ERROR_PARSING = "%prefix%%red%Error Parsing: ";
	String ERROR_LOCALE = "%prefix%%red%Error loading locale.";
	String ERROR_EFFECT = "%prefix%%red%Error loading particle.";
	String ERROR_LINE = "%prefix%%red%Unable to parse: ";

	String TIME_RESET = "%prefix%Roulette length must be greater than 5 seconds.";
}

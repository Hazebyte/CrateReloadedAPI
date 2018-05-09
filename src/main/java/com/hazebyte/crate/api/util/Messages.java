package com.hazebyte.crate.api.util;

/**
 * Internal messages
 */
public interface Messages {

    String UNAVAILABLE_FEATURE  =   "The following feature is not available: %s";
    String MESSAGE_NOT_FOUND    =   "The following message key was not found: ";

    String RELOAD               =   "The plugin has been reloaded.";
    String ERROR                =   "An error has occurred: ";
    String ERROR_LINE           =   ERROR + "Parsing (%s)";
}

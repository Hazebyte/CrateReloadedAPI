package com.hazebyte.crate.api.util;

/**
 * Internal messages
 */
public interface Messages {

    String UNAVAILABLE_FEATURE          =   "The following feature is not available: %s";
    String UNAVAILABLE_FEATURE_INFO     =   "The following feature is not available: %s [see %s]";
    String MESSAGE_NOT_FOUND            =   "The following message key was not found: ";
    String RELOAD                       =   "The plugin has been reloaded.";
    String ERROR                        =   "An error has occurred: ";
    String ERROR_LINE                   =   ERROR + "Parsing (%s)";
    String ERROR_LINE_INFO              =   ERROR + "Parsing (%s) [see %s]";
    String FORMAT                       =   "Please check the format: ";
    String FORMAT_ITEM                  =   FORMAT + "ITEM (%s) [see %s]";
}

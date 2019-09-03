package com.hazebyte.crate.api.util;

/**
 * Internal messages
 */
public interface Messages {

    String UNAVAILABLE_FEATURE          =   "&fThe following feature is not available: %s";
    String UNAVAILABLE_FEATURE_INFO     =   UNAVAILABLE_FEATURE + " [see %s]";
    String MESSAGE_NOT_FOUND            =   "The following message key was not found: ";
    String RELOAD                       =   "The plugin has been reloaded.";
    String WARNING                      =   "&eSomething happened: &f";
    String WARNING_S                    =   WARNING + " %s";
    String WARNING_S_INFO               =   WARNING + " %s [see %s]";
    String ERROR                        =   "&4An error has occurred: &f";
    String ERROR_LINE                   =   ERROR + "Parsing \"%s\"";
    String ERROR_LINE_INFO              =   ERROR + "Parsing \"%s\" [see %s]";
    String FORMAT                       =   "Please check the format: ";
    String FORMAT_ITEM                  =   FORMAT + "ITEM \"%s\" [see %s]";
}

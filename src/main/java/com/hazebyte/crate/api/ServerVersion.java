package com.hazebyte.crate.api;

import org.bukkit.Bukkit;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ServerVersion implements Comparable<ServerVersion> {

    private static final Map<String, ServerVersion> versions = new HashMap<>();

    private static final Pattern versionPattern = Pattern.compile("[a-zA-Z]");
    private static final Pattern numberPattern = Pattern.compile("[0-9]+_[0-9]+_[0-9]+");

    public static ServerVersion v1_8_R1 = ServerVersion.of("1_8_1");
    public static ServerVersion v1_8_R2 = ServerVersion.of("1_8_2");
    public static ServerVersion v1_8_R3 = ServerVersion.of("1_8_3");
    public static ServerVersion v1_9_R1 = ServerVersion.of("1_9_1");
    public static ServerVersion v1_10_R1 = ServerVersion.of("1_10_1");
    public static ServerVersion v1_11_R1 = ServerVersion.of("1_11_1");
    public static ServerVersion v1_12_R1 = ServerVersion.of("1_12_1");
    public static ServerVersion v1_13_R1 = ServerVersion.of("1_13_1");
    public static ServerVersion v1_14_R1 = ServerVersion.of("1_14_1");
    public static ServerVersion v1_15_R1 = ServerVersion.of("1_15_1");
    public static ServerVersion v1_16_R1 = ServerVersion.of("1_16_1");
    public static ServerVersion v1_16_R2 = ServerVersion.of("1_16_2");
    public static ServerVersion v1_16_R3 = ServerVersion.of("1_16_3");
    public static ServerVersion v1_16_R4 = ServerVersion.of("1_16_4");

    private final int major;
    private final int minor;
    private final int revision;

    private ServerVersion(int major, int minor, int revision) {
        this.major = major;
        this.minor = minor;
        this.revision = revision;
    }

    /**
     * This takes in a server version string and returns
     * the server version object. This string should be in the format
     * major_minor_revision e.g. v1_8_R1 => 1_8_1.
     *
     * @return the server version
     */
    public static ServerVersion of(String versionString) {
        Matcher matcher = versionPattern.matcher(versionString);
        versionString = matcher.replaceAll("");

        if (!numberPattern.matcher(versionString).matches())
            throw new IllegalArgumentException("incorrect server version syntax");

        if (versions.containsKey(versionString))
            return versions.get(versionString);

        String[] parts = versionString.split("_");

        int major = Integer.parseInt(parts[0]);
        int minor = Integer.parseInt(parts[1]);
        int revision = Integer.parseInt(parts[2]);

        ServerVersion version = new ServerVersion(major, minor, revision);
        versions.put(versionString, version);
        return version;
    }

    /**
     * Returns the current running server version.
     */
    public static ServerVersion getVersion() {
        String version = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
        return ServerVersion.of(version);
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(major) +
                Integer.hashCode(minor) +
                Integer.hashCode(revision);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ServerVersion))
            return false;

        ServerVersion version = (ServerVersion) obj;
        return this.compareTo(version) == 0;
    }

    /**
     * Returns true if the calling server version is greater than
     * the parameter.
     */
    public boolean gt(ServerVersion version) {
        return this.compareTo(version) > 0;
    }

    /**
     * Returns true if the calling server version is greater than
     * or equal to the parameter.
     */
    public boolean gte(ServerVersion version) {
        return this.compareTo(version) >= 0;
    }

    /**
     * Returns true if the calling server version is less than
     * the parameter.
     */
    public boolean lt(ServerVersion version) {
        return this.compareTo(version) < 0;
    }

    /**
     * Returns true if the calling server version is less than
     * or equal to the parameter.
     */
    public boolean lte(ServerVersion version) {
        return this.compareTo(version) <= 0;
    }

    /**
     * Returns all possible server versions.
     */
    public Collection<ServerVersion> getAllVersions() {
        return versions.values();
    }

    @Override
    public int compareTo(ServerVersion serverVersion) {
        if (this.major > serverVersion.major) {
            return 1;
        } else if (this.major < serverVersion.major) {
            return -1;
        }

        if (this.minor > serverVersion.minor) {
            return 1;
        } else if (this.minor < serverVersion.minor) {
            return -1;
        }

        return Integer.compare(this.revision, serverVersion.revision);
    }

    public int getMajor() {
        return major;
    }

    public int getMinor() {
        return minor;
    }

    public int getRevision() {
        return revision;
    }
}

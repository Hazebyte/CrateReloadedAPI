package com.hazebyte.crate.api;

import org.bukkit.Bukkit;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class ServerVersion implements Comparable<ServerVersion> {

    private static final Map<String, ServerVersion> versions = new HashMap<>();

    private static final Pattern numberPattern = Pattern.compile("[0-9]+.[0-9]+.[0-9]+");

    public static ServerVersion v1_8_R1 = new ServerVersion(1, 8, 1);
    public static ServerVersion v1_8_R2 = new ServerVersion(1, 8, 2);
    public static ServerVersion v1_9_R1 = new ServerVersion(1, 9, 1);
    public static ServerVersion v1_10_R1 = new ServerVersion(1, 10, 1);
    public static ServerVersion v1_12_R1 = new ServerVersion(1, 12, 1);
    public static ServerVersion v1_13_R1 = new ServerVersion(1, 13, 1);
    public static ServerVersion v1_14_R1 = new ServerVersion(1, 14, 1);
    public static ServerVersion v1_16_R1 = new ServerVersion(1, 16, 1);

    public static ServerVersion SERVER_MOCK = new ServerVersion(Integer.MAX_VALUE,0,0);

    private final int major;
    private final int minor;
    private final int revision;

    private ServerVersion(int major, int minor, int revision) {
        this.major = major;
        this.minor = minor;
        this.revision = revision;
    }

    public static boolean isMockServer(String versionString) {
        return versionString.contains("1.19"); // MockBukkit version
    }

    public boolean isMockServer() {
        return this.equals(SERVER_MOCK);
    }

    /**
     *  1.20.6 => Major (1), Minor (20), Revision (6)
     * @return the server version
     */
    public static ServerVersion of(String versionString) {
        if (isMockServer(versionString)) {
            return ServerVersion.SERVER_MOCK;
        }

        if (!numberPattern.matcher(versionString).matches())
            throw new IllegalArgumentException(String.format("Unable to parse server version: [%s]", versionString));

        if (versions.containsKey(versionString))
            return versions.get(versionString);

        String[] parts = versionString.split("\\.");

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
        // 1.20.6-84-591521e (MC: 1.20.6)
        String serverVersion = Bukkit.getServer().getBukkitVersion();
        String[] parts = serverVersion.split("-");
        return ServerVersion.of(parts[0]);
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

    @Override
    public String toString() {
        return String.format("%d_%d_R%d", major, minor, revision);
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

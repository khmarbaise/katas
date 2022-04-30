package com.soebes.versions;

import java.util.Comparator;
import java.util.Objects;

public class Version implements Comparable<Version> {
  private final long major;
  private final long minor;
  private final long patch;

  public Version(long major, long minor, long patch) {
    this.major = major;
    this.minor = minor;
    this.patch = patch;
  }

  public long getMajor() {
    return major;
  }

  public long getMinor() {
    return minor;
  }

  public long getPatch() {
    return patch;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Version version = (Version) o;
    return major == version.major && minor == version.minor && patch == version.patch;
  }

  @Override
  public int hashCode() {
    return Objects.hash(major, minor, patch);
  }

  private static final Comparator<Version> VERSION_COMPARATOR = Comparator
      .comparingLong(Version::getMajor)
      .thenComparingLong(Version::getMinor)
      .thenComparingLong(Version::getPatch);

  @Override
  public int compareTo(Version o) {
    return VERSION_COMPARATOR.compare(this, o);
  }
}

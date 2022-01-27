package kr.luxsoft.demo;

public interface RegionService {
    boolean isServerActive(int serverId);

    String getISOCountryCode();
}
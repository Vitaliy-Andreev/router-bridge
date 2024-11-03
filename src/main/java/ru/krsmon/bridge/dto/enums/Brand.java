package ru.krsmon.bridge.dto.enums;

import lombok.Getter;

public enum Brand {
    KEENETIC("show ip arp", "tools ping %s count 1"),
    MICROTIC("ip arp print", "ping address=%s count=1"),
    DLINK("cat /proc/net/arp", "ping %s -c 1"),
    ASUS("cat /proc/net/arp", "ping %s -c 1"),
    OPENWRT("cat /proc/net/arp", "ping %s -c 1"),
    TPLINK(null, null);

    @Getter
    private final String arp;
    private final String ping;

    Brand(String arp, String ping) {
        this.arp = arp;
        this.ping = ping;
    }

    public String getPing(String ip) {
        return ping.formatted(ip);
    }

}

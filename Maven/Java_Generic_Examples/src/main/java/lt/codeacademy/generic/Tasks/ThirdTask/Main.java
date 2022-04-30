package lt.codeacademy.generic.Tasks.ThirdTask;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Mapas<DnsProvider, DnsServer> dnsMapas = new Mapas<>();
        dnsMapas.add(DnsProvider.GOOGLE, new DnsServer("127.0.0.1", "1.1.1.1"));
        dnsMapas.add(DnsProvider.AWS, new DnsServer("37.88.7.12", "192.127.88.12"));

        DnsServer dnsServer = dnsMapas.get(DnsProvider.AWS);
        System.out.println(dnsServer);

        Mapas<String, Integer> manoMapas = new Mapas<>();
        manoMapas.add("Vienas", 1);
        manoMapas.add("Dešimt", 10);
        manoMapas.add("Šimtas", 100);

        Integer simtas = manoMapas.get("Šimtas");
        System.out.println(simtas);

    }
}

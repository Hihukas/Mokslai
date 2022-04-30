package lt.codeacademy.generic.Tasks.ThirdTask;

public record DnsServer (String ip1, String ip2){
    @Override
    public String toString() {
        return "DnsServer{" +
                "ip1='" + ip1 + '\'' +
                ", ip2='" + ip2 + '\'' +
                '}';
    }
}

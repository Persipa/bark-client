package site.persipa.bark.pojo.client;

import lombok.Data;

@Data
public class BarkServerInfo {

    private String commit;

    private Integer devices;

    private String version;

    private String build;

    private String arch;
}

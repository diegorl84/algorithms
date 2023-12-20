package principles;

import lombok.Data;

@Data
public class Category {

    private String id;
    private String definingorg;
    private String version;
    private String fullcategoryname;
    private String fullcategorypathname;
    private Integer depth;
    private String parentid;
    private String name;
    private String nodetype;
    private String detaillevel;
    private String manufacturer;
    private String model;
    private String manufacturerWarrantyInfoId;
    private String triageInfoId;
    private String displayName;
    private String memory;
    private String color;
    private String operatingSystem;
    private String carrier;
    private String networkType;
    private String description;
    private String url;
    private String imageFileName;
}

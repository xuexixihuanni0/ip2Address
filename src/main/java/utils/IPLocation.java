package utils;

/**
 * Created by angel；
 */
public class IPLocation {
    /**
     * 国家
     */
    private String country;
    /**
     * 区域 - 省份 + 城市
     */
    private String area;
    private String region;

    public IPLocation() {
        country = region = area = "";
    }

    public synchronized IPLocation getCopy() {
        IPLocation ret = new IPLocation();
        ret.country = country;
        ret.area = area;
        ret.region = region;
        return ret;
    }

    public String getRegion() {
        String region = "";
        if(country != null){
            String[] array = country.split("省");
            if(array != null && array.length > 1){
                region =  array[0]+"省";
            } else {
                region = country;
            }
            if(region.length() > 3){
                region.replace("内蒙古", "");
            }
        }
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        String city = "";
        if(country != null){
            String[] array = country.split("省");
            if(array != null && array.length > 1){
                city =  array[1];
            } else {
                city = country;
            }
            if(city.length() > 3){
                city.replace("内蒙古", "");
            }
        }
        return city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        //如果为局域网，纯真IP地址库的地区会显示CZ88.NET,这里把它去掉
        if(area.trim().equals("CZ88.NET")){
            this.area="本机或本网络";
        }else{
            this.area = area;
        }
    }
}


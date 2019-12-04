import com.maxmind.geoip.Location;
import com.maxmind.geoip.LookupService;
import utils.IPAddressUtils;
import utils.IPLocation;

import java.io.IOException;

/**
 * @author DJC
 * @version 1.0
 */
public class ParseIP {

    public static void main(String[] args) throws IOException {
//        databaseFile:ip与与经纬度映射关系文件GeoLiteCity.dat的绝对地址
        LookupService look = new LookupService("E:parseIP2Adr\\src\\main\\resources", LookupService.GEOIP_MEMORY_CACHE);
//        传入需要解析的ip地址
        Location location = look.getLocation("0.0.0.0");
        float latitude = location.latitude;
        float longitude = location.longitude;
        System.out.println(latitude + "\n" + longitude);
        IPAddressUtils ipAddressUtils = new IPAddressUtils();
        IPLocation getregion = ipAddressUtils.getregion("0.0.0.0");
        String country = getregion.getCountry();
        String city = getregion.getCity();
        String area = getregion.getArea();
        String region = getregion.getRegion();
        System.out.println("country:"+country);
        System.out.println("city:"+city);
        System.out.println("area:"+area);
        System.out.println("region:"+region);
    }
}

package site.persipa.bark.dubbo.provider.client;

import site.persipa.bark.pojo.client.vo.BarkDeviceVo;

import java.util.List;

/**
 * @author persipa
 */
public interface BarkDeviceApi {

    List<BarkDeviceVo> listAllDevice();

    BarkDeviceVo findByDeviceName(String deviceName);

}

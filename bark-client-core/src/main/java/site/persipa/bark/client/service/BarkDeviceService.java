package site.persipa.bark.client.service;

import com.baomidou.mybatisplus.extension.service.IService;
import site.persipa.bark.pojo.client.BarkDevice;

/**
 * @author persipa
 */
public interface BarkDeviceService extends IService<BarkDevice> {
    boolean saveInfo(BarkDevice barkDevice);
}
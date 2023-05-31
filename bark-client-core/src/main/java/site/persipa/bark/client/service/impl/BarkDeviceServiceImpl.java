package site.persipa.bark.client.service.impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.persipa.bark.client.mapper.BarkDeviceMapper;
import site.persipa.bark.client.service.BarkDeviceService;
import site.persipa.bark.pojo.client.BarkDevice;

/**
 * @author persipa
 */
@Service
public class BarkDeviceServiceImpl extends ServiceImpl<BarkDeviceMapper, BarkDevice>
        implements BarkDeviceService {
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveInfo(BarkDevice barkDevice) {
        if (barkDevice.getId() == null) {
            barkDevice.setId(IdUtil.fastSimpleUUID());
        }
        return this.saveOrUpdate(barkDevice);
    }
}
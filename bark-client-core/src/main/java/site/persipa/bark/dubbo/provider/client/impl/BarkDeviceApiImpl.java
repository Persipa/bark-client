package site.persipa.bark.dubbo.provider.client.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.DubboService;
import site.persipa.bark.client.service.BarkDeviceService;
import site.persipa.bark.dubbo.provider.client.BarkDeviceApi;
import site.persipa.bark.mapstruct.MapBarkDeviceMapper;
import site.persipa.bark.pojo.client.BarkDevice;
import site.persipa.bark.pojo.client.vo.BarkDeviceVo;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author persipa
 */
@DubboService(version = "1.0")
@RequiredArgsConstructor
public class BarkDeviceApiImpl implements BarkDeviceApi {

    private final BarkDeviceService barkDeviceService;

    private final MapBarkDeviceMapper mapBarkDeviceMapper;

    @Override
    public List<BarkDeviceVo> listAllDevice() {
        List<BarkDevice> deviceList = barkDeviceService.list();
        return deviceList.stream()
                .map(mapBarkDeviceMapper::toVo)
                .collect(Collectors.toList());
    }

    @Override
    public BarkDeviceVo findByDeviceName(String deviceName) {
        BarkDevice barkDevice = barkDeviceService.getOne(Wrappers.lambdaQuery(BarkDevice.class)
                .eq(BarkDevice::getDeviceName, deviceName));
        return mapBarkDeviceMapper.toVo(barkDevice);
    }
}

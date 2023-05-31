package site.persipa.bark.client.manager;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import site.persipa.bark.client.service.BarkDeviceService;
import site.persipa.bark.enums.exception.BarkDeviceExceptionEnum;
import site.persipa.bark.enums.exception.BarkMessageExceptionEnum;
import site.persipa.bark.mapstruct.MapBarkDeviceMapper;
import site.persipa.bark.pojo.client.BarkDevice;
import site.persipa.bark.pojo.client.bo.BarkMessageSendBaseBo;
import site.persipa.bark.pojo.client.dto.BarkDeviceDto;
import site.persipa.bark.pojo.client.dto.BarkDeviceSearchDto;
import site.persipa.bark.pojo.client.vo.BarkDeviceVo;
import site.persipa.cloud.exception.PersipaRuntimeException;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author persipa
 */
@Component
@RequiredArgsConstructor
public class BarkDeviceManager {

    private final BarkMessageManager barkMessageManager;

    private final BarkDeviceService barkDeviceService;

    private final MapBarkDeviceMapper mapBarkDeviceMapper;

    @Transactional(rollbackFor = Exception.class)
    public String add(BarkDeviceDto deviceDto, boolean force) {
        BarkDevice existDevice = barkDeviceService.getOne(Wrappers.lambdaQuery(BarkDevice.class)
                .eq(BarkDevice::getDeviceName, deviceDto.getDeviceName())
                .or().eq(BarkDevice::getDeviceKey, deviceDto.getDeviceKey()));
        Assert.isNull(existDevice, () -> new PersipaRuntimeException(BarkDeviceExceptionEnum.DEVICE_ALREADY_EXIST));

        BarkDevice barkDevice = mapBarkDeviceMapper.fromDto(deviceDto);

        BarkMessageSendBaseBo sendBaseBo = new BarkMessageSendBaseBo();
        sendBaseBo.setTitle("BarkClient 通知");
        String body = "这是一条添加设备的通知。添加的设备：" + barkDevice.getDeviceName();
        sendBaseBo.setBody(body);
        sendBaseBo.setDeviceKey(barkDevice.getDeviceKey());
        boolean success = barkMessageManager.push(sendBaseBo);
        if (!force && !success) {
            throw new PersipaRuntimeException(BarkMessageExceptionEnum.MESSAGE_SEND_FAILED);
        }
        barkDevice.setEnabled(success);

        barkDeviceService.saveInfo(barkDevice);
        return barkDevice.getId();
    }

    public List<BarkDeviceVo> find(BarkDeviceSearchDto searchDto) {
        List<BarkDevice> barkDeviceList = barkDeviceService.list(Wrappers.lambdaQuery(BarkDevice.class)
                .eq(StrUtil.isNotEmpty(searchDto.getDeviceName()), BarkDevice::getDeviceName, searchDto.getDeviceName()));
        return barkDeviceList.stream()
                .map(mapBarkDeviceMapper::toVo)
                .collect(Collectors.toList());
    }

}

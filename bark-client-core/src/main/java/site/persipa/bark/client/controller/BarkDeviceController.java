package site.persipa.bark.client.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import site.persipa.bark.client.manager.BarkDeviceManager;
import site.persipa.bark.pojo.client.dto.BarkDeviceDto;
import site.persipa.bark.pojo.client.dto.BarkDeviceSearchDto;
import site.persipa.bark.pojo.client.vo.BarkDeviceVo;
import site.persipa.cloud.pojo.rest.model.Result;

import java.util.List;

/**
 * @author persipa
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/bark/device")
public class BarkDeviceController {

    private final BarkDeviceManager barkDeviceManager;

    @PostMapping("/add")
    public Result<String> add(@RequestBody BarkDeviceDto deviceDto,
                              @RequestParam(required = false, defaultValue = "false") boolean force) {
        return Result.success(barkDeviceManager.add(deviceDto, force));
    }

    @PostMapping("/list")
    public Result<List<BarkDeviceVo>> list(@RequestBody BarkDeviceSearchDto searchDto) {
        return Result.success(barkDeviceManager.find(searchDto));
    }
}

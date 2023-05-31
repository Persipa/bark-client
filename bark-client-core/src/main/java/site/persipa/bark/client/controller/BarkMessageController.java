package site.persipa.bark.client.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import site.persipa.bark.client.manager.BarkMessageManager;
import site.persipa.bark.pojo.client.BarkServerInfo;
import site.persipa.bark.pojo.client.dto.BarkMessageSendDto;
import site.persipa.cloud.pojo.rest.model.Result;

/**
 * @author persipa
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/bark/client")
public class BarkMessageController {

    private final BarkMessageManager barkMessageManager;

    @GetMapping("/info")
    public Result<BarkServerInfo> info() {
        return Result.success(barkMessageManager.info());
    }

    @GetMapping("/ping")
    public Result<Boolean> ping() {
        return Result.success(barkMessageManager.ping());
    }

    @GetMapping("/health")
    public Result<Boolean> health() {
        return Result.success(barkMessageManager.healthCheck());
    }

    @PostMapping("/push")
    public Result<Boolean> push(@RequestBody BarkMessageSendDto messageSendDto) {
        return Result.success(barkMessageManager.push(messageSendDto));
    }
}

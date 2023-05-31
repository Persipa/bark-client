package site.persipa.bark.pojo.client;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author persipa
 */
@Data
@TableName("bark_device")
public class BarkDevice {

    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    private String deviceName;

    private String deviceKey;

    private Boolean enabled;

    private String remark;

    @TableLogic(value = "0")
    private Boolean deleted;
}

package com.dtstack.alter.dome;

import com.dtstack.channel.IMailChannel;
import com.dtstack.lang.data.R;
import com.dtstack.lang.exception.BizException;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * @Auther: dazhi
 * @Date: 2021/11/12 上午11:25
 * @Email:dazhi@dtstack.com
 * @Description:
 */
public class MailDome implements IMailChannel {

    public R sendMail(List<String> list, String s, String s1, List<File> list1, Map<String, Object> map) throws BizException {
        String result = HttpUtil.doGet("http://www.baidu.com");
        System.out.println(result);
        return R.ok();
    }
}

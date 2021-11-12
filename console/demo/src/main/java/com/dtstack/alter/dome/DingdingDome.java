package com.dtstack.alter.dome;

import com.dtstack.channel.ICustomizeChannel;
import com.dtstack.channel.IDingChannel;
import com.dtstack.lang.data.R;
import com.dtstack.lang.exception.BizException;

import java.util.List;
import java.util.Map;

/**
 * @Auther: dazhi
 * @Date: 2021/11/12 上午11:25
 * @Email:dazhi@dtstack.com
 * @Description:
 */
public class DingdingDome implements IDingChannel {

    public R sendDing(List<String> list, String s, Map<String, String> map, Map<String, Object> map1) throws BizException {
        String result = HttpUtil.doGet("http://www.baidu.com");
        System.out.println(result);
        return R.ok();
    }

    public R sendDingWithMarkDown(List<String> list, String s, String s1, Map<String, String> map, Map<String, Object> map1) throws BizException {
        String result = HttpUtil.doGet("http://www.baidu.com");
        System.out.println(result);
        return R.ok();
    }
}

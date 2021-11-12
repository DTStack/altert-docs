package com.dtstack.alter.dome;

import com.dtstack.channel.ICustomizeChannel;
import com.dtstack.lang.data.R;

import java.util.Map;

/**
 * @Auther: dazhi
 * @Date: 2021/11/12 上午11:25
 * @Email:dazhi@dtstack.com
 * @Description:
 */
public class ICustomizeDome implements ICustomizeChannel {


    public R sendCustomizeAlert(Object o, Map<String, Object> map) {
        String s = HttpUtil.doGet("http://www.baidu.com");
        System.out.println(s);
        return R.ok();
    }

}

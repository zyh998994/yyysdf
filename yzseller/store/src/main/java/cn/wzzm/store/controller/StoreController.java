package cn.wzzm.store.controller;

import cn.wzzm.store.pojo.Store;
import cn.wzzm.store.service.StoreService;
import cn.wzzm.store.service.util.JSONUtil;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;


@Api("店铺")
@RequestMapping("/store")
@Controller
public class StoreController {

    public StoreService getSse() {
        return sse;
    }

    public void setSse(StoreService sse) {
        this.sse = sse;
    }

    @Autowired
    private StoreService sse;


    /**
     * 注册店铺
     *
     * @param json
     * @return
     */
    @ResponseBody
    @RequestMapping("/insertstore")
    @ApiOperation(value = "添加商店", httpMethod = "POST", notes = "添加商店,参数：sid，sname")
    public String insertStore(@RequestBody String json) {
        Store s = new Store();
        JSONObject jsonObject = JSONObject.parseObject(json);
        s.setSname(jsonObject.getString("sname"));
        if (jsonObject.getString("sid") == null || jsonObject.getString("sname") == null) {
            return JSONUtil.setResult(1, "\"无数据\"");
        } else {
            String code = sse.insertStore(s, Integer.parseInt(jsonObject.getString("sid")));
            String s1 = JSONUtil.setResult(0, "\"" + code + "\"");
            return s1;
        }
    }

    /**
     * 修改店铺等级
     *
     * @param json
     * @return
     */
    @ResponseBody
    @RequestMapping("/updatelevel")
    @ApiOperation(value = "修改店铺等级", httpMethod = "POST", notes = "修改店铺等级,参数：sid，level")
    public String updatelevel(@RequestBody String json) {
        JSONObject jsonObject = JSONObject.parseObject(json);
        if (jsonObject.getString("sid") == null || jsonObject.getString("level") == null) {
            return JSONUtil.setResult(1, "\"无数据\"");
        } else {
            String sid = jsonObject.getString("sid");
            String level = jsonObject.getString("level");
            int i = Integer.parseInt(sid);
            int i1 = Integer.parseInt(level);
            String code = sse.updateStoreLevel(i, i1);
            String s = JSONUtil.setResult(0, "\"" + code + "\"");
            return s;
        }
    }

    @RequestMapping(value = "/imgUpLoad")
    public String testUpload(HttpServletRequest request, @RequestParam(value = "desc", required = false) String desc, @RequestParam("photo") CommonsMultipartFile file, @RequestParam int sid) throws Exception {
        ServletContext servletContext = request.getServletContext();//获取ServletContext的对象 代表当前WEB应用
        String realPath = servletContext.getRealPath("/uploads");//得到文件上传目的位置的真实路径
        System.out.println("realPath :" + realPath);
        File file1 = new File(realPath);
        if (!file1.exists()) {
            file1.mkdir();   //如果该目录不存在，就创建此抽象路径名指定的目录。
        }
        String prefix = UUID.randomUUID().toString();
        prefix = prefix.replace("-", "");
        String fileName = prefix + "_" + file.getOriginalFilename();//使用UUID加前缀命名文件，防止名字重复被覆盖

        InputStream in = file.getInputStream();
        //声明输入输出流

        OutputStream out = new FileOutputStream(new File(realPath + fileName));//指定输出流的位置;

        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = in.read(buffer)) != -1) {
            out.write(buffer, 0, len);
            out.flush();                //类似于文件复制，将文件存储到输入流，再通过输出流写入到上传位置
        }                               //这段代码也可以用IOUtils.copy(in, out)工具类的copy方法完成

        out.close();
        in.close();

        //更新用户信息
        String s = sse.updateStoreImage(sid, fileName);
        return s;
    }

}

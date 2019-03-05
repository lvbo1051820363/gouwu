package cn.itsource.gouwu.controller;

import cn.itsource.gouwu.util.FastDfsApiOpr;
import cn.itsource.util.AjaxResult;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/common")
public class FastDfsController {

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public AjaxResult upload(@RequestBody MultipartFile file){
        //获取原始名字
        String filename = file.getOriginalFilename();
        String extension = FilenameUtils.getExtension(filename);

        //工具类封装
        try {
            String ubload = FastDfsApiOpr.ubload(file.getBytes(), extension);
            System.out.println(ubload);
            return AjaxResult.me().setSuccess(true).setMsg("上传成功").setObject(ubload);
        } catch (IOException e) {
            return AjaxResult.me().setSuccess(false).setMsg("上传失败:"+e.getMessage());
        }
    }

    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public AjaxResult delete(@RequestParam("filePath") String filePath){
        try {
            String substring = filePath.substring(1);
            String groupName = substring.substring(0, substring.indexOf("/"));
            String substring1 = filePath.substring(substring.indexOf("/")+1);
            int delete = FastDfsApiOpr.delete(groupName, substring1);
            if (delete == 0){
                return AjaxResult.me().setSuccess(true).setMsg("删除成功");
            }else {
                return AjaxResult.me().setSuccess(false).setMsg("删除失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMsg("删除失败:"+e.getMessage());
        }
    }
}

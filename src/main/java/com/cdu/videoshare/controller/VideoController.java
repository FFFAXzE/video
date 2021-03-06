package com.cdu.videoshare.controller;

import com.cdu.videoshare.model.Category;
import com.cdu.videoshare.model.ResponseEntity;
import com.cdu.videoshare.model.User;
import com.cdu.videoshare.model.Video;
import com.cdu.videoshare.service.CategoryService;
import com.cdu.videoshare.service.HisAndColService;
import com.cdu.videoshare.service.VideoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@Controller
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @Autowired
    private CategoryService categoryService;

    /**
     * 多条件查询视频
     * @param conditionMap form表单提交的多数据
     * @param model        对象
     * @return 页面
     */
    @GetMapping("/list")
    public String list(@RequestParam(required = false) Map<String, String> conditionMap, Integer pageNum, Model model) {
        //查询所有类别
        model.addAttribute("categories", categoryService.getAll());
        // 查询所有视频
        model.addAttribute("pageInfo", videoService.getAll(pageNum == null ? 1 : pageNum, conditionMap));
        model.addAttribute("conditionMap", conditionMap);
        return "admin/video_list";
    }

    //删除视频
    @GetMapping("/del")
    public String del(int id,Integer pageNum, Model model,@RequestParam(required = false) Map<String, String> conditionMap) {
        videoService.delById(id);
        model.addAttribute("pageInfo", videoService.getAll(pageNum == null ? 1 : pageNum,conditionMap));
        return "admin/video_list";
    }

    @GetMapping("/modify/normal")
    @ResponseBody
    public ResponseEntity<Void> modifyStatusNormal(Integer id,Integer pageNum, Model model,@RequestParam(required = false) Map<String, String> conditionMap) {
        int status = 1;
        ResponseEntity<Void> responseEntity = null;
        videoService.modifyStatus(id,status);
        model.addAttribute("pageInfo", videoService.getAll(pageNum == null ? 1 : pageNum,conditionMap));
        responseEntity = new ResponseEntity<>();
        responseEntity.setCode(200);
        responseEntity.setMessage("ok");
        return responseEntity;
    }

    @GetMapping("/modify/ban")
    @ResponseBody
    public ResponseEntity<Void> modifyStatusBan(Integer id,Integer pageNum, Model model,@RequestParam(required = false) Map<String, String> conditionMap) {
        int status = 2;
        ResponseEntity<Void> responseEntity = null;
        videoService.modifyStatus(id,status);
        model.addAttribute("pageInfo", videoService.getAll(pageNum == null ? 1 : pageNum,conditionMap));
        responseEntity = new ResponseEntity<>();
        responseEntity.setCode(200);
        responseEntity.setMessage("ok");
        return responseEntity;
    }




    @GetMapping("add")
    public String add(Model model){
        //查询所有类别并保存
        model.addAttribute("categories", categoryService.getAll());
        return "home/video_update";
    }





    @Transactional
    @PostMapping("add")
    public String add(MultipartFile[] multipartFiles, Video video, HttpSession session,Model model) throws IOException {
        //文件上传
        for (int i=0;i<multipartFiles.length;i++){
            if (!multipartFiles[i].isEmpty()){
                String fileName = multipartFiles[i].getOriginalFilename();
                //文件后缀
                String suffix = fileName.substring(fileName.lastIndexOf("."));
                //新的文件名
                String newFileName = UUID.randomUUID().toString().replace("-", "") + suffix;
                //保存文件到服务器
                if (suffix.equals(".jpg")||suffix.equals(".png")){
                    File fileImage = new File("D:/ideaProject/vsfile/images/"+newFileName);
                    multipartFiles[i].transferTo(fileImage);
                    video.setCover(newFileName);
                }else {
                    File fileVideo = new File("D:/ideaProject/vsfile/video/"+newFileName);
                    multipartFiles[i].transferTo(fileVideo);
                    video.setUrl(newFileName);
                }
            }
        }
        //增加数据到数据表
        User user = (User) session.getAttribute("user");
        video.setUser(user);
        int status = videoService.addVideo(video);
        if (status == 1){
            videoService.updUserVideoNum(user.getId());
        }
        return "redirect:/index";
    }


    @Autowired
    private HisAndColService hisAndColService;

    @GetMapping("/del/{id}")
    public  String del(@PathVariable int id, Model model,HttpSession session) {
        User user = (User) session.getAttribute("user");
        videoService.delVideoById(id,user.getId());
        model.addAttribute("videos", hisAndColService.getMyVideo(user.getId()));
        return "home/myVideo";
    }

    @GetMapping("/delhis/{id}")
    public  String delHis(@PathVariable int id, Model model,HttpSession session) {
        User user = (User) session.getAttribute("user");
        videoService.delHisById(id,user.getId());
        model.addAttribute("videos", hisAndColService.getMyVideo(user.getId()));
        return "home/videoHistory";
    }
    @GetMapping("/delFavor/{id}")
    public  String delFar(@PathVariable int id, Model model,HttpSession session) {
        User user = (User) session.getAttribute("user");
        videoService.delFavorById(id,user.getId());
        model.addAttribute("videos", hisAndColService.getMyVideo(user.getId()));
        return "home/videoCollection";
    }

    @GetMapping("/delPraise/{id}")
    public  String delPra(@PathVariable int id, Model model,HttpSession session) {
        User user = (User) session.getAttribute("user");
        videoService.delPraiseById(id,user.getId());
        model.addAttribute("videos", hisAndColService.getMyVideo(user.getId()));
        return "home/videoPraise";
    }
}

package com.malasong.server.Controller;

import com.malasong.server.Model.JsonResult;
import com.malasong.server.Model.PicModel;
import com.malasong.server.Repository.PicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController(value = "pic model controller")
@RequestMapping(value = "/pic")
public class PicController {
    private final PicRepository mPicRository;

    @Autowired
    public PicController(PicRepository mPicRepository) {
        this.mPicRository = mPicRepository;
    }

    @GetMapping(value = "")
    public JsonResult<List<PicModel>> getPics() {
        List<PicModel> pics = mPicRository.findAll();
        JsonResult<List<PicModel>> result = new JsonResult<>();
        result.setData(pics);
        result.setMessage("success");
        result.setCode(200);
        return result;
    }

}

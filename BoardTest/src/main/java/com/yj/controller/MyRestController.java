package com.yj.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yj.service.BoardService;

@Controller
@RequestMapping(value="/ajax", produces="application/json; charset=UTF-8")
public class MyRestController {
    @Autowired
    BoardService bs;

    @RequestMapping(value="/delete", method=RequestMethod.POST, consumes="application/json", produces="application/json; charset=UTF-8")
    @ResponseBody
    public Map<String,String> ajaxDelete(@RequestBody Map<String, Integer> requestBody) {
        System.out.println("ajax 들어옴");
        System.out.println(requestBody);
        int bno = requestBody.get("bno");

        bs.boardDelete(bno);
        HashMap<String,String> map = new HashMap<String,String>();
        
        map.put("text","삭제성공");
        
        return map;

    }
}


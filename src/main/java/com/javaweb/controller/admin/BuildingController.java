package com.javaweb.controller.admin;



import com.javaweb.enums.buildingType;
import com.javaweb.enums.district;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.service.IBuildingService;
import com.javaweb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HttpServletBean;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller(value="buildingControllerOfAdmin")
public class BuildingController {
    @Autowired
    private IUserService userService ;
    @Autowired
    IBuildingService buildingService ;
    @GetMapping(value = "/admin/building-list")
    public ModelAndView buildingList(@ModelAttribute BuildingSearchRequest buildingSearchRequest, HttpServletRequest request)
    {
        ModelAndView mav = new ModelAndView("admin/building/list") ;
        mav.addObject("modelSearch",buildingSearchRequest) ;
        // xuong db lay data
        List<BuildingSearchResponse> responseList = buildingService.Finall(buildingSearchRequest) ;
//        BuildingSearchResponse item1 = new BuildingSearchResponse() ;
//        item1.setId(3) ;
//        item1.setName("ACM Building") ;
//        item1.setAddress("130 Quang Trung, Pham Ngu Lao, Quan 1");
//        item1.setNumberOfBasement(2);
//        item1.setManagerName("anh Long");
//        item1.setManagerPhoneNumber("090000001");
//        item1.setRentArea("100, 200, 300");
//
//        BuildingSearchResponse item2 = new BuildingSearchResponse() ;
//        item2.setId(5) ;
//        item2.setName("MA Building") ;
//        item2.setAddress("Nguyen Hue, Tan Mai, Quan 3");
//        item2.setNumberOfBasement(3);
//        item2.setManagerName("anh Hai");
//        item2.setManagerPhoneNumber("090000002");
//        item2.setRentArea("200, 300");

//        responseList.add(item1) ;
//        responseList.add(item2) ;
        mav.addObject("buildingList", responseList) ;
        mav.addObject("listStaffs", userService.getStaffs()) ;
        mav.addObject("districts", district.type()) ;
        mav.addObject("typeCodes", buildingType.type()) ;
        return mav ;
    }
    @GetMapping(value = "/admin/building-edit")
    public ModelAndView buildingEdit(@ModelAttribute("buildingEdit") BuildingDTO buildingDTO, HttpServletRequest request)
    {
        ModelAndView mav = new ModelAndView("admin/building/edit") ;
        mav.addObject("districts", district.type()) ;
        mav.addObject("typeCodes", buildingType.type()) ;


        return mav ;
    }
    @GetMapping(value = "/admin/building-edit-{id}")
    public ModelAndView buildingEdit(@PathVariable("id") Integer id, HttpServletRequest request)
    {
        ModelAndView mav = new ModelAndView("admin/building/edit") ;
//        mav.addObject("building",buildingDTO) ;
        // xuong db tim building theo id
        BuildingDTO buildingDTO = new BuildingDTO() ;
        buildingDTO.setName("Phuc Building");
        buildingDTO.setId(id);
        mav.addObject("buildingEdit", buildingDTO) ;
        mav.addObject("districts", district.type()) ;
        mav.addObject("typeCodes", buildingType.type()) ;
        return mav ;
    }
}

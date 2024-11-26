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
        // cam du lieu update cho db
//        buildingService.sendBuilding(buildingDTO) ;
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
//        if(buildingDTO.getType() != null)
//        {
//            buildingService.updateBuilding(id, buildingDTO) ;
//        }
        BuildingDTO buildingDTO2 = buildingService.findBuilding(id) ;
//        buildingDTO.setName("Phuc Building");
//        buildingDTO.setId(id);
        mav.addObject("buildingEdit", buildingDTO2) ;
        mav.addObject("districts", district.type()) ;
        mav.addObject("typeCodes", buildingType.type()) ;
        return mav ;
    }
        @DeleteMapping(value = "/admin/building-list-{id}")
        public ModelAndView buildingDelete(@PathVariable("id") List<Integer> id, HttpServletRequest request)
    {
        ModelAndView mav = new ModelAndView("admin/building/list") ;
        buildingService.deleteBuilding(id) ;
        return mav ;
    }
}

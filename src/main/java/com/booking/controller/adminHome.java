package com.booking.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.bridge.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.booking.dto.NewDTO;
import com.booking.service.ICategoryService;
import com.booking.service.INewService;

@Controller
public class adminHome {
	@Autowired
	private ICategoryService categoryService;

	@Autowired
	private INewService newService;
	
	@Autowired
	private MessageUtil messageUtil;


	@GetMapping(value = "/admin/new")
	public String showNew(Model model) {
		List<NewDTO> news = new ArrayList<NewDTO>();
		news = newService.findAll();
		model.addAttribute("news", news);
		return "views/admin/home";
	}

	@RequestMapping(value = "/admin/quan-tri/bai-viet/danh-sach", method = RequestMethod.GET)
	public String showNew(@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "limit", required = false) Integer limit, Model model, HttpServletRequest request) {
		NewDTO newDto = new NewDTO();
		if (page != null && limit != null) {
			newDto.setPage(page);
			Pageable pageable = new PageRequest(page - 1, limit);
			newDto.setListResult(newService.findAll(pageable));
			newDto.setTotalPage((int) Math.ceil((double) (newService.totalItem()) / limit));
		} else {
			newDto.setListResult(newService.findAll());
		}
		
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			model.addAttribute("message", message.get("message"));
			model.addAttribute("alert", message.get("alert"));
		}
		model.addAttribute("model", newDto);
		return "views/admin/new/list";
	}
	
	@RequestMapping(value = "/admin/quan-tri/bai-viet/chinh-sua", method = RequestMethod.GET)
	public String editNew(@RequestParam(value = "id", required = false) Long id, Model model) {
		NewDTO newDto = new NewDTO();
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("model", newDto);
		return "views/admin/new/edit";
	}



}

package com.myrealtor.spring.mvc.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import com.myrealtor.domain.beans.SearchResult;
import com.myrealtor.service.external.ApartmentSearchService;

@Controller
public class SearchController extends BaseController {

	@Resource(name = "apartmentSearchDummy")
	protected ApartmentSearchService apartmentSearchService;

	@RequestMapping(method = RequestMethod.GET)
	public void index(Model model, WebRequest request) throws Exception {
		log.debug("index");
		SearchResult result = apartmentSearchService.search(null);
		model.addAttribute("apartmentList", result.getApartmentList());
	}

}

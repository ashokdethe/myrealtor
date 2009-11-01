package com.myrealtor.spring.mvc.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import com.myrealtor.domain.beans.SearchCriteria;
import com.myrealtor.domain.beans.SearchResult;
import com.myrealtor.service.external.ApartmentSearchService;


@Controller
public class SearchController extends BaseController {

	@Resource(name = "apartmentSearchServiceImpl")
	protected ApartmentSearchService apartmentSearchService;

	@RequestMapping(method = RequestMethod.GET)
	public void index(Model model, WebRequest request) throws Exception {
		log.debug("index");
		model.addAttribute("criteria", new SearchCriteria());
//		SearchResult result = apartmentSearchService.search(null);
//		model.addAttribute("apartmentList", result.getApartmentList());
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void search(@ModelAttribute SearchCriteria criteria, Model model, WebRequest request) throws Exception {
		log.debug("search");
		//TODO need to validate zip code
		SearchResult result = apartmentSearchService.search( criteria );
		model.addAttribute( "apartmentList", result.getApartmentList() );
		model.addAttribute("criteria", criteria );
	}

}

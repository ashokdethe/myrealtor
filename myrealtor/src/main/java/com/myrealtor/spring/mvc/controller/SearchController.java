package com.myrealtor.spring.mvc.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import com.myrealtor.domain.beans.Apartment;
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
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public String search(@ModelAttribute SearchCriteria criteria, Model model, WebRequest request) throws Exception {
		log.debug("search");
		String view = "search/search";
		
		//TODO need to validate zip code
		SearchResult result = apartmentSearchService.search( criteria );
		
		if (result.getApartmentList() == null || result.getApartmentList().size() == 0) {
			String msg = "No apartment was found for criteria: " + criteria.getCriteria();
			log.info(msg);
			model.addAttribute( "message", msg );
			view = "search/index";
		} else {
			model.addAttribute( "apartmentList", result.getApartmentList() );			
		}
		model.addAttribute("criteria", criteria );
		return view;		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public void list(@RequestParam("username") String username, @RequestParam("zip") String zip, Model model, WebRequest request) throws Exception {
		log.debug("list username: " + username);
		List<Apartment> list = apartmentSearchService.findApartmentList(username, zip);
		model.addAttribute( "apartmentList", list );
		model.addAttribute( "provider", list.get(0).getOwner() );
		model.addAttribute( "address", list.get(0).getAddress() );
		
	}

}

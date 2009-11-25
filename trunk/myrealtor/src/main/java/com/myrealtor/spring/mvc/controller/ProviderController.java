package com.myrealtor.spring.mvc.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import com.myrealtor.domain.beans.Apartment;
import com.myrealtor.service.external.ApartmentSearchService;


@Controller
public class ProviderController extends BaseController {

	@Resource(name = "apartmentSearchServiceImpl")
	protected ApartmentSearchService apartmentSearchService;

	
	@RequestMapping(method = RequestMethod.GET)
	public void index(Model model, WebRequest request) throws Exception {
		log.debug("index");		
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	public void list(@RequestParam("username") String username, Model model, WebRequest request) throws Exception {
		log.debug("list username: " + username);
		List<Apartment> list = apartmentSearchService.findApartmentList(username, null);
		model.addAttribute( "apartmentList", list );
		model.addAttribute( "provider", list.get(0).getOwner() );
		model.addAttribute( "address", list.get(0).getAddress() );				
	}

}

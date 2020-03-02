package com.football.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.football.StandingsService;
import com.football.model.Standing;

@Controller
public class StandingsController {
	
	@Autowired
	StandingsService standingService;
	
	
	@GetMapping("/football")
	public String getStandings(@RequestParam("countryName") String countryName,
							 @RequestParam("leagueName") String leagueName,
							 @RequestParam("teamName") String teamName, Model model) {
		
		Standing standing = standingService.getStanding(countryName, leagueName, teamName);
		
		//System.out.println(">>> "+standing.toString());
		model.addAttribute("standing",standing );
		return "football";
	}
}

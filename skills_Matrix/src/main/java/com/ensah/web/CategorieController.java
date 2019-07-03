package com.ensah.web;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ensah.entity.Categorie;
import com.ensah.entity.Competence;
import com.ensah.entity.Operation;
import com.ensah.services.CategorieService;
import com.ensah.services.OperationService;

@Controller
public class CategorieController {
	 @Autowired
	private CategorieService categorieService ; 
	 @Autowired
	private OperationService operationService ; 
		@RequestMapping(value="/addCategorie", method = RequestMethod.GET)
	 public String addCategorie(Model model) {
			model.addAttribute("categorie", new Categorie());
		return "categorie";
	}
		@RequestMapping(value="/saveCategorie",method=RequestMethod.POST)
		public String  saveCat(Model model , @Valid Categorie categorie,BindingResult bindingResult ) {
			if(bindingResult.hasErrors())
				return "categorie";
			categorieService.addCategorie(categorie);
			return "redirect:/addCategorie";
		}
		
		@RequestMapping(value="/addCompetence", method = RequestMethod.GET)
		 public String addCompetence(Model model) {
			List<Categorie> categories = categorieService.getAllCategorie();
				model.addAttribute("categories",categories);
				model.addAttribute("categorie", new Categorie());
				model.addAttribute("competence", new Competence());
			return "competence";
		}
		@RequestMapping(value="/saveCompetence", method = RequestMethod.POST)
		 public String saveCompetence( Categorie categorie, Competence competence,BindingResult bindingResult) {
			if(bindingResult.hasErrors())
				return "competence";
			competence.setCategorie(categorie);
			operationService.add_competence(Long.valueOf(1), competence, competence.getNiveau());
			System.out.println(categorie);
			System.out.println(competence);
			return "redirect:/addCompetence";
		}
		@RequestMapping(value="/admin/operations", method = RequestMethod.GET)
		 public String saveCompetence( Model model) {
			List<Operation> operations = operationService.listOperations();
			model.addAttribute("operations", operations);
			return "operation";
		}
}

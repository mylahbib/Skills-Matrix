package com.ensah.web;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ensah.entity.Categorie;
import com.ensah.entity.Competence;
import com.ensah.services.CategorieService;
import com.ensah.services.CompetenceService;

@Controller
public class MatrixController {
	@Autowired
	private CategorieService categorieService ; 
	@Autowired
	private CompetenceService competenceService;
	
	
	@RequestMapping(value="/index")
	public String listCompetence(Model model ) {
		
		List<Categorie> listCategories = 	categorieService.getAllCategorie();
		List<Competence> listcompetences =  competenceService.getAllCompetences();

		if (listCategories != null) {
		    model.addAttribute("listCategories", listCategories);
		} else {
		    model.addAttribute("listCategories", new ArrayList<Categorie>());
		}
		
		Integer id_comp=0;
		model.addAttribute("listcompetences", listcompetences);
		model.addAttribute("competence", new Competence());
		model.addAttribute("categorieSelected",new Categorie());
		model.addAttribute("id",id_comp);

		return "skillsMatrix";
	}
	
	@RequestMapping(value="/addCat",method=RequestMethod.POST)
	public String  addCat(Model model ,  Categorie categorie ) {
		
		List<Competence> competences = competenceService.getAllCompetences();
		List<Competence> listCompetence = new ArrayList<>();
		for (Competence competence : competences) {
			if (categorie.getId_cat() ==  competence.getCategorie().getId_cat()) {
				listCompetence.add(competence);
			}
		}
		
		System.out.println(categorie.getNom());
		for (Competence competence : listCompetence) {
			System.out.println(competence.getType());

		}
		model.addAttribute("listCompetence", listCompetence);
		return "skillsMatrix";
	}
	@RequestMapping(value="/niveau/{id}")
	public String niveau(@PathVariable Long id ,@Valid Competence competence,BindingResult bindingResult){
		if(bindingResult.hasErrors())
			return "redirect:/index";
		Integer niveau = competence.getNiveau();
	 competence =  competenceService.getCompetence(id);
	 			competence.setNiveau(niveau);
	 			competenceService.updatCompetence(id, competence);
	System.out.println(competence);
		return "redirect:/index";
	}
	
	@RequestMapping(value="/skills",method=RequestMethod.GET)
	public String skills(Model model){

		List<Categorie> listCategories = 	categorieService.getAllCategorie();

		if (listCategories != null) {
		    model.addAttribute("listCategories", listCategories);
		} else {
		    model.addAttribute("listCategories", new ArrayList<Categorie>());
		}
		model.addAttribute("categorieSelected",new Categorie());
		return "matrix";
	}
	@RequestMapping(value="/histo",method=RequestMethod.GET)
	public String historique(){
		return "historique";
	}

	public CategorieService getCategorieService() {
		return categorieService;
	}

	public void setCategorieService(CategorieService categorieService) {
		this.categorieService = categorieService;
	}

	public CompetenceService getCompetenceService() {
		return competenceService;
	}

	public void setCompetenceService(CompetenceService competenceService) {
		this.competenceService = competenceService;
	}
	
}

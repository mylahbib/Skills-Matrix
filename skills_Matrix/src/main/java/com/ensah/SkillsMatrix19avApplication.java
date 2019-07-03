package com.ensah;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ensah.dao.CompetenceDao;
import com.ensah.dao.OperationDao;
import com.ensah.entity.Categorie;
import com.ensah.entity.Competence;
import com.ensah.entity.User;
import com.ensah.services.CategorieService;
import com.ensah.services.CompetenceService;
import com.ensah.services.HistoriqueService;
import com.ensah.services.OperationService;
import com.ensah.services.UserService;

@SpringBootApplication
public class SkillsMatrix19avApplication {
	@Autowired
	static CompetenceDao competenceDao;
	@Autowired
	static CompetenceService competenceService;

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SkillsMatrix19avApplication.class, args);

		System.out.println("----------- USER TEST --------------");

//		UserService userService = ctx.getBean(UserService.class);
		System.out.println(" Ajout User ");
//
//		User u1 = new User("Mohamed", "Mounaqid", 1);
//		User u2 = new User("khaoula", "elfba", 2);
//		User u3 = new User("ysf", "aml", 3);
//		User u4 = new User("rida", "khouna", 4);

//	 userService.addUser(u1);
//		 userService.addUser(u2);
//		 userService.addUser(u3);
//		 userService.addUser(u4);

		System.out.println("-----------Comptence TEST--------------");

		CompetenceService competenceService = ctx.getBean(CompetenceService.class);

		System.out.println("-----------CATEGORIE TEST--------------");

		CategorieService categorieService = ctx.getBean(CategorieService.class);
		System.out.println(" Ajout Categorie ");
//		categorieService.addCategorie(new Categorie("base de donnee"));

		System.out.println("---------- Test entre les classes -----------------");
//		competenceService.addCompetence(new Competence("Java", 4, new Categorie(1L),
//	new User(1L)));
//	 competenceService.addCompetence(new Competence("Cpp", 3,new Categorie(1L),
//		 new User(1L)));
		System.out.println("---------- Test Operation -----------------");
//		OperationService operationService = ctx.getBean(OperationService.class);

//		 OperationService operationService=ctx.getBean(OperationService.class);
		// operationService.mettre_a_jour(1L, 1L, 5);
		// operationService.mettre_a_jour(1L, 1L, 3);
//		operationService.add_competence(1L, new Competence("Cpp", new Categorie(1L)),
//		 4);
		// operationService.add_competence(1L, new Competence("C", new Categorie(1L)),
		// 5);   
		//
		// operationService.add_competence(2L, new Competence("Cpp", new Categorie(1L)),
		// 3);
		// operationService.add_competence(2L, new Competence("C", new Categorie(1L)),
		// 2);
		//
		// operationService.add_competence(3L, new Competence("java", new
		// Categorie(1L)), 4);
		// operationService.add_competence(3L, new Competence("Cpp", new Categorie(1L)),
		// 1);
		//
		// operationService.add_competence(4L, new Competence("Cpp", new Categorie(1L)),
		// 2);
		// operationService.add_competence(4L, new Competence("java", new
		// Categorie(1L)), 5);
		// operationService.add_competence(4L, new Competence("C", new Categorie(1L)),
		// 1);
		//

		// Mise a jour
		// operationService.mettre_a_jour(1L, 1L, 5);
		// operationService.mettre_a_jour(1L, 2L, 3);
		// operationService.mettre_a_jour(2L, 3L, 4);
		// operationService.mettre_a_jour(2L, 4L, 5);
		// operationService.mettre_a_jour(3L, 5L, 3);
		// operationService.mettre_a_jour(3L, 6L, 3);
		// operationService.mettre_a_jour(4L, 7L, 4);
		// operationService.mettre_a_jour(4L, 8L, 4);
		// operationService.mettre_a_jour(4L, 9L, 3);

		// userService.addUser(new User("Yousef", "AML", 12));
		// operationService.mettre_a_jour(2L, 4L, 2);
		// operationService.add_competence(1L, new Competence("Cpp", new Categorie(1L)),
		// 5);
		// System.out.println("Test de lala la fct");
		//
//		 competenceService.getCompetenceswithusers("C",1).forEach(c->System.out.println(c+" | User : "+c.getUser()));
		//

		System.out.println();

		System.out.println();

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();

		System.out.println("---------- Test Historique -----------------");
//		HistoriqueService historiqueService = ctx.getBean(HistoriqueService.class);
//		System.out.println("niveau java : " + historiqueService.niveauActuelByCompetence("jAVa"));
		System.out.println("********************************");
//		historiqueService.historiqueComp("Cpp").forEach(c -> System.out.println(c));
//		
//		System.out.println("---------- Test Historique Par Personne -----------------");
//		
		System.out.println("********************************");

//		historiqueService.historiqueCompByuser("cpp", 2L).forEach(c->System.out.println(c));
//		
		List<Competence> competences = competenceService.getAllCompetences();

		for (Competence competence : competences) {
			System.out.println(competence.getType());
			}
	}
}

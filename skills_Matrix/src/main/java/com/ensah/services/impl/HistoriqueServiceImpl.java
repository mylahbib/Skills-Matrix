package com.ensah.services.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensah.entity.Competence;
import com.ensah.entity.HistoriqueType;
import com.ensah.entity.Operation;
import com.ensah.services.CompetenceService;
import com.ensah.services.HistoriqueService;
import com.ensah.services.OperationService;

@Service
public class HistoriqueServiceImpl implements HistoriqueService {
	
	@Autowired
	OperationService operationService;

	@Autowired
	CompetenceService competenceService;

	@Override
	public double niveauActuelByCompetence(String cmp) {
		List<Competence> tt_comp = competenceService.getAllCompetences();
		List<Competence> comp_of_type = new ArrayList<>();
		double niveau = 0;
		for (int i = 0; i < tt_comp.size(); i++) {
			if (tt_comp.get(i).getType().equalsIgnoreCase(cmp)) {
				comp_of_type.add(tt_comp.get(i));
			}
		}
		for (int index = 0; index < comp_of_type.size(); index++) {
			niveau += comp_of_type.get(index).getNiveau();

		}
		return niveau / comp_of_type.size();
	}

	@Override
	public List<HistoriqueType> historiqueComp(String cmp) {

		List<HistoriqueType> historiqueans = new ArrayList<>();

		// TODO get id of cmp from table competence
		List<Long> ids_comp = new ArrayList<>();
		List<Competence> tt_comp = competenceService.getAllCompetences();
		for (int i = 0; i < tt_comp.size(); i++) {
			if (tt_comp.get(i).getType().equals(cmp)) {
				ids_comp.add(tt_comp.get(i).getId_comp());
			}
		}
		// J'ai récupereer les ids maintenant

		// TODO Je passe a la table de journalisation et je recupere

		List<Operation> operations = new ArrayList<>();
		operations = operationService.listOperations();
		List<Operation> operationsparcompetence = new ArrayList<>();

		for (int index = 0; index < operations.size(); index++) {
			for (int j = 0; j < ids_comp.size(); j++) {
				if (operations.get(index).getId_competence() == ids_comp.get(j)) {
					operationsparcompetence.add(operations.get(index));
				}
			}
		}

		// maintenat j'ai une liste qui contient les competence concerner
		double niveau = 0;
		int year;
		int tmp = 0;
		List<Integer> annee = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		//
		// int year = cal.get(Calendar.YEAR);
		for (int i = 0; i < operationsparcompetence.size(); i++) {
			cal.setTime(operationsparcompetence.get(i).getDateOperation());
			year = cal.get(Calendar.YEAR);
			annee.add(year);

		}
		int tmp2;
		int nmbr = 0;
		List<Integer> nombreannee=new ArrayList<>();
		if (!annee.isEmpty()) {
			tmp2 = annee.get(0);
			for (int i = 0; i < annee.size(); i++) {
				if (annee.get(i) == tmp2)
					nmbr++;
				else {
					nombreannee.add(nmbr);
					tmp2 = annee.get(i);
					nmbr = 1;
				}

			}
			nombreannee.add(nmbr);

		}

		double moyenne=0;
		int cmptr=0;
		int ctr=0;
		int i;
		int nombre=0;
		int ans=0;
		while(cmptr<nombreannee.size())
		{
			for(i=tmp;i<nombreannee.get(cmptr)+ctr;i++)
			{
				moyenne+=operationsparcompetence.get(i).getNote();
				nombre++;
				if(i==tmp)
					ans=annee.get(tmp);

			}

			tmp=ctr=i;
			cmptr++;
			historiqueans.add(new HistoriqueType(cmp, ans ,moyenne/nombre));
			nombre=0;
			moyenne=0;


		}
	
		return historiqueans;

	}

	@Override
	public List<HistoriqueType> historiqueCompByuser(String cmp, Long id) {
		List<HistoriqueType> historiqueans = new ArrayList<>();

		// TODO get id of cmp from table competence
		List<Long> ids_comp = new ArrayList<>();
		List<Competence> tt_comp = competenceService.getAllCompetences();
		for (int i = 0; i < tt_comp.size(); i++) {
			if (tt_comp.get(i).getType().equalsIgnoreCase(cmp)&&tt_comp.get(i).getUser().getId()==id) {
				ids_comp.add(tt_comp.get(i).getId_comp());
			}
		}
		// J'ai récupereer les ids maintenant

		// TODO Je passe a la table de journalisation et je recupere

		List<Operation> operations = new ArrayList<>();
		operations = operationService.listOperations();
		List<Operation> operationsparcompetence = new ArrayList<>();

		for (int index = 0; index < operations.size(); index++) {
			for (int j = 0; j < ids_comp.size(); j++) {
				if (operations.get(index).getId_competence() == ids_comp.get(j)) {
					operationsparcompetence.add(operations.get(index));
				}
			}
		}

		// maintenat j'ai une liste qui contient les competence concerner
		double niveau = 0;
		int year;
		int tmp = 0;
		List<Integer> annee = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		//
		// int year = cal.get(Calendar.YEAR);
		for (int i = 0; i < operationsparcompetence.size(); i++) {
			cal.setTime(operationsparcompetence.get(i).getDateOperation());
			year = cal.get(Calendar.YEAR);
			annee.add(year);

		}
		int tmp2;
		int nmbr = 0;
		List<Integer> nombreannee=new ArrayList<>();
		if (!annee.isEmpty()) {
			tmp2 = annee.get(0);
			for (int i = 0; i < annee.size(); i++) {
				if (annee.get(i) == tmp2)
					nmbr++;
				else {
					nombreannee.add(nmbr);
					tmp2 = annee.get(i);
					nmbr = 1;
				}

			}
			nombreannee.add(nmbr);

		}

		double moyenne=0;
		int cmptr=0;
		int ctr=0;
		int i;
		int nombre=0;
		int ans=0;
		while(cmptr<nombreannee.size())
		{
			for(i=tmp;i<nombreannee.get(cmptr)+ctr;i++)
			{
				moyenne+=operationsparcompetence.get(i).getNote();
				nombre++;
				if(i==tmp)
					ans=annee.get(tmp);

			}
			System.out.println("Moyenne : "+moyenne+"ans : "+ans+" nombre : "+nombre);

			tmp=ctr=i;
			cmptr++;
			historiqueans.add(new HistoriqueType(cmp, ans ,moyenne/nombre));
			nombre=0;
			moyenne=0;


		}
	
		return historiqueans;
	}

}

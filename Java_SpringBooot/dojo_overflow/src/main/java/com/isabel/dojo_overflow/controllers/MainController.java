package com.isabel.dojo_overflow.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.isabel.dojo_overflow.models.Answer;
import com.isabel.dojo_overflow.models.Question;
import com.isabel.dojo_overflow.models.Tag;
import com.isabel.dojo_overflow.services.MainServices;

import jakarta.validation.Valid;

@Controller
public class MainController {

	@Autowired
	private MainServices mainServices;

	@GetMapping("/")
	public String index() {
		return "redirect:/questions";
	}

	@GetMapping("/questions")
	public String rutaQuestions(Model model) {
		model.addAttribute("listaPreguntas", mainServices.obtenerPreguntas());
		return "questions.jsp";
	}

	@GetMapping("/questions/new")
	public String rutaNewQuestions(@ModelAttribute("question") Question question) {
		return "newQuestion.jsp";
	}

	@GetMapping("questions/{id}")
	public String rutaQuestion(@PathVariable("id")Long id,Model model) {
		//obtener pregunta segun su id
		Question q = mainServices.getQuestionByID(id);
		if(q == null) {
			return"redirect:/";
		}
		model.addAttribute("question",q);
		return "question.jsp";
	}



	@PostMapping("/questions/new")
	public String newQuestion(@Valid @ModelAttribute("question") Question question, BindingResult result,
			@RequestParam("listaTag") String listaTag, RedirectAttributes redirectAttributes) {
		// ___________________________validar text_question________________________
		if (result.hasErrors()) {
			return "newQuestion.jsp";
		}
		// ___________________________validar campo vacio tag________________________
		listaTag = listaTag.trim();
		if(listaTag.isEmpty()) {
			redirectAttributes.addFlashAttribute("error", "por favor ingrese un tag");
			return "redirect:/questions/new";
		}
		
		//___________________ Transformar el valor de tags en una lista de objetos Tag___________
		List<Tag> tagsList = new ArrayList<>();
		String[] tagArray = listaTag.split(",");
		System.out.println(tagArray.length);

		// ___________________________validar que no sean mas de 3 elementos________________________
		if ( tagArray.length > 3) {
			redirectAttributes.addFlashAttribute("error", "por favor ingrese un tag y recordar que maximo deben ser 3");
			return "redirect:/questions/new";
		}

		//___________________________recorrer tagArray_______________________________________
		for (String tagSubject : tagArray) {
			String subjectTag = tagSubject.trim().toLowerCase();

			// Verificar si el tag ya existe en la base de datos
			Tag existingTag = mainServices.existeTag(subjectTag);

			// Si no existe, se crea un nuevo objeto Tag y se agrega a la lista
			if (existingTag == null) {
				Tag newTag = new Tag();
				newTag.setSubject(subjectTag);
				tagsList.add(newTag);
			} else {
				tagsList.add(existingTag);
			}
		}

		 //Guardar los tags y la pregunta en la base de datos
		 for (Tag tag : tagsList) {
		 mainServices.guardarTag(tag);
		 }
		 question.setTags(tagsList);
		 mainServices.guardarQuestion(question);

		return "redirect:/";
	}
	
	@PostMapping("/newAnswer")
	public String guardarRespuesta(@RequestParam("idQuestion")Long id,@RequestParam("text_answer")String answer) {
		System.out.println(id);
		//obtener la entidad question que este en la base de datos por el id
		Question q = mainServices.getQuestionByID(id);
		
		if(q != null) {
			 Answer newAnswer = new Answer();
			 newAnswer.setText_answer(answer);
			 newAnswer.setQuestion(q);
			 mainServices.guardarAnswer(newAnswer);
		}
		return "redirect:/";
	}
}

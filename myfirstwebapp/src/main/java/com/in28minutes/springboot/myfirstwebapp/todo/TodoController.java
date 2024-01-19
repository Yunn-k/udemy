package com.in28minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoController {

	private TodoService todoService;

	public TodoController(TodoService tooService) {
		super();
		this.todoService = tooService;
	}

	// 투두 메인페이지
	@RequestMapping(value = "list-todos", method = RequestMethod.GET)
	public String listAllTodos(ModelMap model) {
		List<Todo> todos = todoService.findByUsername("sample");
		model.addAttribute("todos", todos);
		return "listTodos";
	}

	// 투두 입력버튼
	@RequestMapping(value = "add-todo", method = RequestMethod.GET)
	public String showTodoPage(ModelMap model) {
		String username = (String) model.get("name");
		Todo todo = new Todo(0, username, "default description", LocalDate.now().plusYears(1), false);
		model.put("todo", todo); // username만 가진 깡통을 만들어서 모델에 넣어줌 > post발생시 사용 가능
		return "todo";
	}

	// 투두 입력 제출
	@RequestMapping(value = "add-todo", method = RequestMethod.POST)
	public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		// Bean을 바인딩에 쓸 때에는, Model이 첫번째 파라미터가 되어야 한다

		// validation에 따른 result 출력
		if (result.hasErrors()) {
//			String error = "확인요청!! 최소 10자 이상 입력해주세요";
//			model.addAttribute("errorMsg", error);
			return "todo";
		}

		// 값전달
		String username = (String) model.get("name");

		todoService.addTodo(username, todo.getDescription(), LocalDate.now().plusYears(1), false);
		return "redirect:list-todos";
	}
	
	
	// 투두 삭제하기
	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		
		//Delete todo
		todoService.deleteById(id);
		
		return "redirect:list-todos"; //리다이렉트는 request를 다시 날리는거라서 뷰가 아닌 경로로 잡아줘야 한다.
	}


}

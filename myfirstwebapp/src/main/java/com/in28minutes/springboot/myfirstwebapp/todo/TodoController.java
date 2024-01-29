package com.in28minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
		String name = getLoggedInUserName(model);
		System.out.println(name);
		List<Todo> todos = todoService.findByUsername(name);
		model.addAttribute("todos", todos);
		return "listTodos";
	}



	// 투두 입력버튼
	@RequestMapping(value = "add-todo", method = RequestMethod.GET)
	public String showTodoPage(ModelMap model) {
		String username = getLoggedInUserName(model);
		Todo todo = new Todo(0, username, "", LocalDate.now().plusYears(1), false);
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
		String username = getLoggedInUserName(model);

		todoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), false);
		return "redirect:list-todos";
	}
	
	
	// 투두 수정화면
	@RequestMapping(value = "update-todo",  method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		
//		todo화면에 있는 modelAttrivute="todo"에 맞춰주기 위해 todo객체를 읽어와서 넣어준다
		Todo todo = todoService.findById(id);
		//jsp에 있는 modelAttribute이름과 맞춰줘야 한다
		model.addAttribute("todo",todo);
		return "todo";
	}
	
	// 투두 입력 제출
	@RequestMapping(value = "update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		// Bean을 바인딩에 쓸 때에는, Model이 첫번째 파라미터가 되어야 한다

		// validation에 따른 result 출력
		if (result.hasErrors()) {
			return "todo";
		}

		// todo.jsp에서 전달하고 있지 않은 username에 대해 직접 읽어와서 set처리해줌.
		String username = getLoggedInUserName(model);
		todo.setUsername(username);

		todoService.updateTodo(todo);
		return "redirect:list-todos";
	}
	
	// 투두 삭제하기
	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		
		//Delete todo
		todoService.deleteById(id);
		
		return "redirect:list-todos"; //리다이렉트는 request를 다시 날리는거라서 뷰가 아닌 경로로 잡아줘야 한다.
	}
	
	private String getLoggedInUserName(ModelMap model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();

		return username;
	}


}

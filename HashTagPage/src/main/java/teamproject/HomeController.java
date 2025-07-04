/**
 * 
 */
package teamproject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import teamproject.book.service.BookService;
import teamproject.book.service.BookVO;
import teamproject.common.Criteria;

/**
 * @author user
 * 메인화면: http://localhost:8080
 */
@Controller
public class HomeController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/home.do")
	public String home(@ModelAttribute Criteria criteria,Model model) {
		List<?> books=bookService.selectTrendList(criteria);
		model.addAttribute("books", books);
		return "webtoon/main";
    }
	@GetMapping("/hashtagpage.do")
	public String home2(@ModelAttribute Criteria criteria,Model model) {
		List<?> books=bookService.selectTrendList(criteria);
		model.addAttribute("books", books);
		return "webtoon/main";
    }
	@GetMapping("/hashtagpage/webtoon.do")
	public String webtoon1(@RequestParam(defaultValue = "") String genre,
			@ModelAttribute Criteria criteria		
	   ,Model model) {
	    model.addAttribute("genre",genre);
	    List<?> books=bookService.selectTrendList(criteria);
		model.addAttribute("books", books);
		return "webtoon/main";
    }
	@GetMapping("/hashtagpage/webtoon/list.do")
	public String webtoon2() {
		return "webtoon/list";
    }
	@GetMapping("/hashtagpage/webtoon/detail.do")
	public String webtoon3() {
		return "webtoon/detail";
    }
	@GetMapping("/hashtagpage/webnovel.do")
	public String webnovel1(@RequestParam(defaultValue = "") String genre,
			@ModelAttribute Criteria criteria
	   ,Model model) {
		 model.addAttribute("genre",genre);
		 List<?> books=bookService.selectTrendList(criteria);
			model.addAttribute("books", books);
		return "webnovel/main";
    }
	@GetMapping("/hashtagpage/webnovel/list.do")
	public String webnovel2() {
		return "webnovel/list";
    }
	@GetMapping("/hashtagpage/webnovel/detail.do")
	public String webnovel3() {
		return "webnovel/detail";
    }
	@GetMapping("/hashtagpage/community.do")
	public String community1(@RequestParam(defaultValue = "") String genre
			,Model model) {
		 model.addAttribute("genre",genre);
		return "community/main";
    }
	@GetMapping("/hashtagpage/community/list.do")
	public String community2(@RequestParam(defaultValue = "") String genre
			,Model model) {
		 model.addAttribute("genre",genre);
		return "community/list";
    }
	@GetMapping("/hashtagpage/community/detail.do")
	public String community3() {
		return "community/detail";
    }
	@GetMapping("/hashtagpage/cart.do")
	public String cart() {
		return "modules/cart";
    }
	@GetMapping("/hashtagpage/info.do")
	public String info() {
		return "modules/info";
    }
	@GetMapping("/hashtagpage/liked.do")
	public String liked() {
		return "modules/liked";
    }
	@GetMapping("/hashtagpage/login.do")
	public String login() {
		return "modules/login";
    }
	@GetMapping("/hashtagpage/mypage.do")
	public String mypage() {
		return "modules/mypage";
    }
	@GetMapping("/hashtagpage/search.do")
	public String search(@RequestParam(defaultValue = "") String search
			,Model model) {
		model.addAttribute("search",search);
		return "modules/search";
    }
	@GetMapping("/hashtagpage/signup.do")
	public String signup() {
		return "modules/signup";
    }
	@GetMapping("/hashtagpage/payment.do")
	public String payment() {
		return "modules/payment";
    }
	








}

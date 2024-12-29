package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.Dto.Bulletinboard;
import com.example.demo.Entity.BulletinboardEntity;
import com.example.demo.Repository.BulletinboardRepository;
import com.example.demo.Repository.CommentRepository;
import com.example.demo.Service.CommentService;
import com.example.demo.Dto.Comment;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BulletinboardController {
	
	@Autowired
	private BulletinboardRepository bulletinboardrepository;
	
	@Autowired
	private CommentRepository commentrepository;
	
	@Autowired
	private CommentService commentservice;
	
	@GetMapping("/homepage")
	public String MainPage() {
		return "test/replace";
	}
	
	@GetMapping("/forums")
	public String forumPage(Model model) {
	    List<BulletinboardEntity> posts = bulletinboardrepository.findAll();
	    model.addAttribute("posts", posts);
	    return "test/mainpage";
	}
	
	@GetMapping("/addCommen")
	public String addCommenPage() {
		return "test/addCommen";
	}

	@PostMapping("/submit")
	public String SumitClick(Bulletinboard board) {
//		System.out.println(board.toString());
//		log.info(board.toString());
		
		BulletinboardEntity bulletinboardentity = board.toEntity();
//		log.info(bulletinboardentity.toString());
		
		BulletinboardEntity saved = bulletinboardrepository.save(bulletinboardentity);
//		System.out.println(saved.toString());
//		log.info(saved.toString());
		return "redirect:/forums";
	}

	@GetMapping("/submit/{id}")
	public String Inshow(@PathVariable("id") Long id, Model model) {
//		log.info("id = " + id);
		BulletinboardEntity findId = bulletinboardrepository.findById(id).orElse(null);
		model.addAttribute("find", findId);
		return "test/EditDelete";
	}
	
	// 생성
	@PostMapping("/submit/update") //수정할 부분
	public String EditUpdate(Bulletinboard board) {
		BulletinboardEntity bulletinboardentity = board.toEntity();
		BulletinboardEntity edit = bulletinboardrepository.findById(bulletinboardentity.getId()).orElse(null);
		if(edit != null) {
			bulletinboardrepository.save(bulletinboardentity);
		}
		
		return "redirect:/submit/" + bulletinboardentity.getId();
	}
	
	// 수정
	@GetMapping("/submit/{id}/edit")
	public String Update(@PathVariable("id") Long id, Model model) {
		BulletinboardEntity edit = bulletinboardrepository.findById(id).orElse(null);
		model.addAttribute("edit", edit);
		return "test/edit";
	}
	
	// 삭제
	@GetMapping("/submit/{id}/delete")
	public String delete(@PathVariable("id") Long id, RedirectAttributes deletes) {
		BulletinboardEntity delete = bulletinboardrepository.findById(id).orElse(null);
		if(delete != null) {
			int order = delete.getDisplayOrder();
			commentrepository.deleteByBulletinboardEntityId(id);
			bulletinboardrepository.delete(delete);
			bulletinboardrepository.updateDisplayOrderAfterDelete(order);
			deletes.addFlashAttribute("target", "삭제되었습니다.");
		}
		return "redirect:/forums";
	}

	// 댓글 목록
	@GetMapping("/submit/{id}/comment")
	public String Comment(@PathVariable("id") Long id, Model model) {
		BulletinboardEntity findId = bulletinboardrepository.findById(id).orElse(null);
		List<Comment> cmt = commentservice.comments(id);
		model.addAttribute("finda", findId);
		model.addAttribute("cmts", cmt);
		return "test/comment";
	}
	
}
package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.RandomStringService;

@Controller
public class RandomStringController {
	
	@Autowired // Springによるオブジェクトの管理（注入）
	RandomStringService service; // ランダム文字列生成サービス
	
	// 初期表示
	@GetMapping("/random")
	public String index() {
		return "random";
	}
	
	// 作成するボタンをクリックしたとき
	@PostMapping("/random")
	public String generate(
			@RequestParam("charLength") int charLength,
			@RequestParam(name = "withNumber", defaultValue = "false") boolean withNumber,
			@RequestParam(name = "withAlphabet", defaultValue = "false") boolean withAlphabet,
			@RequestParam(name = "createdCount", defaultValue = "1") int createdCount,
			Model model) {
		// ランダムな文字列を生成
		List<String> list = service.generate(charLength, withNumber, withAlphabet, createdCount);
		// 生成した文字列リストをスコープに登録
		model.addAttribute("randomList", list);
		// 画面遷移
		return "random";
	}
}

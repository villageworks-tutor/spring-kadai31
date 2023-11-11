package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
public class RandomStringService {
	@SuppressWarnings("unused")
	private final static int GENERATE_NUM = 10; // 生成文字列の個数

	/**
	 * ランダムな文字列のリストを生成する
	 * @param charLength 生成する文字列の文字数
	 * @param withNumber 生成する文字列に数字を含めるかどうか：数字を含む場合はtrue、それ以外はfalse
	 * @param count 
	 * @return ランダムな文字列のリスト 
	 */
	public List<String> generate(int charLength, boolean withNumber, int count) {
		// 生成した文字列を格納するリスト
		List<String> list = new ArrayList<String>();
		// 生成する個数分繰り返す
		for (int i = 0; i < count; i++)  {
			if (withNumber) {
				// 数字を含む文字列を生成する場合
				list.add(RandomStringUtils.randomAlphanumeric(charLength));
			} else {
				// 数字を含まない文字列を生成する場合
				list.add(RandomStringUtils.randomAlphabetic(charLength));
			}
		}
		return list;
	}
	
}

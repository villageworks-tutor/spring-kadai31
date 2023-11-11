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
	 * @param charLength   生成する文字列の文字数
	 * @param withNumber   生成する文字列に数字を含めるかどうか：数字を含む場合はtrue、それ以外はfalse
	 * @param createdCount 生成する文字列の個数
	 * @return ランダムな文字列のリスト 
	 */
	public List<String> generate(int charLength, boolean withNumber, int createdCount) {
		// 生成した文字列を格納するリスト
		List<String> list = new ArrayList<String>();
		// 生成する個数分繰り返す
		for (int i = 0; i < createdCount; i++)  {
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

	/**
	 * ランダムな文字列のリストを生成する
	 * @param charLength   生成する文字列の文字数
	 * @param withNumber   生成する文字列に数字を含めるかどうか：数字を含む場合はtrue、それ以外はfalse
	 * @param withAlphabet 生成する文字列に英字を含めるかどうか：英字を含む場合はtrue、それ以外はfalse
	 * @param createdCount 生成する文字列の個数
	 * @return ランダムな文字列のリスト 
	 */
	public List<String> generate(int charLength, boolean withNumber, boolean withAlphabet, int createdCount) {
		// 生成した文字列を格納するリスト
		List<String> list = new ArrayList<String>();
		// 生成する個数分の繰り返し
		for (int i = 0; i < createdCount; i++) {
			if (withNumber && withAlphabet) {
				// 数字と英字が混在する文字列を生成する場合
				list.add(RandomStringUtils.randomAlphanumeric(charLength));
			} else if (withNumber && !withAlphabet) {
				// 数字のみの文字列を生成する場合
				list.add(RandomStringUtils.randomNumeric(charLength));
			} else if (!withNumber && withAlphabet) {
				// 英字のみの文字列を生成する場合
				list.add(RandomStringUtils.randomAlphabetic(charLength));
			} else {
				// 数字も英字も含めない場合：文字列は生成しない
			}
		}
		// ランダムに生成した文字列リストを返却
		return list;
	}
	
}

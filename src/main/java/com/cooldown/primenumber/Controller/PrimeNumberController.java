package com.cooldown.primenumber.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cooldown.primenumber.Model.isPrime;

@Controller
public class PrimeNumberController {
  @Autowired
  HttpSession session;  //セッション管理

  @RequestMapping(value = "/", method = RequestMethod.GET)    // 最初の画面
  public ModelAndView PrimeNumber1(ModelAndView mav) {
	int num = 2;
	//numをセッションに保存
	session.setAttribute("PNumber", num);
	//初期値は2を表示
	mav.addObject("PrimeNumber", num);
	//ビューのURLをセット
	mav.setViewName("/CoolDown_By_PrimeNumber");
    return mav;
  }

  @RequestMapping(value = "/CoolDown_By_PrimeNumber", method = RequestMethod.GET)    // リロードされるたびに素数を表示
  public ModelAndView PrimeNumber2(ModelAndView mav) {
	int num = 2;
	//素数判定メソッド（Numが素数になるまでループ）
	while(isPrime.JudgePrimeNumber(num) == 1) {
		num = getNumber();
	}
	//素数だったらmavオブジェクトに格納
	mav.addObject("PrimeNumber", num);
	//ビューのURLをセット
	mav.setViewName("/CoolDown_By_PrimeNumber");
    return mav;
  }

  @RequestMapping(value = "/Cool_Down", method = RequestMethod.POST)		//落ち着いた気がしたら少年を出す
  public ModelAndView Cool_Down(ModelAndView mav) {
	//ビューのURLをセット
	mav.setViewName("/Cool_Down");
	return mav;
  }

  //数値のカウントアップ用メソッド
  private int getNumber() {
	//numをセッションから取り出す
	int num = (int)session.getAttribute("PNumber");
	//インクリメント
	num++;
	//numをセッションに保存
	session.setAttribute("PNumber", num);
	return num;
  }

}